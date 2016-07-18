package forms;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.ListOfPages;

public class NewsListForm extends BaseForm {

    private ListOfPages newsList = new ListOfPages(By.xpath("//h3[@class='b-posts-1-item__title']/a"));
    public NewsListForm() {
        super(By.xpath("//h3[contains(text(),'Самое актуальное')]"), "NewsList.logo");
    }

    public void clickFirstNews(){
        logger.info("==========The title news==========");
        logger.info(newsList.getElementOfPage(0).getText());
        newsList.clickAndWait(0);
    }
}
