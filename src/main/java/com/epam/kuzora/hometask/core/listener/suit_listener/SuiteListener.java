package com.epam.kuzora.hometask.core.listener.suit_listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import static com.epam.kuzora.hometask.core.util.Logger.logInConsole;

public class SuiteListener implements ISuiteListener {
    private static final String SUITE_STATUS = "Status";
    private static final String SUITE_NAME = "Suite name";
    private static final String STATUS_START_SUITE = "SUITE START ";
    private static final String STATUS_FINISH_SUITE = "SUITE FINISH";

    @Override
    public void onStart(ISuite iSuite) {
        String logMessage = String.format("%s: %s; %s: %s\n\r", SUITE_NAME, iSuite.getName(), SUITE_STATUS,
            STATUS_START_SUITE);
        logInConsole(logMessage);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        String logMessage = String.format("%s: %s; %s: %s\n\r", SUITE_NAME, iSuite.getName(), SUITE_STATUS, STATUS_FINISH_SUITE);
        logInConsole(logMessage);
    }
}
