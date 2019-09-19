$(function () {
    var validCode=true;
    $("#selectAdmin").click(function () {
        if($(this).text()=="普通方式登录"){
            $(this).text("手机动态码登录");
            $(".tel").attr("placeholder","手机号");
            $(".msg").attr("placeholder","密码");
            $(".msg").attr("type","password");
            $("#getMsg").hide();

        }else{
            $(this).text("普通方式登录");
            $(".tel").attr("placeholder","请输入手机号，未注册将自动注册");
            $(".msg").attr("placeholder","动态码");
            $("#getMsg").text("获取手机动态码");
            $(".msg").attr("type","text");
            $("#getMsg").show();
        }
    })

    //发送验证码
    $("#getMsg").click(function () {
        if($(".tel").val().length != 11){
            $(".errorTel").show();
        }else{
            $(".errorTel").hide();
            $.ajax({
                url: "http://localhost:8080/sendVerifyCode",
                type: "post",
                data: {
                    'tel': $(".tel").val()
                },
                dataType: "json",
                success: function (data) {
                    $(".sendMsg").css("display","inline");
                    if(data){
                        var time=60;
                        var code=$("#getMsg");
                        if (validCode) {
                            validCode=false;
                            var t=setInterval(function  () {
                                code.attr("disabled","true");
                                time--;
                                code.val("重新获取"+time+"秒");
                                code.css({"cursor": "not-allowed", "opacity": "0.5"});
                                if (time==0) {

                                    code.attr("disabled","false");
                                    code.css({"cursor": "pointer", "opacity": "1"});
                                    clearInterval(t);
                                    code.val("重新获取");
                                    validCode=true;
                                }
                            },1000)
                        }
                    }
                }
            })
        }
    })
    //判断验证码是否正确，再判断该用户是否注册，没注册将自动注册，若注册将成功登陆
    $(".admin1").click(function () {
        if($("#selectAdmin").text()=="手机动态码登录"){
            $.ajax({
                url: "http://localhost:8080/checkCustom",
                type: "post",
                data: {
                    'cusPwd': $(".msg").val(),
                    'cusTel': $(".tel").val()
                },
                dataType: "json",
                success: function (data) {
                    if(data==1){
                        $.ajax({
                            url: "http://localhost:8080/getUserId",
                            type: "post",
                            data: {
                                'cusTel': $(".tel").val()
                            },
                            dataType: "json",
                            success: function (data) {
                                getCudID();
                                window.location.assign("http://localhost:8080/index.html")
                            }
                        })
                        window.location.assign("http://localhost:8080/index.html");
                    }else{
                        $(".errorTel").show();
                        $(".tel1").text("用户名或者密码错误");
                    }
                }
            })
        }else{
            $.ajax({
                url: "http://localhost:8080/checkVerifyCode1",
                type: "post",
                data: {
                    'verifyCode': $(".msg").val(),
                    'tel': $(".tel").val()
                },
                dataType: "json",
                success: function (data) {
                    if(data.flag){
                        $(".errorTel").hide();
                        if(data.rowNum==1){
                            getCudID();
                        }else{
                            $.ajax({
                                url: "http://localhost:8080/insertCustom1",
                                type: "post",
                                data: {
                                    'cusTel': $(".tel").val()
                                },
                                dataType: "json",
                                success: function (data) {
                                    getCudID();
                                }
                            })
                        }
                    }else{
                        $(".errorTel").show();
                        $(".tel1").text("验证码错误");
                    }
                }
            })
        }

    })
})
function getCudID() {
    $.ajax({
        url: "http://localhost:8080/getUserId",
        type: "post",
        data: {
            'cusTel': $(".tel").val()
        },
        dataType: "json",
        success: function (data) {
            sessionStorage.setItem('cusID',data);
            window.location.assign("http://localhost:8080/index.html")
        }
    })

}