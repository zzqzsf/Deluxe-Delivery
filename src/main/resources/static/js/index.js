$(function () {
    // 百度地图API功能
    function G(id) {
        return document.getElementById(id);
    }
    var cityName;

    var map = new BMap.Map("allmap"); //创建地图实例
    var point = new BMap.Point(116.331398, 39.897445); //创建点坐标
    map.centerAndZoom(point, 13); //初始化地图，设置中心点坐标和地图级别
    var myGeo = new BMap.Geocoder();// 创建地址解析器实例


    function myFun(result) {
        cityName = result.name;
        map.setCenter(cityName);
        $("#test1").val(cityName);
    }

    var myCity = new BMap.LocalCity();
    myCity.get(myFun);

    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
        {"input" : "search"
            ,"location" : map
        });


    ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
        var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });

    var myValue;
    ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
        var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
    });

    $("#search1").click(function () {
        myGeo.getPoint($("#search").val(), function(point){
            if (point) {
                alert(point.lng+","+point.lat);
                map.centerAndZoom(point, 16);
                map.addOverlay(new BMap.Marker(point));
            }else{
                alert("您选择地址没有解析到结果!");
            }
        }, cityName);
    })

})








