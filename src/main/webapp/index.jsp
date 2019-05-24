<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>这是一个登陆页面(来自1)</title>
    <link rel="stylesheet" href="static/css/style.css">
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/js/jquery-3.4.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/md5.js"></script>
    <script src="static/js/login.js"></script>

</head>
<body>
<%--<form action="user/userShiroLogin" method="get">--%>
<form>
    <div class="form-group">
        <label for="exampleInputEmail1">用户名</label>
        <input type="text" class="form-control" name="userLonginName" id="exampleInputEmail1" placeholder="用户名">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control" name="userPassword" id="exampleInputPassword1" placeholder="密码">
    </div>
    <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
            验证码:<input id="checks" class="input-text size-L" type="text" value="" style="width:150px;"/>
            <img id="imgVerify" src="" alt="点击更换验证码"/>
            <button type="button" id="imgVerify2" class="btn btn-default">看不清，换一张</button>
        </div>
    </div>

    <button type="button" id="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
