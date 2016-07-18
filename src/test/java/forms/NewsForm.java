package forms;



import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.ListOfPages;

public class NewsForm extends BaseForm {
    private Label commentNumber = new Label(By.xpath("//a[@class='comment-icon-1']/span"),"commentNumber");
    private ListOfPages commentList = new ListOfPages(By.xpath("//span[@class='date']"),"commentList");
    public NewsForm() {
        super(By.xpath("//h3[contains(text(),'Обсуждение')]"), "News.Logo");
    }
    public void assertComments(){
        commentNumber.navigateToElement();
        String msgPass = "Displays the number = "+commentNumber.getText()+ " of matches counted the number = "+commentList.getListOfPageSize();
        String msgFail = "Displays the number = "+commentNumber.getText()+ " of NOT matches counted the number= "+commentList.getListOfPageSize();
        doAssertFail(Integer.parseInt(commentNumber.getText())==commentList.getListOfPageSize(),msgPass,msgFail);
    }


}
