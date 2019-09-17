$(function () {
    var flag = 0; //验证码是否正确标记位 1：正确 0：错误
    var validCode = true;
    $("#tel").focus(function () {
        $("#error").text("");
    })

    //判断手机号是否注册
    $(".getMsg").click(function () {
        if ($("#tel").val() == "") {

        } else {
            $.ajax({
                url: "http://localhost:8080/checkTel",
                type: "post",
                data: {
                    'tel': $("#tel").val()
                },
                dataType: "json",
                success: function (data) {
                    if (data == 1) {
                        $(".errorReg").text("该手机号以被注册，请直接登陆或密码找回");
                    } else {
                        $(".errorReg").text("已发送，一分钟后可重新获取");
                        var time = 60;
                        var code = $(".getMsg");
                        if (validCode) {
                            validCode = false;
                            var t = setInterval(function () {
                                code.attr("disabled", "true");
                                code.css({"opacity": "0.5", "cursor": "not-allowed"});
                                time--;
                                code.val("重新获取" + time + "秒");
                                if (time == 0) {
                                    code.css({"opacity": "1", "cursor": "pointer"});
                                    code.removeAttr("disabled");
                                    clearInterval(t);
                                    code.val("重新获取");
                                    validCode = true;
                                    $(".errorReg").text("");
                                }
                            }, 1000)
                        }
                    }
                }
            })

        }
    })
    //判断验证码是否正确
    $("#msgCheck").blur(function () {
        if ($("#msgCheck").val().length == 0) {
            $("#codeMsg").text("");
        }
        $.ajax({
            url: "http://localhost:8080/checkVerifyCode",
            type: "post",
            data: {
                'verifyCode': $("#msgCheck").val(),
                'tel': $("#tel").val()
            },
            dataType: "json",
            success: function (data) {
                if (data) {
                    $("#codeMsg").text("验证码正确");
                    flag = 1;
                } else {
                    if ($("#msgCheck").val().length > 0) {
                        $("#codeMsg").text("验证码错误");
                    }
                    flag = 0;
                }
            }
        })
    })
    //插入用户注册数据
    $("#registerButton").click(function () {
        if ($("#pass").val() != $("#repass").val()) {
            flag = 0;
        } else {
            flag = 1;
        }
        if (flag == 0) {

        } else {
            $.ajax({
                url: "http://localhost:8080/insertCustom",
                type: "post",
                data: {
                    'cusPwd': $("#pass").val(),
                    'cusTel': $("#tel").val()
                },
                dataType: "json",
                success:function (data) {
                    alert(data);
                    window.location.href = "http://localhost:8080/index.html";
                }
            })
            window.location.assign("http://localhost:8080/index.html");
        }
    })

    $("#registerForm").validate({
        success: function (label) {
            //label.text('').addClass('valid');
            label.removeClass('label');
            label.addClass("ok").css('color', '#666').text('');
        },
        onfocusout: function (element) {
            this.element(element);
        },
        rules: {
            tel: {
                required: true,
                regex: /^[1]([3-9])[0-9]{9}$/
            },
            cusPwd: {
                required: true,
                minlength: 6
            },
            repass: {
                required: true,
                minlength: 6,
                equalTo: "#pass"
            },
            verifyCode: {
                required: true
            }
        },
        messages: {
            tel: {
                required: "请输入手机号",
                regex: "请输入正确的11位手机号码"
            },
            cusPwd: {
                required: "请输入密码",
                minlength: "密码长度至少为6"
            },
            repass: {
                required: "请再次输入密码",
                minlength: "密码长度至少为6",
                equalTo: "两次密码不一致"
            },
            verifyCode: {
                required: "请输入短信动态码"
            }
        }
    });
})
