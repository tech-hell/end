//DAA Practical no 1: Fibonacci Series Recursive and Non-recursive 
package daa_practicals;

public class Fibonacci {

	//recursive code for fibonnaci 
	static int fib_rec(int n)
	{
		//if n is 1 then return 0 and n is 2 then return 1
		if(n==1)
			return 0;
		else if(n==2)
			return 1;
		
		//else return fib(n-1) + fib(n-2)
		return fib_rec(n-1) + fib_rec(n-2);
	}
	
	//non-recursive code for fibonacci
	static int fib(int n) {
		//initial coditions
		if(n==1) 
			return 0;
		else if (n==2) 
			return 1;
		
		//else
		int f1, f2, f3=0;
		f1=0; f2=1;
		for(int i=3; i<=n; i++) {
			f3 = f1+f2;
			f1 = f2;
			f2 = f3;
		}
		return f3;
	}
	
	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			System.out.print(fib(i)+ " ");
		}
		System.out.println();
		
		for(int i=1; i<=10; i++) {
			System.out.print(fib_rec(i) + " ");
		}

	}

}
