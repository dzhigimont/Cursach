package webdriver;

import java.util.Date;
import org.openqa.selenium.By;
import org.testng.Assert;

import webdriver.elements.Label;

/**
 * Base form
 */
public abstract class BaseForm extends BaseEntity {


	public BaseForm(final By locator, final String title) {
		long before = new Date().getTime();
		Label titlePicture = new Label(locator,title);
		titlePicture.explicitWaits();
		try{
			Assert.assertTrue(titlePicture.isPresent());
			
			long openTime = new Date().getTime() - before;
			
				info(String.format(getLoc("loc.form.appears"), title) + String.format(" in %smsec",openTime));
			
		} catch (Throwable e) {
			fatal(String.format(getLoc("loc.form.doesnt.appears"), title));
		}
	}


	/**
	 * For logs
	 * @param message Message
	 * @return Messagemessage
	 */
	protected String formatLogMsg(final String message) {
		return message;
	}



	

}
