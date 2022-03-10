package com.spring.annotations.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Service
@Component("SampleBean")
public class SampleBean {

	@Value("#{new String[]{\"item1\", \"item2\"}}")
	private List<String> aList;

	public List<String> getList() {

		return this.aList;

	}

	public String hello(String msg) {

		return "Hello " + msg;

	}

}
