package tests;

import forms.DropDownMenuNews;
import forms.MainOnlinerForm;
import forms.NewsListForm;
import forms.apartments.ApartmentForm;
import forms.apartments.ApartmentsSearchForm;
import forms.apartments.DropDownMenuApartments;
import utility.GetCoordinatesByAddress;
import webdriver.BaseTest;

import java.util.List;

public class TestApartmentAddressViewByMap extends BaseTest {

    public void runTest(){

        MainOnlinerForm mainOnlinerForm = new MainOnlinerForm();

        logger.step(1);
        mainOnlinerForm.navigate(MainOnlinerForm.Buttons.apartments.toString());
        DropDownMenuApartments dropDownMenuApartments= new  DropDownMenuApartments();

        logger.step(2);
        dropDownMenuApartments.clickMinsk();
        ApartmentsSearchForm apartmentsSearchForm = new ApartmentsSearchForm();

        logger.step(3);
        apartmentsSearchForm.clickFirstLink();
        ApartmentForm apartmentForm = new ApartmentForm();

        logger.step(4);
        String[] coordOnliner = apartmentForm.getCoordinate();
        GetCoordinatesByAddress getCoordinatesByAddress = new GetCoordinatesByAddress();
        String[] coordMap = getCoordinatesByAddress.getCoordinates(apartmentForm.getStreet());

        logger.step(5);
        apartmentForm.assertCoordinate(coordOnliner,coordMap);
        System.out.println();
    }
}
