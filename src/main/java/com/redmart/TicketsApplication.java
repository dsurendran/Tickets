package com.redmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@ComponentScan
@SpringBootApplication
public class TicketsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TicketsApplication.class, args);

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
//        for(String bean : beanNames){
//            System.out.println(bean);
//        }
    }
}
