package com.epam.kuzora.hometask.tests.test;

import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import com.epam.kuzora.hometask.service.APIServiceHelper;
import com.epam.kuzora.hometask.service.ServiceHelper;
import com.epam.kuzora.hometask.service.api.command.fakerestapi.book.GetListsOfBooks;
import com.epam.kuzora.hometask.service.util.JsonParser;
import com.epam.kuzora.hometask.tests.BaseAPITest;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.Props;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestGroup;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestMessages;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIGetBookMethodTest extends BaseAPITest {
    private APIServiceHelper apiServiceHelper = new APIServiceHelper(Props.BASE_FAKE_REST_API_URL);
    private ServiceHelper serviceHelper = new ServiceHelper();

    @Test(groups = {TestGroup.FULL, TestGroup.API, TestGroup.SMOKE})
    public void checkGetBookSchemaTest() {
        final int bookId = 4;

        JsonParser gsonParser = new JsonParser();

        // get body using simple SimpleAPIService
        String actual = apiServiceHelper.getEntityAsString(TestValues.GET_BOOKS);

        // parse String Json into object and then object into json using schema from bean class
        List<Book> list = gsonParser.parseJsonIntoList(actual, Book.class);
        String expected = gsonParser.parseListIntoJson(list, Book.class);

        // check without schema
        Assert.assertEquals(actual, expected, TestMessages.SCHEMA_NOT_VALID_MES);

        String actuaLBook = apiServiceHelper.getEntityAsString(TestValues.GET_BOOKS + bookId);
        Book book = gsonParser.parseJsonIntoObject(actuaLBook, Book.class);
        String expected2 = gsonParser.parseObjectIntoJson(book, Book.class);

        // check without schema
        Assert.assertEquals(actuaLBook, expected2, TestMessages.SCHEMA_NOT_VALID_MES);

        // validate book json with schema from file
        Assert.assertTrue(serviceHelper.isGsonValidWithSchemaFromFile(Props.PATH_TO_JSON_SCHEMA, actuaLBook));
    }

    @Test(groups = {TestGroup.FULL, TestGroup.API, TestGroup.SMOKE})
    public void checkSpecifiedBookNameTest() {

        // get list of books using RetrofitAPIService
        List<Book> listsOfBooks = (List<Book>) apiServiceHelper.getResponseWithRetrofitCommand(new GetListsOfBooks())
            .body();

        // check specified book name in list
        Assert.assertTrue(serviceHelper.findBookInListByName(listsOfBooks, TestValues.SPECIFIED_BOOK_NAME_API),
            TestMessages.SPECIFIED_BOOK_WAS_NOT_FOUND);
    }

    @Test(groups = {TestGroup.FULL, TestGroup.API, TestGroup.SMOKE})
    public void checkPublishedDateInPastTest() {

        // get list of books using RetrofitAPIService
        List<Book> listsOfBooks = (List<Book>) apiServiceHelper.getResponseWithRetrofitCommand(new GetListsOfBooks())
            .body();

        // check specified book name in list
        Assert.assertTrue(serviceHelper.isPublishedTimeOfAllBooksInPastTime(listsOfBooks));
    }
}
