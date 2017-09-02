import java.util.ArrayList;

/*
 * Programmer: Joseph Cuellar
 * Created: 8/22/2017
 * Last date modified: 9/01/2017
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
		//projectEulerEight();
		//projectEulerTen(10);
		//projectEulerEleven();
		projectEulerTwelve();
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
		if(a==2)return true;
		if(a<2 || a%2==0){
			return false;
		}
		for(int i=3; i<=Math.sqrt(a); i+=2){
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

	/* 10. Summation of primes below n */
	public static void projectEulerTen(int n){
		int sum = 0;
		if(n > 2){ sum = 2;}
		for(int i = 3; i<n; i+=2){
			if(isPrime(i)){
				sum += i;
			}
		}
		System.out.println("Summation of prime numbers below " + n + " is " + sum);
	}

	/* 11. What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally)
	 * 	   in the 20×20 grid?*/
	public static void projectEulerEleven(){
		int product = 0;
		int[][] list = {{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
				{49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 0},
				{81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
				{52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
				{22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
				{24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
				{32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
				{67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
				{24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
				{21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
				{78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
				{16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
				{86, 56, 0, 48, 35, 71, 89, 07, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
				{19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
				{4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
				{88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
				{4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
				{20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
				{20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
				{1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}};

		/* Create and initialize the array list*/
		ArrayList<ArrayList<Integer>> gridHorizontal = new ArrayList<ArrayList<Integer>>();
		initializeArrayList(gridHorizontal, list);

		/* Calculate highest sum horizontally*/
		product = findHighestProduct(gridHorizontal);
		System.out.println("Highest product (After horizontal check) : " + product);

		/* Calculate highest sum vertically */
		int[][] listVertical = new int[20][20];
		listVertical = reverse(list); /* reversing the new list to insert in the new array list*/
		/* Create and initialize the array list*/
		ArrayList<ArrayList<Integer>> gridVertical = new ArrayList<ArrayList<Integer>>();
		initializeArrayList(gridVertical, listVertical);
		product = findHighestProduct(gridVertical);
		System.out.println("Highest product (After vertical check): " + product);

		product = findHighestDiagProduct(list);

	}

	public static void initializeArrayList(ArrayList<ArrayList<Integer>> grid, int[][] list){
		/* Create and initialize the array list*/
		for(int i=0; i<20; i++){
			grid.add(new ArrayList<Integer>());
		}

		/* Insert values from the list*/
		for(int i=0; i<list.length; i++){
			for(int j=0; j<list[i].length; j++){
				grid.get(i).add(list[i][j]);
			}
		}
	}

	public static int[][] reverse(int[][] grid){
		int[][] newGrid = new int[20][20];
		for(int r = 0; r<20; r++){
			for(int c=0; c<20; c++){
				newGrid[c][r] = grid[r][c];
			}
		}
		return newGrid;
	}

	public static int findHighestProduct(ArrayList<ArrayList<Integer>> list){
		int product = 0, currProduct = 0;
		for(int i=0; i<list.size(); i++){
			for(int j=0; j<list.size(); j++){
				product = list.get(i).stream().skip(j).limit(4).reduce(1, (a,b) -> a*b);
				String s = list.get(i).stream().skip(i).limit(4).map(e -> e.toString()+" ").reduce("", String::concat);
				if(product > currProduct){
					currProduct = product;
					System.out.println("i: " + i + ", Total " + product + ", Numbers: " + s);
				}
			}
		}
		return currProduct;
	}

	public static int findHighestDiagProduct(int [][] list){
		int product = 0, currProduct = 0;
		/* Find highest product diagonally with the direction "\" */
		for(int r=0; r<list.length-3; r++){
			for(int c=0; c<list[r].length-3; c++){
				product = list[r][c] * list[r+1][c+1] * list[r+2][c+2] * list[r+3][c+3];
				if(product > currProduct){
					currProduct = product;
				}
			}
		}
		System.out.println("1. Highest Product Diagonal (After first diagonal check) : " + currProduct);
		/* Find highest product diagonally with the direction "/" */
		for(int r=0; r<list.length-3; r++){
			for(int c=3; c<list[r].length; c++){
				product = list[r][c] * list[r+1][c-1] * list[r+2][c-2] * list[r+3][c-3];
				if(product > currProduct){
					currProduct = product;
				}
			}
		}
		System.out.println("2. Highest Product Diagonal (After second diagonal check) : " + currProduct);

		return currProduct;
	}

	/*12. What is the value of the first triangle number to have over five hundred divisors? */
	public static void projectEulerTwelve(){
		int nthTri = 0, totalFactors = 0, i = 1;
		boolean overHundred = false;
		while(!overHundred){
			nthTri = nthTriangle(i);
			totalFactors = countFactors(nthTri);
			System.out.println("Total factors for " + nthTri + " is " + totalFactors);
			if(totalFactors > 100)
				overHundred = true;
			i++;
		}

	}

	public static int nthTriangle(int n){
		if(n == 0)
			return 0;
		else
			return n + nthTriangle(n - 1);
	}

	public static int countFactors(int n){
		if(n == 1) return n;
		int count = 2;

		for(int i=2; i<n; i++){
			if(n%i == 0)
				count+=1;
		}
		return count;
	}
}
