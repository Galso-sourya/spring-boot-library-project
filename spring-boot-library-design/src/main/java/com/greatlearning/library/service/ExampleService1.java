package com.greatlearning.library.service;

import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.serviceImpl.ExampleService;
public interface ExampleService1 {

	GreatLearning get();

	GreatLearning customInfo(String courseName,String firstName,String lastName);

}