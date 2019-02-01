package domain.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数学相关工具类
 * 
 */
public class MathUtil {
	/***
	 * 放大100倍 - 单位 改成：元
	 */
	public static int magnified100(BigDecimal yuanAmount){
		return yuanAmount.multiply(new BigDecimal("100")).intValue();
	}
	/***
	 * 缩小100倍 - 单位 改成：分
	 */
	public static BigDecimal smaller100(int fenAmount){
		BigDecimal fenAmount1 = BigDecimal.valueOf(fenAmount); 
		return fenAmount1.divide(new BigDecimal("100"));
	}
    /**
     * @描述:求组合C(n,r)
     * @param n
     * @param r
     * @return
     */
    public final static int getCombinationCount(int n, int r) {
        if (r > n)
            return 0;
        if (r < 0 || n < 0)
            return 0;
        return getFactorial(n).divide(getFactorial(r), BigDecimal.ROUND_HALF_DOWN)
                .divide(getFactorial((n - r)), BigDecimal.ROUND_HALF_DOWN).intValue();
    }

    /**
     * @描述:求排列p(n,r)
     * @param n
     * @param r
     * @return
     */
    public final static int getPermutationCount(int n, int r) {
        if (r > n)
            return 0;
        if (r < 0 || n < 0)
            return 0;
        return getFactorial(n).divide(getFactorial(n - r)).intValue();
    }

    /**
     * @描述:求n的阶乘
     * @param n
     * @return
     */
    public final static BigDecimal getFactorial(int num) {
        BigDecimal sum = new BigDecimal(1.0);
        for (int i = 1; i <= num; i++) {
            BigDecimal a = new BigDecimal(new BigInteger(i + ""));
            sum = sum.multiply(a);
        }
        return sum;
    }

    /**
     * 求幂
     * 
     * @param m
     *            底数
     * @param n
     *            幂
     * @return
     */
    public static final long getPower(int m, int n) {
        assert n >= 0;
        if (n == 0)
            return 1;
        if (n == 1)
            return m;
        long temp = getPower(m, n / 2);
        return n % 2 == 0 ? temp * temp : temp * temp * m;
    }

    /**
     * 从两个数组中组合出个数为num的所有组合，不包括单个数组内满足条件的组合，排序,String[] 内元素必须是单个号码
     * @param firstArr
     * @param secondArr
     * @param num
     * @param separator
     * @return
     * @create_time 2013-7-31 下午10:11:29
     */
    public static final List<String[]> combine(String[] firstArr, String[] secondArr, int num, String separator) {
        List<String[]> allContentList = new ArrayList<String[]>();
        if (num <= 1) {
            return allContentList;
        }
        if (firstArr.length == 0 || secondArr.length == 0 || firstArr.length + secondArr.length < num) {
            return allContentList;
        }
        String[] minArr = null;
        String[] maxArr = null;
        if (firstArr.length > secondArr.length) { //从小的数组开始取
            maxArr = firstArr;
            minArr = secondArr;
        } else {
            maxArr = secondArr;
            minArr = firstArr;
        }
        int minArrLength = minArr.length;

        //计数，从1开始算所有的组合
        int counter = minArrLength < (num - 1) ? minArrLength : (num - 1);

        for (int i = 1; i <= counter; i++) {
            List<String> minStringList = combine(minArr, i, separator);
            List<String> maxStringList = combine(maxArr, num - i, separator);
            for (String minStr : minStringList) {
                for (String maxStr : maxStringList) {
                    String[] newArr = StringUtils.split(minStr + separator + maxStr, separator);
                    Arrays.sort(newArr);
                    allContentList.add(newArr);
                }
            }
        }
        return allContentList;
    }

    /**
     * 组合排序算法(回溯方法)
     * 
     * @param str
     *            需要排序的字符串
     * @param n
     *            拖的个数 如果为-1，则默认为str的长度
     * @param m
     *            拖中要选的个数
     * @return
     */
    public static final List<String> combine(String str[], int m, String separator) {
        int n = str.length;
        m = m > n ? n : m;
        List<String> list = new ArrayList<String>();
        int[] order = new int[m + 1];
        for (int i = 0; i <= m; i++)
            order[i] = i - 1; // 注意这里order[0]=-1用来作为循环判断标识
        int count = 0;
        int k = m;
        boolean flag = true; // 标志找到一个有效组合
        while (order[0] == -1) {
            if (flag) { // 输出符合要求的组合
                StringBuffer sb = new StringBuffer();
                for (int j = 1; j <= m; j++) {
                    count++;
                    if (j != m) {
                        sb.append(str[order[j]] + separator);
                    } else {
                        sb.append(str[order[j]]);
                    }
                }
                flag = false;
                list.add(sb.toString());
            }
            order[k]++; // 在当前位置选择新的数字
            if (order[k] == n) {// 当前位置已无数字可选，回溯
                order[k--] = 0;
                continue;
            }
            if (k < m) {// 更新当前位置的下一位置的数字
                order[++k] = order[k - 1];
                continue;
            }
            if (k == m)
                flag = true;
        }
        return list;
    }
    
    /**
	 * 组合排序算法(回溯方法),返回String[]数组
	 * 
	 * @param str
	 *            需要排序的字符串
	 * @param n
	 *            拖的个数 如果为-1，则默认为str的长度
	 * @param m
	 *            拖中要选的个数
	 * @return
	 */
	public static final List<String[]> combine(String str[], int m) {
		int n = str.length;
		m = m > n ? n : m;
		List<String[]> list = new ArrayList<String[]>();
		int[] order = new int[m + 1];
		for (int i = 0; i <= m; i++)
			order[i] = i - 1; // 注意这里order[0]=-1用来作为循环判断标识
		int count = 0;
		int k = m;
		boolean flag = true; // 标志找到一个有效组合
		while (order[0] == -1) {
			if (flag) { // 输出符合要求的组合
				String[] sb = new String[m];
				for (int j = 1; j <= m; j++) {
					count++;
					sb[j - 1] = (str[order[j]]);
				}
				flag = false;
				list.add(sb);
			}
			order[k]++; // 在当前位置选择新的数字
			if (order[k] == n) {// 当前位置已无数字可选，回溯
				order[k--] = 0;
				continue;
			}
			if (k < m) {// 更新当前位置的下一位置的数字
				order[++k] = order[k - 1];
				continue;
			}
			if (k == m)
				flag = true;
		}
		return list;
	}

    /**
     * 高效的组合算法
     * 
     * @param n
     *            可选的数目
     * @param m
     *            取的数目
     * @param callBack
     *            每取出一个组合时的回调函数
     * @author kerong.zhou
     */
    public static void efficientComb(int n, int m, CombCallBack callBack) {
        if (m > n) {
            return;
        }

        boolean[] bs = new boolean[n];
        for (int i = 0; i < m; i++) {
            bs[i] = true;
        }
        if (m == n) {
            callBack.callback(bs, m);
            return;
        }
        for (int i = m; i < n; i++) {
            bs[i] = false;
        }
        if (m == 0) {
            callBack.callback(bs, m);
            return;
        }

        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;
        // 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
        do {
            sum = 0;
            pos = 0;
            tempFlag = true;
            callBack.callback(bs, m);

            // 找到第一个10组合，然后变成01
            for (int i = 0; i < n - 1; i++) {
                if (bs[i] == true && bs[i + 1] == false) {
                    bs[i] = false;
                    bs[i + 1] = true;
                    pos = i;
                    break;
                }
            }

            // 将左边的1全部移动到数组的最左边
            for (int i = 0; i < pos; i++) {
                if (bs[i] == true) {
                    sum++;
                }
            }
            for (int i = 0; i < pos; i++) {
                if (i < sum) {
                    bs[i] = true;
                } else {
                    bs[i] = false;
                }
            }

            // 检查是否所有的1都移动到了最右边
            for (int i = n - m; i < n; i++) {
                if (bs[i] == false) {
                    tempFlag = false;
                    break;
                }
            }
            if (tempFlag == false) {
                flag = true;
            } else {
                flag = false;
            }

        } while (flag);
        callBack.callback(bs, m);
    }

    /**
     * "四舍六入五成双"个性化算法，保留2为小数。
     * 
     * 第4位小数不参与，这点与BigDecimal.ROUNDING_HALF_EVEN不一样。
     * 
     * @param t
     * @return
     */
    public static BigDecimal roundHalfEven(BigDecimal t) {
        BigDecimal bd = t.setScale(2, BigDecimal.ROUND_FLOOR);
        String strT = t.toString();
        int dotPos = strT.indexOf(".");
        if (dotPos < 0 || (strT.length() - 1 <= dotPos + 2)) {
            return bd;
        }
        char fragDigit3 = strT.charAt(dotPos + 3);
        if (fragDigit3 < '5') {
            return bd;
        } else if (fragDigit3 > '5') {
            return bd.add(new BigDecimal("0.01"));
        } else {
            char fragDigit2 = strT.charAt(dotPos + 2);
            if ((int) fragDigit2 % 2 == 1) {
                return bd.add(new BigDecimal("0.01"));
            } else {
                return bd;
            }
        }
    }

    // 随机产生不重复的几个随机指定范围随机数
    public static Integer[] randomNoRepetNum(int numCount, int minValue, int maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException("maxValue - minValue 不能小于 0");// 会出现死循环
        }
        Integer[] intRet = new Integer[numCount];
        if (maxValue == minValue && numCount == 1) {
            intRet[0] = maxValue;
            return intRet;
        }
        if (maxValue - minValue < numCount - 1) {
            throw new IllegalArgumentException("maxValue - minValue 不能小于 numCount -1");// 会出现死循环
        }
        int rcount = 0;
        while (rcount < numCount) {
            int rnum = (int) Math.round(Math.random() * (maxValue - minValue) + minValue);
            if (ArrayUtils.contains(intRet, rnum)) {
                continue;
            }
            intRet[rcount] = rnum;
            rcount++;
        }
        return intRet;
    }

    // 随机产生不重复的几个随机指定范围随机数,小于9前面要加0
    public static String[] randomNoRepetNumPerZero(int numCount, int minValue, int maxValue) {
        String[] strRet = new String[numCount];
        int rcount = 0;
        while (rcount < numCount) {
            int rnum = (int) Math.round(Math.random() * (maxValue - minValue) + minValue);
            String num = rnum <= 9 ? ("0" + rnum) : String.valueOf(rnum);
            if (ArrayUtils.contains(strRet, num)) {
                continue;
            }
            strRet[rcount] = num;
            rcount++;
        }
        return strRet;
    }

    public interface CombCallBack {
        /**
         * 组合算法的回调函数
         * @param comb 选中的数组，数组元素的值为真表示原数组相同下标的元素被选中
         * @param m 选中的元素数目
         */
        void callback(boolean[] comb, int m);
    }
    /**  
    * 提供精确的加法运算。  
    * @param v1 被加数  
    * @param v2 加数  
    * @return 两个参数的和  
    */  
    public static BigDecimal add(BigDecimal b1,BigDecimal b2){   
    	return b1.add(b2);   
    }  
    /**  
    * 提供精确的加法运算。  
    * @param v1 被加数  
    * @param v2 加数  
    * @return 两个参数的和  
    */  
    public static double add(double v1,double v2){   
    BigDecimal b1 = new BigDecimal(Double.toString(v1));   
    BigDecimal b2 = new BigDecimal(Double.toString(v2));   
    return b1.add(b2).doubleValue();   
    }   
    /**  
    * 提供精确的减法运算。  
    * @param v1 被减数  
    * @param v2 减数  
    * @return 两个参数的差  
    */  
    public static double sub(double v1,double v2){   
	    BigDecimal b1 = new BigDecimal(Double.toString(v1));   
	    BigDecimal b2 = new BigDecimal(Double.toString(v2));   
	    return b1.subtract(b2).doubleValue();   
    } 
    public static BigDecimal sub(BigDecimal b1,BigDecimal b2){      
	    return b1.subtract(b2);   
    }  
    /**  
    * 提供精确的乘法运算。  
    * @param v1 被乘数  
    * @param v2 乘数  
    * @return 两个参数的积  
    */  
    public static double mul(double v1,double v2){   
	    BigDecimal b1 = new BigDecimal(Double.toString(v1));   
	    BigDecimal b2 = new BigDecimal(Double.toString(v2));   
	    return b1.multiply(b2).doubleValue();   
    }   
    /**  
    * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到  
    * 小数点以后10位，以后的数字四舍五入。  
    * @param v1 被除数  
    * @param v2 除数  
    * @return 两个参数的商  
    */  
    public static double div(double v1,double v2){   
    	return div(v1,v2,2);   
    }   
    /**  
    * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到  
    * 小数点以后10位，以后的数字四舍五入。  
    * @param v1 被除数  
    * @param v2 除数  
    * @return 两个参数的商  
    */  
    public static BigDecimal div(BigDecimal v1,BigDecimal v2){   
    	return v1.divide(v2,2,BigDecimal.ROUND_HALF_UP);   
    } 
    /**  
    * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指  
    * 定精度，以后的数字四舍五入。  
    * @param v1 被除数  
    * @param v2 除数  
    * @param scale 表示表示需要精确到小数点以后几位。  
    * @return 两个参数的商  
    */  
    public static double div(double v1,double v2,int scale){   
	    if(scale<0){   
	    	throw new IllegalArgumentException("The scale must be a positive integer or zero");   
	    }   
	    BigDecimal b1 = new BigDecimal(Double.toString(v1));   
	    BigDecimal b2 = new BigDecimal(Double.toString(v2));   
	    return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();   
    }   

    public static void main(String[] args) {
    	System.out.println( magnified100(new BigDecimal("56.55")) );
    	System.out.println( magnified100(new BigDecimal("0.56")) );
    	System.out.println( smaller100(5655) );
    	System.out.println( smaller100(56) );
    }
}
