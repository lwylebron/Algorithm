package lianxi;

public class Solution55 {
    private static int solution(String str){

        char[] a = str.toCharArray();

        int len = a.length;

        int res = 0;

        int count = 0;

        for(int i=0;i<len;i++){
            if(a[i]=='('){
                count++;
            }else if(a[i]==')'){
                count--;
            }else{
                res = count;
                count=0;
                break;
            }
        }

        for(int j=len-1;j>=0;j--){
            if(a[j]==')'){
                count++;
            }else if(a[j]=='('){
                count--;
            }else{
                res = res<count?res:count;
            }
        }

        return res;
    }
}
