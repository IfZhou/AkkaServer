package com.ifzhou.akkaserver.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by zhouyifu on 2017/7/6.
 */
@Component
public class BeanFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private static BeanFactory factory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        factory = this;
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) applicationContext.getBean(clazz);
    }

    public Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static BeanFactory buildFactory(){
        return factory;
    }

}
