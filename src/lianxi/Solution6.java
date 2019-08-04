package lianxi;

import java.text.DecimalFormat;
import java.util.*;

public class Solution6 {

    public static void main(String[] args) {

        Scanner in  =new Scanner(System.in);
        int n = in.nextInt();
        int k  = in.nextInt();

        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int aa=0;
        int bb=0;
        for(int i=0;i<k;i++){
            aa = in.nextInt();
            bb = in.nextInt();
            map.put(aa,bb);
            list.add(aa);
        }

        double a = 1;

        DecimalFormat df = new DecimalFormat("0.00");

        Collections.sort(list);

        int k1 = list.get(0);

        double v1 = a/n;

        int count  = k1;

        a = a-k1/n; //还剩多少

        double res = 0;

        for(int i=0;i<k1;i++){
            res = res+v1;
            System.out.println(df.format(res));
        }

        int kk1=0;int kk2=0;int vv1=0;int vv2=0;

        for(int i=1;i<list.size();i++){

             kk1 = list.get(i-1);
             kk2 = list.get(i);
             vv1 = map.get(kk1);
             vv2 = map.get(kk2);

            double temp = (1-res)/(vv1-kk1);

            for(int j=0;j<kk2-kk1;j++){
                res = res+temp;
                System.out.println(df.format(res));
            }

           // a = a-res;

        }

        double temp1 = (1-res)/(vv2-kk2);

        for(int i=0;i<(vv2-kk2);i++){

            res = res+temp1;
            System.out.println(df.format(res));
        }

    }
}
