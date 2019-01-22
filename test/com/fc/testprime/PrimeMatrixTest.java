package com.fc.testprime;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class PrimeMatrixTest {
		
	@Rule
	public SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	

	@Before
	public void setUp() throws Exception {
		
		PrimeMatrix.sieveOfEratosthenes(10000,false);
	}

	@After
	public void tearDown() throws Exception {
		systemOutRule.clearLog();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test_getPrimeNumbers_When_Input_Is_0() {
	   	assertArrayEquals(new int[0], PrimeMatrix.getPrimeNumbers(0));
	}
	@Test
	public void test_getPrimeNumbers_When_Input_Is_1() {
		assertArrayEquals(new int[]{2}, PrimeMatrix.getPrimeNumbers(1));
	}

	@Test
	public void test_getPrimeNumbers_should_only_return_2_when_input_is_1_() {
		
		Assert.assertNotSame("expected output is 2", new Integer(5), PrimeMatrix.getPrimeNumbers(1)[0]);
	}
	@Test
	public void test_getPrimeNumbers_When_Input_Is_Negative() {		
		assertArrayEquals(new int[0], PrimeMatrix.getPrimeNumbers(-5));
		
	}	
	@Test
	public void test_getPrimeNumbers_When_Input_Is_10() {		
		assertArrayEquals(new int[]{2,3,5,7,11,13,17,19,23,29}, PrimeMatrix.getPrimeNumbers(10));
		
	}
	@Test
	public void test_PrintPrimeMultiplicationTable_should_print_nothing_when_N_is_0() {
		
		PrimeMatrix.printMultiplicationTable(PrimeMatrix.getPrimeNumbers(0));    
		assertEquals("", systemOutRule.getLogWithNormalizedLineSeparator());
	}
	@Test
	public void test_PrintMultiplicationTable_should_print_nothing_when_N_is_Negative() {
		
		 PrimeMatrix.printMultiplicationTable(PrimeMatrix.getPrimeNumbers(-1));    
		 assertEquals("", systemOutRule.getLogWithNormalizedLineSeparator());
	}
	@Test
	public void test_PrintMultiplicationTable_when_N_is_1() {
		
		int[] primeNumbers =PrimeMatrix.getPrimeNumbers(1);
		PrimeMatrix.printMultiplicationTable(primeNumbers);
		// format = (no of digits in 2)*2 +2 = 4
		StringBuilder output = new StringBuilder();
		output.append("   X   2");output.append("\n");
		output.append("   2   4");output.append("\n");
		
		assertEquals(output.toString(), systemOutRule.getLogWithNormalizedLineSeparator());
	
	}
	@Test
	public void test_PrintPrimeMultiplicationTable_when_N_is_4() {
		
		int[] primeNumbers =PrimeMatrix.getPrimeNumbers(4);
		PrimeMatrix.printMultiplicationTable(primeNumbers);
		// format = (no of digits in 7)*2 +2 = 4
		StringBuilder output = new StringBuilder();
		output.append("   X   2   3   5   7");output.append("\n");
		output.append("   2   4   6  10  14");output.append("\n");
		output.append("   3   6   9  15  21");output.append("\n");
		output.append("   5  10  15  25  35");output.append("\n");
		output.append("   7  14  21  35  49");output.append("\n");	
  
	    assertEquals(output.toString(), systemOutRule.getLogWithNormalizedLineSeparator());
	}
	@Test
	public void test_PrintMultiplicationTable_when_N_is_10() {
		
		int[] primeNumbers =PrimeMatrix.getPrimeNumbers(10);
		PrimeMatrix.printMultiplicationTable(primeNumbers);
		
		StringBuilder output = new StringBuilder();
		// format = (no of digits in 29)*2 +2 = 6
		
		output.append("     X     2     3     5     7    11    13    17    19    23    29");output.append("\n");
		output.append("     2     4     6    10    14    22    26    34    38    46    58");output.append("\n");
		output.append("     3     6     9    15    21    33    39    51    57    69    87");output.append("\n");
	    output.append("     5    10    15    25    35    55    65    85    95   115   145");output.append("\n");
		output.append("     7    14    21    35    49    77    91   119   133   161   203");output.append("\n");
		output.append("    11    22    33    55    77   121   143   187   209   253   319");output.append("\n");
	    output.append("    13    26    39    65    91   143   169   221   247   299   377");output.append("\n");
	    output.append("    17    34    51    85   119   187   221   289   323   391   493");output.append("\n");
	    output.append("    19    38    57    95   133   209   247   323   361   437   551");output.append("\n");
	    output.append("    23    46    69   115   161   253   299   391   437   529   667");output.append("\n");
        output.append("    29    58    87   145   203   319   377   493   551   667   841");output.append("\n");
        
   	    assertEquals(output.toString(), systemOutRule.getLogWithNormalizedLineSeparator());		
	}
	
	@Test
	public void test_PrintMultiplicationTable_when_has_negative_numbers() {
		
		int[] input ={-1,-2,-3};
		PrimeMatrix.printMultiplicationTable(input);	
		// format = (no of digits in -3)*2 +2 = 6
		StringBuilder output = new StringBuilder();
		output.append("     X    -1    -2    -3");output.append("\n");
		output.append("    -1     1     2     3");output.append("\n");
		output.append("    -2     2     4     6");output.append("\n");
		output.append("    -3     3     6     9");output.append("\n");
		    
		assertEquals(output.toString(), systemOutRule.getLogWithNormalizedLineSeparator());
	}

}
