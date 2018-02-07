package com.epam.kuzora.hometask.tests.test;

import com.epam.kuzora.hometask.core.util.Logger;
import com.epam.kuzora.hometask.model.bean.Book;
import com.epam.kuzora.hometask.tests.BaseAPITest;
import com.epam.kuzora.hometask.tests.common.util.api.GsonParser;
import com.epam.kuzora.hometask.service.APIService;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIGetMethodBookTest extends BaseAPITest {
    @Test(groups = "Debug")
    public void apiGetAllMethodBookTest() {
        String jsonMimeType = "application/json";
        APIService apiService = new APIService("http://fakerestapi.azurewebsites.net/api/");
        GsonParser<Book> gsonParser = new GsonParser<Book>();
        String res = "";
        HttpEntity entity = null;
        try {
            entity = apiService.getResponse(apiService.setRequest("Books")).getEntity();
            res = EntityUtils.toString(entity);
            System.out.println(res);
        } catch (Exception e) {
            Logger.logInConsole(e.getMessage());
        }
        List<Book> list = gsonParser.parseGsonIntoList(res, Book.class);
        String mimeType = ContentType.getOrDefault(entity).getMimeType();
        System.out.println(jsonMimeType + " " + mimeType);
        Assert.assertEquals(jsonMimeType, mimeType);
    }
}
