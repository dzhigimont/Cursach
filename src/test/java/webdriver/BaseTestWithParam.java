package webdriver;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * An abstract class that describes the basic test application contains
 * methods for logging and field test settings (options)
 */
public abstract class BaseTestWithParam extends BaseEntity{

	/**
	 * To override.
	 */
	public abstract void runTest(String vendor,String maxPrice, String minDate, String minScreenSize,String maxScreenSize) throws InterruptedException, Exception;

	String vendor;
	String maxPrice;
	String minDate;
	String minScreenSize;
	String maxScreenSize;






	/**
	 * Before Class method
	 */
	@BeforeTest


	@Parameters({"vendor","maxPrice","minDate","minScreenSize","maxScreenSize"})
	/**
	 * readParam
	 * this method read parameter  from an external file TestSuite.xml
	 *
	 */

	public void readParam(String vendor,String maxPrice,String minDate,String minScreenSize,String maxScreenSize){
		this.vendor=vendor;
		this.maxPrice= maxPrice;
		this.minDate = minDate;
		this.minScreenSize= minScreenSize;
		this.maxScreenSize = maxScreenSize;
	}

	/**
	 * Test
	 * @throws Throwable Throwable
	 */
	@Test
	public void xTest() throws Exception {
		Class<? extends BaseTestWithParam> currentClass = this.getClass();
		
		try {
			logger.logTestName(currentClass.getName());
			browser.navigate(Browser.getBaseUrl());
			runTest(vendor,maxPrice,minDate,minScreenSize,maxScreenSize);
			logger.logTestEnd(currentClass.getName());
		} catch (Throwable e) {
			
				logger.warn("");
				logger.warnRed(getLoc("loc.test.failed"));
				logger.warn("");
				logger.fatal(e.getMessage());
			}
		
	}

	/**
	 * Format logging
	 * @param message Message
	 * @return Message
	 */
	protected String formatLogMsg(final String message) {
		return message;
	}

}
