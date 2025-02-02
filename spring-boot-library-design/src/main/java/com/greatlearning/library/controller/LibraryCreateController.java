package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryCreateService;

@RestController
public class LibraryCreateController {
@Autowired
LibraryCreateService createService;
@PostMapping("/addSingleLibrary")
public String addSingleLibrary(Library library) {
	return createService.addSingleLibrary(library);
}
@PostMapping("/insertAllLibraries")
public String insertAllLibraries(@RequestBody List<Library> libraries) {
	return createService.addAllLibraries(libraries);
}

}
