package amazonAssignment;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FirstScripts.Search;

public class AmazonTestCases extends AmazonXpaths {

	
	static WebDriver driver;
	static WebDriverWait wait;
		
	
	public void launchWebsite() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	
	}
	
	public void signIn() {
		
		driver.findElement(signin).click();
		WebElement email = driver.findElement(emailTextField);
			email.click();
			email.clear();
			email.sendKeys("sumantawelekar08@hotmail.com");
		driver.findElement(continueButton).click();
		WebElement password = driver.findElement(passwordTextField);
			password.click();
			password.clear();
			password.sendKeys("Shopping@1616");
		driver.findElement(loginButton).click();
	}

	public void signOut() {
		
		WebElement logout = driver.findElement(signin);
		Actions action = new Actions(driver);
		action.moveToElement(logout).build().perform();
		
		WebElement signOut = wait.until(ExpectedConditions.visibilityOfElementLocated(signOutLink));
		signOut.click();
		
	}
	
	
	public static void searchAndAddToCart(String item, String brand) throws InterruptedException {
		
		driver.navigate().refresh();
		//searching item through search
		WebElement category = driver.findElement(toEnterItem);
    		category.click();
    		category.clear();
    		category.sendKeys(item);
    	driver.findElement(submitEnter).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//img[contains(@alt,'" +brand+ "')]")).click();
    
    	//window handle : switch to child window
    	Set <String> st = driver.getWindowHandles();
	    Iterator<String> it = st.iterator();
	    String parent =  it.next();
	    String child = it.next();
	    driver.switchTo().window(child);
	    
	    //adding item to cart
        driver.findElement(addToCart).click();
        driver.findElement(toCart).click();

        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(parent);
        driver.navigate().refresh();
        
	}
	
	public void cartTotalVerification() {
		
		driver.findElement(amazonLogo).click();
		driver.findElement(cart).click();
		
		//storing total elements into list
		List<WebElement> prizeList = driver.findElements(CartItemPrize);
		
		int i=0;
		float []a = new float[prizeList.size()];
		float b =0;
		
		//storing webelement to float array
			for(WebElement we:prizeList){
				
				System.out.println(Float.parseFloat(we.getText().replaceAll(",", "")));
				a[i] = Float.parseFloat(we.getText().replaceAll(",", ""));
				i++;
			}
				
		//addition of array element
				for(int j=0;j<i-1;j++) {
			
					b = b + a[j];
				}
		
		//checking item total with cart total
					if(b==a[i-1]) {
			
						System.out.println("item total "+b+" is equal to cart total "+a[i-1]);
					}
	}
	
	public void deleteCartItems() throws InterruptedException {
		
		driver.findElement(amazonLogo).click();
		driver.findElement(cart).click();
		Thread.sleep(3000);
		//storing total elements into list
		List<WebElement> deleteItemList = driver.findElements(deleteCartItem);
				
		//storing webelement to float array
			for(WebElement we:deleteItemList){
				
					we.click();
					Thread.sleep(3000);
					
			}	
	}
	
}
