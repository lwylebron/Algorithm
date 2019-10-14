package lianxi;

import java.util.*;

public class Solution64 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        s1 = s1.substring(1,s1.length()-1);
        s2 = s2.substring(1,s2.length()-1);

        String[] c1 = s1.split(",");
        String[] c2 = s2.split(",");

        int[] a = new int[c1.length];
        int[] b = new int[c2.length];

        for(int i=0;i<c1.length;i++){
            a[i] = Integer.parseInt(c1[i]);
        }
        for(int i=0;i<c2.length;i++){
            b[i] = Integer.parseInt(c2[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]){
                    set.add(a[i]);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Integer integer:set){

            list.add(integer);

        }

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
}
