package com.epam.kuzora.hometask.tests.common.constant;

import com.epam.kuzora.hometask.core.util.GetPropertyValues;

public class TestConstant {
    private static final GetPropertyValues getPropertyValues = new GetPropertyValues();
    private static final String CONFIG_FILE_NAME_1 = "config.properties";
    private static final String CONFIG_FILE_NAME_2 = "testparameters.properties";

    public interface TestGroup {
        String DEBUG = "Debug";
        String API = "Api";
        String FULL = "Full";
        String SMOKE = "Smoke";
        String UI = "UI";
    }

    public interface Props {
        String BASE_FAKE_REST_API_URL = getPropertyValues.getPropValues("baseFakeRestApiUrl", CONFIG_FILE_NAME_1);
        String PATH_TO_JSON_SCHEMA = getPropertyValues.getPropValues("pathToJsonSchema", CONFIG_FILE_NAME_1);
    }

    public interface TestValues {
        String SPECIFIED_BOOK_NAME = getPropertyValues.getPropValues("specifiedBookName", CONFIG_FILE_NAME_2);
        String SCHEMA_NOT_VALID_MES = "Schema is not valid.";
        String GET_BOOKS = "api/Books/";
        String SPECIFIED_BOOK_WAS_NOT_FOUND = "Specified book was not found";
    }
}
