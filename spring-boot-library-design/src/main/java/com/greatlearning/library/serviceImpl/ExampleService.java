package com.greatlearning.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService1;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleService implements ExampleService1 {
	@Override
	public GreatLearning get() {
		log.info("Inside get() method");
		GreatLearning greatLearning=new GreatLearning();
		greatLearning.setCourseName("learn controllers in spring boot");
		return greatLearning;
	}
	@Override
	public GreatLearning customInfo(String courseName,String firstName,String lastName) {
		log.info("Inside customInfo() method");
		GreatLearning greatLearning=new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setInstructorName(FullName.builder().firstName("samarth").lastName("narula").build());
		return greatLearning;
	}
}
