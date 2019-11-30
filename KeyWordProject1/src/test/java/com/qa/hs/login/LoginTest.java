package com.qa.hs.login;

import org.testng.annotations.Test;

import com.qa.orange.keywordengine.KeywordEngine;

public class LoginTest {
 public KeywordEngine keywordEngine;
	
@Test	
public void loginTest()
{
 keywordEngine = new KeywordEngine();	
 keywordEngine.startExcution("Login");
}
	
@Test	
public void logoTest()
{
 keywordEngine = new KeywordEngine();	
 keywordEngine.startExcution("logo");
}	
	
	
	
}
