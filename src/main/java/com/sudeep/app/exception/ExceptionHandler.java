package com.sudeep.app.exception;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.sudeep.app.constant.AppConstant;
import com.sudeep.app.properties.PropertiesCache;
	
@Controller
@ControllerAdvice
public class ExceptionHandler {

	@Autowired
	private PropertiesCache cache;
	
	public String handleNullPointer(Map<String, String> map) {
		map.put(AppConstant.FORM_MSG,"Something went Wrong please try agian!!............ ");
		return cache.getMap().get("err"); 
		
	}
	
}
