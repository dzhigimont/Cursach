package webdriver;

import static webdriver.Logger.getLoc;

import java.util.concurrent.TimeUnit;

import javax.naming.NamingException;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriver.elements.Label;
import com.google.common.base.Strings;

/**
 * The main class to access the browser, which extends the capabilities of the standard RemoteWebdriver
 */
	public final class Browser {

	
	private static final long IMPLICITY_WAIT = 60;
	private static final String DEFAULT_CONDITION_TIMEOUT = "defaultConditionTimeout";
	private static final String DEFAULT_PAGE_LOAD_TIMEOUT = "defaultPageLoadTimeout";
	
//	private static final String URL_LOGIN_PAGE = "urlLoginPage";

	
	
	
	// имя файла с настройками Selenium
	/**
	 * speedValue=100 defaultPageLoadTimeout=60 defaultConditionTimeout=180
	 * urlLoginPage=http://opensesame:%23pears0n@dev.pearsoninnovationlabs.com/ #overrided in
	 * Browser.initProperties-default=firefox; #if null - use argument 'browser' to JVM; if other value (without '*'),
	 * #will use it as browserStartCommand #Usage: #firefox #iexplore #chrome #null browser=iexplore
	 */
	static final String PROPERTIES_FILE = "selenium.properties";
	private static final String BROWSER_BY_DEFAULT = "firefox";
	private static final String BROWSER_PROP = "browser";

	

	// browsers
	private static Browser instance;
	private static RemoteWebDriver driver;
	public static PropertiesResourceManager props;

	// поля класса

	private static String timeoutForPageLoad;
	private static String timeoutForCondition;

	

	public static Browsers currentBrowser;
	
	

	/**
	 * Private constructor (singleton pattern)
	 */
	private Browser() {
		Logger.getInstance().info(String.format(getLoc("loc.browser.ready"), currentBrowser.toString()));
	}

	/**
	 * Checks is Browser slive
	 * @return true\false
	 */
	public boolean isBrowserAlive() {
		return instance != null;
	}

	/**
	 * Checks is BaseUrl()
	 * @return String url
	 */
	public static String getBaseUrl(){
		return System.getProperty("urlLoginPage", props.getProperty("urlLoginPage"));
	}
	
	/**
	 * Gets instance of Browser
	 * @return browser instance
	 */
	public static Browser getInstance() {
		if (instance == null) {
			initProperties();
			try {
				driver = (RemoteWebDriver) BrowserFactory.setUp(currentBrowser.toString());
				driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
				Logger.getInstance().info(getLoc("loc.browser.constructed"));
			} catch (NamingException e) {
				Logger.getInstance().info("NamingException...");
				e.printStackTrace();
			}
			instance = new Browser();
		}
		return instance;
	}

	/**
	 * The implementation of the browser is closed
	 * <p>
	 * see {@link BaseEntity#checkAndKill()} all browser processes will be killed
	 * <p>
	 * void after test
	 */
	public void exit() {
		try {
			driver.quit();
			Logger.getInstance().info(getLoc("loc.browser.driver.qiut"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance = null;
		}
	}

	/**
	 * gets TimeoutForCondition
	 * @return timeoutForCondition
	 */
	public String getTimeoutForCondition() {
		return timeoutForCondition;
	}
	

	/**
	 * gets TimeoutForPageLoad
	 * @return timeoutForPageLoad
	 */
	public String getTimeoutForPageLoad() {
		return timeoutForPageLoad;
	}

		/**
	 * init
	 */
	private static void initProperties() {

		props = new PropertiesResourceManager(PROPERTIES_FILE);
		timeoutForPageLoad = props.getProperty(DEFAULT_PAGE_LOAD_TIMEOUT);
		timeoutForCondition = props.getProperty(DEFAULT_CONDITION_TIMEOUT);

		if (Strings.isNullOrEmpty(props.getProperty(BROWSER_PROP))) {
			// using System.getProperty
			currentBrowser = Browsers.valueOf(System.getProperty(BROWSER_PROP, BROWSER_BY_DEFAULT).toUpperCase());
		} else {
			// using selenium.properties
			String proper = props.getProperty(BROWSER_PROP);
			currentBrowser = Browsers.valueOf(proper.toUpperCase());
		}
	}

	/**
	 * wait the download page (on Javascript readyState)
	 */
	public void waitForPageToLoad() {
		// Logger.getInstance().info("waitForPageToLoad started");
		WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(getTimeoutForPageLoad()));

		try {
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(final WebDriver d) {
					if (!(d instanceof JavascriptExecutor)) {
						return true;
					}
					Object result = ((JavascriptExecutor) d)
							.executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
					if (result != null && result instanceof Boolean && (Boolean) result) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			Logger.getInstance().warn(getLoc("loc.browser.page.timeout"));
		}
		// Logger.getInstance().info("waitForPageToLoad ended");
	}



	/**
	 * maximizes the window
	 * <p>
	 */
	public void windowMaximise() {
		driver.manage().window().maximize();

	}

	/**
	 * Navigates to the Url
	 * @param url Url
	 */
	public void navigate(final String url) {
		driver.navigate().to(url);
	}

	/** navigateToBack
	 * this method flips one page back and waits
	 *
	 */
	public  void navigateToBack(){
		driver.navigate().back();
		waitForPageToLoad();
	}

	/**  goToFrame
	 * this method switch another frame
	 *@param i=4
	 */
	public  void goToFrame(int i){
		driver.switchTo().frame(i);
	}

	/**  goToFrame
	 * this method switch another frame
	 *@param str = "new frame"
	 */
	public  void goToFrame(String str){
		driver.switchTo().frame(str);
	}



	/**
	 * get RemoteWebDriver
	 * @return driver
	 */
	public RemoteWebDriver getDriver() {
		return driver;
	}

	

	/**
	 * Clicks on element
	 * @param selector By Locator
	 */
	@Deprecated
	public void click(final By selector) {
		new Label(selector).clickAndWait();
	}


	
	/**
	 * Gets current URL
	 * @return current URL
	 */
	public String getLocation() {
		return driver.getCurrentUrl();
	}


	/**
	 * Browsers enumeration
	 */
	public enum Browsers {
		/**
		 * @uml.property name="fIREFOX"
		 * @uml.associationEnd
		 */
		FIREFOX("firefox"), /**

		 * @uml.property name="iEXPLORE"
		 * @uml.associationEnd
		 */
		IEXPLORE("iexplore"), /**

		 * @uml.property name="cHROME"
		 * @uml.associationEnd
		 */
		CHROME("chrome"), /** 

		  * @uml.property name="oPERA"
		 * @uml.associationEnd
		 */
		OPERA("opera"), /** 

		 * @uml.property name="sAFARI"
		 * @uml.associationEnd
		 */
		 SAFARI("safari");
		
		private String value;

		/**
		 * Constructor
		 * @param values Value
		 */
		 Browsers(final String values) {
			value = values;
		}

		/**
		 * Returns string value
		 * @return String value
		 */
		public String toString() {
			return value;
		}
	}

	
	
	
	

	
	
	
}
