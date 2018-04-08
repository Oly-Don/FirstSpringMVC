<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <title>注册 用户</title>
</head>
<body>


<h3>注册</h3>
<form action="register" method="post">
    <table>

        <tr>
            <td> 姓名:<input type="text" name="username" id="username"/></td>
        </tr>
        <tr>
            <td> 用户:<input type="text" name="id" id="id"/></td>
        </tr>
        <tr>
            <td> 密码:<input type="text" name="passwd" id="passwd"/></td>
        </tr>
        <tr>
            <td> 确认密码:<input type="text" name="repasswd" id="repasswd"/></td>
        </tr>


        <tr>
            <td><input type="submit" value="注册" name="注册"/></td>
        </tr>
    </table>
</form>

</body>
</html>
