package com.epam.kuzora.hometask.tests.test;

import com.epam.kuzora.hometask.tests.BaseUITest;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestGroup;
import com.epam.kuzora.hometask.tests.common.pageobject.googlesearch.StartGooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebBrowserTest extends BaseUITest {
    private String baseUrl = "https://www.google.by";
    private StartGooglePage startGooglePage;

    @Test(groups = {TestGroup.FULL, TestGroup.UI, TestGroup.SMOKE})
    public void tst_checkGoogle() {
        driver.get(baseUrl);

        page.GetInstance(StartGooglePage.class).isItStartPageOfGoogle();

        // check is it start pageobject for www.google.by
        Assert.assertTrue(page.GetInstance(StartGooglePage.class).isItStartPageOfGoogle());

        //        // click on confirm button and check is it start pageobject
        page.GetInstance(StartGooglePage.class).setSearchFieldAndClick("EPAM");
    }
}
