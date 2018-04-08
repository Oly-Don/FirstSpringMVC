<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
    <title>Login Page</title>
</head>
<body>
<h3>用户登录</h3>
<form action="login" method="post">
    <table>
        <tr>
            <td> 用户:<input type="text" name="id" id="id"/></td>
        </tr>
        <tr>
            <td> 密码:<input type="text" name="passwd" id="passwd"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录" id="loginbutton"/></td>
        </tr>
        <%--
                <tr>
                    <td><input type="button" value="注册" name="注册" /></td>
                </tr>--%>

        <%--

        POST /FirstSpringMVC/user/login HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 13
Cache-Control: max-age=0
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
Referer: http://localhost:8080/FirstSpringMVC/user/login
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cookie: JSESSIONID=4832FF0EC4889FE8D4E673C7CCD31DC1

        --%>
    </table>
</form>

</body>
</html>
