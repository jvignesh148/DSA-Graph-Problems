import java.util.Scanner;
public class Test1MonkeyClimbsDown {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt(),j=sc.nextInt(),m=sc.nextInt(),p=sc.nextInt();
        if(n<=0 || k<=0 || j<=0 || m<=0 || p<=0) {
            System.out.println("INVALID INPUT");
            return;
        }
        int result=0;
        result = m%k==0 && p%j==0 ? m/k+p/j : m/k+p/j+1;
//        result+=p%j==0 ? p/j : p/j;
        System.out.println("Number of Monkeys left on tree : " + (n-result));
    }
}
