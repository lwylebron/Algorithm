package lianxi;

import java.util.ArrayList;
import java.util.List;

class Solution3 {

    static List<String> list = new ArrayList<>();

    public  static List<String> wordBreak(String s, List<String> wordDict) {

        if(s==null){
            return list;
        }

        help(new ArrayList<String>(),s,wordDict,0);

        return list;

    }

    public  static  void help(List<String> temp,String s, List<String> wordDict,int a){

        if(a==s.length()){
            String str = "";
            for(int i=0;i<temp.size();i++){
                str=str+temp.get(i)+" ";
            }

            str = str.trim();  //去除两端空格

            list.add(str);
        }


        for(int i=0;i<wordDict.size();i++){

            if(match(s,a,wordDict.get(i))){
                temp.add(wordDict.get(i));
                help(temp,s,wordDict,a+wordDict.get(i).length());
                temp.remove(temp.size()-1);
            }

        }

    }

    public static boolean match(String s,int a,String p){

        int len = p.length();

        if(s.length()<len+a-1){

            return false;
        }

        for(int i=0;i<len;i++){

            if(s.charAt(a+i)!=p.charAt(i)){

                return false;

            }

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        List<String> list1 = new ArrayList<>();
        list1.add(s);

        wordBreak(s,list1);



    }
}
