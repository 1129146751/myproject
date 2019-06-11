$(document).ready(function () {
    debugger
    //cookie数据保存格式是key=value;key=value;形式，loginInfo为保存在cookie中的key值，具体看controller代码
    var str = getCookie("loginInfo");
    str = str.substring(1,str.length-1);
    var username = str.split("!")[0];
    var password = str.split("!")[1];
    //自动填充用户名和密码
    $("#exampleInputEmail1").val(username);
    $("#exampleInputPassword1").val(password);
    // if(!(username==null||username=='')){
        $("#rememberMe").attr('checked', 'true');
    $("#rememberMe").val(1);
    // }

    $("#imgVerify").attr("src", "user/getVerify?" + Math.random());
    $("#imgVerify2").click(function () {
        $("#imgVerify").attr("src", "user/getVerify?" + Math.random());
    });

    function gg() {
        alert("sfljsl");
    }

    function openHtml() {
        alert();
        global.location.href = "/WEB-INF/html/test.html";
    }


    function ecxelDownload() {
        $.ajax({
            async: false,    //表示请求是否异步处理
            type: "get",    //请求类型
            url: "user/userLogin10",//请求的 URL地址
            dataType: "json",//返回的数据类型
            success: function (data) {
                debugger
                console.log("成功" + data);  //在控制台打印服务器端返回的数据
                window.location.href = "html/test.html";
            },
            error: function (data) {
                alert(data.result);
            }
        })
    }
    $("#rememberMe").click(function(){
        var remFlag = $("input:checkbox").is(':checked');
        if(remFlag){
            //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
            var conFlag = confirm("记录密码功能不宜在公共场所使用,以防密码泄露.您确定要使用此功能吗?");
            if(conFlag){
                //确认标志
                $("#rememberMe").val("1");
            }else{
                $("input:checkbox").removeAttr('checked');
                $("#rememberMe").val("0");
            }
        }else{
            //如果没选中设置remFlag为""
            $("#rememberMe").val("0");
        }
    })
    function remember(){
        debugger
        var remFlag = $("input:checkbox").is(':checked');
        if(remFlag){
            //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
            var conFlag = confirm("记录密码功能不宜在公共场所使用,以防密码泄露.您确定要使用此功能吗?");
            if(conFlag){
                //确认标志
                $("#rememberMe").val("1");
            }else{
                $("input:checkbox").removeAttr('checked');
                $("#rememberMe").val("0");
            }
        }else{
            //如果没选中设置remFlag为""
            $("#rememberMe").val("0");
        }
    }
    //获取cookie
    function getCookie(cname) {
        debugger
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1);
            if (c.indexOf(name) != -1) return c.substring(name.length-1, c.length);
        }
        return "";
    }

    $("#submit").click(function () {
        debugger

        var userPassword = hex_md5($("#exampleInputPassword1").val());
        var vaildata = $("#checks").val();
        console.log(vaildata);
        console.log(userPassword);
        var userLonginName = $("#exampleInputEmail1").val();
        console.log(userLonginName);
        $.ajax({
            async: false,    //表示请求是否异步处理
            type: "get",    //请求类型
            url: "user/userShiroLogin",//请求的 URL地址
            dataType: "json",//返回的数据类型
            contentType: 'text/json,charset=utf-8',
            data: {
                userPassword: userPassword,
                userLonginName: userLonginName,
                userLonginName2: $("#exampleInputEmail1").val(),
                rememberMe:$("#rememberMe").val(),
                vaildata: vaildata
            },

            success: function (data) {
                debugger
                if (data.code == 200) {
                    console.log("成功" + data);  //在控制台打印服务器端返回的数据
                    window.location.href = "zhuye";
                    // window.location.href="html/test.html";
                } else {
                    alert(data.msg);
                }
            },
            error: function (data) {
                alert(data.result);
            }
        })
    })
});
