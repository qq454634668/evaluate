package com.evaluate.util;

/**
 * 编码生成工具
 */
public class CodeMakeUtils {

    /**
     * hundred 百位
     * 百位编码
     * 例：001,013
     */
    public static String hundred(String num) {
        String result = "";
        switch(num.length())
        {
            case 1 :
                result = "00"+num;
                break;
            case 2 :
                result = "0"+num;
                break;
            default :
                result = num;
        }
        System.out.println(result);
        return result;
    }
    /**
     * decade 十位
     * 十位编码
     * 例：01,03,18
     */
    public static String decade(String num) {
        String result = "";
        switch(num.length())
        {
            case 1 :
                result = "0"+num;
                break;
            default :
                result = num;
        }
        System.out.println(result);
        return result;
    }
}
