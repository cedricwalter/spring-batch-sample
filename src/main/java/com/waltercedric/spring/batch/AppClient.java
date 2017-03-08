package com.waltercedric.spring.batch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//simply loads the application context and does nothing more.
public class AppClient {

    public static void main(String[] args) {
        String[] str = {"classpath:/META-INF/spring/jobs/helloWorldJob.xml", "classpath:/META-INF/spring/batch/override/data-source-context.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(str);
    }

}
