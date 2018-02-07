package com.epam.kuzora.hometask.core.runner.runner_core.browser;

import com.epam.kuzora.hometask.core.runner.runner_core.browser.exception.BrowserException;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import java.util.HashMap;
import java.util.Map;

public class BrowserProvider {
    private static final BrowserProvider instance = new BrowserProvider();
    private Map<BrowserName, BrowserVersion> browserList = new HashMap<>();

    private BrowserProvider() {
        browserList.put(BrowserName.FIREFOX_45, BrowserVersion.FIREFOX_45);
        browserList.put(BrowserName.FIREFOX_52, BrowserVersion.FIREFOX_52);
        browserList.put(BrowserName.EDGE, BrowserVersion.EDGE);
    }

    public static BrowserProvider getInstance() {
        return instance;
    }

    public BrowserVersion getBrowser(String stringBrowser) throws BrowserException {
        String browser = stringBrowser.replace("-", "_").toUpperCase();
        BrowserVersion browserVersion;
        BrowserName name;
        try {
            name = BrowserName.valueOf(browser);
            browserVersion = browserList.get(name);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new BrowserException(e.getMessage(), e);
        }
        if (browserVersion == null)
            browserVersion = browserList.get(BrowserVersion.FIREFOX_52);
        return browserVersion;
    }
}
