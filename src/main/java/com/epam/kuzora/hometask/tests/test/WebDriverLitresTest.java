package com.epam.kuzora.hometask.tests.test;

import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import com.epam.kuzora.hometask.service.APIServiceHelper;
import com.epam.kuzora.hometask.service.api.command.fakerestapi.book.GetListsOfBooks;
import com.epam.kuzora.hometask.tests.BaseUITest;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestMessages;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.Props;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestGroup;
import com.epam.kuzora.hometask.tests.common.pageobject.litres.blocks.ContentBlock;
import com.epam.kuzora.hometask.tests.common.pageobject.litres.blocks.HeaderMenuBlock;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestValues;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class WebDriverLitresTest extends BaseUITest {
    private HeaderMenuBlock headerMenuBlock;
    private ContentBlock bestContent, newContent;

    @Test(groups = {TestGroup.FULL, TestGroup.UI})
    public void checkMostExpensiveBooksFromTabsTest() {

        // open base url
        driver.get(TestValues.BASE_LITRES_URL);
        headerMenuBlock = page.getBlockInstance(HeaderMenuBlock.class);

        // click on best tab and open best content
        headerMenuBlock.clickOnBestContentTab();
        bestContent = page.getBlockInstance(ContentBlock.class);

        // check most exp book name from best tab with define book name1
        String actualMostExpPopBook = bestContent.nameOfBookByPrice(bestContent.findMaxBookPrice());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMostExpPopBook, TestValues.SPECIFIED_BOOK_NAME_UI_1, TestMessages.SPECIFIED_BOOK_WAS_NOT_FOUND);

        // click on new tab and open new content
        headerMenuBlock.clickOnNewContentTab();
        newContent = page.getBlockInstance(ContentBlock.class);

        // check most exp book name from new tab with define book name2
        String actualMostExpNovBook = newContent.nameOfBookByPrice(newContent.findMaxBookPrice());
        softAssert.assertEquals(actualMostExpNovBook, TestValues.SPECIFIED_BOOK_NAME_UI_2, TestMessages.SPECIFIED_BOOK_WAS_NOT_FOUND);
        softAssert.assertAll();
    }

    @Test(groups = {TestGroup.FULL, TestGroup.UI})
    public void checkAllBookFromGetBooksOnUITest() {
        APIServiceHelper apiServiceHelper = new APIServiceHelper(Props.BASE_FAKE_REST_API_URL);

        // open base url
        driver.get(TestValues.BASE_LITRES_URL);
        headerMenuBlock = page.getBlockInstance(HeaderMenuBlock.class);

        // click on best tab and open best content
        headerMenuBlock.clickOnBestContentTab();
        bestContent = page.getBlockInstance(ContentBlock.class);

        // get list of books using RetrofitAPIService
        List<Book> listsOfBooks = (List<Book>) apiServiceHelper.getResponseWithRetrofitCommand(new GetListsOfBooks())
                .body();
        List<String> titlesOnUI = bestContent.getListOfBooksFromContent();

        // check all books from api call are on UI
        for (Book book : listsOfBooks) {
            if (!titlesOnUI.contains(book.getTitle())) {
                Assert.fail(TestMessages.NOT_ALL_BOOK_FROM_API_ON_UI);
            }
        }
    }
}
