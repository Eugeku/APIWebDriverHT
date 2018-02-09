package com.epam.kuzora.hometask.tests.test;

import com.epam.kuzora.hometask.tests.BaseUITest;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestValues;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestGroup;
import com.epam.kuzora.hometask.tests.common.pageobject.googlesearch.StartGooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebBrowserGoogleTest extends BaseUITest {

    @Test(groups = {TestGroup.FULL, TestGroup.UI, TestGroup.SMOKE})
    public void tst_checkGoogle() {
        driver.get(TestValues.BASE_GOOGLE_URL);

        page.getPageInstance(StartGooglePage.class).isItStartPageOfGoogle();

        // check is it start pageobject for www.google.by
        Assert.assertTrue(page.getPageInstance(StartGooglePage.class).isItStartPageOfGoogle());

        //        // click on confirm button and check is it start pageobject
        page.getPageInstance(StartGooglePage.class).setSearchFieldAndClick("EPAM");
    }
}
