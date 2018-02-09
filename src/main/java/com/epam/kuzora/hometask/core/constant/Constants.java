package com.epam.kuzora.hometask.core.constant;

public class Constants {
    public interface Runner {
        int MINIMAL_COUNT_OF_PARAM_IN_REQUEST = 2;
        String COMMAND_PARSER_REG_EXP = "[0-9A-Za-z_.,/]+";
    }

    public interface Driver {
        String OS_TYPE = "mac";
        String USER_DIR = "user.dir";
        String OS_NAME = "os.name";
        String WEBDR_CHROME_DRIVER = "webdriver.chrome.driver";
        String CHROME_DRIVER_NAME_MAC = "/chromedriver";
        String CHROME_DRIVER_NAME_WIN = "\\chromedriver.exe";

        interface ChromeOption {
            String TEST_TYPE = "test-type";
            String DISABLE_POPUP_BLOCKING ="disable-popup-blocking";
        }
    }



}
