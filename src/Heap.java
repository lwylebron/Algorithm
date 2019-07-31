public class Heap {


    //堆排序
    public static void sort(int[] arr){

        //从非叶节点从右至左，从下至上，创建好大顶堆
        for(int i =arr.length/2-1;i>=0;i--){
            adjustHeadp(arr,i,arr.length);
        }

        //交换堆顶元素与最后一个堆节点，保证每次最后一个节点最大
        for(int i = arr.length-1;i>0;i--){
            swap(arr,0,i);   //arr[0]便是堆顶
            adjustHeadp(arr,0,i);
        }

    }

    //调整大顶堆,每个i值从上往下调整
    public static void adjustHeadp(int[] arr,int i,int length){

        int temp = arr[i];

        for(int k = 2*i+1;k<length;k=2*k+1){
            //选择左右子节点较大的一个
            if(k+1<length&&arr[k+1]>arr[k]){
                k++;
            }

            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }

        arr[i] = temp;

    }

    public static void swap(int[] arr,int a,int b){
        int temp  = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] a  =new int[]{1,5,4,7,2};
        sort(a);
        for(int i=0;i<a.length;i++){
                System.out.println(a[i]);
        }
    }


}
