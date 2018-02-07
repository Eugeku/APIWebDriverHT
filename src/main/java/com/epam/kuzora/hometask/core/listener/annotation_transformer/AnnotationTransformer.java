package com.epam.kuzora.hometask.core.listener.annotation_transformer;

import com.epam.kuzora.hometask.core.listener.retry_analyzer.RetryAnalyzer;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        Class reflectAnalyzerObj = RetryAnalyzer.class;
        iTestAnnotation.setRetryAnalyzer(reflectAnalyzerObj);
    }
}
