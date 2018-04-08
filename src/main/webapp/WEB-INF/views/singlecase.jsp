<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/7
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%-- ①引入标签的声明--%>
<html>
<head>
    <title>用例执行页面</title>
</head>
<body>


<form:form method="post" modelAttribute="RunnerVo" action="runsingle">
    <table>
        <tr>
            <td> url:</td>
            <td><form:input type="text" id="url" path="url"></form:input></td>
        </tr>
        <tr>
            <td> 调用方法:</td>
            <td><form:checkboxes path="httpMethods" items="${methodsList}" width="50px"/></td>
        </tr>
        <tr>
            <td> 头部:</td>
            <td><form:checkboxes path="conterctTypes" items="${contectTypesList}"/></td>
        </tr>
        <tr>
            <td>Body:</td>
            <td>
                <form:textarea path="body" rows="30%" cols="80%"/>
                <form:errors path="body" id="errorMessage">
                    [${requestScope.errorMessage}]
                </form:errors>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="执行"></td>
        </tr>
        <tr>
            <td> 返回信息:</td>
            <td><form:textarea path="resultInfo" rows="20%" cols="80%"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>
