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
    //判断商铺名字
    $("#shopName").blur(function () {
        $.ajax({
            url: "http://localhost:8080/checkShopName",
            type: "post",
            data: {
                'shopName':$("#shopName").val(),
            },
            dataType: "json",
            success: function (data) {
                if (data != true) {
                    $("#shopNameMsg").text("该商家名已被注册");
                    return flag = 0;
                }
            }
        })
    })

    $('#suggestId').focus(function () {
        $('#l-map').show();
    });
    $('#suggestId').blur(function () {
        $('#l-map').hide();
    });


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
});

// 百度地图API功能
function G(id) {
    return document.getElementById(id);
}

var map = new BMap.Map("l-map");
var point = new BMap.Point(116.331398,39.897445);
map.centerAndZoom(point,12);                  // 初始化地图,设置城市和地图级别。
// 创建地址解析器实例
var myGeo = new BMap.Geocoder();



var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
    {
        "input": "suggestId"
        , "location": map
    });

ac.addEventListener("onhighlight", function (e) {  //鼠标放在下拉列表上的事件
    var str = "";
    var _value = e.fromitem.value;
    var value = "";
    if (e.fromitem.index > -1) {
        value = _value.province + _value.city + _value.district + _value.street + _value.business;
    }
    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

    value = "";
    if (e.toitem.index > -1) {
        _value = e.toitem.value;
        value = _value.province + _value.city + _value.district + _value.street + _value.business;
    }
    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
    G("searchResultPanel").innerHTML = str;
});

var myValue;
ac.addEventListener("onconfirm", function (e) {    //鼠标点击下拉列表后的事件
    var _value = e.item.value;
    myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
    G("searchResultPanel").innerHTML = "onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

    setPlace();
});

function setPlace() {
    map.clearOverlays();    //清除地图上所有覆盖物
    function myFun() {
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        map.centerAndZoom(pp, 18);
        map.addOverlay(new BMap.Marker(pp));    //添加标注
    }

    var local = new BMap.LocalSearch(map, { //智能搜索
        onSearchComplete: myFun
    });
    local.search(myValue);
}
var jingdu;
var weidu;
$("#suggestId").blur(function () {
    myGeo.getPoint($("#suggestId").val(), function (point) {
        if (point) {
            jingdu = point.lng;
            weidu = point.lat;
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        }
    }, "厦门市");
    $.ajax({
        url: "http://localhost:8080/insertLoction",
        type: "post",
        data: {
            "jingdu":jingdu,
            "weidu":weidu,
            'name':$("#shopName").val(),
        },
        dataType: "json",
        success: function (data) {
            alert(data);
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
