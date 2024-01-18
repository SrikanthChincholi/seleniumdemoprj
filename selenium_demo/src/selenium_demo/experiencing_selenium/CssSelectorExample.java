package selenium_demo.experiencing_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorExample {

	static WebDriver d = null;
	static WebElement ele = null;

	public static void main(String[] args) throws Exception {
		identifywithCssSelectortagnamewithNthChild();
	}

	public static void loadapplication() throws Exception {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.amazon.in");
		Thread.sleep(3000);
	}

	public static void identifywithCssSelectorclassname() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector(".nav-right"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();

	}
	
	public static void identifywithCssSelectorId() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("#twotabsearchtextbox"));
		XpathClassExample.highlightEle(d,ele);
		ele.sendKeys("TV 65 inches");
		ele.submit();
		tearDown();
	}
	
	public static void identifywithCssSelectortagname() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("a[id='nav-logo-sprites']"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithAnd() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("a[id='nav-logo-sprites'][aria-label='Amazon.in']"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithOr() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("a[id='nav-logo'],[aria-label='Amazon.in']"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	public static void identifywithCssSelectortagnamewithStartswith() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("a[class^='nav']"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithEndswith() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("div[id$='slot']"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithContains() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("input[id*='textbox']"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithDirectChild() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("div[class='nav-fill']>div>input"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithInDirectChild() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("div[class='nav-fill'] a span"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithNthtype() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("div[class='nav-fill'] a:nth-of-type(5)"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithNthChild() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("div[class='nav-fill'] a:nth-child(5)"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}
	
	public static void identifywithCssSelectortagnamewithNot() throws Exception {
		loadapplication();
		ele = d.findElement(By.cssSelector("div[class='nav-fill'] a:nth-child(5)"));
		XpathClassExample.highlightEle(d,ele);
		tearDown();
	}


	public static void tearDown() throws Exception

	{
		Thread.sleep(3000);
		d.quit();
	}

}
