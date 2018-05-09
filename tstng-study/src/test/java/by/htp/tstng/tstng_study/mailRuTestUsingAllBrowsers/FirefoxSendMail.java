package by.htp.tstng.tstng_study.mailRuTestUsingAllBrowsers;

import org.testng.annotations.Test;

import by.htp.tstng.tstng_study.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class FirefoxSendMail {
  
	private Steps steps;
	private final String USERNAME = "bulbazavr.bulbazavrovich";
	private final String PASSWORD = "YourMyHeartYourMySoul";
	private final String TO = "tathtp@mail.ru";
	private final String SUBJECT = "Testing test";
	private final String EMAILCONTENT = "Maksim Shkrabkov link to git: https://github.com/Maksim-Shkrabkov";
	
   @BeforeMethod
   public void beforeMethod() {
	   steps = new Steps();
		steps.initFirefoxBrowser();
   }
  
   @Test
   public void testFirefoxSendMail() {
	   steps.sendEmailWithLoginUser(USERNAME, PASSWORD, TO, SUBJECT, EMAILCONTENT);
   } 

   @AfterMethod
   public void afterMethod() {
	   steps.closeDriverFactory();
   }

}
