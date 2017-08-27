/*
 * Programmer: Joseph Cuellar
 * Created: 8/22/2017
 * Last date modified: 8/26/2017
 */
public class Main {

	public static void main(String[] jc){
		//even_sum_fib(11);
		//multThreeFive(10);
		//multThreeFivee(3,5,30);
		//largestPrimeFactor(6008);
		//largestPalProduct();
		//projectEulerFive();
		//projectEulerSix(100);
		projectEulerSeven(100001);
	}

	/* 1.1. Multiple of 3 and 5 */
	public static void multThreeFive(int a){
		int pattern[] = {3,2,1,3,1,2,3};
		int i=0, currNum = 0, sum = 0;
		while((currNum += pattern[i++ % pattern.length]) < a){
			System.out.println("Log: " + currNum);
			sum += currNum;
		}
		System.out.println("The sum of all multiples of 3 or 5 below " + a + " is " + sum);
	}

	/* 1.2 same problem as 1.1 but without using a loop */
	/* The formula is a summation with respect of n being multiple of 15. N: 15, 30, 45, etc*/
	public static void multThreeFivee(int a, int b, int n){
		double sum = .5 * ((n+a)*(n/a) + (n+b)*(n/b) - (n+15)*(n/(a*b)));
		System.out.println("The sum of all multiples of 3 or 5 below " + a + " is " + sum);
	}

	/* 2. Summation of the even fibonacci numbers. The threshold is the number terms  */
	/* Assuming the first two fibonacci numbers are 1 and 2 */
	public static void even_sum_fib(int threshold){
		int a=1; int b = 2;
		int sum = a + b; int tsum = 2;
		int count = 2;

		while (count < threshold){
			System.out.println("Log fib: " + sum);
			if(sum % 2 == 0){
				tsum += sum;
			}
			a = b;
			b = sum;
			sum = a + b;
			count++;
		}
		System.out.println("The sum of the even fibonacci with threshold " + threshold + " is: " + tsum);
	}

	/* 3. Largest Prime Factor */
	public static boolean isPrime(int a){
		if(a>2 && a%2==0){
			return false;
		}

		for(int i=3; i<a; i+=2){
			if(a%i == 0){
				return false;
			}
		}
		return true;
	}

	public static void largestPrimeFactor(int num){
		int pNum = 0;
		for(int i=2; i<= num; i++){
			if(isPrime(i) && num%i == 0){
				pNum = i;
			}
		}
		System.out.println("Largest prime factor for value " + num + " is " + pNum);
	}

	/* 4. Find the largest palindrome made from the product of two 3-digit numbers */
	public static boolean isPalindrome(String s, int start, int end){
		if(start > end)
			return true;
		if(s.length() == 0 || s.length() == 1)
			return true;
		if(s.charAt(start) != s.charAt(end))
			return false;
		return isPalindrome(s, start+1, end -1);
	}

	public static void largestPalProduct(){
		int pNum = -1;
		String s = "";
		for(int i=100; i<=999; i++){
			for(int j=100; j<=999; j++){
				s = Integer.toString(i*j);
				if(isPalindrome(s,0,s.length()-1) && (i*j)>pNum)
					pNum = i*j;
			}
		}
		System.out.println("The largest palindrome made from the product two 3-digit numbers is " + pNum);
	}

	/* 5. What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20? */
	public static boolean isDivisible(int n){
		for(int i=1; i<= 20; i++){
			if(n%i != 0)
				return false;
		}
		return true;
	}

	public static void projectEulerFive(){
		int n=20;
		while(!isDivisible(n++));
		System.out.println("The smallest number that is evenly divisible by all of the numbers from 1 to 20 is " + (n-1));
	}

/* 6. Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.*/
	public static void projectEulerSix(int n){
		int square_of_sum = (int) Math.pow((n*(n+1))/2,2);
		int sum_of_squares = (n*(n+1)*(2*n+1))/6;
		System.out.println("The difference between the sum of the square of the first one hundread natural numbers"
				+ " and the square of the sum is " + (square_of_sum - sum_of_squares));
	}

	/* 7. What is the 10 001st prime number? */
	public static void projectEulerSeven(int n){
		int count = 0, pNum = 1;
		while(count < n){
			if(isPrime(++pNum)){
				//System.out.println("Log: " + pNum);
				count++;
			}
		}
		System.out.println("The " + n + "th prime number is " + pNum);
	}

}
