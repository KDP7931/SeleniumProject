package com.Kp.qa.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WebdriverEventListener implements WebDriverListener {
	  private static final Logger LOGGER = Logger.getLogger(WebdriverEventListener.class.getName());

    public void beforeAnyCall(Object target, Method method, Object[] args) {
    	
    }

    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
    	
    }

    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
    //	LOGGER.log(Level.INFO,"Error while calling method: " + method.getName() + " - " + e.getMessage());
    }

    public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
    //	LOGGER.log(Level.INFO,"Before calling WebDriver method: " + method.getName());
    }

    public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
    //	LOGGER.log(Level.INFO,"After calling WebDriver method: " + method.getName());
    }

    public void beforeGet(WebDriver driver, String url) {
    	LOGGER.log(Level.INFO,"Before navigating to URL: " + url);
    }

    public void afterGet(WebDriver driver, String url) {
    	LOGGER.log(Level.INFO,"After navigating to URL: " + url);
    }

    public void beforeGetCurrentUrl(WebDriver driver) {
    //	LOGGER.log(Level.INFO,"Before getting current URL.");
    }

    public void afterGetCurrentUrl(String result, WebDriver driver) {
    //	LOGGER.log(Level.INFO,"After getting current URL: " + result);
    }

    public void beforeGetTitle(WebDriver driver) {
    	LOGGER.log(Level.INFO,"Before getting page title.");
    }

    public void afterGetTitle(WebDriver driver, String result) {
    	LOGGER.log(Level.INFO,"After getting page title: " + result);
    }

    public void beforeFindElement(WebDriver driver, By locator) {
    	LOGGER.log(Level.INFO,"Before finding element by: " + locator);
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        LOGGER.log(Level.INFO,"After finding element by: " + locator);
    }

    public void beforeFindElements(WebDriver driver, By locator) {
        LOGGER.log(Level.INFO,"Before finding elements by: " + locator);
    }

    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        LOGGER.log(Level.INFO,"After finding elements by: " + locator);
    }

    public void beforeGetPageSource(WebDriver driver) {
    //    LOGGER.log(Level.INFO,"Before getting page source.");
    }

    public void afterGetPageSource(WebDriver driver, String result) {
      //  LOGGER.log(Level.INFO,"After getting page source.");
    }

    public void beforeClose(WebDriver driver) {
    //    LOGGER.log(Level.INFO,"Before closing the WebDriver.");
    }

    public void afterClose(WebDriver driver) {
    //    LOGGER.log(Level.INFO,"After closing the WebDriver.");
    }

    public void beforeQuit(WebDriver driver) {
    //    LOGGER.log(Level.INFO,"Before quitting the WebDriver.");
    }

    public void afterQuit(WebDriver driver) {
    //    LOGGER.log(Level.INFO,"After quitting the WebDriver.");
    }

    public void beforeGetWindowHandles(WebDriver driver) {
     //   LOGGER.log(Level.INFO,"Before getting window handles.");
    }

    public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
     //   LOGGER.log(Level.INFO,"After getting window handles.");
    }

    public void beforeGetWindowHandle(WebDriver driver) {
   //     LOGGER.log(Level.INFO,"Before getting window handle.");
    }

    public void afterGetWindowHandle(WebDriver driver, String result) {
     //   LOGGER.log(Level.INFO,"After getting window handle.");
    }

    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
     //   LOGGER.log(Level.INFO,"Before executing script: " + script);
    }

    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
      //  LOGGER.log(Level.INFO,"After executing script: " + script);
    }

    public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {
     //   LOGGER.log(Level.INFO,"Before executing async script: " + script);
    }

    public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {
    //    LOGGER.log(Level.INFO,"After executing async script: " + script);
    }

    public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
    //    LOGGER.log(Level.INFO,"Before performing actions.");
    }

    public void afterPerform(WebDriver driver, Collection<Sequence> actions) {
    //    LOGGER.log(Level.INFO,"After performing actions.");
    }

    public void beforeResetInputState(WebDriver driver) {
    //    LOGGER.log(Level.INFO,"Before resetting input state.");
    }

    public void afterResetInputState(WebDriver driver) {
     //   LOGGER.log(Level.INFO,"After resetting input state.");
    }

    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
     //   LOGGER.log(Level.INFO,"Before calling WebElement method: " + method.getName());
    }

    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
     //   LOGGER.log(Level.INFO,"After calling WebElement method: " + method.getName());
    }

    public void beforeClick(WebElement element) {
        LOGGER.log(Level.INFO,"Trying to click on: "+ element.toString());
    }

    public void afterClick(WebElement element) {
        LOGGER.log(Level.INFO,"After clicking on element.");
    }

    public void beforeSubmit(WebElement element) {
     //   LOGGER.log(Level.INFO,"Before submitting a form element.");
    }

    public void afterSubmit(WebElement element) {
     //   LOGGER.log(Level.INFO,"After submitting a form element.");
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        LOGGER.log(Level.INFO,"Before sending keys to element.");
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        LOGGER.log(Level.INFO,"After sending keys to element.");
    }

    public void beforeClear(WebElement element) {
        LOGGER.log(Level.INFO,"Before clearing the text of an element.");
    }

    public void afterClear(WebElement element) {
        LOGGER.log(Level.INFO,"After clearing the text of an element.");
    }

    public void beforeGetTagName(WebElement element) {
     //   LOGGER.log(Level.INFO,"Before getting the tag name of an element.");
    }

    public void afterGetTagName(WebElement element, String result) {
     //   LOGGER.log(Level.INFO,"After getting the tag name of an element: " + result);
    }

    public void beforeGetAttribute(WebElement element, String name) {
        LOGGER.log(Level.INFO,"Before getting an attribute of an element: " + name);
    }

    public void afterGetAttribute(WebElement element, String name, String result) {
       LOGGER.log(Level.INFO,"After getting an attribute of an element: " + name);
    }

    public void beforeIsSelected(WebElement element) {
        LOGGER.log(Level.INFO,"Before checking if element is selected.");
    }

    public void afterIsSelected(WebElement element, boolean result) {
        LOGGER.log(Level.INFO,"After checking if element is selected: " + result);
    }

    public void beforeIsEnabled(WebElement element) {
        LOGGER.log(Level.INFO,"Before checking if element is enabled.");
    }

    public void afterIsEnabled(WebElement element, boolean result) {
        LOGGER.log(Level.INFO,"After checking if element is enabled: " + result);
    }

    public void beforeGetText(WebElement element) {
        LOGGER.log(Level.INFO,"Before getting text from element.");
    }

    public void afterGetText(WebElement element, String result) {
        LOGGER.log(Level.INFO,"After getting text from element: " + result);
    }

    public void beforeFindElement(WebElement element, By locator) {
        LOGGER.log(Level.INFO,"Trying to find Element By :" + locator);
    }

    public void afterFindElement(WebElement element, By locator, WebElement result) {
        LOGGER.log(Level.INFO,"Found Element By :  " + locator);
    }

    public void beforeFindElements(WebElement element, By locator) {
        LOGGER.log(Level.INFO,"Trying to find Element By : " + locator);
    }

    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        LOGGER.log(Level.INFO,"Found Element By : " + locator);
    }
}