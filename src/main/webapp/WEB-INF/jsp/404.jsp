<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
</head>
<body>
<%--<%= request.getServletPath()%>
<%=request.getServletContext().getRealPath("/")%>
${pageContext.request.contextPath}
<p>开始疯狂2222</p>--%>
<img src="${pageContext.request.contextPath}/static/error/404.jpg">
</body>
</html>