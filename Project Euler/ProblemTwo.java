import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProblemTwo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            int a=1, b=2, count = 2, sum = a+b, tsum = 2;; 
            while(sum < n){
                if(sum%2==0){
                    tsum += sum;
                }
                a=b;
                b=sum;
                sum=a+b;
                count++;
            }
            System.out.println(tsum);
            
        }
    }
}