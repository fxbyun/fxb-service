package domain.util;

import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 处理字符串的类
 *
 * @project commons
 * @author Administrator
 * @date 2010-12-8
 * Copyright (C) 2010-2012 www.2caipiao.com Inc. All rights reserved.
 */
public class StringUtil {

    /**
     * 把形如[01 02 04 05] 数组转为 "01,02,04,05"字符串
     * @param strs
     * @param spliter
     * @return
     */
    public static String toSplitString(String[] strs, String spliter) {
        if (strs == null) {
            return "";
        }
        StringBuffer returnStrBuff = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            returnStrBuff.append(strs[i]);
            if (i < strs.length - 1) {
                returnStrBuff.append(spliter);
            }
        }
        return returnStrBuff.toString();
    }

    /*将汉字转换为Unicode
         * Converts unicodes to encoded &#92;uxxxx and escapes
         * special characters with a preceding slash
      */
    public static String toUnicode(String theString, boolean escapeSpace, boolean escapeUnicode) {
        int len = theString.length();
        int bufLen = len * 2;
        if (bufLen < 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuffer outBuffer = new StringBuffer(bufLen);

        for (int x = 0; x < len; x++) {
            char aChar = theString.charAt(x);
            // Handle common case first, selecting largest block that
            // avoids the specials below
            if ((aChar > 61) && (aChar < 127)) {
                if (aChar == '\\') {
                    outBuffer.append('\\');
                    outBuffer.append('\\');
                    continue;
                }
                outBuffer.append(aChar);
                continue;
            }
            switch (aChar) {
            case ' ':
                if (x == 0 || escapeSpace)
                    outBuffer.append('\\');
                outBuffer.append(' ');
                break;
            case '\t':
                outBuffer.append('\\');
                outBuffer.append('t');
                break;
            case '\n':
                outBuffer.append('\\');
                outBuffer.append('n');
                break;
            case '\r':
                outBuffer.append('\\');
                outBuffer.append('r');
                break;
            case '\f':
                outBuffer.append('\\');
                outBuffer.append('f');
                break;
            case '=': // Fall through
            case ':': // Fall through
            case '#': // Fall through
            case '!':
                outBuffer.append('\\');
                outBuffer.append(aChar);
                break;
            default:
                if (((aChar < 0x0020) || (aChar > 0x007e)) & escapeUnicode) {
                    outBuffer.append('\\');
                    outBuffer.append('u');
                    outBuffer.append(toHex((aChar >> 12) & 0xF));
                    outBuffer.append(toHex((aChar >> 8) & 0xF));
                    outBuffer.append(toHex((aChar >> 4) & 0xF));
                    outBuffer.append(toHex(aChar & 0xF));
                } else {
                    outBuffer.append(aChar);
                }
            }
        }
        return outBuffer.toString();
    }

    /**
       * Convert a nibble to a hex character
       * @param	nibble	the nibble to convert.
       */
    private static char toHex(int nibble) {
        return hexDigit[(nibble & 0xF)];
    }

    /** A table of hex digits */
    private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F' };

    public static void main(String[] ars) {
        //System.out.print(toUnicode("人  生\u4EBA", false, true));
        String str = "622 　20215020　16565529";
        String strNew = replaceBlank(str);
        System.out.println(strNew);
    }

    /**  
     * 获取本机所有IP  
     */
    public static String[] getAllLocalHostIP() {
        List<String> res = new ArrayList<String>();
        Enumeration netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                Enumeration nii = ni.getInetAddresses();
                while (nii.hasMoreElements()) {
                    ip = (InetAddress) nii.nextElement();
                    if (ip.getHostAddress().indexOf(":") == -1) {
                        res.add(ip.getHostAddress());
                        //System.out.println("本机的ip=" + ip.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return (String[]) res.toArray(new String[0]);
    }

    /**
     * 取最后一个IP
     * @return
     * @create_time 2011-3-17 下午05:41:09
     */
    public static String getLocalLastIp() {
        String ip[] = getAllLocalHostIP();
        return ip[ip.length - 1];
    }

    /**
     * 把形如 abc_cbd的字符串转换成形如abcCbd的字符串
     * @param sourceStr
     * @return
     * @create_time 2012-9-13 下午11:26:47
     */
    public static String changeDbcloumStyleToJavaStyle(String sourceStr) {
        if (null == sourceStr) {
            return null;
        } else {
            sourceStr = sourceStr.trim();
        }
        if (sourceStr.length() == 0) {
            return sourceStr;
        }
        if (sourceStr.indexOf("_") < 0) {
            return sourceStr.toLowerCase();
        }
        StringBuilder sb = new StringBuilder();
        String[] partsOfStr = sourceStr.split("_");
        for (int i = 0; i < partsOfStr.length; i++) {
            if (i == 0) {
                sb.append(partsOfStr[i].toLowerCase());
            } else {
                sb.append(changeThefirstCharToUppercase(partsOfStr[i]));
            }
        }
        return sb.toString();
    }

    /**
     * 把字符串首字母变成大写，去掉两边空格
     * <ol>
     *    <li>2aadaAwc=2aadaAwc</li>
     *    <li>aadaAwc=AadaAwc</li>
     *    <li>AadaAwc=AadaAwc</li>
     * </ol>
     * @param sourceStr
     * @return
     * @create_time 2012-9-13 下午11:22:39
     */
    public static String changeThefirstCharToUppercase(String sourceStr) {
        if (null == sourceStr) {
            return null;
        } else {
            sourceStr = sourceStr.trim();
        }
        if (sourceStr.length() == 0) {
            return sourceStr;
        }
        if (sourceStr.length() == 1) {
            return sourceStr.toUpperCase();
        }
        StringBuilder sb = new StringBuilder();
        char[] charsOfStr = sourceStr.toCharArray();
        for (int i = 0; i < charsOfStr.length; i++) {
            char c = charsOfStr[i];
            if (i == 0) {
                if (c >= 'a' && c <= 'z') {
                    c -= 32;
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    c += 32;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
    
    /**
     * 格式化字符串 s->s; ss->s*; ss..s->s*s;
     * @param str
     * @return
     * @create_time 2012-12-21 下午4:16:38
     */
    public static String formatStr(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return str;
        }
        if (str.length() == 2) {
            return str.charAt(0) + "*";
        }
        return str.substring(0, 1) + "*" + str.substring(str.length() - 1, str.length());
    }
    
    /***
     * 判断字符串是否不为Null 并且.trim()不为""
     * @param value
     * @return
     */
    public static boolean isNotBlank(String value){
		if(value!=null && !value.trim().equals("")){
			return true;
		}
		return false;
	}
    /***
     * 判断字符串是否为Null 或者.trim()不为""
     * @param value
     * @return
     */
    public static boolean isBlank(String value){
		if(value==null || value.trim().equals("")){
			return true;
		}
		return false;
	}
    
     /**
      * 去除字符串内的空格字符
      * @param str
      * @return
      */
     public static String replaceBlank(String str){
    	 if(StringUtils.isNotBlank(str)){
    		 return str.replaceAll(" |　", "");
    	 }else{
    		 return str;
    	 }
     }
}
