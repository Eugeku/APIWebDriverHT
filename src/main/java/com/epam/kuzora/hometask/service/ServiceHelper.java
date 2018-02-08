package com.epam.kuzora.hometask.service;

import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import com.epam.kuzora.hometask.service.util.TimeUtil;
import com.epam.kuzora.hometask.service.util.ValidationUtil;

import java.io.File;
import java.util.List;

public class ServiceHelper {
    public boolean findBookInListByName(List<Book> list, String bookName) {
        for (Book book : list) {
            if (book.getTitle().contains(bookName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPublishedTimeOfAllBooksInPastTime(List<Book> list) {
        for (Book book : list) {
            if (TimeUtil.parseOffsetTimeFromString(book.getPublishDate()).isAfter(TimeUtil.getCurrentTime())) {
                return false;
            }
        }
        return true;
    }

    public boolean isGsonValidWithSchemaFromFile(String pathToJson, String actualJson) {
        try {
            ValidationUtil.validateJson(new File(pathToJson), actualJson);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
