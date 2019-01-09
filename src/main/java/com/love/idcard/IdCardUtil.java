package com.love.idcard;

import java.util.Calendar;
import java.util.HashMap;

/**
 * According to the Id Card numbers to get it's age/sex/birthday and so on
 * <p>
 * Created by ls on 2018/12/13.
 */
public final class IdCardUtil {

    /**
     *
     */
    private IdCardUtil() {
        throw new RuntimeException("can't initialize IdCardUtil ... ");
    }

    /**
     * store the province information
     */
    public static final HashMap<String, String> province_map = new HashMap<>();

    /**
     * store the city information
     */
    public static final HashMap<String, String> city_map = new HashMap<>();

    static {
        province_map.put("11", "北京市");
        province_map.put("12", "天津市");
        province_map.put("13", "河北省");
        province_map.put("14", "山西");
        province_map.put("15", "内蒙古自治区");
        province_map.put("21", "辽宁省");
        province_map.put("22", "吉林省");
        province_map.put("23", "黑龙江省");
        province_map.put("31", "上海市");
        province_map.put("32", "江苏省");
        province_map.put("33", "浙江省");
        province_map.put("34", "安徽省");
        province_map.put("35", "福建省");
        province_map.put("36", "江西省");
        province_map.put("37", "山东省");
        province_map.put("41", "河南省");
        province_map.put("42", "湖北省");
        province_map.put("43", "湖南省");
        province_map.put("44", "广东省");
        province_map.put("45", "广西壮族自治区");
        province_map.put("46", "海南省");
        province_map.put("50", "重庆市");
        province_map.put("51", "四川省");
        province_map.put("52", "贵州省");
        province_map.put("53", "云南省");
        province_map.put("54", "西藏自治区");
        province_map.put("61", "陕西省");
        province_map.put("62", "甘肃省");
        province_map.put("63", "青海省");
        province_map.put("64", "宁夏回族自治区");
        province_map.put("65", "新疆维吾尔自治区");

        //
        city_map.put("1101", "市辖区");
        city_map.put("1102", "县");
        city_map.put("1201", "市辖区");
        city_map.put("1202", "县");
        city_map.put("1301", "石家庄市");
        city_map.put("1302", "唐山市");
        city_map.put("1303", "秦皇岛市");
        city_map.put("1304", "邯郸市");
        city_map.put("1305", "邢台市");
        city_map.put("1306", "保定市");
        city_map.put("1307", "张家口市");
        city_map.put("1308", "承德市");
        city_map.put("1309", "沧州市");
        city_map.put("1310", "廊坊市");
        city_map.put("1311", "衡水市");
        city_map.put("1401", "太原市");
        city_map.put("1402", "大同市");
        city_map.put("1403", "阳泉市");
        city_map.put("1404", "长治市");
        city_map.put("1405", "晋城市");
        city_map.put("1406", "朔州市");
        city_map.put("1407", "晋中市");
        city_map.put("1408", "运城市");
        city_map.put("1409", "忻州市");
        city_map.put("1410", "临汾市");
        city_map.put("1411", "吕梁市");
        city_map.put("1501", "呼和浩特市");
        city_map.put("1502", "包头市");
        city_map.put("1503", "乌海市");
        city_map.put("1504", "赤峰市");
        city_map.put("1505", "通辽市");
        city_map.put("1506", "鄂尔多斯市");
        city_map.put("1507", "呼伦贝尔市");
        city_map.put("1508", "巴彦淖尔市");
        city_map.put("1509", "乌兰察布市");
        city_map.put("1522", "兴安盟");
        city_map.put("1525", "锡林郭勒盟");
        city_map.put("1529", "阿拉善盟");
        city_map.put("2101", "沈阳市");
        city_map.put("2102", "大连市");
        city_map.put("2103", "鞍山市");
        city_map.put("2104", "抚顺市");
        city_map.put("2105", "本溪市");
        city_map.put("2106", "丹东市");
        city_map.put("2107", "锦州市");
        city_map.put("2108", "营口市");
        city_map.put("2109", "阜新市");
        city_map.put("2110", "辽阳市");
        city_map.put("2111", "盘锦市");
        city_map.put("2112", "铁岭市");
        city_map.put("2113", "朝阳市");
        city_map.put("2114", "葫芦岛市");
        city_map.put("2201", "长春市");
        city_map.put("2202", "吉林市");
        city_map.put("2203", "四平市");
        city_map.put("2204", "辽源市");
        city_map.put("2205", "通化市");
        city_map.put("2206", "白山市");
        city_map.put("2207", "松原市");
        city_map.put("2208", "白城市");
        city_map.put("2224", "延边朝鲜族自治州");
        city_map.put("2301", "哈尔滨市");
        city_map.put("2302", "齐齐哈尔市");
        city_map.put("2303", "鸡西市");
        city_map.put("2304", "鹤岗市");
        city_map.put("2305", "双鸭山市");
        city_map.put("2306", "大庆市");
        city_map.put("2307", "伊春市");
        city_map.put("2308", "佳木斯市");
        city_map.put("2309", "七台河市");
        city_map.put("2310", "牡丹江市");
        city_map.put("2311", "黑河市");
        city_map.put("2312", "绥化市");
        city_map.put("2327", "大兴安岭地区");
        city_map.put("3101", "市辖区");
        city_map.put("3102", "县");
        city_map.put("3201", "南京市");
        city_map.put("3202", "无锡市");
        city_map.put("3203", "徐州市");
        city_map.put("3204", "常州市");
        city_map.put("3205", "苏州市");
        city_map.put("3206", "南通市");
        city_map.put("3207", "连云港市");
        city_map.put("3208", "淮安市");
        city_map.put("3209", "盐城市");
        city_map.put("3210", "扬州市");
        city_map.put("3211", "镇江市");
        city_map.put("3212", "泰州市");
        city_map.put("3213", "宿迁市");
        city_map.put("3301", "杭州市");
        city_map.put("3302", "宁波市");
        city_map.put("3303", "温州市");
        city_map.put("3304", "嘉兴市");
        city_map.put("3305", "湖州市");
        city_map.put("3306", "绍兴市");
        city_map.put("3307", "金华市");
        city_map.put("3308", "衢州市");
        city_map.put("3309", "舟山市");
        city_map.put("3310", "台州市");
        city_map.put("3311", "丽水市");
        city_map.put("3401", "合肥市");
        city_map.put("3402", "芜湖市");
        city_map.put("3403", "蚌埠市");
        city_map.put("3404", "淮南市");
        city_map.put("3405", "马鞍山市");
        city_map.put("3406", "淮北市");
        city_map.put("3407", "铜陵市");
        city_map.put("3408", "安庆市");
        city_map.put("3410", "黄山市");
        city_map.put("3411", "滁州市");
        city_map.put("3412", "阜阳市");
        city_map.put("3413", "宿州市");
        city_map.put("3415", "六安市");
        city_map.put("3416", "亳州市");
        city_map.put("3417", "池州市");
        city_map.put("3418", "宣城市");
        city_map.put("3501", "福州市");
        city_map.put("3502", "厦门市");
        city_map.put("3503", "莆田市");
        city_map.put("3504", "三明市");
        city_map.put("3505", "泉州市");
        city_map.put("3506", "漳州市");
        city_map.put("3507", "南平市");
        city_map.put("3508", "龙岩市");
        city_map.put("3509", "宁德市");
        city_map.put("3601", "南昌市");
        city_map.put("3602", "景德镇市");
        city_map.put("3603", "萍乡市");
        city_map.put("3604", "九江市");
        city_map.put("3605", "新余市");
        city_map.put("3606", "鹰潭市");
        city_map.put("3607", "赣州市");
        city_map.put("3608", "吉安市");
        city_map.put("3609", "宜春市");
        city_map.put("3610", "抚州市");
        city_map.put("3611", "上饶市");
        city_map.put("3701", "济南市");
        city_map.put("3702", "青岛市");
        city_map.put("3703", "淄博市");
        city_map.put("3704", "枣庄市");
        city_map.put("3705", "东营市");
        city_map.put("3706", "烟台市");
        city_map.put("3707", "潍坊市");
        city_map.put("3708", "济宁市");
        city_map.put("3709", "泰安市");
        city_map.put("3710", "威海市");
        city_map.put("3711", "日照市");
        city_map.put("3712", "莱芜市");
        city_map.put("3713", "临沂市");
        city_map.put("3714", "德州市");
        city_map.put("3715", "聊城市");
        city_map.put("3716", "滨州市");
        city_map.put("3717", "菏泽市");
        city_map.put("4101", "郑州市");
        city_map.put("4102", "开封市");
        city_map.put("4103", "洛阳市");
        city_map.put("4104", "平顶山市");
        city_map.put("4105", "安阳市");
        city_map.put("4106", "鹤壁市");
        city_map.put("4107", "新乡市");
        city_map.put("4108", "焦作市");
        city_map.put("4109", "濮阳市");
        city_map.put("4110", "许昌市");
        city_map.put("4111", "漯河市");
        city_map.put("4112", "三门峡市");
        city_map.put("4113", "南阳市");
        city_map.put("4114", "商丘市");
        city_map.put("4115", "信阳市");
        city_map.put("4116", "周口市");
        city_map.put("4117", "驻马店市");
        city_map.put("4190", "省直辖县级行政区划");
        city_map.put("4201", "武汉市");
        city_map.put("4202", "黄石市");
        city_map.put("4203", "十堰市");
        city_map.put("4205", "宜昌市");
        city_map.put("4206", "襄阳市");
        city_map.put("4207", "鄂州市");
        city_map.put("4208", "荆门市");
        city_map.put("4209", "孝感市");
        city_map.put("4210", "荆州市");
        city_map.put("4211", "黄冈市");
        city_map.put("4212", "咸宁市");
        city_map.put("4213", "随州市");
        city_map.put("4228", "恩施土家族苗族自治州");
        city_map.put("4290", "省直辖县级行政区划");
        city_map.put("4301", "长沙市");
        city_map.put("4302", "株洲市");
        city_map.put("4303", "湘潭市");
        city_map.put("4304", "衡阳市");
        city_map.put("4305", "邵阳市");
        city_map.put("4306", "岳阳市");
        city_map.put("4307", "常德市");
        city_map.put("4308", "张家界市");
        city_map.put("4309", "益阳市");
        city_map.put("4310", "郴州市");
        city_map.put("4311", "永州市");
        city_map.put("4312", "怀化市");
        city_map.put("4313", "娄底市");
        city_map.put("4331", "湘西土家族苗族自治州");
        city_map.put("4401", "广州市");
        city_map.put("4402", "韶关市");
        city_map.put("4403", "深圳市");
        city_map.put("4404", "珠海市");
        city_map.put("4405", "汕头市");
        city_map.put("4406", "佛山市");
        city_map.put("4407", "江门市");
        city_map.put("4408", "湛江市");
        city_map.put("4409", "茂名市");
        city_map.put("4412", "肇庆市");
        city_map.put("4413", "惠州市");
        city_map.put("4414", "梅州市");
        city_map.put("4415", "汕尾市");
        city_map.put("4416", "河源市");
        city_map.put("4417", "阳江市");
        city_map.put("4418", "清远市");
        city_map.put("4419", "东莞市");
        city_map.put("4420", "中山市");
        city_map.put("4451", "潮州市");
        city_map.put("4452", "揭阳市");
        city_map.put("4453", "云浮市");
        city_map.put("4501", "南宁市");
        city_map.put("4502", "柳州市");
        city_map.put("4503", "桂林市");
        city_map.put("4504", "梧州市");
        city_map.put("4505", "北海市");
        city_map.put("4506", "防城港市");
        city_map.put("4507", "钦州市");
        city_map.put("4508", "贵港市");
        city_map.put("4509", "玉林市");
        city_map.put("4510", "百色市");
        city_map.put("4511", "贺州市");
        city_map.put("4512", "河池市");
        city_map.put("4513", "来宾市");
        city_map.put("4514", "崇左市");
        city_map.put("4601", "海口市");
        city_map.put("4602", "三亚市");
        city_map.put("4603", "三沙市");
        city_map.put("4690", "省直辖县级行政区划");
        city_map.put("5001", "市辖区");
        city_map.put("5002", "县");
        city_map.put("5101", "成都市");
        city_map.put("5103", "自贡市");
        city_map.put("5104", "攀枝花市");
        city_map.put("5105", "泸州市");
        city_map.put("5106", "德阳市");
        city_map.put("5107", "绵阳市");
        city_map.put("5108", "广元市");
        city_map.put("5109", "遂宁市");
        city_map.put("5110", "内江市");
        city_map.put("5111", "乐山市");
        city_map.put("5113", "南充市");
        city_map.put("5114", "眉山市");
        city_map.put("5115", "宜宾市");
        city_map.put("5116", "广安市");
        city_map.put("5117", "达州市");
        city_map.put("5118", "雅安市");
        city_map.put("5119", "巴中市");
        city_map.put("5120", "资阳市");
        city_map.put("5132", "阿坝藏族羌族自治州");
        city_map.put("5133", "甘孜藏族自治州");
        city_map.put("5134", "凉山彝族自治州");
        city_map.put("5201", "贵阳市");
        city_map.put("5202", "六盘水市");
        city_map.put("5203", "遵义市");
        city_map.put("5204", "安顺市");
        city_map.put("5205", "毕节市");
        city_map.put("5206", "铜仁市");
        city_map.put("5223", "黔西南布依族苗族自治州");
        city_map.put("5226", "黔东南苗族侗族自治州");
        city_map.put("5227", "黔南布依族苗族自治州");
        city_map.put("5301", "昆明市");
        city_map.put("5303", "曲靖市");
        city_map.put("5304", "玉溪市");
        city_map.put("5305", "保山市");
        city_map.put("5306", "昭通市");
        city_map.put("5307", "丽江市");
        city_map.put("5308", "普洱市");
        city_map.put("5309", "临沧市");
        city_map.put("5323", "楚雄彝族自治州");
        city_map.put("5325", "红河哈尼族彝族自治州");
        city_map.put("5326", "文山壮族苗族自治州");
        city_map.put("5328", "西双版纳傣族自治州");
        city_map.put("5329", "大理白族自治州");
        city_map.put("5331", "德宏傣族景颇族自治州");
        city_map.put("5333", "怒江傈僳族自治州");
        city_map.put("5334", "迪庆藏族自治州");
        city_map.put("5401", "拉萨市");
        city_map.put("5421", "昌都地区");
        city_map.put("5422", "山南地区");
        city_map.put("5423", "日喀则地区");
        city_map.put("5424", "那曲地区");
        city_map.put("5425", "阿里地区");
        city_map.put("5426", "林芝地区");
        city_map.put("6101", "西安市");
        city_map.put("6102", "铜川市");
        city_map.put("6103", "宝鸡市");
        city_map.put("6104", "咸阳市");
        city_map.put("6105", "渭南市");
        city_map.put("6106", "延安市");
        city_map.put("6107", "汉中市");
        city_map.put("6108", "榆林市");
        city_map.put("6109", "安康市");
        city_map.put("6110", "商洛市");
        city_map.put("6201", "兰州市");
        city_map.put("6202", "嘉峪关市");
        city_map.put("6203", "金昌市");
        city_map.put("6204", "白银市");
        city_map.put("6205", "天水市");
        city_map.put("6206", "武威市");
        city_map.put("6207", "张掖市");
        city_map.put("6208", "平凉市");
        city_map.put("6209", "酒泉市");
        city_map.put("6221", "酒泉市");
        city_map.put("6210", "庆阳市");
        city_map.put("6211", "定西市");
        city_map.put("6212", "陇南市");
        city_map.put("6229", "临夏回族自治州");
        city_map.put("6230", "甘南藏族自治州");
        city_map.put("6301", "西宁市");
        city_map.put("6302", "海东市");
        city_map.put("6322", "海北藏族自治州");
        city_map.put("6323", "黄南藏族自治州");
        city_map.put("6325", "海南藏族自治州");
        city_map.put("6326", "果洛藏族自治州");
        city_map.put("6327", "玉树藏族自治州");
        city_map.put("6328", "海西蒙古族藏族自治州");
        city_map.put("6401", "银川市");
        city_map.put("6402", "石嘴山市");
        city_map.put("6403", "吴忠市");
        city_map.put("6404", "固原市");
        city_map.put("6405", "中卫市");
        city_map.put("6501", "乌鲁木齐市");
        city_map.put("6502", "克拉玛依市");
        city_map.put("6521", "吐鲁番地区");
        city_map.put("6522", "哈密地区");
        city_map.put("6523", "昌吉回族自治州");
        city_map.put("6527", "博尔塔拉蒙古自治州");
        city_map.put("6528", "巴音郭楞蒙古自治州");
        city_map.put("6529", "阿克苏地区");
        city_map.put("6530", "克孜勒苏柯尔克孜自治州");
        city_map.put("6531", "喀什地区");
        city_map.put("6532", "和田地区");
        city_map.put("6540", "伊犁哈萨克自治州");
        city_map.put("6542", "塔城地区");
        city_map.put("6543", "阿勒泰地区");
        city_map.put("6590", "自治区直辖县级行政区划");
        city_map.put("3414", "巢湖市");
        city_map.put("5222", "铜仁地区");
        city_map.put("5224", "毕节地区");
        city_map.put("6321", "海东地区");
    }


    /**
     * get age from identity card
     *
     * @param card identity card
     * @return age
     */
    public static int getAgeByIdCard(String card) {

        if (!isValid(card)) {
            return 0;
        }

        Calendar cal = Calendar.getInstance();
        String year = card.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        return iCurrYear - Integer.valueOf(year);
    }


    /**
     * get birthday from identity card
     *
     * @param card identity card
     * @return yyyyMMdd
     */
    public static String getBirthdayByIdCard(String card) {
        if (!isValid(card)) {
            return null;
        }
        return card.substring(6, 14);
    }


    /**
     * @param card identity card
     * @return 1女  2男
     */
    public static String getSexByIdCard(String card) {
        if (!isValid(card)) {
            return "";
        }
        String sCardNum = card.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 == 0) {
            return "女";
        } else {
            return "男";
        }
    }


    /**
     * @param card personal IdCard
     * @return
     */
    public static String getProvinceByIdCard(String card) {
        if (!isValid(card)) {
            return null;
        }
        return province_map.get(card.substring(0, 2));
    }


    /**
     * @param card personal IdCard
     * @return
     */
    public static String getCityByIdCard(String card) {
        if (!isValid(card)) {
            return null;
        }

        return city_map.get(card.substring(0, 4));
    }

    /**
     * @param card personal IdCard
     * @return
     */
    public static String getProvinceAndCityByIdCard(String card) {
        if (!isValid(card)) {
            return null;
        }
        String result = "";
        String p = getProvinceByIdCard(card);
        if (p != null) {
            result = p;
        }
        String c = getCityByIdCard(card);
        if (c != null) {
            result = result + c;
        }
        return result;
    }


    private static boolean isValid(String card) {

        // 纯数字，15位或者18位
        if (card == null || card.trim() == "") {
            return false;
        }

        if (card.trim().length() == 18) {
            return card.trim().substring(0, 17).matches("^[0-9]*$");
        }

        return false;
    }

}
