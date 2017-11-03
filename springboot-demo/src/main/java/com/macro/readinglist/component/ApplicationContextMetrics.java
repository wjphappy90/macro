package com.macro.readinglist.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zhenghong on 2017/11/3.
 */
@Component
public class ApplicationContextMetrics implements PublicMetrics {
    @Autowired
    private ApplicationContext context;
    @Override
    public Collection<Metric<?>> metrics() {
        List<Metric<?>> metrics = new ArrayList<>();
        metrics.add(new Metric<>("spring.context.startup-date",context.getStartupDate()));
        metrics.add(new Metric<>("spring.beans.definitions",context.getBeanDefinitionCount()));
        metrics.add(new Metric<>("spring.beans",context.getBeanNamesForType(Object.class).length));
        metrics.add(new Metric<>("spring.beans",context.getBeanNamesForAnnotation(Controller.class).length));
        return metrics;
    }
}
