package lianxi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution9 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);



        //foreach的遍历方式
    //    for(Integer m:list){
    //        m=m+1;
    //    }

        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){
            int a = it.next();
            it.remove(); //要使用迭代器删除
        }

        list.add(4);
        list.add(5);
        list.add(6);

        for(int i=0;i<list.size();i++){
            if(i==1){
                list.add(i);  //操作过程中可以改变数组，即判断条件处数组会改变。
            }

        }



        System.out.println(list.size());
    }
}
