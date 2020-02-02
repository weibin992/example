package cn.weibin.springboot.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author weibin
 */
public abstract class StringUtils {

    /**
     * 字符串为空
     */
    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str));
    }

    /**
     * 字符串不为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 是否空白字符串
     */
    public static boolean isBlank(String str) {
        if(str != null) {
            str = str.trim();
        }
        return isEmpty(str);
    }

    /**
     * 是否非空白字符串
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 是否数字字符串
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[\\d]+$");
        return pattern.matcher(str).matches();
    }

    /** 号码匹配正则 */
    private final static Pattern PHONE_PATTERN = Pattern.compile("^[18]\\d{10}$");

    /**
     * 是否手机号
     * @param str
     * @return
     */
    public static boolean isPhoneNumber(String str) {
        if(str == null) {
            return false;
        }
        return PHONE_PATTERN.matcher(str).matches();
    }

    /**
     * 字符数组去无效空格
     * @param stringArr
     * @return
     */
    public static String[] trim(String[] stringArr) {
        if(stringArr != null) {
            for(int i=0; i<stringArr.length; i++) {
                if(stringArr[i] != null) {
                    stringArr[i] = stringArr[i].trim();
                }
            }
        }
        return stringArr;
    }

    /**
     * SQL工具
     * @author weibin
     */
    public static class SQL {

        private static final String LIKE_SYMBOL = "%";

        public static String leftLike(String str) {
            return str + LIKE_SYMBOL;
        }

        public static String like(String str) {
            return LIKE_SYMBOL + str + LIKE_SYMBOL;
        }
    }

    /**
     * 将数字字符串转为指定进度的字符串
     * @param number - 数字字符串
     * @param radix - 指定进制
     * @return
     */
    public static String toHexString(String number, int radix) {
        number = number.replaceAll("\\D", "");
        BigInteger bigInt = new BigInteger(number, 10);
        return bigInt.toString(radix);
    }

    /**
     * 字符串分割
     * @param collect
     * @param values
     * @param regex
     */
    private static void split(Collection<String> collect, String values, String regex) {
        if(isNotEmpty(values)) {
            String[] items = values.split(regex);
            for(String item : items) {
                item = item.trim();
                if(isNotEmpty(item)) {
                    collect.add(item);
                }
            }
        }
    }

    /**
     * 字符串分割成list
     * @param values
     * @param regex
     * @return
     */
    public static List<String> splitList(String values, String regex) {
        List<String> list = new ArrayList<>();
        split(list, values, regex);
        return list;
    }

    /**
     * 字符串分割成set
     * @param values
     * @param regex
     * @return
     */
    public static Set<String> splitSet(String values, String regex) {
        Set<String> set = new HashSet<>();
        split(set, values, regex);
        return set;
    }

    /**
	 * 获取号码段
	 * @param phone
	 * @return
	 */
	public static String getPhonecur(String phone) {
		if(StringUtils.isEmpty(phone) || phone.length() < 7) {
			return "";
		}
		return phone.substring(0, 7);
	}
}
