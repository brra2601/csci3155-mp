package com.miniproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiConfiguration {

    @Bean
    public Animal getAnimal() {
		try {
			Class<?> animal = Class.forName(getEnv("ANIMAL", "com.miniproject.Bird"));
			return (Animal)(animal.newInstance());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private static boolean hasEnv(String varname) {
    	return System.getenv(varname) != null && !System.getenv(varname).trim().isEmpty();
    }

	private static String getEnv(String varname, String defaultValue) {
        if (hasEnv(varname)) {
            return System.getenv(varname);
        }
    	return defaultValue;
    }
}