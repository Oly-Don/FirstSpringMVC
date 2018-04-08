<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/7
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TESTCASE RUNNER</title>
</head>
<body>
<form method="post" action="testcastrunner">
    <table>
        <tr>
            <td> url:</td>
            <td><input type="text" id="url" path="url"/></td>
        </tr>
        <tr>
            <td> 调用方法:</td>
            <td>
                <select id="httpMethods">
                    <option>
                        post
                    </option>
                    <option>
                        get
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td> 头部:</td>
            <td>
                <select id="contectType">
                    <option>
                        application/json
                    </option>
                    <option>
                        application/xml
                    </option>
                </select>

            </td>
        </tr>
        <tr>
            <td>Body:</td>
            <td>
                <input type="text" name="body" id="body">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="执行"></td>
        </tr>
        <tr>
            <td> 返回信息:</td>
            <td>
                <input type="text" name="resultInfo" id="resultInfo">[${requestScope.resultError}]
            </td>

        </tr>
    </table>
</form>


</body>
</html>
