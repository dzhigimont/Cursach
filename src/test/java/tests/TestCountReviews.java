package tests;


import forms.DropDownMenuNews;
import forms.MainOnlinerForm;
import forms.NewsForm;
import forms.NewsListForm;
import webdriver.BaseTest;

public class TestCountReviews extends BaseTest {


    public void runTest(){
        MainOnlinerForm mainOnlinerForm = new MainOnlinerForm();

        logger.step(1);
        mainOnlinerForm.navigate(MainOnlinerForm.Buttons.news.toString());
        DropDownMenuNews dropDownMenuNews = new DropDownMenuNews();

        logger.step(2);
        dropDownMenuNews.clickTechnology();
        NewsListForm newsListForm = new NewsListForm();

        logger.step(3);
        newsListForm.clickFirstNews();
        NewsForm newsForm = new NewsForm();

        logger.step(4);
        newsForm.assertComments();


    }
}
