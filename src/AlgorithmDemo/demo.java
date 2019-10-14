package AlgorithmDemo;

import java.util.Stack;

public  class demo {
    public static void main(String[] args) {

        int[] a = new int[]{1,3,2,5,4};

        HeapSort(a);

        for (int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }

        System.out.println();

        int b=  binaryFind(a,3);

     //   System.out.println(b);

        int[] p = {1,2,3,2,1};
        int c = lengthOfLift(p);
        System.out.println(c);

        String s1 = "absc";
        String s2 = "12378";
        String s3 = "57932";
        System.out.println(add(s2,s3));

        System.out.println(factorialDigit(6));

        int[] arr = new int[]{1,2,3};

        permutation_2(arr,0,3);
    }

    public static void swap(int[] arr,int a,int b){
        int temp  = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void bubbleSort(int[] arr){
        for(int i=arr.length-1;i>0;i--){

            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }

        }
    }

    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex  =i;
            for(int j=i+1;j<arr.length;j++){
                minIndex = arr[minIndex]>arr[j]?j:minIndex;

            }

            swap(arr,minIndex,i);
        }
    }

    public static void insertSort(int[] arr){
        for(int i =1;i<arr.length;i++){
            int k = arr[i];
            for(int j=i-1;j>=0&&arr[j]>k;j--){
                swap(arr,j,j+1);
            }
        }
    }


    public static void binaryInsertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int k = arr[i];
            int left = 0,right=i-1;

            while(right>=left){
                int mid  =left+(right-left)/2;
                if(arr[mid]>k){
                    right=mid-1;
                }else{
                    left = mid+1;
                }
            }

            for(int j=i-1;j>=left;j--){
                swap(arr,j,j+1);
            }
        }
    }

   public static void shellSort(int[] arr){
        for(int gap =arr.length;gap>0;gap/=2){

            for(int i=gap;i<arr.length;i++){
                if(arr[i]<arr[i-gap]){
                    swap(arr,i-gap,i);
                }
            }
        }
   }

   public static void quicksort(int[] arr,int left,int right){
        if(left<right){
            int index = findIndex(arr,left,right);
            quicksort(arr,left,index-1);
            quicksort(arr,index+1,right);
        }
   }

   static int findIndex(int[] arr,int left,int right){
        int temp = arr[left];
        while(left<right){
            while(arr[right]>temp){
                right--;
            }
            arr[left] = arr[right];

            while(left<right&&arr[left]<temp){
                left++;
            }

            arr[right]=arr[left];
        }

        arr[left] = temp;
        return left;
   }

   public static void mergeSort(int[] arr){
        if(arr==null||arr.length==0){
            return ;
        }

        mergeSort(arr,0,arr.length-1);
   }

   static void mergeSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }

        int mid = left+(right-left)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        merge(arr,left,mid,right);

   }

   static void merge(int[] arr,int left,int mid,int right){
        int[] p = new int[right-left+1];
        int m=left;
        int n = mid+1;
        int k=0;

        while(m<=mid&&n<=right){
            p[k++]=arr[m]>arr[n]?arr[n++]:arr[m++];
        }

        while(m<=mid){
            p[k++]=arr[m++];
        }
        while(n<=right){
            p[k++]=arr[n++];
        }

        for(int i=0;i<k;i++){
            arr[left+i]=p[i];
        }
   }

   public static void HeapSort(int[] arr){
        //构建大顶堆
       for(int i=arr.length/2-1;i>=0;i--){
           //从第一个非叶子节点，从下往上，从右至左做调整为大顶推
           adjustHeap(arr,i,arr.length);
       }

       for(int j=arr.length-1;j>=0;j--){
           swap(arr,0,j);
           adjustHeap(arr,0,j);
       }
   }

   static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];

        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){
                   k=k+1;
            }
            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }

        arr[i]=temp;
   }



   //二分查找
    public  static int binaryFind(int[] arr,int key){
        int left=0,right=arr.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]<key){
                left=mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }


    //二叉树非递归遍历
    static class Node{
        int val;
        Node left;
        Node right;

        public  Node(int val){
            this.val=val;
        }
    }

    public static Node buildTree(int[] arr, int i) {
        //元素值为-1或超过数组范围，则为空节点
        if (i >= arr.length || arr[i] == -1) {
            return null;
        }
        Node root = new Node(arr[i]);
        root.left = buildTree(arr,i * 2 + 1);
        root.right = buildTree(arr,i * 2 + 2);
        return root;
    }

    public static void  preOrder(Node root){
        if(root==null){
            return;
        }

        Stack<Node> stack =new Stack<>();

        Node p = root;

        while(p!=null||!stack.empty()){
            while(p!=null){
                System.out.print(p.val+" ");
                stack.push(p);
                p=p.left;
            }

            p=stack.pop();
            p=p.right;
        }
    }

    public static void  inOrder(Node root){
        if(root==null){
            return;
        }

        Stack<Node> stack =new Stack<>();

        Node p = root;

        while(p!=null||!stack.empty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }

            p=stack.pop();
            System.out.print(p.val+" ");
            p=p.right;
        }
    }

    //后续遍历
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        Node p = root;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty()){
            Node cur = s1.pop();
            s2.push(cur);
            if(cur.left!=null){
                s1.push(cur.left);
            }
            if(cur.right!=null){
                s1.push(cur.right);
            }
        }
        while(!s2.empty()){
            System.out.print(s2.pop().val+" ");
        }
    }


   /** 0-1问题
   *  @param w 物品i的重量为wi
   * @param v 物品i的价值为vi
   * @param c 背包总的容量为c
   * @return 能装入背包的总价值
   * */
    public static int getResult(int[] w,int[] v,int c){
        if(w.length!=v.length){
            throw new IllegalArgumentException();
        }

        if(c<=0){
            return 0;
        }

        int n = w.length;

        int[][] dp =new int[n][c+1];

        for(int j=0;j<c+1;j++){
            if(w[0]>j){
                dp[0][j]=0;
            }else{
                dp[0][j]=v[0];
            }
        }

        //dp[i][j]表示背包容量为j时，尝试放入前i+1个物品所能获得的最大价值
        for(int i=1;i<n;i++){
            for(int j=0;j<c+1;j++){
                //当前物品不可以放入背包时
                if(w[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(v[i]+dp[i-1][j-w[i]],dp[i-1][j]);
                }
            }
        }

        return dp[n-1][c];
    }

    /**
     * 完全背包问题
     */
    public static int getResult1(int[] w,int[] v,int c){

        if(w.length!=v.length){
            throw new IllegalArgumentException();
        }

        int n = w.length;
        if(c<=0){
            return 0;
        }

        int[][] dp = new int[n+1][c+1];

        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<c+1;i++){
            dp[i][0]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=c;j++){
                int count = j/w[i-1];
                dp[i][j] = Math.max(count*v[i-1]+dp[i-1][j-count*w[i-1]],dp[i-1][j]);
            }
        }

        return dp[n+1][c+1];
    }


    /**
     * 最长上升字串
     * 题目: https://leetcode-cn.com/problems/longest-increasing-subsequence/
     */

    public static int lengthOfLift(int[] nums){
        int L = nums.length;
        if(L==0){
            return 0;
        }
        if(L==1){
            return 1;
        }

        int maxLength=1;
        int max = 0;
        for(int i=1;i<L;i++){
            if(nums[i]>nums[i-1]){
                maxLength++;
            }else{
                maxLength=1;
            }
            max = Math.max(maxLength,max);
        }

        return max;
    }

    /**
     * 最长公共子序列，子序列不要求连续
     * 题目: http://www.51nod.com/Challenge/Problem.html#!#problemId=1006
     */
    //找出最长子序列的长度
    public static int[][] getDp(char[] s1,char[] s2){
        int n1 = s1.length;
        int n2 = s2.length;
        int[][] dp = new int[n1][n2];//  dp[i][j]存放s1{0...i}与s2{0...j}最长公共子序列
        dp[0][0]=s1[0]==s2[0]?1:0;

        for(int i=1;i<n1;i++){
            dp[i][0]=Math.max(dp[i-1][0],s1[i]==s2[0]?1:0);
        }

        for(int j=1;j<n2;j++){
            dp[0][j]=Math.max(dp[0][j-1],s1[0]==s2[j]?1:0);
        }

        for(int i=1;i<n1;i++){
            for(int j=1;j<n2;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(s1[i]==s2[j]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp;
    }

    //根据最长子序列长度及dp数组生成最长子序列
    public static String getLCS(char[] s1,char[] s2,int[][] dp){
        if(s1==null||s1.length==0||s2==null||s2.length==0){
            return "";
        }
        int i =s1.length-1;
        int j =s2.length-1;

        int index  = dp[i][j]-1;

        char[] res = new char[dp[i][j]];

        while(index>=0){
            if(i>0&&dp[i][j]==dp[i-1][j]){
                i--;
            }else if(j>0&&dp[i][j]==dp[i][j-1]){
                j--;
            }else{         //dp[i][j]==dp[i-1][j-1]+1
                res[index--]=s1[i];
                i--;
                j--;
            }

        }

        return res.toString();

    }

    /**
     * 最长公共子串问题 ,字串是连续的
     * 题目: https://www.nowcoder.com/questionTerminal/02e7cc263f8a49e8b1e1dc9c116f7602?toCommentId=1532408
     */

    public int[][] findLongest(String A, int n, String B, int m) {
        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        int[][] dp = new int[s1.length][s2.length];
        for (int i = 0; i < s1.length; i++) //注意和最长公共子序列有点不同
            dp[i][0] = s1[i] == s2[0] ? 1 : 0;
        for (int j = 0; j < s2.length; j++)
            dp[0][j] = s1[0] == s2[j] ? 1 : 0;
        int res = 0;
        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                if (s1[i] == s2[j]) {        //s1[i]!=s2[j]时，dp[i][j]=0
                    dp[i][j] = dp[i - 1][j - 1] + 1;       //dp[i][j]表示字串以s1[i](s2[j])结尾时的字串长度
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        System.out.println(res); //dp数组中的最大值，就是最大公共字串的长度
        return dp;
    }

    //得到最长公共子串
    public static String getLongestSubString(String s1,String s2,int[][] dp){
        if(s1==null||s1.length()==0||s2==null||s2.length()==0){
            return "";
        }
        int n1 = s1.length();
        int n2 = s2.length();
        int max = 0;
        int end = 0;

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(dp[i][j]>max){
                    max = dp[i][j];
                    end = i;
                }
            }
        }

        return s1.substring(end-max+1,end+1);
    }

    /**
     * 大数相加，两个用字符串表示的大数
    * */
    public static String add(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int m = Math.max(s1.length,s2.length);
        int[] a = new int[m+1];
        int[] b = new int[m+1];

        for(int i=0;i<s1.length;i++){
            a[i] = s1[m-i-1]-'0';
        }

        for(int i=0;i<s2.length;i++){
            b[i] = s2[m-i-1]-'0';
        }

        for(int i=0;i<m;i++){
            int temp = a[i]+b[i];
            if(temp>=10){
                a[i]=temp%10;
                a[i+1]+=temp/10;
            }else{
                a[i]=temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(a[m]!=0){
            sb.append(a[m]);
        }
        for(int i=m-1;i>=0;i--){
            sb.append(a[i]);
        }

        return sb.toString();
    }

    /**
     * 大数乘法
    * */
    public static String mul(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n1 = s1.length, n2 = s2.length;
        int[] a = new int[n1];
        int[] b = new int[n2];
        int[] c = new int[n1 + n2];
        for (int i = 0; i < n1; i++) a[i] = s1[n1 - i - 1] - '0'; //低位到高位排序
        for (int i = 0; i < n2; i++) b[i] = s2[n2 - i - 1] - '0';

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                c[i+j] +=a[i]*b[j];
            }
        }

        for(int i=0;i<n1+n2-1;i++){  //最高位在n1+n2位；
            int temp = c[i];
            c[i]+=temp%10;
            c[i+1]+=temp/10;
        }

        StringBuffer sb = new StringBuffer();

        int i; //高位可能位0，判断直到第一个不为0

        for(i=n1+n2-1;i>=0;i--){
            if(c[i]!=0){
                break;
            }
        }
        for(;i>=0;i--){
            sb.append(c[i]);
        }

        return sb.toString();
    }

    /**
     * 大数阶乘，即计算n的阶乘
    */

    //第一种方法 lg(N!)=[lg(N*(N-1)*(N-2)*......*3*2*1)]+1 = [lgN+lg(N-1)+lg(N-2)+......+lg3+lg2+lg1]+1;
    static int factorialDigit(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++)
            sum += Math.log10(i);
        return (int) Math.pow(10,sum)+1;
    }
    //第二种方法
    static String bigFactorial(int n) {
        int[] res = new int[100001];
        int digit = 1;
        res[0] = 1;
        for (int i = 2; i <= n; i++) {
            int carry = 0;
            for (int j = 0; j < digit; j++) {
                int temp = res[j] * i + carry; //每一位的运算结果
                res[j] = temp % 10;   //将最低位保留在原位置
                carry = temp / 10;   //计算进位, 等下这个进位会累加到j+1
            }
            while (carry != 0) {
                res[digit] = carry % 10;
                carry /= 10;
                digit++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digit - 1; i >= 0; i--) sb.append( (char)(res[i] + '0'));
        return sb.toString();
    }

    /**
     * 全排列
     * */

    //1-n的全排列,经典排序
    public static void permutation_2(int[] arr, int cur, int n){  //cur 重cur位开始排序，n,排到n位
        if(cur == n){
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = cur; i < n; i++){
            swap(arr, i, cur);
            permutation_2(arr, cur + 1, n);
            swap(arr, i, cur);
        }
    }

    //去重全排列  因为给定数组中可能有重复的元素，得到的全排列中便可能有重复元素
    public static void permutation_3(int[] arr, int cur, int n){  //cur 重cur位开始排序，n,排到n位

        if(cur == n){
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = cur; i < n; i++){
            //当没有重叠的数字时，才进行交换
            if(!isSwap(arr,cur,i))
            swap(arr, i, cur);
            permutation_2(arr, cur + 1, n);
            swap(arr, i, cur);
        }
    }
    private static boolean isSwap(int[] arr, int start, int end) {
        for(int i=start;i<end;i++){
            if(arr[i] == arr[end]){
                return true;
            }
        }
        return false;
    }


}
