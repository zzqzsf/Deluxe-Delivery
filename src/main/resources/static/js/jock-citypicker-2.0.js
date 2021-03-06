/*!
 * jock-citypicker  v2.0
 * Copyright 2012, JockChou
 * Date: Sat Feb 13 22:33:48 2010 -0500
 * Email: 164068300@qq.com
 * QQ:164068300
 */

(function (host) {
    var window = host || window,
        doc = document,
        selectedCity = "",
        popUpCityFrame = null,
        selectEventProxy = null,
        hotEventProxy = null,
        scrollEventProxy = null,
        toString = Object.prototype.toString,
        city = {
            A: [
                {
                    name: "张志强",
                    spell: "zhangzhiqiang"
                },
                {
                    name: "阿克苏",
                    spell: "aksu"
                },
                {
                    name: "阿拉善",
                    spell: "alashan"
                },
                {
                    name: "阿里",
                    spell: "ali"
                },
                {
                    name: "阿勒泰",
                    spell: "altay"
                },
                {
                    name: "安康",
                    spell: "ankang"
                },
                {
                    name: "安庆",
                    spell: "anqing"
                },
                {
                    name: "鞍山",
                    spell: "anshan"
                },
                {
                    name: "安顺",
                    spell: "anshun"
                },
                {
                    name: "安阳",
                    spell: "anyang"
                },
                {
                    name: "澳门",
                    spell: "aomen"
                }],
            B: [{
                name: "白城",
                spell: "baicheng"
            },
                {
                    name: "百色",
                    spell: "baise"
                },
                {
                    name: "白山",
                    spell: "baishan"
                },
                {
                    name: "白银",
                    spell: "baiyin"
                },
                {
                    name: "保定",
                    spell: "baoding"
                },
                {
                    name: "宝鸡",
                    spell: "baoji"
                },
                {
                    name: "保山",
                    spell: "baoshan"
                },
                {
                    name: "包头",
                    spell: "baotou"
                },
                {
                    name: "巴彦淖尔",
                    spell: "bayannaoer"
                },
                {
                    name: "巴音郭楞",
                    spell: "bayinguoleng"
                },
                {
                    name: "巴中",
                    spell: "bazhong"
                },
                {
                    name: "北海",
                    spell: "beihai"
                },
                {
                    name: "北京",
                    spell: "beijing"
                },
                {
                    name: "蚌埠",
                    spell: "bengbu"
                },
                {
                    name: "本溪",
                    spell: "benxi"
                },
                {
                    name: "毕节",
                    spell: "bijie"
                },
                {
                    name: "滨州",
                    spell: "binzhou"
                },
                {
                    name: "博尔塔拉",
                    spell: "boertala"
                },
                {
                    name: "亳州",
                    spell: "bozhou"
                }],
            C: [{
                name: "沧州",
                spell: "cangzhou"
            },
                {
                    name: "长春",
                    spell: "changchun"
                },
                {
                    name: "常德",
                    spell: "changde"
                },
                {
                    name: "昌都",
                    spell: "changdu"
                },
                {
                    name: "昌吉",
                    spell: "changji"
                },
                {
                    name: "长沙",
                    spell: "changsha"
                },
                {
                    name: "长治",
                    spell: "changzhi"
                },
                {
                    name: "常州",
                    spell: "changzhou"
                },
                {
                    name: "巢湖",
                    spell: "chaohu"
                },
                {
                    name: "朝阳",
                    spell: "chaoyang"
                },
                {
                    name: "潮州",
                    spell: "chaozhou"
                },
                {
                    name: "承德",
                    spell: "chengde"
                },
                {
                    name: "成都",
                    spell: "chengdu"
                },
                {
                    name: "郴州",
                    spell: "chenzhou"
                },
                {
                    name: "赤峰",
                    spell: "chifeng"
                },
                {
                    name: "池州",
                    spell: "chizhou"
                },
                {
                    name: "重庆",
                    spell: "chongqing"
                },
                {
                    name: "崇左",
                    spell: "chongzuo"
                },
                {
                    name: "楚雄",
                    spell: "chuxiong"
                },
                {
                    name: "滁州",
                    spell: "chuzhou"
                },
                {
                    name: "长汀",
                    spell: "changting"
                },
            ],
            D: [{
                name: "大理",
                spell: "dali"
            },
                {
                    name: "大连",
                    spell: "dalian"
                },
                {
                    name: "丹东",
                    spell: "dandong"
                },
                {
                    name: "儋州",
                    spell: "danzhou"
                },
                {
                    name: "大庆",
                    spell: "daqing"
                },
                {
                    name: "大同",
                    spell: "datong"
                },
                {
                    name: "大兴安岭",
                    spell: "daxinganling"
                },
                {
                    name: "达州",
                    spell: "dazhou"
                },
                {
                    name: "德宏",
                    spell: "dehong"
                },
                {
                    name: "德阳",
                    spell: "deyang"
                },
                {
                    name: "德州",
                    spell: "dezhou"
                },
                {
                    name: "定西",
                    spell: "dingxi"
                },
                {
                    name: "迪庆",
                    spell: "diqing"
                },
                {
                    name: "东方",
                    spell: "dongfang"
                },
                {
                    name: "东莞",
                    spell: "dongguan"
                },
                {
                    name: "东营",
                    spell: "dongying"
                }],
            E: [{
                name: "鄂尔多斯",
                spell: "eerduosi"
            },
                {
                    name: "恩施",
                    spell: "enshi"
                },
                {
                    name: "鄂州",
                    spell: "ezhou"
                }],
            F: [{
                name: "防城港",
                spell: "fangchenggang"
            },
                {
                    name: "佛山",
                    spell: "foshan"
                },
                {
                    name: "抚顺",
                    spell: "fushun"
                },
                {
                    name: "阜新",
                    spell: "fuxin"
                },
                {
                    name: "阜阳",
                    spell: "fuyang"
                },
                {
                    name: "福州",
                    spell: "fuzhou"
                },
                {
                    name: "抚州",
                    spell: "fuzhou1"
                }],
            G: [{
                name: "甘南",
                spell: "gannan"
            },
                {
                    name: "赣州",
                    spell: "ganzhou"
                },
                {
                    name: "甘孜",
                    spell: "ganzi"
                },
                {
                    name: "广安",
                    spell: "guang,an"
                },
                {
                    name: "广元",
                    spell: "guangyuan"
                },
                {
                    name: "广州",
                    spell: "guangzhou"
                },
                {
                    name: "贵港",
                    spell: "guigang"
                },
                {
                    name: "桂林",
                    spell: "guilin"
                },
                {
                    name: "贵阳",
                    spell: "guiyang"
                },
                {
                    name: "果洛",
                    spell: "guoluo"
                },
                {
                    name: "固原",
                    spell: "guyuan"
                }],
            H: [{
                name: "哈尔滨",
                spell: "haerbin"
            },
                {
                    name: "海北",
                    spell: "haibei"
                },
                {
                    name: "海东",
                    spell: "haidong"
                },
                {
                    name: "海口",
                    spell: "haikou"
                },
                {
                    name: "海南",
                    spell: "hainan"
                },
                {
                    name: "海西",
                    spell: "haixi"
                },
                {
                    name: "哈密",
                    spell: "hami"
                },
                {
                    name: "邯郸",
                    spell: "handan"
                },
                {
                    name: "杭州",
                    spell: "hangzhou"
                },
                {
                    name: "汉中",
                    spell: "hanzhong"
                },
                {
                    name: "鹤壁",
                    spell: "hebi"
                },
                {
                    name: "河池",
                    spell: "hechi"
                },
                {
                    name: "合肥",
                    spell: "hefei"
                },
                {
                    name: "鹤岗",
                    spell: "hegang"
                },
                {
                    name: "黑河",
                    spell: "heihe"
                },
                {
                    name: "衡水",
                    spell: "hengshui"
                },
                {
                    name: "衡阳",
                    spell: "hengyang"
                },
                {
                    name: "河源",
                    spell: "heyuan"
                },
                {
                    name: "菏泽",
                    spell: "heze"
                },
                {
                    name: "贺州",
                    spell: "hezhou"
                },
                {
                    name: "红河",
                    spell: "honghe"
                },
                {
                    name: "和田",
                    spell: "hotan"
                },
                {
                    name: "淮安",
                    spell: "huaian"
                },
                {
                    name: "淮北",
                    spell: "huaibei"
                },
                {
                    name: "怀化",
                    spell: "huaihua"
                },
                {
                    name: "淮南",
                    spell: "huainan"
                },
                {
                    name: "黄冈",
                    spell: "huanggang"
                },
                {
                    name: "黄南",
                    spell: "huangnan"
                },
                {
                    name: "黄山",
                    spell: "huangshan"
                },
                {
                    name: "黄石",
                    spell: "huangshi"
                },
                {
                    name: "呼和浩特",
                    spell: "huhehaote"
                },
                {
                    name: "惠州",
                    spell: "huizhou"
                },
                {
                    name: "葫芦岛",
                    spell: "huludao"
                },
                {
                    name: "呼伦贝尔",
                    spell: "hulunbeier"
                },
                {
                    name: "湖州",
                    spell: "huzhou"
                }],
            J: [{
                name: "佳木斯",
                spell: "jiamusi"
            },
                {
                    name: "吉安",
                    spell: "jian"
                },
                {
                    name: "江门",
                    spell: "jiangmen"
                },
                {
                    name: "焦作",
                    spell: "jiaozuo"
                },
                {
                    name: "嘉兴",
                    spell: "jiaxing"
                },
                {
                    name: "嘉峪关",
                    spell: "jiayuguan"
                },
                {
                    name: "揭阳",
                    spell: "jieyang"
                },
                {
                    name: "吉林",
                    spell: "jilin"
                },
                {
                    name: "济南",
                    spell: "jinan"
                },
                {
                    name: "金昌",
                    spell: "jinchang"
                },
                {
                    name: "晋城",
                    spell: "jincheng"
                },
                {
                    name: "景德镇",
                    spell: "jingdezhen"
                },
                {
                    name: "荆门",
                    spell: "jingmen"
                },
                {
                    name: "荆州",
                    spell: "jingzhou"
                },
                {
                    name: "金华",
                    spell: "jinhua"
                },
                {
                    name: "济宁",
                    spell: "jining"
                },
                {
                    name: "晋中",
                    spell: "jinzhong"
                },
                {
                    name: "锦州",
                    spell: "jinzhou"
                },
                {
                    name: "九江",
                    spell: "jiujiang"
                },
                {
                    name: "酒泉",
                    spell: "jiuquan"
                },
                {
                    name: "鸡西",
                    spell: "jixi"
                },
                {
                    name: "济源",
                    spell: "jiyuan"
                }],
            K: [{
                name: "开封",
                spell: "kaifeng"
            },
                {
                    name: "克拉玛依",
                    spell: "karamay"
                },
                {
                    name: "喀什",
                    spell: "kashi"
                },
                {
                    name: "克州",
                    spell: "kezhou"
                },
                {
                    name: "昆明",
                    spell: "kunming"
                }],
            L: [{
                name: "来宾",
                spell: "laibin"
            },
                {
                    name: "莱芜",
                    spell: "laiwu"
                },
                {
                    name: "廊坊",
                    spell: "langfang"
                },
                {
                    name: "兰州",
                    spell: "lanzhou"
                },
                {
                    name: "拉萨",
                    spell: "lasa"
                },
                {
                    name: "乐山",
                    spell: "leshan"
                },
                {
                    name: "凉山",
                    spell: "liangshan"
                },
                {
                    name: "连云港",
                    spell: "lianyungang"
                },
                {
                    name: "聊城",
                    spell: "liaocheng"
                },
                {
                    name: "辽阳",
                    spell: "liaoyang"
                },
                {
                    name: "辽源",
                    spell: "liaoyuan"
                },
                {
                    name: "丽江",
                    spell: "lijiang"
                },
                {
                    name: "临沧",
                    spell: "lincang"
                },
                {
                    name: "临汾",
                    spell: "linfen"
                },
                {
                    name: "临夏",
                    spell: "linxia"
                },
                {
                    name: "临沂",
                    spell: "linyi"
                },
                {
                    name: "林芝",
                    spell: "linzhi"
                },
                {
                    name: "丽水",
                    spell: "lishui"
                },
                {
                    name: "六安",
                    spell: "liuan"
                },
                {
                    name: "六盘水",
                    spell: "liupanshui"
                },
                {
                    name: "柳州",
                    spell: "liuzhou"
                },
                {
                    name: "陇南",
                    spell: "longnan"
                },
                {
                    name: "龙岩",
                    spell: "longyan"
                },
                {
                    name: "娄底",
                    spell: "loudi"
                },
                {
                    name: "漯河",
                    spell: "luohe"
                },
                {
                    name: "洛阳",
                    spell: "luoyang"
                },
                {
                    name: "泸州",
                    spell: "luzhou"
                },
                {
                    name: "吕梁",
                    spell: "lvliang"
                }],
            M: [{
                name: "马鞍山",
                spell: "maanshan"
            },
                {
                    name: "茂名",
                    spell: "maoming"
                },
                {
                    name: "眉山",
                    spell: "meishan"
                },
                {
                    name: "梅州",
                    spell: "meizhou"
                },
                {
                    name: "绵阳",
                    spell: "mianyang"
                },
                {
                    name: "牡丹江",
                    spell: "mudanjiang"
                }],
            N: [{
                name: "南昌",
                spell: "nanchang"
            },
                {
                    name: "南充",
                    spell: "nanchong"
                },
                {
                    name: "南京",
                    spell: "nanjing"
                },
                {
                    name: "南宁",
                    spell: "nanning"
                },
                {
                    name: "南平",
                    spell: "nanping"
                },
                {
                    name: "南通",
                    spell: "nantong"
                },
                {
                    name: "南阳",
                    spell: "nanyang"
                },
                {
                    name: "那曲",
                    spell: "naqu"
                },
                {
                    name: "内江",
                    spell: "neijiang"
                },
                {
                    name: "宁波",
                    spell: "ningbo"
                },
                {
                    name: "宁德",
                    spell: "ningde"
                },
                {
                    name: "怒江",
                    spell: "nujiang"
                }],
            P: [{
                name: "盘锦",
                spell: "panjin"
            },
                {
                    name: "攀枝花",
                    spell: "panzhihua"
                },
                {
                    name: "平顶山",
                    spell: "pingdingshan"
                },
                {
                    name: "平凉",
                    spell: "pingliang"
                },
                {
                    name: "萍乡",
                    spell: "pingxiang"
                },
                {
                    name: "普洱",
                    spell: "puer"
                },
                {
                    name: "莆田",
                    spell: "putian"
                },
                {
                    name: "濮阳",
                    spell: "puyang"
                }],
            Q: [{
                name: "黔东南",
                spell: "qiandongnan"
            },
                {
                    name: "潜江",
                    spell: "qianjiang"
                },
                {
                    name: "黔南",
                    spell: "qiannan"
                },
                {
                    name: "黔西南",
                    spell: "qianxinan"
                },
                {
                    name: "青岛",
                    spell: "qingdao"
                },
                {
                    name: "庆阳",
                    spell: "qingyang"
                },
                {
                    name: "清远",
                    spell: "qingyuan"
                },
                {
                    name: "秦皇岛",
                    spell: "qinhuangdao"
                },
                {
                    name: "钦州",
                    spell: "qinzhou"
                },
                {
                    name: "琼海",
                    spell: "qionghai"
                },
                {
                    name: "齐齐哈尔",
                    spell: "qiqihar"
                },
                {
                    name: "七台河",
                    spell: "qitaihe"
                },
                {
                    name: "泉州",
                    spell: "quanzhou"
                },
                {
                    name: "曲靖",
                    spell: "qujing"
                },
                {
                    name: "衢州",
                    spell: "quzhou"
                }],
            R: [{
                name: "日照",
                spell: "rizhao"
            }],
            S: [{
                name: "三门峡",
                spell: "sanmenxia"
            },
                {
                    name: "三明",
                    spell: "sanming"
                },
                {
                    name: "三亚",
                    spell: "sanya"
                },
                {
                    name: "上海",
                    spell: "shanghai"
                },
                {
                    name: "商洛",
                    spell: "shangluo"
                },
                {
                    name: "商丘",
                    spell: "shangqiu"
                },
                {
                    name: "上饶",
                    spell: "shangrao"
                },
                {
                    name: "山南",
                    spell: "shannan"
                },
                {
                    name: "汕头",
                    spell: "shantou"
                },
                {
                    name: "汕尾",
                    spell: "shanwei"
                },
                {
                    name: "韶关",
                    spell: "shaoguan"
                },
                {
                    name: "绍兴",
                    spell: "shaoxing"
                },
                {
                    name: "邵阳",
                    spell: "shaoyang"
                },
                {
                    name: "神农架",
                    spell: "shennongjia"
                },
                {
                    name: "沈阳",
                    spell: "shenyang"
                },
                {
                    name: "深圳",
                    spell: "shenzhen"
                },
                {
                    name: "石河子",
                    spell: "shihezi"
                },
                {
                    name: "石家庄",
                    spell: "shijiazhuang"
                },
                {
                    name: "十堰",
                    spell: "shiyan"
                },
                {
                    name: "石嘴山",
                    spell: "shizuishan"
                },
                {
                    name: "双鸭山",
                    spell: "shuangyashan"
                },
                {
                    name: "朔州",
                    spell: "shuozhou"
                },
                {
                    name: "四平",
                    spell: "siping"
                },
                {
                    name: "松原",
                    spell: "songyuan"
                },
                {
                    name: "绥化",
                    spell: "suihua"
                },
                {
                    name: "遂宁",
                    spell: "suining"
                },
                {
                    name: "随州",
                    spell: "suizhou"
                },
                {
                    name: "宿迁",
                    spell: "suqian"
                },
                {
                    name: "苏州",
                    spell: "suzhou"
                },
                {
                    name: "宿州",
                    spell: "suzhou1"
                }],
            T: [{
                name: "塔城",
                spell: "tacheng"
            },
                {
                    name: "泰安",
                    spell: "taian"
                },
                {
                    name: "台北",
                    spell: "taibei"
                },
                {
                    name: "太原",
                    spell: "taiyuan"
                },
                {
                    name: "台州",
                    spell: "taizhou"
                },
                {
                    name: "泰州",
                    spell: "taizhou1"
                },
                {
                    name: "唐山",
                    spell: "tangshan"
                },
                {
                    name: "天津",
                    spell: "tianjin"
                },
                {
                    name: "天门",
                    spell: "tianmen"
                },
                {
                    name: "天水",
                    spell: "tianshui"
                },
                {
                    name: "铁岭",
                    spell: "tieling"
                },
                {
                    name: "铜川",
                    spell: "tongchuan"
                },
                {
                    name: "通化",
                    spell: "tonghua"
                },
                {
                    name: "通辽",
                    spell: "tongliao"
                },
                {
                    name: "铜陵",
                    spell: "tongling"
                },
                {
                    name: "铜仁",
                    spell: "tongren"
                },
                {
                    name: "吐鲁番",
                    spell: "turpan"
                }],
            W: [{
                name: "万宁",
                spell: "wanning"
            },
                {
                    name: "潍坊",
                    spell: "weifang"
                },
                {
                    name: "威海",
                    spell: "weihai"
                },
                {
                    name: "渭南",
                    spell: "weinan"
                },
                {
                    name: "文昌",
                    spell: "wenchang"
                },
                {
                    name: "文山",
                    spell: "wenshan"
                },
                {
                    name: "温州",
                    spell: "wenzhou"
                },
                {
                    name: "乌海",
                    spell: "wuhai"
                },
                {
                    name: "武汉",
                    spell: "wuhan"
                },
                {
                    name: "芜湖",
                    spell: "wuhu"
                },
                {
                    name: "乌兰察布",
                    spell: "wulanchabu"
                },
                {
                    name: "乌鲁木齐",
                    spell: "wulumuqi"
                },
                {
                    name: "武威",
                    spell: "wuwei"
                },
                {
                    name: "无锡",
                    spell: "wuxi"
                },
                {
                    name: "五指山",
                    spell: "wuzhishan"
                },
                {
                    name: "吴忠",
                    spell: "wuzhong"
                },
                {
                    name: "梧州",
                    spell: "wuzhou"
                }],
            X: [{
                name: "厦门",
                spell: "xiamen"
            },
                {
                    name: "西安",
                    spell: "xian"
                },
                {
                    name: "香港",
                    spell: "xianggang"
                },
                {
                    name: "湘潭",
                    spell: "xiangtan"
                },
                {
                    name: "湘西",
                    spell: "xiangxi"
                },
                {
                    name: "襄阳",
                    spell: "xiangyang"
                },
                {
                    name: "咸宁",
                    spell: "xianning"
                },
                {
                    name: "仙桃",
                    spell: "xiantao"
                },
                {
                    name: "咸阳",
                    spell: "xianyang"
                },
                {
                    name: "孝感",
                    spell: "xiaogan"
                },
                {
                    name: "日喀则",
                    spell: "xigaze"
                },
                {
                    name: "锡林郭勒",
                    spell: "xilinguole"
                },
                {
                    name: "兴安",
                    spell: "xingan"
                },
                {
                    name: "邢台",
                    spell: "xingtai"
                },
                {
                    name: "西宁",
                    spell: "xining"
                },
                {
                    name: "新乡",
                    spell: "xinxiang"
                },
                {
                    name: "信阳",
                    spell: "xinyang"
                },
                {
                    name: "新余",
                    spell: "xinyu"
                },
                {
                    name: "忻州",
                    spell: "xinzhou"
                },
                {
                    name: "西双版纳",
                    spell: "xishuangbanna"
                },
                {
                    name: "宣城",
                    spell: "xuancheng"
                },
                {
                    name: "许昌",
                    spell: "xuchang"
                },
                {
                    name: "徐州",
                    spell: "xuzhou"
                }],
            Y: [{
                name: "雅安",
                spell: "yaan"
            },
                {
                    name: "延安",
                    spell: "yanan"
                },
                {
                    name: "延边",
                    spell: "yanbian"
                },
                {
                    name: "盐城",
                    spell: "yancheng"
                },
                {
                    name: "阳江",
                    spell: "yangjiang"
                },
                {
                    name: "阳泉",
                    spell: "yangquan"
                },
                {
                    name: "扬州",
                    spell: "yangzhou"
                },
                {
                    name: "烟台",
                    spell: "yantai"
                },
                {
                    name: "宜宾",
                    spell: "yibin"
                },
                {
                    name: "宜昌",
                    spell: "yichang"
                },
                {
                    name: "宜春",
                    spell: "yichun"
                },
                {
                    name: "伊春",
                    spell: "yichun1"
                },
                {
                    name: "伊犁",
                    spell: "yili"
                },
                {
                    name: "银川",
                    spell: "yinchuan"
                },
                {
                    name: "营口",
                    spell: "yingkou"
                },
                {
                    name: "鹰潭",
                    spell: "yingtan"
                },
                {
                    name: "益阳",
                    spell: "yiyang"
                },
                {
                    name: "永州",
                    spell: "yongzhou"
                },
                {
                    name: "岳阳",
                    spell: "yueyang"
                },
                {
                    name: "玉林",
                    spell: "yulin"
                },
                {
                    name: "榆林",
                    spell: "yulin1"
                },
                {
                    name: "运城",
                    spell: "yuncheng"
                },
                {
                    name: "云浮",
                    spell: "yunfu"
                },
                {
                    name: "玉树",
                    spell: "yushu"
                },
                {
                    name: "玉溪",
                    spell: "yuxi"
                }],
            Z: [{
                name: "枣庄",
                spell: "zaozhuang"
            },
                {
                    name: "张家界",
                    spell: "zhangjiajie"
                },
                {
                    name: "张家口",
                    spell: "zhangjiakou"
                },
                {
                    name: "张掖",
                    spell: "zhangye"
                },
                {
                    name: "漳州",
                    spell: "zhangzhou"
                },
                {
                    name: "湛江",
                    spell: "zhanjiang"
                },
                {
                    name: "肇庆",
                    spell: "zhaoqing"
                },
                {
                    name: "昭通",
                    spell: "zhaotong"
                },
                {
                    name: "郑州",
                    spell: "zhengzhou"
                },
                {
                    name: "镇江",
                    spell: "zhenjiang"
                },
                {
                    name: "中山",
                    spell: "zhongshan"
                },
                {
                    name: "中卫",
                    spell: "zhongwei"
                },
                {
                    name: "周口",
                    spell: "zhoukou"
                },
                {
                    name: "舟山",
                    spell: "zhoushan"
                },
                {
                    name: "珠海",
                    spell: "zhuhai"
                },
                {
                    name: "驻马店",
                    spell: "zhumadian"
                },
                {
                    name: "株洲",
                    spell: "zhuzhou"
                },
                {
                    name: "淄博",
                    spell: "zibo"
                },
                {
                    name: "自贡",
                    spell: "zigong"
                },
                {
                    name: "资阳",
                    spell: "ziyang"
                },
                {
                    name: "遵义",
                    spell: "zunyi"
                }]
        },
        hotCity = [{
            name: "北京",
            spell: "beijing"
        },
            {
                name: "上海",
                spell: "shanghai"
            },
            {
                name: "广州",
                spell: "guangzhou"
            },
            {
                name: "深圳",
                spell: "shenzhen"
            },
            {
                name: "成都",
                spell: "chengdu"
            },
            {
                name: "重庆",
                spell: "chongqing"
            },
            {
                name: "福州",
                spell: "fuzhou"
            },
            {
                name: "厦门",
                spell: "xiamen"
            },
            {
                name: "杭州",
                spell: "hangzhou"
            },
            {
                name: "武汉",
                spell: "wuhan"
            }],
        KEY = ["A", "B", "C", "D", "E", "F", "G", "H", "", "J", "K", "L", "M", "N", "", "P", "Q", "R", "S", "T", "", "", "W", "X", "Y", "Z"],
        ID = {
            cityFrame: "div_select_city_sub_menu",
            cityList: "div_city_list"
        },
        CLAZZ = {
            cityFrame: "mod_list_city",
            cityTop: "city_top",
            cityList: "list_wrap",
            cityHot: "hot",
            cityCont: "city_cont",
            col1: "col1",
            col2: "col2",
            table: "mod_city_list"
        };

    function createCityTopHtml() {
        var fragment = doc.createDocumentFragment(),
            strong = doc.createElement("strong"),
            txt1 = doc.createTextNode("城市索引："),
            txt2 = doc.createTextNode("全部"),
            p = doc.createElement("p"),
            a = doc.createElement("a");
        strong.appendChild(txt1);
        a.href = "#";
        a.appendChild(txt2);
        p.appendChild(a);
        for (var row in city) {
            if (city.hasOwnProperty(row)) {
                a = doc.createElement("a");
                a.href = "#" + row;
                a.appendChild(doc.createTextNode(row));
                p.appendChild(a);
            }
        }
        fragment.appendChild(strong);
        fragment.appendChild(p);
        return fragment;
    }

    function createHotCityHtml() {
        var fragment = doc.createDocumentFragment(),
            strong = doc.createElement("strong"),
            txt = doc.createTextNode("热门城市："),
            currentCity = null,
            cityText = "",
            link = null;
        strong.appendChild(txt);
        fragment.appendChild(strong);
        for (var i = 0, len = hotCity.length; i < len; i++) {
            currentCity = hotCity[i];
            link = doc.createElement("a");
            link.href = "/" + currentCity.spell;
            cityText = doc.createTextNode(currentCity.name);
            link.appendChild(cityText);
            link.title = currentCity.name;
            fragment.appendChild(link);
        }
        return fragment;
    }

    function createCityTRHtml() {
        var fragment = doc.createDocumentFragment();
        for (var miao in city) {
            if (city.hasOwnProperty(miao)) {
                var tr = doc.createElement("tr"),
                    th = doc.createElement("th"),
                    td = doc.createElement("td"),
                    span = doc.createElement("span"),
                    text = doc.createTextNode(miao),
                    miaoArray = city[miao],
                    currentMiao = null,
                    a = null;
                for (var j = 0, len = miaoArray.length; j < len; j++) {
                    currentMiao = miaoArray[j];
                    a = doc.createElement("a");
                    a.title = currentMiao.name;
                    a.href = "/" + currentMiao.spell;
                    a.appendChild(doc.createTextNode(currentMiao.name));
                    td.appendChild(a);
                }
                span.appendChild(text);
                th.appendChild(span);
                tr.id = "miao_" + miao;
                tr.appendChild(th);
                tr.appendChild(td);
                fragment.appendChild(tr);
            }
        }
        return fragment;
    }

    function createCityContentHtml() {
        var fragment = doc.createDocumentFragment(),
            h4 = doc.createElement("h4"),
            table = doc.createElement("table"),
            colgroup = doc.createElement("colgroup"),
            tbody = doc.createElement("tbody"),
            col1 = doc.createElement("col"),
            col2 = doc.createElement("col"),
            h4Text = doc.createTextNode("全部城市："),
            trHtml = createCityTRHtml();
        table.className = CLAZZ.table;
        col1.className = CLAZZ.col1;
        col2.className = CLAZZ.col2;
        colgroup.appendChild(col1);
        colgroup.appendChild(col2);
        h4.appendChild(h4Text);
        tbody.appendChild(trHtml);
        table.appendChild(colgroup);
        table.appendChild(tbody);
        selectEventProxy = table;
        fragment.appendChild(h4);
        fragment.appendChild(table);
        return fragment;
    }

    function stopPropagation(event) {
        if (event.stopPropagation) {
            event.stopPropagation();
        } else {
            event.cancelBubble = true;
        }
    }

    function preventDefault(event) {
        if (event.preventDefault) {
            event.preventDefault();
        } else {
            event.returnValue = false;
        }
    }

    function cityScroll(m) {
        if (m && typeof m === "string") {
            m = m.toUpperCase();
            if (doc.all) {
                var cityListDiv = doc.getElementById(ID.cityList),
                    tr = doc.getElementById("miao_" + m);
                if (tr !== null) {
                    cityListDiv.scrollTop = tr.offsetTop + 32;
                }
            } else {
                var miao = doc.getElementById("miao_" + m);
                if (miao !== null) {
                    miao.scrollIntoView();
                }
            }
        }
    }

    function addSelectEvent(proxyTag, type, callback) {
        proxyTag["on" + type] = function (e) {
            var event = e || window.event,
                target = event.srcElement || event.target;
            if (target.tagName.toLowerCase() == "a") {
                selectedCity = target.innerHTML;
                callback(selectedCity);
            }
            citypicker.close();
            stopPropagation(event);
            preventDefault(event);
        };
    }

    function addScrollEvent(proxyTag, type) {
        proxyTag["on" + type] = function (e) {
            var event = e || window.event,
                target = event.srcElement || event.target;
            if (target.tagName.toLowerCase() == "a") {
                var m = target.getAttribute("href").replace(/^#/, "") || "A";
                cityScroll(m);
            }
            stopPropagation(event);
            preventDefault(event);
        };
    }

    function addKeyPressEvent(tag) {
        tag.onkeypress = function (e) {
            var event = window.event || e,
                charCode,
                keyIndex = 0,
                keyCode;
            if (typeof event.charCode == "number") {
                charCode = event.charCode;
            } else {
                charCode = event.keyCode;
            }
            if (charCode >= 97 && charCode <= 122) {
                keyIndex = charCode - 97;
            } else if (charCode >= 65 && charCode <= 90) {
                keyIndex = charCode - 65;
            }
            keyCode = KEY[keyIndex];
            cityScroll(keyCode);
        };
    }

    function createFrame() {
        var cityFrame = doc.createElement("div"),
            cityTop = doc.createElement("div"),
            cityHot = doc.createElement("p"),
            cityList = doc.createElement("div"),
            cityCont = doc.createElement("div"),
            hotCityHtml = createHotCityHtml(),
            cityContentHtml = createCityContentHtml(),
            cityTopHtml = createCityTopHtml();
        addKeyPressEvent(cityFrame);
        hotEventProxy = cityHot;
        scrollEventProxy = cityTop;
        popUpCityFrame = cityFrame;
        cityFrame.id = ID.cityFrame;
        cityFrame.className = CLAZZ.cityFrame;
        cityTop.className = CLAZZ.cityTop;
        cityHot.className = CLAZZ.cityHot;
        cityList.id = ID.cityList;
        cityList.className = CLAZZ.cityList;
        cityCont.className = CLAZZ.cityCont;
        cityHot.appendChild(hotCityHtml);
        cityCont.appendChild(cityContentHtml);
        cityTop.appendChild(cityTopHtml);
        cityList.appendChild(cityCont);
        cityFrame.appendChild(cityTop);
        cityFrame.appendChild(cityHot);
        cityFrame.appendChild(cityList);
        return cityFrame;
    }

    var citypicker = {
        version: "2.0",
        point: {
            left: 0,
            top: 0
        },
        callback: function () {
        },
        show: function () {
            var lenght = arguments.length,
                options,
                point = citypicker.point,
                callback = citypicker.callback;
            if (lenght == 2) {
                point = arguments[0];
                callback = arguments[1];
            } else {
                options = arguments[0];
                if (options && typeof options === "object") {
                    point.left = options.left || citypicker.point;
                    point.top = options.top || citypicker.top;
                    callback = options.selected || citypicker.callback;
                }
            }
            var docCityFrame = doc.getElementById(ID.cityFrame);
            if (!popUpCityFrame || !docCityFrame) {
                popUpCityFrame = createFrame();
                addScrollEvent(scrollEventProxy, "click");
                addKeyPressEvent(doc);
                doc.body.appendChild(popUpCityFrame);
            }
            citypicker.fix(point);
            citypicker.bind(callback);
            popUpCityFrame.style.display = "block";
            return this;
        },
        close: function () {
            if (popUpCityFrame) {
                popUpCityFrame.style.display = "none";
            }
        },
        getSelectedCity: function () {
            return selectedCity;
        },
        fix: function (point) {
            if (point && typeof point === "object") {
                var left = parseInt(point.left, 10) || 0,
                    top = parseInt(point.top, 10) || 0;
                citypicker.point = {
                    left: left,
                    top: top
                };
                if (popUpCityFrame) {
                    popUpCityFrame.style.left = left + "px";
                    popUpCityFrame.style.top = top + "px";
                }
            }
            return this;
        },
        bind: function (callback) {
            if (toString.call(callback) === "[object Function]") {
                citypicker.callback = callback;
                if (popUpCityFrame !== null) {
                    addSelectEvent(selectEventProxy, "click", callback);
                    addSelectEvent(hotEventProxy, "click", callback);
                }
            }
            return this;
        }
    };
    window.citypicker = citypicker;
})(window);