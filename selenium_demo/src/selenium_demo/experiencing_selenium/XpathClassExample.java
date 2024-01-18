package selenium_demo.experiencing_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathClassExample {

	static WebDriver d = null;

	public static void main(String[] args) throws Exception {
		idetxpathwithrelative();
	}

	public static void loadapplication() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(3000);
	}

	public static void idetxpathwithrelative() throws Exception

	{
		loadapplication();
		WebElement ele = d.findElement(By.xpath("//input[@ng-model='FirstName']"));
		ele.sendKeys("Chincholi");
		System.out.println(ele.getAttribute("value"));
		Thread.sleep(3000);
		tearDown();

	}

	public static void idetxpathwithrelativeAnd() throws Exception

	{
		loadapplication();
		WebElement ele = d.findElement(By.xpath("//input[@type='text' and @placeholder='Last Name']"));
		ele.sendKeys("Chincholi");
		System.out.println(ele.getAttribute("value"));
		Thread.sleep(3000);
		tearDown();

	}

	public static void idetxpathwithrelativeOR() throws Exception

	{
		loadapplication();
		WebElement ele = d.findElement(By.xpath("//input[@type='tex' or @placeholder='Last Name']"));
		ele.sendKeys("Chincholi");
		System.out.println(ele.getAttribute("value"));
		Thread.sleep(3000);
		tearDown();

	}

	public static void idetxpathwithrelativeIndex() throws Exception {
		loadapplication();
		WebElement ele = d.findElement(By.xpath("(//input[@type='text'])[2]"));
		ele.sendKeys("Chincholi");
		System.out.println(ele.getAttribute("value"));
		Thread.sleep(3000);
		tearDown();
	}

	public static void idetxpathwithxpathText() throws Exception {
		loadapplication();
		WebElement ele = d.findElement(By.xpath("//label[text()='Email address*']"));
		System.out.println(ele.getText());
		Thread.sleep(3000);
		tearDown();
	}

	public static void idetxpathwithxpathContains() throws Exception {
		loadapplication();
		WebElement ele = d.findElement(By.xpath("//label[contains(@class,'checks')]"));
		System.out.println(ele.getText());
		Thread.sleep(3000);
		tearDown();
	}

	public static void idetxpathwithxpathContainstext() throws Exception {
		loadapplication();
		WebElement ele = d.findElement(By.xpath("//label[contains(text(),'Hoc')]"));
		System.out.println(ele.getText());
		Thread.sleep(3000);
		tearDown();
	}

	public static void idetxpathwithxpathStartswith() throws Exception {
		loadapplication();
		WebElement ele = d.findElement(By.xpath("//textarea[starts-with(@ng-model,'Adr')]"));
		ele.sendKeys("My Address location is Hyderabad");
		Thread.sleep(3000);
		tearDown();
	}

	public static void identxpathnormalizespace() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Windows.html");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//button[text()[normalize-space()='click']]"));
		ele.click();
		Thread.sleep(3000);
		tearDown();
	}

	public static void identxpathnormalizespacewithChainedXpath() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://demo.automationtesting.in/Windows.html");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//div[@id='Tabbed']//button[text()[normalize-space()='click']]"));
		ele.click();
		Thread.sleep(3000);
		tearDown();
	}

	public static void xapthParentAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//input[@id='twotabsearchtextbox']/parent::div[@class='nav-search-field ']"));
		highlightEle(ele);
		Thread.sleep(3000);
		tearDown();
	}
	
	public static void xapthChildAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//div[@id='nav-xshop']/child::a[position()=4]"));
		highlightEle(ele);
		Thread.sleep(3000);
		tearDown();
	}
	
	public static void xapthAncestorAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//input[@id='twotabsearchtextbox']/ancestor::div[@class='nav-fill']"));
		highlightEle(ele);
		Thread.sleep(3000);
		tearDown();
	}
	
	public static void xapthDescendantAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//div[@class='nav-fill']/descendant::input[@id='twotabsearchtextbox']"));
		highlightEle(ele);
		ele.sendKeys("Bread toaster");
		ele.submit();
		Thread.sleep(3000);
		tearDown();
	}

	public static void xapthFollowingSiblingAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Mobiles']/following-sibling::a"));
		highlightEle(ele);
		ele.click();
		Thread.sleep(3000);
		tearDown();
	}
	
	public static void xapthPrecedingSiblingAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Mobiles']/preceding-sibling::a[text()=\"Today's Deals\"]"));
		highlightEle(ele);
		ele.click();
		Thread.sleep(3000);
		tearDown();
	}
	
	public static void xapthFollowingAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Mobiles']/following::a[5]"));
		highlightEle(ele);
		Thread.sleep(3000);
		tearDown();
	}
	
	public static void xapthPrecedingAxes() throws Exception {
		d = new ChromeDriver();
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
		d.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ele = d.findElement(By.xpath("//div[@id='nav-xshop']/a[text()='Mobiles']/preceding::a[4]"));
		highlightEle(ele);
		Thread.sleep(3000);
		tearDown();
	}
	public static void highlightEle(WebDriver d, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	}
	public static void highlightEle(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		d.quit();
	}

}
