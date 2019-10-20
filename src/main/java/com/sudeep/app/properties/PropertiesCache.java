package com.sudeep.app.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "sri")
@Data
/**
 * 
 * @author SRI
 *Chache class for properties
 */
public class PropertiesCache {

	private Map<String, String> map=new HashMap();
}
