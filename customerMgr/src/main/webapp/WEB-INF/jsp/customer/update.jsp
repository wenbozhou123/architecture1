<%--
  Created by IntelliJ IDEA.
  User: Zhou Bowen
  Date: 2019/6/10
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/static/css/application.css" rel="stylesheet">
</head>
<body>
<form action="${pageContext.request.contextPath}/customer/update" method="post">
    <input type="hidden" name="uuid" value="${cm.uuid }" />
    <input type="hidden" name="registerTime" value="${cm.registerTime }" />
    <table width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine">
        <tr>
            <td colspan=4 align=center class="tableLineBg">客户修改</td>
        </tr>
        <tr>
            <td>客户编号</td>
            <td><input type="text" name="customerId" value="${cm.customerId}" class="input"></td>
            <td>客户密码</td>
            <td><input type="text" name="pwd" value="${cm.pwd}" class="input"></td>
        </tr>
        <tr>
            <td>显示名称</td>
            <td><input type="text" name="showName" value="${cm.showName}" class="input"></td>
            <td>真实姓名</td>
            <td><input type="text" name="trueName" value="${cm.trueName}" class="input"></td>
        </tr>
        <tr>
            <td colspan=4 align=center><input type="submit" value="修改" class="button"></td>
        </tr>
    </table>
</form>

</body>
</html>
