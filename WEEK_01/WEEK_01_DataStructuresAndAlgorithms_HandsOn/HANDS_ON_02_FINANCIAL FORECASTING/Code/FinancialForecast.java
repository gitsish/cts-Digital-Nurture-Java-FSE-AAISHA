package com.financialforecast;
import java.util.Scanner;
public class Main{
	//Naive Approach Of recursion
	public static double forecastRecursive(int year,double baseValue,double growthRate)
	{
		if(year==0)
		{
			return baseValue;
		}
		return forecastRecursive(year-1,baseValue,growthRate)*(1+growthRate);
	}
	
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("_______Financial Forecasting Tool_______");
		System.out.println("_______Enter base Financial amount(>1000): ");
		double baseValue=sc.nextDouble();
		System.out.print("Enter Annual Growth Rate(in %)");
		double growthRatePercent=sc.nextDouble();
		double growthRate=growthRatePercent/100.0;
		System.out.print("Enter number of years to forecast:");
		int years=sc.nextInt();
		//Naive Forecast
		long startTimeRecur=System.nanoTime();
		double futureValRecur=forecastRecursive(years,baseValue,growthRate);
		long endTimeRecur=System.nanoTime();
		long durationRecur=endTimeRecur-startTimeRecur;
		
		//when the years are huge,naive recursive function might collapse to execute(at times,stackOverFlowErrors)
		//whereas the optimized approach will execute with no error,but
		//for small inputs it may take more time to execute 
		System.out.printf("\nNaive Recursion ->Future Value after %d years: %.2f rupees\n",years,futureValRecur);
		System.out.printf("Time Taken: %.4f ms\n",durationRecur/1_000_000.0);
		
			sc.close();
}
}
