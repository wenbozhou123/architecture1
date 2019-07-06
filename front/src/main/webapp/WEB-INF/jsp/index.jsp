<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags" %>


<table width="70%" align="center">
    <tr>
        <td colspan=4><a href="${pageContext.request.contextPath}/index/toCart">查看购物车</a></td>
    </tr>
    <c:set var="num" value="0"></c:set>
    <c:forEach var="m" items="${page.result}">
        <c:if test="${num==0}">
            <tr>
        </c:if>
        <td>
            <a href="${pageContext.request.contextPath}/index/toGoodsDesc/${m.uuid}">
                <table>
                    <tr>
                        <td><img alt="" src="${pageContext.request.contextPath}/static/images/logo.gif"/></td>
                        <td>${m.description }</td>
                    </tr>
                    <tr>
                        <td>${m.name }</td>
                    </tr>
                </table>
            </a>
        </td>
        <c:set var="num" value="${num+1}"></c:set>
        <c:if test="${num==3}">
            <c:set var="num" value="0"></c:set>
            </tr>
        </c:if>
    </c:forEach>
</table>
</html>
