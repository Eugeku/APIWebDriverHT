package com.epam.kuzora.hometask.tests.common.constant;

import com.epam.kuzora.hometask.core.util.GetPropertyValues;

public class TestConstant {
    private static final GetPropertyValues getPropertyValues = new GetPropertyValues();
    private static final String CONFIG_PROPERTIES = "config.properties";
    private static final String TEST_PARAMETERS_PROPERTIES = "testparameters.properties";

    public interface TestGroup {
        String DEBUG = "Debug";
        String API = "Api";
        String FULL = "Full";
        String SMOKE = "Smoke";
        String UI = "UI";
        String BROKEN = "Broken";
    }

    public interface Props {
        String BASE_FAKE_REST_API_URL = getPropertyValues.getPropValues("baseFakeRestApiUrl", CONFIG_PROPERTIES);
        String PATH_TO_JSON_SCHEMA = getPropertyValues.getPropValues("pathToJsonSchema", CONFIG_PROPERTIES);
    }

    public interface TestValues {
        String SPECIFIED_BOOK_NAME_API = getPropertyValues.getPropValues("specifiedBookName",
            TEST_PARAMETERS_PROPERTIES);
        String SPECIFIED_BOOK_NAME_UI_1 = getPropertyValues.getPropValues("specifiedBookNameUI1",
            TEST_PARAMETERS_PROPERTIES);
        String SPECIFIED_BOOK_NAME_UI_2 = getPropertyValues.getPropValues("specifiedBookNameUI2",
            TEST_PARAMETERS_PROPERTIES);
        String BASE_LITRES_URL = "https://www.litres.ru/";
        String BASE_GOOGLE_URL = "https://www.google.by";
        String GET_BOOKS = "api/Books/";
    }

    public interface TestMessages {
        String SPECIFIED_BOOK_WAS_NOT_FOUND = "Specified book was not found";
        String NOT_ALL_BOOK_FROM_API_ON_UI = "Not all of books from api call on UI";
        String SCHEMA_NOT_VALID_MES = "Schema is not valid.";
    }

    public interface DriverProps {
        int MAX_LATENCY = 30;
    }
}
