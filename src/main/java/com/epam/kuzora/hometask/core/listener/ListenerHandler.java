package com.epam.kuzora.hometask.core.listener;

import com.epam.kuzora.hometask.core.listener.annotation_transformer.AnnotationTransformer;
import com.epam.kuzora.hometask.core.listener.suit_listener.SuiteListener;
import com.epam.kuzora.hometask.core.listener.test_listener.TestListener;
import org.testng.ITestNGListener;

import java.util.ArrayList;

public class ListenerHandler {
    private static final ListenerHandler instance = new ListenerHandler();
    private ArrayList<Class<? extends ITestNGListener>> listOfListeners = new ArrayList<>();

    private ListenerHandler() {
        listOfListeners.add(AnnotationTransformer.class);
        listOfListeners.add(SuiteListener.class);
        listOfListeners.add(TestListener.class);
    }

    public static ListenerHandler getInstance() {
        return instance;
    }

    public ArrayList<Class<? extends ITestNGListener>> getListOfListeners() {
        return listOfListeners;
    }
}
