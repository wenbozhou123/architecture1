<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome login page</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/front/login" method="post">
    <table width="100%">
        <tr height="200">
            <td colspan="2">&nbsp;</td>
        </tr>
        <tr>
            <td width="350">&nbsp;</td>
            <td>
                <table>
                    <tr>
                        <td>登录名：</td>
                        <td><input type="text" name="customerId"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="pwd"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="登录"></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
