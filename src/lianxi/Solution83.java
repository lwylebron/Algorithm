package lianxi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution83 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        double[] a = new double[n];
        double[] b = new double[n];

        Map<Double,Double> map = new HashMap<>();
        Map<Double,Double> map1 = new HashMap<>();

        for(int i=0;i<n;i++){
            a[i] = in.nextDouble();
            double t = in.nextDouble();
            map.put(a[i],t);
            b[i] = a[i]*t;
            map1.put(b[i],a[i]);

        }



        Arrays.sort(b);


        for(int i=0;i<n;i++){
            a[i] = map1.get(b[i]);
        }



        double res = 0;

        double v = 0;

        for(int i=n-1;i>=0;i--){
            double u = a[i];
            double t = map.get(u);
            res = res+v*t+0.5*u*(t*t);
            v = v+u*t;
        }

        String s = String.format("%.1f", res);
        System.out.println(s);
    }
}

