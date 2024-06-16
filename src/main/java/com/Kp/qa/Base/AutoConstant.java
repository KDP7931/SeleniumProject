package com.Kp.qa.Base;

import java.time.Duration;

public interface AutoConstant {
	
	public static final Duration ExplicitWaitTime = Duration.ofSeconds(30);
	long ImplicitWaitTime = 90;
	Duration PageLoaderTime = Duration.ofSeconds(30);
	String UserName = "mngr576516";
	String Password = "EmEpypa";
	static long ConstantTime = 10000;
	/*####File Path#####*/	
	String Downloadpath ="C:\\Users\\dhava\\Downloads"; 


}
