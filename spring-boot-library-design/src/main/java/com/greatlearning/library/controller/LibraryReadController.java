package com.greatlearning.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryReadService;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {
@Autowired
LibraryReadService readService;
@GetMapping("/getAllLibrary")
public List<Library> getAllLibrary(){
	return readService.getAllLibrary();
}
@GetMapping("/getAllLibrariesWithNoBooks")
public List<Library> getAllLibrariesWithNoBooks(){
	return readService.getAllLibrariesWithNoBooks();
}
@GetMapping("/getLibrariesPaged")
public Page<Library> getLibrariesPaged(){
	return readService.getLibrariesPaged();
}
@GetMapping("/getLibrariesCustomPaged")
public Page<Library> getLibrariesCustomPaged(int pageNumber,int numberOfRecordsOnAPage){
	return readService.getLibrariesCustomPaged(pageNumber,numberOfRecordsOnAPage);
}
@GetMapping("/getLibrariesCustomSortedById")
public List<Library> getLibrariesCustomSortedById(Direction direction){
	return readService.getLibrariesCustomSortedById(direction);
}
@GetMapping("/getLibrariesCustomSortedByName")
public List<Library> getLibrariesCustomSortedByName(Direction direction){
	return readService.getLibrariesCustomSortedByName(direction);
}
@GetMapping("/getLibrariesCustomSortedByNameAndWithTheseBooks")
public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames){
	return readService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeparatedBookNames);
}
/*@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSeparatedBookNames,
		int pageNumber,int numberOfRecordsOnAPage){
	return readService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(commaSeparatedBookNames
			,pageNumber,numberOfRecordsOnAPage);
}
@PostMapping("/getLibrariesByIds")
public List<Library> getLibrariesByIds(@RequestBody List<Long> ids){
	return readService.getLibrariesByIds(ids);
}*/

}
