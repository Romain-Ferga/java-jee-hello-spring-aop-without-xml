package com.spring.annotations.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.spring.annotations.beans", "com.spring.annotations.aop" })
public class ConfigBean {

	public static void main(String args[]) {

		try {

			AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(ConfigBean.class);

			SampleBean sampleBean = ctxt.getBean("SampleBean", SampleBean.class);

			System.out.println(sampleBean.getList());

			System.out.println(sampleBean.hello("I'm MAD"));

			ctxt.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
