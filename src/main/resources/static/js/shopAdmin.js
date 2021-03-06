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
                url: "http://localhost:8080/checkShopTel",
                type: "post",
                data: {
                    'shopTel': $(".tel").val()
                },
                dataType: "json",
                success: function (data) {
                    if(data==true){
                        $.ajax({
                            url: "http://localhost:8080/checkShopPass",
                            type: "post",
                            data: {
                                'shopTel': $(".tel").val(),
                                'shopPwd': $(".msg").val(),
                            },
                            dataType: "json",
                            success: function (data) {
                                if (data==true) {
                                    window.location.assign("http://localhost:8080/merchant.html")
                                }
                                else {
                                     $(".errorTel").show();
                                    $(".tel1").text("用户名或密码错误");
                                }
                            }
                        })
                    }else{
                        $(".errorTel").show();
                        $(".tel1").text("该手机号未注册");
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
                        window.location.assign("http://localhost:8080/merchant.html")
                        }else{
                            $.ajax({
                                url: "http://localhost:8080/checkShopTel",
                                type: "post",
                                data: {
                                    'shopTel': $(".tel").val()
                                },
                                dataType: "json",
                                success: function (data) {
                                 window.location.assign("http://localhost:8080/merchant.html")
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
function getShopID() {
    $.ajax({
        url: "http://localhost:8080/getShopId",
        type: "post",
        data: {
            'shopTel': $(".tel").val()
        },
        dataType: "json",
        success: function (data) {
            sessionStorage.setItem('shopID',data);
            window.location.assign("http://localhost:8080/mercant.html")
        }
    })

}