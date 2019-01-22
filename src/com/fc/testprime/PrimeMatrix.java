package com.fc.testprime;

import java.time.Duration;
import java.time.Instant;

/**
 * This class has utility methods to get N prime numbers
 * and print the multiplication table of prime numbers
 * sieve of Eratosthenes algorithm is used to calculate the 
 * prime numbers up to 1 million.
 *   
 * @author dinesh
 *
 */
public class PrimeMatrix {
	
	 	final static int MAX = 100000000;
	 	
	     // Create a boolean array "prime[0..n]" and initialize  
	    // all entries as true. A value in prime[i] will 
	    // finally be false if i is Not a prime, else true. 
	 	// the time complexity of this up front computation is
	 	// O(NlogN(logN)) where N is the given number up to which we 
	 	// we find the prime numbers. 
	 	static boolean prime[] = new boolean [MAX +1] ; 
	    
	    static void sieveOfEratosthenes(int customLimit,boolean useCustomLimit)  
	    {       	
	    	if(useCustomLimit){
	    		prime = new boolean [customLimit +1] ; 
	    	}
	    	
	       for(int i = 0; i <= MAX; i++){
	        	 prime[i] = true ; 
	       }          
	       prime[1] = false;  
	        
	       for (int p = 2; p * p <= MAX; p++) {  
	        
	            // If prime[p] is not changed, then it is a prime  
	            if (prime[p] == true) {  
	        
	                // Set all multiples of p to non-prime  
	                for (int i = p * 2; i <= MAX; i += p)  
	                    prime[i] = false;  
	            }  
	        }  
	    } 
   /**
    * This Method prints the multiplication table for the given numbers.
    * Each cell is the product of number corresponding to row and column
    * The product is formated by the width of largest product in the table
    *   
    * @param int array
    */
	public static void printMultiplicationTable(int[] input){
		
		int length = input.length;
				
		if(length==0){
			return;
		}
		// get the highest/last number from the input
	    int maxLen = String.valueOf(input[length-1]).length()*2+2;
		//format number
		String format = new StringBuilder().append("%1$").append(maxLen).append("s").toString();
		
		/**
		 * print multiplication table to system out
		 */
	    
	    System.out.print(String.format(format,"X"));
	    for(int col=0;col<length;col++){
	    	 System.out.print(String.format(format,String.valueOf(input[col])));	    	
	    }
	    System.out.println();
		for(int row=0;row<length;row++){
			 System.out.print(String.format(format,String.valueOf(input[row])));	
			for(int col=0;col<length;col++){
				 System.out.print(String.format(format,String.valueOf(input[col]*input[row])));	
						
			}
			System.out.println();
		}		
	}

	/**
	 * Returns the array of prime numbers of length given
	 * by input 
	 * @param n, number of prime numbers 
	 * @return array of prime numbers of size n
	 */
	public static int[] getPrimeNumbers(int n){
		
		if(n<=0){
			return new int[0];
		}	
		int[] primeNumbers = new int[n]; 
		
		int count =1;
		int i=1;
		int j=0;
		
		while(count<=n){
			if(prime[i] && j<n){
				primeNumbers[j] = i;
				j++;count++;
			}
			i++;
		}
		
		return primeNumbers;
	}
	
	public static void main(String[] args) throws NumberFormatException, Exception {
		
		Instant start = Instant.now();
		// up front computation of all prime numbers up to given MAX number
		// set customLimit to false
		 sieveOfEratosthenes(10000,false);
		 if(args==null || args.length==0){
			 System.out.println("Only number is a valid argument");
			 return;
		 }else{
			 try{
				 int[] primeNumbers =getPrimeNumbers(Integer.parseInt(args[0]));
				 printMultiplicationTable(primeNumbers);
			 }
			 catch(NumberFormatException e){
				 System.out.println("Only number is a valid argument");
				
			 }
		 }
			
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		//System.out.println("\n time elapsed in seconds==> "+ (double)timeElapsed/1000);

	}

}
