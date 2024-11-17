package m.sierra.utilities.annotationTransformer;

import m.sierra.utilities.retryAnalyzer.RetryAnalyzer;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    private final boolean isEnabled = Boolean.parseBoolean(System.getProperty("retryFailedTestCases"));

    @Override
    public void transform(ITestAnnotation annotation, Class clazz, Constructor constructor, Method method) {
        if (isEnabled) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }

}
