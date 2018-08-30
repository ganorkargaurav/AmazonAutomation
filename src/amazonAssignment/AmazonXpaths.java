package amazonAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonXpaths {
	
			By signin = By.id("nav-link-yourAccount");
			By emailTextField = By.id("ap_email");
			By continueButton = By.id("continue");
			By passwordTextField = By.id("ap_password");
			By loginButton = By.id("signInSubmit");
			By signOutLink = By.xpath("//span[contains(text(),'Sign Out')]");
			static By toEnterItem = By.id("twotabsearchtextbox");
			static By submitEnter = By.xpath("//div[@class = 'nav-search-submit nav-sprite']");
			static By addToCart = By.xpath("//input[@id ='add-to-cart-button']");
			static By toCart = By.xpath("//span[@class = 'a-button-inner']");
			static By itemCartPrice = By.xpath("//div[@class='a-column a-span2 a-text-left']");
			By cart = By.id("nav-cart");
			By activeCartItemPrize = By.xpath("//div[@id='sc-active-cart']//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']");
			By CartItemPrize = By.xpath("//div[@id='sc-active-cart']//span[@style='text-decoration: inherit; white-space: nowrap;']");
			static By amazonLogo = By.className("nav-logo-link");
			By deleteCartItem = By.xpath("//div[@id='sc-active-cart']//input[@value='Delete']");
			
	}
