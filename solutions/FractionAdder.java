/*
 * Name: Christopher Grigsby
 * Date: 10/09/20
 * Assignment: EOM4 (FractionAdd)
 * Pseudocode: 
 * PROGRAM FractionAdd: 
 * Initialize all variables (fraction1,fraction2, numer1, numer2
 * denom1, denom2, numerSum, denomSum, simplify)
 * 
 * Prompt for first fraction 
 *   assign fraction1
 *   
 * Prompt for second fraction
 *   assign fraction2 
 *  
 * assign numer1 by call method getNumerator(fraction1)
 * assign numer2 by call method getNumerator(fraction2)
 * assign denom1 by call method getDenominator(fraction1)
 * assign denom2 by call method getDenominator(fraction2)
 * 
 * if numerator1 OR numer2 equals zero
 *   Display msg Invalid Entry 
 * 
 * otherwise 
 * 
 *   if denom1 does not equal denom2 
 *     calculate denomSum by multiplying denom1 by denom2
 *     calculate numerSum by (numer1 times denom2) plus (numer2 times denom1)
 *   
 *   otherwise 
 *     calculate denomSum equals denom1 
 *     calculate numerSum by adding numer1 and numer2
 *   
 *   assign simplify by calling method commonDivisor(numerSum, denomSum)
 *   
 *   calculate numerSum by numerSum divided by simplify
 *   calculate denomSum by denomSum divided by simplify 
 *   
 *   Display msg The result is numerSum/denomSum 
 *   
 *   ----------------------------------------------
 *   Method getNumerator - converts the numerator of a String to an integer
 *	 @param fraction - the string to be separated then converted 
 *   @return - an integer of the numerator of a fraction
 *   
 *   assign i by call method findSlash(fraction)
 *   assign numerator by converting fraction.substring(0,i) to an integer
 *   
 *   return numerator
 *   
 *   -----------------------------------------------
 *   Method getDenominator - converts the denominator of String to an integer
 *   @param fraction - the string to be separated then converted 
 *   @return - an integer of the denominator of a fraction 
 *   
 *   assign i by calling method findSlash(fraction)
 *   assign denominator by converting fraction.substring(0,i) to an integer
 *   return denominator
 *   
 *   ------------------------------------------------
 *   Method findSlash - provides the position of backslash in a string
 *   @param str - a string to which is believed to contain a backslash
 *   @return - an integer for a position in a string 
 *   
 *   initialize position to 1
 *   declare character ch 
 *   
 *   repeat for x=0, x < str.length, x++
 *   
 *     assign ch to str.charAt(x) 
 *   
 *     if x equals / 
 *       assign position to x 
 *     
 *   return position 
 *   
 *   --------------------------------------------------
 *    Method commonDivisor - obtains the greatest common divisor for a fraction 
 *    @param numer - the numerator of a fraction 
 *    @param denom - the denominator of a fraction 
 *    @return - an integer for the greatest common divisor of the two integers 
 *      
 *    Initialize variables(divisor, maxCount)
 *    
 *    if numer equals denom
 *      assign divisor to denom
 *    
 *    otherwise if numer is greater than denom
 *      assign maxCount to numer
 *    
 *    otherwise 
 *      assign maxCount to denom 
 *      
 *    repeat for i=1, i < maxCount, i++
 *    
 *      if numer%1 equals 0 AND denom%1 equals 0 
 *        assign divisor equals i 
 *        
 *     return divisor  
 */

/**
 * Program Description: 
 * This program reads two fractions, adds them, and displays the result 
 * so that the numerator and denominator have no common factor. 
 */
import java.util.Scanner;

public class FractionAdder 
{
	public static void main(String[] args) 
	{
		//Initialize all variables 
		Scanner in = new Scanner(System.in);
		String fraction1 = ""; 
		String fraction2 = ""; 
		int numer1 = 0; 
		int numer2 = 0; 
		int denom1 = 0; 
		int denom2 = 0; 
		int numerSum = 0; 
		int denomSum = 0; 
		int simplify = 1;
		
		//Prompt for information
		System.out.print("Enter the first fraction: "); //obtain first fraction
		fraction1 = in.next(); 
		
		System.out.print("Enter the second fraction: "); //obtain second fraction
		fraction2 = in.next(); 
		
		numer1 = getNumerator(fraction1); //method call to obtain the numerator for both fractions 
		numer2 = getNumerator(fraction2); 
		denom1 = getDenominator(fraction1); //method call to obtain the denominator for both fractions 
		denom2 = getDenominator(fraction2); 
		
		//Calculations 
		if (denom1 == 0 || denom2==0) //input validation for denominator equals zero 
		{
			System.out.println("\nInvalid entry. Denominator cannot equal zero."); 
		}
		else 
		{
	
			if (denom1 != denom2) //discover how to add the fractions 
			{
				denomSum = denom1*denom2; 
				numerSum = (numer1*denom2)+(numer2*denom1); //find a common multiple if needed
			}
			else 
			{
				denomSum = denom1; 
				numerSum = numer1 + numer2; //otherwise just add the numerators 
			}
			
			simplify = commonDivisor(numerSum,denomSum); //method call to obtain greatest common divisor
			numerSum = numerSum / simplify; //get simplified fraction
			denomSum = denomSum / simplify; 
			
			//Display
			System.out.printf("%nThe result is %d/%d", numerSum,denomSum); //display fraction	
		}
	}//main
		
		/**
		 * Method getNumerator - converts the numerator of a String to an integer
		 * @param fraction - the string to be separated then converted 
		 * @return - an integer of the numerator of a fraction 
		 */
	
		public static int getNumerator(String fraction)
		{
			int i = findSlash(fraction); //call helper method to find slash
			int numerator = Integer.parseInt(fraction.substring(0,i)); //convert
			return numerator; 	
		}//getNumerator 
		
		/**
		 * Method getDenominator - converts the denominator of String to an integer
		 * @param fraction - the string to be separated then converted 
		 * @return - an integer of the denominator of a fraction 
		 */
		
		public static int getDenominator(String fraction)
		{
			int i = findSlash(fraction); //call helper method find slash
			int denominator = Integer.parseInt(fraction.substring(i+1)); //convert 
			return denominator; 	
		}//getDenominator
		
		/**
		 * Method findSlash - provides the position of backslash in a string
		 * @param str - a string to which is believed to contain a backslash
		 * @return - an integer for a position in a string 
		 */
		
		public static int findSlash(String str) 
		{
			int position = 1;  
			char ch; 
			
			for(int x = 0; x < str.length(); x++) //loop to find slash
			{
				ch = str.charAt(x); 
				
				if ( ch == '/') 
				{
					position = x; //will return position if found 
				}	
			}
			return position; 
		}//findSlash
		
		/**
		 * Method commonDivisor - obtains the greatest common divisor for a fraction 
		 * @param numer - the numerator of a fraction 
		 * @param denom - the denominator of a fraction 
		 * @return - an integer of the greatest common divisor of the two integers
		 */
		
		public static int commonDivisor(int numer, int denom)
		{
			int divisor = 0; 
			int maxCount = 0; 
			
			if (numer == denom) //no further action needed 
			{
				divisor = numer; 
			}
			else if (numer > denom) //otherwise obtain a max count for the loop
			{
				maxCount = numer; 
			}
			else 
			{
				maxCount = denom; 
			}
			
			for (int i=1; i <= maxCount; i++) //loop to find greatest common factor 
			{
				if (numer%i == 0 && denom%i == 0)
				{
					divisor = i; 
				}
			}
			return divisor; 	
		}//commonDivisor	
}//class
