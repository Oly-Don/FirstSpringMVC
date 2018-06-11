package com.oly.set.controller.userlogin;

import com.oly.set.entity.user.UserVO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")//k客户端需要加上这层目录 拼接下面的地址
public class UserController {


    Logger logger = Logger.getLogger(UserController.class);
    List<UserVO> userVOList;

    public UserController() {
        super();
        userVOList = new ArrayList<UserVO>();
    }

    // http://localhost:8080/FirstSpringMVC/user/register  get
    //接受get请求,返回视图
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerFrom(//返回为String 需要返回视图**.jsp
    ) {
        logger.info("/user/registerFrom" + "has been called");
        return "registerForm";
    }

    //    http://localhost:8080/FirstSpringMVC/user/register    post
    //post 传入方法table的值参数ID username得值  返回登录页,或重新注册页
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("id") String id,
                           @RequestParam("username") String username,
                           @RequestParam("passwd") String passwd,
                           @RequestParam("repasswd") String repasswd
    ) {
        logger.info("/user/registerFrom" + "has been called");
        if (id != null && passwd != null && passwd.equals(repasswd)) {
            UserVO userFromLogin = new UserVO();
            userFromLogin.setId(id);
            userFromLogin.setPasswd(passwd);
            userFromLogin.setUsername(username);
            userVOList.add(userFromLogin);
            return "loginForm";
        } else {
            logger.info("/user/registerFrom" + "出现错误,请检查注册信息");
        }
        return "registerForm";
    }


    //登录  http://localhost:8080/FirstSpringMVC/user/login   get post
    //4.0 spring RequestParam如果没有参数会报错,解决报错 需要加required = false 为空不报错
    //传入Model model, model.addAttribute("user", obj);可传对象给对应的接收界面. html jsp接收的用法[${requestScope.user.proporty}]
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "id", required = false) String id,
                        @RequestParam(value = "passwd", required = false) String passwd, Model model
    ) {
        logger.info("/user/login" + "has been called");
        if (userVOList.get(0).getId().equals(id) && userVOList.get(0).getPasswd().equals(passwd)) {
            model.addAttribute("user", userVOList.get(0));
            return "welcome";
        }
        return "loginForm";
//        return "register";//debug return不存在的视图的file 名字||controller的path,返回了错误.结论,必须返回视图文件名
    }


    //@RequestHeader("Referer") String Referer  将请求上的request header 的Referer直接传给方法  ,required = false避免无值时 的报错
    //疑问:无法获取到表单上的id passwd
//    http://localhost:8080/FirstSpringMVC/user/login/  get post
/*    @RequestMapping("/login")
    public String login(@RequestHeader(value = "Referer", defaultValue = "") String Referer,
                        @CookieValue(value = "JSESSIONID", defaultValue = "", required = false) Object JSESSIONID,
                        ModelMap params
    ) {
        logger.info("/user/login" + "has been called");
        logger.info("Referer:" + Referer + "\r" + "JSESSIONID" + JSESSIONID);
        String id = (String) params.get("id");
        String passwd = (String) params.get("passwd");
        if (userVOList.get(0).getId().equals(id) && userVOList.get(0).getPasswd().equals(passwd)) {
            params.addAttribute("user", userVOList.get(0));
            return "welcome";
        } else {
//            return "welcome";//debug
            return "loginForm";
        }
    }*/


    //http://localhost:8080/FirstSpringMVC/user/path/1  跳转到了/FirstSpringMVC/user/register get方法上
    @RequestMapping(value = "/path/{pageDeplogin}")
    public void pageDeplogin(@PathVariable("pageDeplogin") String pageDeplogin, HttpServletRequest request, HttpServletResponse response
    ) {
        logger.info("/user/pageDeplogin" + "has been called");
        if (pageDeplogin.equals("1")) {
            try {
                response.sendRedirect("/FirstSpringMVC/user/register");//sendRedirect 自动采用当前目录,如果需要从新跳转需要用绝对路径
            } catch (IOException e) {
                logger.info("/user/welcome" + "has direct error");
                e.printStackTrace();
            }
        }
    }


}
