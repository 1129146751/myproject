<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--/shiro:hasRole;--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/css/style.css">

    <script src="static/js/jquery-3.4.1.js"></script>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/login.js"></script>

</head>
<body>
<shiro:hasRole name = "admin"></shiro:hasRole><%--用来初始化shiro权限的--%>

<shiro:hasRole name = "admin">admin欢迎你</shiro:hasRole>
<a href="<%=request.getServletPath()%>/../success.jsp">访问页面</a>
<br>
<a href="shiro/logout">退出</a>
<br>
<a href="user/userAdmin">权限(通过配置)</a>
<br>
<a href="user/userAdminAnon">权限(通过注解)</a>
<br>
<p>这是一个主页</p>
<a href="user/userLogin">get方法 </a>
<form action="user/userLogin3" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit">
</form>
<form method="post" action="user/userLogin3">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" name="PUT_REST"/>
</form>
<span onclick="gg()">gg</span>
<form method="post" action="upFileMethod" enctype="multipart/form-data">
    备注：<input type="text" name="fileName">
    <input type="file" name="uploadeFiles">
    <input type="submit">
</form>
<a href="laodFile">下载</a>


<p>---------------excel文件上传</p>
<form method="post" action="ecxelUpload" enctype="multipart/form-data">
    备注：<input type="text" name="fileName">
    <input type="file" name="file">
    <input type="submit">
</form>

<a href="${pageContext.request.contextPath}/ecxelDownload2">下载poi</a>
<a href="${pageContext.request.contextPath}/ecxelDownload">下载easy</a>
<p onclick="ecxelDownload()">打开静态页面</p>
<button class="btn btn-success">按钮</button>
<p>测试浏览器和页面访问</p>
<a href="user/browserAndPage">测试浏览器和页面访问</a>
<form method="post" action="user/browserAndPage">
    <input type="submit"/>
</form>
</body>
</html>
