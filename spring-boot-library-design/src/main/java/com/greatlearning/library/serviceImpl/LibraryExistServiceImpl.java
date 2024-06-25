package com.greatlearning.library.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryExistService;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {
@Autowired
LibraryRepository libraryRepository;
@Override
public boolean ckeckLibraryExistsById(Long id) {
	return libraryRepository.existsById(id);
}
@Override
public boolean ckeckLibraryExistsByExample(String commaSeparatedBooknames) {
	Library library=new Library();
	library.setCommaSeparatedBooknames(commaSeparatedBooknames);
	ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("commaSeparatedBooknames",
			ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
	Example<Library> example=Example.of(library,exampleMatcher);
	return libraryRepository.exists(example);
}
}
