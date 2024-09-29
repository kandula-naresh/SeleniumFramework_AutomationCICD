package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	public AbstractComponent(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "[routerlink*='cart']")
	private WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	private WebElement orderHeader;


	public void waitForElementToAppear(By findBy) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForWebElementToClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		return new CartPage(driver);
	}
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		return new OrderPage(driver);
		
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

	}

}
