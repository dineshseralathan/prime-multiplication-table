package com.fc.testprime;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PrimeMatrixTestRunner {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	public static void main(String[] args) {	
		
		Result result = JUnitCore.runClasses(PrimeMatrixTest.class);
		
		for(Failure failure: result.getFailures())
		{   
			System.out.println(failure.toString());
		}
		
		System.out.println("All test cases passed: "+result.wasSuccessful());
		

	}

}
