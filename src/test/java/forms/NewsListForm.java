package forms;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.ListOfPages;

public class NewsListForm extends BaseForm {

    private ListOfPages newsList = new ListOfPages(By.xpath("//h3[@class='b-posts-1-item__title']/a"));
    /**
     *
     *this Class constructor
     *
     */
    public NewsListForm() {
        super(By.xpath("//h3[contains(text(),'Самое актуальное')]"), "NewsList.logo");
    }
    /**
     * clickFirstNews()
     *this method clicks first link in the list news
     *
     * @return void
    public void clickFirstNews(){
        logger.info("==========The title news==========");
        logger.info(newsList.getElementOfPage(0).getText());
        newsList.clickAndWait(0);
    }
}
