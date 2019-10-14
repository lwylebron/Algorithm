package lianxi;

    public class Solution81 {
        public static void main(String[] args) {
            System.out.println(str2int("222"));
        }

        public static int str2int(String s){
            if(s.charAt(0)=='0'){
                return 0;
            }
            boolean flag = true;
            if(s.charAt(0)=='-'){
                flag = false;
                s = s.substring(1);
            }

            char[] a = s.toCharArray();

            int j=1;

            int res = 0;

            for(int i = a.length-1;i>=0;i--){
                res = res+(a[i]-'0')*j;
                j = j*10;

            }

            return flag?res:-res;
        }
    }

