package ClassicAlgorithm;

public class DecodeString {

    public static String decodeString(String s) {
        String ret = "";
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int tempIndex2 = i;
                //可能出现11,01这种数字
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    i++;
                }
                int freq1 = Integer.parseInt(s.substring(tempIndex2, i));
                //找到a10中的a字符
                String c = ret.charAt(ret.length() - 1) + "";
                //将a10变为aaaaaaaaaa
                ret = ret.substring(0, ret.length() - 1) + multiStr(c, freq1);
            } else if (s.charAt(i) == '(') {
                int weight = 0;
                //  找到与i位置的[相匹配的右括号]的索引位置
                int j = i;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) == '(') {
                        weight++;
                    } else if (s.charAt(j) == ')') {
                        weight--;
                        if (weight == 0) {
                            break;
                        }
                    }
                }
                //数字开始
                int tempI = j + 1;
                while (tempI < s.length() && s.charAt(tempI) >= '0' && s.charAt(tempI) <= '9') {
                    tempI++;
                }
                //找到频率
                int freq2 = Integer.parseInt(s.substring(j + 1, tempI));
                ret += multiStr(decodeString(s.substring(i + 1, j)), freq2);
                i = tempI;
            } else {
                //纯字符，直接+
                ret += s.charAt(i);
                i++;
            }
        }
        return ret;
    }


    private static String multiStr(String str, int freq) {
        String ret = "";
        if (freq == 0) {
            return ret;
        }
        for (int i = 0; i < freq; i++) {
            ret += str;
        }
        return ret;
    }
}
