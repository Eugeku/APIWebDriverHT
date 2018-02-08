package com.epam.kuzora.hometask.tests.test;

import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import com.epam.kuzora.hometask.service.APIServiceHelper;
import com.epam.kuzora.hometask.service.api.RetrofitAPIService;
import com.epam.kuzora.hometask.service.api.command.fakerestapi.book.GetBook;
import com.epam.kuzora.hometask.service.api.command.fakerestapi.book.GetListsOfBooks;
import com.epam.kuzora.hometask.tests.BaseAPITest;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.Props;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.TestGroup;
import com.epam.kuzora.hometask.service.util.GsonParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIGetMethodBookTest extends BaseAPITest {

    @Test(groups = {TestGroup.FULL, TestGroup.API, TestGroup.SMOKE})
    public void apiGetAllMethodBookTest() {
        APIServiceHelper apiServiceHelper = new APIServiceHelper(Props.BASE_FAKE_REST_API_URL);
        GsonParser gsonParser = new GsonParser();

        String res = apiServiceHelper.getEntityAsString("api/Books");
        List<Book> list = gsonParser.parseGsonIntoList(res, Book.class);
        String exp = gsonParser.parseListIntoJson(list, Book.class);

        Assert.assertEquals(exp, res);

        System.out.println(list.size());

        RetrofitAPIService controllerAPIRetrofit = new RetrofitAPIService(Props.BASE_FAKE_REST_API_URL);

        try {
            System.out.println(controllerAPIRetrofit.getAllBooks().execute().body().get(1).getDescription());
            System.out.println(controllerAPIRetrofit.getBook(4).execute().body().getID());
            List<Book> lisct = (List<Book>) controllerAPIRetrofit.flexibleCommand(new GetListsOfBooks(), Props.BASE_FAKE_REST_API_URL).execute().body();
            System.out.println(lisct.get(1).getDescription());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
