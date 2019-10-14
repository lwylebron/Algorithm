package lianxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution67 {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        char[] c = s.toCharArray();

        help(c,0,"");

        Collections.sort(list);

        System.out.print("[");
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1){
                System.out.print(list.get(i));
            }else{
                System.out.print(list.get(i)+",");
            }
        }
        System.out.print("]");


    }

    public static void help(char[] c,int count,String s){
        if(count==c.length){
            if(!list.contains(s)){
                list.add(s);
            }
            return;
        }
            char num = c[count];

            if(num=='7'||num=='9'){
                for (int j = 0; j < 4; j++) {
                    char ch = get(num, j);
                    String s1 = s + ch;
                    help(c, count + 1, s1);
                }
            }else {
                for (int j = 0; j < 3; j++) {
                    char ch = get(num, j);
                    String s1 = s + ch;
                    help(c, count + 1, s1);
                }
            }

    }

    public static char get(char num,int j){
        if(num=='2'){
            if(j==0){
                return 'a';
            }
            if(j==1){
                return 'b';
            }
            if(j==2){
                return 'c';
            }
        }

        if(num=='3'){
            if(j==0){
                return 'd';
            }
            if(j==1){
                return 'e';
            }
            if(j==2){
                return 'f';
            }
        }

        if(num=='4'){
            if(j==0){
                return 'g';
            }
            if(j==1){
                return 'h';
            }
            if(j==2){
                return 'i';
            }
        }

        if(num=='5'){
            if(j==0){
                return 'j';
            }
            if(j==1){
                return 'k';
            }
            if(j==2){
                return 'l';
            }
        }

        if(num=='6'){
            if(j==0){
                return 'm';
            }
            if(j==1){
                return 'o';
            }
            if(j==2){
                return 'n';
            }
        }

        if(num=='7'){
            if(j==0){
                return 'q';
            }
            if(j==1){
                return 'p';
            }
            if(j==2){
                return 'r';
            }
            if(j==3){
                return 's';
            }
        }

        if(num=='8'){
            if(j==0){
                return 't';
            }
            if(j==1){
                return 'u';
            }
            if(j==2){
                return 'v';
            }
        }

        if(num=='9'){
            if(j==0){
                return 'w';
            }
            if(j==1){
                return 'x';
            }
            if(j==2){
                return 'y';
            }
            if(j==3){
                return 'z';
            }
        }

        return ' ';
    }
}
