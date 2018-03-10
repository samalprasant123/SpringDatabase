package com.prasant.spring.app.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config/jdbc.properties")
public class Test {
	
	@Value("${name}")
	private String name;

	public String getName() {
		return name;
	}

}
