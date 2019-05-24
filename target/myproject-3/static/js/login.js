$(document).ready(function() {
    // alert();
    // debugger
    $("#imgVerify").attr("src","user/getVerify?"+Math.random());
    $("#imgVerify2").click(function(){
        $("#imgVerify").attr("src","user/getVerify?"+Math.random());
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

    $("#submit").click(function () {
        debugger

        var  userPassword=hex_md5($("#exampleInputPassword1").val());
        var vaildata=$("#checks").val();
        console.log(vaildata);
        console.log(userPassword);
        var userLonginName=$("#exampleInputEmail1").val();
        console.log(userLonginName);
        $.ajax({
            async: false,    //表示请求是否异步处理
            type: "get",    //请求类型
            url: "user/userShiroLogin",//请求的 URL地址
            dataType: "json",//返回的数据类型
            contentType: 'text/json,charset=utf-8',
            data:{
                userPassword:userPassword,
                userLonginName:userLonginName,
                userLonginName2:$("#exampleInputEmail1").val(),
                vaildata:vaildata
                  },

            success: function (data) {
                debugger
                if(data.code==200){
                    console.log("成功" + data);  //在控制台打印服务器端返回的数据
                    window.location.href="zhuye";
                    // window.location.href="html/test.html";
                }else{
                    alert(data.msg);
                }
            },
            error: function (data) {
                alert(data.result);
            }
        })
    })
});
