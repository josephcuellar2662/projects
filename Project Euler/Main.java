
public class Main {
	
	public static void main(String[] jc){
		even_sum_fib(11);
	}
	
	/* Summation of the even fibonacci numbers. The threshold is the number terms  */
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
	
}
