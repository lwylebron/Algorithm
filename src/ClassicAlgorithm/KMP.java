package ClassicAlgorithm;

public class KMP {
    /**
     * 模式串匹配问题
     * KMP算法的核心在于求出数组next，即模式串T中每一个长度为j (0<j<T.length) 的前缀所对应的next[j]的值
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */


    public static int KMP(String s,String t){
         int slen  =s.length();
         int tlen = t.length();
         if(slen<tlen){
             return -1;
         }

         int i=0;
         int j=0;
         int[] a = getNext(t.toCharArray());

         while(i<slen&&j<tlen){
             if(s.charAt(i)==t.charAt(j)){
                 i++;
                 j++;
             }else{
                 if(j==0){
                     i++;
                 }else{
                     j=a[j-1];
                 }
             }
         }

         if(j==tlen){
             return i-j;
         }

        return -1;
    }

    //寻找相同的前缀及后缀
    //每个字符前的
    //对于模式串T，next[j]代表了T的前j个字符组成的子串中，其前缀和后缀的最长公共串的长度。
     static int[] getNextArray(char[] t){

        int len = t.length;
        int[] next = new int[len];
        int k =-1;
        int j =0;
        next[0]=-1;

        while(j<len-1){
            if (k==-1||t[j]==t[k]){
                k++;
                j++;
                next[j]=k;
            }else{
                k=next[k];
            }
        }

        return next;

    }

    public static int[] getNext(char[] a){

        int j=1;
        int k=0;
        int len = a.length;
        int[] next = new int[len];
        next[0] = 0;

        while(j<len){
            if(a[j]==a[k]){
                j++;
                k++;
                next[j-1] = k;
            }else{
                k=0;
                j++;
            }
        }

        return next;

    }

    public static void main(String[] args) {
        char[] t = new char[]{'a','a','b','a','a','a'};
        int[] b = getNext(t);
        int[] c  =new int[]{1,1,1};
       for(int i=0;i<b.length;i++){
           System.out.print(b[i]+" ");
       }

       System.out.println();

       String str1 = "abacbaccda";
       String str2 = "accda";
       System.out.print(KMP(str1,str2));
    }
}
