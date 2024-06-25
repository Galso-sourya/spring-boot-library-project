package com.greatlearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService1;

//@Controller
@RestController
public class ExampleController {
	@Autowired
ExampleService1 exampleService;	
@GetMapping("/info")
//@ResponseBody
public GreatLearning get() {
	//GreatLearning greatLearning=new GreatLearning();
	//greatLearning.setCourseName("learn controllers in spring boot");
	//return greatLearning;
	return exampleService.get();
}
@PostMapping("/customInfo")
public GreatLearning customInfo(String courseName,String firstName,String lastName) {
	//GreatLearning greatLearning=new GreatLearning();
	//greatLearning.setCourseName(courseName);
	//return greatLearning;
	return exampleService.customInfo(courseName,firstName,lastName);
}
}
