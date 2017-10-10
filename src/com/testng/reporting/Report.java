package com.testng.reporting;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

public class Report implements IReporter{
	
	@Test
	public static void test1()
	{
		System.out.println("In test1");
	}
	
	
	@Test
	public static void test2()
	{
		System.out.println("In test2");
	}
	
	@Test
	public static void test3()
	{
		Assert.assertTrue(false);
		System.out.println("In test3");
	}
	
	
	

	@Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) 
    {
           
           System.out.println("+++++++++++  REPORT  +++++++++++");
           
           for (ISuite suite : suites)
           {
                        String suiteName = suite.getName();
                        
                         System.out.println("suite name :  "+suiteName);
                       Map<String, ISuiteResult> suiteResults = suite.getResults();
                     
                       for (ISuiteResult sr : suiteResults.values())
                      {
                         
                   
                          ITestContext tc = sr.getTestContext();
                                                
                          
                          // For Passed Tests
                          IResultMap passedtests  = tc.getPassedTests();         
                          Set<ITestResult>  rc=   passedtests.getAllResults();                        
                          Iterator <ITestResult> ir = rc.iterator();
                        
                        
                        while (ir.hasNext())
                        {
                        	ITestResult r = ir.next();
                        	System.out.println(r.getName());
                        	System.out.println(r.getStatus());
                        }
                        
                        
                        // For Failed Tests Tests
                        IResultMap failedcount  =  tc.getFailedTests();             
                       
                        Set<ITestResult>  rc1 =   failedcount.getAllResults();                        
                        Iterator <ITestResult> ir1 = rc1.iterator();
                      
                      
                      while (ir1.hasNext())
                      {
                      	ITestResult r1 = ir1.next();
                      	System.out.println(r1.getName());
                      	System.out.println(r1.getStatus());
                      }
                        
                        
                        
                        
                      // For Failed Tests Tests
                      IResultMap skippedTests  =  tc.getSkippedTests();                   
                      Set<ITestResult>  rc2 =   skippedTests.getAllResults();                        
                      Iterator <ITestResult> ir2 = rc2.iterator();
                    
                    
                    while (ir2.hasNext())
                    {
                    	ITestResult r2 = ir2.next();
                    	System.out.println(r2.getName());
                    	System.out.println(r2.getStatus());
                    }
                      
                    
                    
                    
                        
                        
                        
                        
                        
                          System.out.println(passedtests.size());
                          System.out.println("Passed tests for suite '" + suiteName + "' is:" + tc.getPassedTests().getAllResults().size());
                          System.out.println("Failed tests for suite '" + suiteName + "' is:" + tc.getFailedTests().getAllResults().size());
                          System.out.println("Skipped tests for suite '" + suiteName + "' is:" + tc.getSkippedTests().getAllResults().size());
                         // System.out.println("test case name: "+tc.getName());
                          
                          
                      }
                       
                       
                       
                       

		
	}

    }
    }
