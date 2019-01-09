package com.love.phone;

import java.util.regex.Pattern;

/**
 * Getting the phone number's supplier
 * <p>
 * Created by ls on 2018/12/13.
 */
public final class PhoneUtil {

    private PhoneUtil() {
        throw new RuntimeException("PhoneUtil can't be initialized ...");
    }

    private static final int PREFIX_LENGTH = 3;

    private final static Pattern PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");

    public static boolean isInteger(String str) {
        return PATTERN.matcher(str).matches();
    }

    /**
     * 移动电话开头为139、138、137、136、135 、134、188、187、182、159、158、157 、152 、150
     * 电信电话开头为133、153、180、189
     * 联通电话开头为130 、131、132、155、156、186
     *
     * @param phoneNo phone number
     * @return
     */
    public static String getSupplier(String phoneNo) {

        if (phoneNo == null || phoneNo.length() < PREFIX_LENGTH) {
            return "";
        }

        switch (phoneNo.substring(0, 3).trim()) {
            case "139":
            case "138":
            case "137":
            case "136":
            case "135":
            case "134":
            case "147":
            case "159":
            case "158":
            case "157":
            case "152":
            case "151":
            case "150":
            case "178":
            case "188":
            case "187":
            case "184":
            case "183":
            case "182":
            case "198":
                return "移动";
            case "133":
            case "149":
            case "153":
            case "173":
            case "177":
            case "180":
            case "181":
            case "189":
            case "199":
                return "电信";
            case "130":
            case "131":
            case "132":
            case "145":
            case "155":
            case "156":
            case "166":
            case "171":
            case "175":
            case "176":
            case "185":
            case "186":
                return "联通";
            case "170":
                return "虚拟";
            default:
                return "";
        }
    }


}
