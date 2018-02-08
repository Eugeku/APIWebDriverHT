package com.epam.kuzora.hometask.tests.common.constant;

import com.epam.kuzora.hometask.core.util.GetPropertyValues;

public class TestConstant {
    private static final GetPropertyValues getPropertyValues = new GetPropertyValues();

    public interface TestGroup {
        String DEBUG = "Debug";
        String API = "Api";
        String FULL = "Full";
        String SMOKE = "Smoke";
        String UI = "UI";
    }

    public interface Props {
        String BASE_FAKE_REST_API_URL = getPropertyValues.getPropValues("baseFakeRestApiUrl", "config.properties");
    }
}
