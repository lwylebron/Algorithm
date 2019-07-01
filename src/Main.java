import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int b = sc.nextInt();

        int c = w+b;
        int h=0;

        int i=0;

        while(i>=0){
            int temp = (i*i+i)/2;
            if(temp>c){
                break;
            }
            i++;
        }

        h=i>1?i-1:0;

        System.out.print(h);

        System.out.print(" ");

        System.out.print(countH(h,w,b));

    }

    static int countH(int h,int w,int b) {

        if(h==0){
            return 1;
        }

            if (w < 0 || b < 0) {
                return 0;
            } else if (w == 0 || b == 0) {
                return 1;
            } else {
                return  (countH(h - 1, w - h, b) + countH(h - 1, w, b - h));
            }
        }


}
