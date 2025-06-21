package com.singletonpattern;

public class LoggerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Logger logger1=Logger.getInstance();
Logger logger2=Logger.getInstance();
logger1.log("Logging from logger1");
logger2.log("Logging from logger2");
if(logger1==logger2)
{
	System.out.println("Singleton confirmed! Only one Logger instance is used.");
	
}
else
{
	System.out.println("Singleton failed: Different instances found.");
}
	}

}
