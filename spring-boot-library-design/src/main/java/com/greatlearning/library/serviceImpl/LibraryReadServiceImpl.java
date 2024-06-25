package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {
@Autowired
LibraryRepository readRepository;
@Override
public List<Library> getAllLibrary(){
	return readRepository.findAll();
}
@Override
public List<Library> getAllLibrariesWithNoBooks() {
	Library libraryWithNoBooks=new Library();
	libraryWithNoBooks.setCommaSeparatedBooknames("");
	//exampleMatcher will make sure that only CommaSeparatedBooknames is considered and id and name are ignored
	ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("commaSeparatedBooknames",
			ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
	System.out.println(libraryWithNoBooks);
	Example<Library> example=Example.of(libraryWithNoBooks,exampleMatcher);
	return readRepository.findAll(example);
}
@Override
public Page<Library> getLibrariesPaged(){
	Pageable first3records=PageRequest.of(0,3);
	//Pageable first3records=PageRequest.of(1,3);
	return readRepository.findAll(first3records);
}
@Override
public Page<Library> getLibrariesCustomPaged(int pageNumber,int numberOfRecordsOnAPage){
	Pageable first3records=PageRequest.of(pageNumber,numberOfRecordsOnAPage);
	return readRepository.findAll(first3records);
}
@Override
public List<Library> getLibrariesWithLatestAddedOrder(){
	return readRepository.findAll(Sort.by(Direction.DESC,"id"));
}
@Override
public List<Library> getLibrariesCustomSortedById(Direction direction){
	return readRepository.findAll(Sort.by(direction,"id"));
}
@Override
public List<Library> getLibrariesCustomSortedByName(Direction direction){
	return readRepository.findAll(Sort.by(direction,"name"));
}
@Override
public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBooknames) {
	Library libraryWithTheseBooks=new Library();
	libraryWithTheseBooks.setCommaSeparatedBooknames(commaSeparatedBooknames);
	ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("commaSeparatedBooknames",
			ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
	Example<Library> example=Example.of(libraryWithTheseBooks,exampleMatcher);
	Pageable first3records=PageRequest.of(0,2,Sort.by("name"));
	return readRepository.findAll(example,first3records);
}
}
