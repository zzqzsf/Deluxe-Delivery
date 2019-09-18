$(function(){
    // sessionStorage.setItem('telephone', $("input[name='telphone']").val());
    //页面间传参数（己方）
     var shopId =sessionStorage.getItem("shopId");
    //起送费
    var startMoney = 0;
    var oi=[];
    sessionStorage.setItem('foodNum', $("#num").val());
    var opFlag = -1;
    $("#MenuSort").css("display","block");
    $(".foodShow").css("display","block");
    $("#cartFixed").css("display","block");
    $("#menuAssess ul li").eq(0).css({borderBottom:"2px solid red",color:"red"});
    //设置菜品展示模板
    $foodShowModel = $(".foodShow:eq(0)");
    //购物车食物展示模板
    $cartFoodmodel = $(".cartFood:eq(0)");
    //设置评论模板
    $assessModel = $(".assessBigBox:eq(0)");
    //购物车的包装费和配送费
    $.ajax({
        url:"http://localhost:8080/shop",
        type:"post",
        data:{
            'shopId':$("#shopId").text()
        },
        dataType:"json",
        success:function (data) {
            $("#partOneLeft").children().eq(0).attr("src",data.shopImg);
            $("#shopName").children().eq(0).text(data.shopName);
            $("#score").text(data.shopCom);
            let level = data.shopCom*72/5;
            $("#startwo").css({width:level+"px"});
            $("#OpenTime").children().eq(1).text("地点："+data.shopAddr);
            $(".OneCenterBigBox:eq(1)").children().eq(1).children().eq(0).text(data.startPrice);
            $(".OneCenterBigBox:eq(2)").children().eq(1).children().eq(0).text(data.packagFee);
            $(".packCharge:eq(0)").children().eq(1).text("￥"+data.packagFee);
            $(".packCharge:eq(1)").children().eq(1).text("￥"+data.packagFee);
            $("#startSend").text("差"+data.startPrice+"元起送");
            $("#allMark").text(data.shopCom);
            level = data.shopCom*20;
            $("#marktwo").css({width:level+"%"});
        }
    });

    //食物分类和食物展示
    $.ajax({
        url:"http://localhost:8080/foodType",
        type:"post",
        cache:false,
        async:false,
        data:{
            'shopId':$("#shopId").text()
        },
        dataType:"json",
        success:function(data1){
            // alert(1);
            let count1 = data1.length;
            for (let i = 0;i <count1;i++){
                $("#MenuSort ul").append("<li>" +data1[i].ftyName + "</li>");
                let $node1 = $foodShowModel.clone(true);
                $node1.children().eq(0).text(data1[i].ftyName).attr("id",i);
                $.ajax({
                    url:"http://localhost:8080/food",
                    type: "post",
                    cache:false,
                    async:false,
                    data:{
                        'shopId':$("#shopId").text(),
                        'foodTypeId':data1[i].ftyId
                    },
                    dataType: "json",
                    success:function (data2) {
                        let count2 = data2.length;

                        for (let j = 0;j<count2;j++){
                            let $node2 = $(".foodSmallBox").eq(0).clone(true);
                            $node2.children().eq(0).attr("src",data2[j].foodPath);
                            $node2.children().eq(1).text(data2[j].foodName);
                            $node2.children().eq(2).empty();
                            $node2.children().eq(2).append("<span>￥</span>"+data2[j].foodPrice);
                            $node1.children().eq(1).prepend($node2);
                            // obj.detMoney=sum1;
                            // obj.foodNumber=$("input[name='num']").val;
                            // oi.push(obj);
                        }
                    }
                });
                $node1.children(1).children().last().detach();
                $("#cartShow").before($node1);
            }
        }
    });
    //菜品分类，当前页面跳转
    var $liLIst = $("#MenuSort ul li");
    $("#MenuSort ul li").click(function () {
        let i = $liLIst.index(this);
        let top = document.getElementById(i).offsetTop;
        document.getElementById(i).scrollIntoView({
            behavior: 'smooth'
        });
    });
    //去结算

    // var od={addrId: "1",
    //     orderNote:"1",
    //     orderStatus: "未完成付款",
    //     shopId:"1",
    //     estimatedTime: "1",}
    //     var orderVo={"order":od,"orderItems":oi};
    sessionStorage.setItem('shopId', $("#shopId").text());
    $("#startSend").click(function () {
       // $.ajax({
       //              url: "/insertOrder",
       //              data: JSON.stringify(orderVo),
       //              dataType: "text",
       //              type: "post",
       //              contentType: "application/json",//{name:'david',pass：'123'}
       //              success: function (text) {
       //                  alert("生成订单成功");
       //              }
       //          });
        window.location.href="takeOrder.html";
    })
    //选项卡功能
    $("#menuAssess ul li").eq(0).click(function () {
        $("#menuAssess ul li").eq(1).css({borderBottom:"0",color:"black"});
        $("#menuAssess ul li").eq(0).css({borderBottom:"2px solid red",color:"red"});
        $("#selectAssess").css("display","none");
        $(".assessBigBox").css("display","none");
        $("#markBigBox").css("display","none");
        $("#MenuSort").css("display","block");
        $(".foodShow").css("display","block");
        $("#cartShow").css("display","block");
        $("#cartFixed").css("display","block");
    });
    $("#menuAssess ul li").eq(1).click(function () {
        $("#menuAssess ul li").eq(0).css({borderBottom:"0",color:"black"});
        $("#menuAssess ul li").eq(1).css({borderBottom:"2px solid red",color:"red"});
        $("#MenuSort").css("display","none");
        $(".foodShow").css("display","none");
        $("#cartShow").css("display","none");
        $("#cartFixed").css("display","none");
        $("#selectAssess").css("display","block");
        $(".assessBigBox").css("display","block");
        $("#markBigBox").css("display","block");
    });
    //添加商品到购物车
    let addButList = $(".addButton");
    $(".addButton").click(function () {
        obj=new Object();
        $("#cartShow").css("display","block");
        $("#clearCart").show();
        $(".packCharge").show();
        $("#allMoney").show();
        $("#startSend").text("去结算");
        $("#startSend").css({backgroundColor:"#ffd161"});
        //获得当前商品的下标
        let i = addButList.index(this);
        let $node = $cartFoodmodel.clone(true);
        $node.children().eq(0).empty();
        $node.children().eq(0).text($(this).prevAll().eq(1).text());
        $node.children().eq(4).text($(this).prevAll().eq(0).text());
        $node.children().eq(5).text($(this).prevAll().eq(0).text());
        $node.find("#foodId").html($(this).foodTypeId);
        $("#clearCart").after($node);
        calcTotal();
        //$node.children().eq(0).text($(this).prevAll().eq(1).text()).html();
        obj.detMoney=$("#one-price").html();
        oi.push(obj);

    });
    //数量加一
    $("button[name='add']").click(function(){
        $(this).prev().val(parseInt($(this).prev().val()) + 1);
        $("input[name='num']").trigger("change");
    });
    //数量减一
    $("button[name='sub']").click(function(){
        if (parseInt($(this).next().val()) === 1){
            $(this).parent().detach();
            if ($(".cartFood").length === 0){
                $("#clearCart").hide();
                $(".packCharge").hide();
                $("#allMoney").hide();
                $("#startSend").text("差"+startMoney+"元起送");
                $("#startSend").css({backgroundColor:"#cccccc"});
            }
        }else{
            $(this).next().val(parseInt($(this).next().val()) - 1);
            $("input[name='num']").trigger("change");
        }
        calcTotal();
    });//计算合计
    $("input[name='num']").change(function(){
        var num1 = parseFloat($(this).val());
        var num2 = parseFloat($(this).nextAll().eq(1).text().substr(1));
        $(this).nextAll().eq(2).empty();
        $(this).nextAll().eq(2).text("￥"+num1*num2);
        calcTotal();
    });

    function calcTotal(){
        var sum1 = 0;
        var sum2 = 0;
        $(".cartFood").each(function(){
            let str = $(this).children().eq(5).text().substr(1);
            sum1 += parseFloat(str);
            sum2 += parseFloat($(this).children().eq(2).val());
        });
        sum1 += parseFloat($(".packCharge:eq(0)").children().eq(1).text().substr(1));
        sum1 += parseFloat($(".packCharge:eq(1)").children().eq(1).text().substr(1));
        $("#allMoney p").children().eq(1).text("￥"+sum1);
        $("#allMoney p").children().eq(0).text(sum2);
    }
    //清空购物车
    $("#clearCart").children().eq(1).click(function () {
        $("#clearCart").hide();
        $(".packCharge").hide();
        $("#allMoney").hide();
        $("#startSend").text("差"+startMoney+"元起送");
        $("#startSend").css({backgroundColor:"#cccccc"});
        $(".cartFood").detach();
    });
    //评论展示
    $.ajax({
        url:"http://localhost:8080/comment",
        type:"post",
        data:{
            'shopId':$("#shopId").text(),
            'level':opFlag
        },
        dataType:'json',
        success:function (data) {
            for (let i = 0;i< data.length;i++){
                let $node = $assessModel.clone(true);
                $node.children().eq(0).attr("src",data[i].custom.cusImg);
                $node.children().eq(1).text(data[i].custom.cusName);
                $node.children().eq(2).text(timestampToTime(data[i].comTime));
                var level = data[i].comLevel*20;
                $node.children().eq(3).children().eq(0).css({width:level+"%"});
                if (data[i].comLevel >3){
                    $node.children().eq(4).text("好评");
                } else if (data[i].comLevel > 2) {
                    $node.children().eq(4).text("中评");
                }else {
                    $node.children().eq(4).text("差评");
                }
                $node.children().eq(5).text(data[i].comText);
                $("#menuAssess").after($node);
            } 
        }
    });
    //处理时间字符串的方法
    function timestampToTime(times) {
        var date = new Date(times);
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate();
        return Y+M+D;
    }
    $(".assessBigBox:last").detach();
    $(".cartFood:last").detach();
    $(".foodShow:first").detach();
});