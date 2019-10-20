package com.sudeep.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class RestFormController {
		@GetMapping("/name")
		@ApiOperation("this to get name")
		public String getName() {
		  return "sudeep";	
		}
	}

