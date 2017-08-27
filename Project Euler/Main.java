import java.util.ArrayList;

/*
 * Programmer: Joseph Cuellar
 * Created: 8/22/2017
 * Last date modified: 8/27/2017
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
		//projectEulerSeven(10001);
		projectEulerEight();
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

	/* 8. */
	public static void projectEulerEight(){
		ArrayList<Integer> list =  new ArrayList<Integer>();

		int[] importList = {7,3,1,6,7,1,7,6,5,3,1,3,3,0,6,2,4,9,1,9,2,2,5,1,1,9,6,7,4,4,2,6,5,7,4,7,4,2,3,5,5,3,4,9,1,9,4,9,3,4,
				9,6,9,8,3,5,2,0,3,1,2,7,7,4,5,0,6,3,2,6,2,3,9,5,7,8,3,1,8,0,1,6,9,8,4,8,0,1,8,6,9,4,7,8,8,5,1,8,4,3,
				8,5,8,6,1,5,6,0,7,8,9,1,1,2,9,4,9,4,9,5,4,5,9,5,0,1,7,3,7,9,5,8,3,3,1,9,5,2,8,5,3,2,0,8,8,0,5,5,1,1,
				1,2,5,4,0,6,9,8,7,4,7,1,5,8,5,2,3,8,6,3,0,5,0,7,1,5,6,9,3,2,9,0,9,6,3,2,9,5,2,2,7,4,4,3,0,4,3,5,5,7,
				6,6,8,9,6,6,4,8,9,5,0,4,4,5,2,4,4,5,2,3,1,6,1,7,3,1,8,5,6,4,0,3,0,9,8,7,1,1,1,2,1,7,2,2,3,8,3,1,1,3,
				6,2,2,2,9,8,9,3,4,2,3,3,8,0,3,0,8,1,3,5,3,3,6,2,7,6,6,1,4,2,8,2,8,0,6,4,4,4,4,8,6,6,4,5,2,3,8,7,4,9,
				3,0,3,5,8,9,0,7,2,9,6,2,9,0,4,9,1,5,6,0,4,4,0,7,7,2,3,9,0,7,1,3,8,1,0,5,1,5,8,5,9,3,0,7,9,6,0,8,6,6,
				7,0,1,7,2,4,2,7,1,2,1,8,8,3,9,9,8,7,9,7,9,0,8,7,9,2,2,7,4,9,2,1,9,0,1,6,9,9,7,2,0,8,8,8,0,9,3,7,7,6,
				6,5,7,2,7,3,3,3,0,0,1,0,5,3,3,6,7,8,8,1,2,2,0,2,3,5,4,2,1,8,0,9,7,5,1,2,5,4,5,4,0,5,9,4,7,5,2,2,4,3,
				5,2,5,8,4,9,0,7,7,1,1,6,7,0,5,5,6,0,1,3,6,0,4,8,3,9,5,8,6,4,4,6,7,0,6,3,2,4,4,1,5,7,2,2,1,5,5,3,9,7,
				5,3,6,9,7,8,1,7,9,7,7,8,4,6,1,7,4,0,6,4,9,5,5,1,4,9,2,9,0,8,6,2,5,6,9,3,2,1,9,7,8,4,6,8,6,2,2,4,8,2,
				8,3,9,7,2,2,4,1,3,7,5,6,5,7,0,5,6,0,5,7,4,9,0,2,6,1,4,0,7,9,7,2,9,6,8,6,5,2,4,1,4,5,3,5,1,0,0,4,7,4,
				8,2,1,6,6,3,7,0,4,8,4,4,0,3,1,9,9,8,9,0,0,0,8,8,9,5,2,4,3,4,5,0,6,5,8,5,4,1,2,2,7,5,8,8,6,6,6,8,8,1,
				1,6,4,2,7,1,7,1,4,7,9,9,2,4,4,4,2,9,2,8,2,3,0,8,6,3,4,6,5,6,7,4,8,1,3,9,1,9,1,2,3,1,6,2,8,2,4,5,8,6,
				1,7,8,6,6,4,5,8,3,5,9,1,2,4,5,6,6,5,2,9,4,7,6,5,4,5,6,8,2,8,4,8,9,1,2,8,8,3,1,4,2,6,0,7,6,9,0,0,4,2,
				2,4,2,1,9,0,2,2,6,7,1,0,5,5,6,2,6,3,2,1,1,1,1,1,0,9,3,7,0,5,4,4,2,1,7,5,0,6,9,4,1,6,5,8,9,6,0,4,0,8,
				0,7,1,9,8,4,0,3,8,5,0,9,6,2,4,5,5,4,4,4,3,6,2,9,8,1,2,3,0,9,8,7,8,7,9,9,2,7,2,4,4,2,8,4,9,0,9,1,8,8,
				8,4,5,8,0,1,5,6,1,6,6,0,9,7,9,1,9,1,3,3,8,7,5,4,9,9,2,0,0,5,2,4,0,6,3,6,8,9,9,1,2,5,6,0,7,1,7,6,0,6,
				0,5,8,8,6,1,1,6,4,6,7,1,0,9,4,0,5,0,7,7,5,4,1,0,0,2,2,5,6,9,8,3,1,5,5,2,0,0,0,5,5,9,3,5,7,2,9,7,2,5,
				7,1,6,3,6,2,6,9,5,6,1,8,8,2,6,7,0,4,2,8,2,5,2,4,8,3,6,0,0,8,2,32,5,7,5,3,0,4,2,0,7,5,2,9,6,3,4,5,0};
		for(int i=0; i<importList.length; i++){
			list.add(importList[i]);
		}

		int product = 0;
		for(int i=0; i<list.size(); i++){
			int total = list.stream().skip(i).limit(4).reduce(1, (a,b) -> a*b);
			String s = list.stream().skip(i).limit(4).map(e -> e.toString()).reduce("", String::concat);
			if(total > product){
				product = total;
				System.out.println("i: " + i + ", Total " + product + ", Numbers: " + s);
			}

		}
	}
}
