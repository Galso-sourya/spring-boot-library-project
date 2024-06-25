package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryCreateService;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {
@Autowired
LibraryRepository libraryRepository;
@Override
public String addSingleLibrary(Library library) {
	libraryRepository.save(library);
	libraryRepository.flush();
	return "library saved";
} 
@Override
public String addAllLibraries(List<Library> libraries) {
	libraryRepository.saveAll(libraries);
	libraryRepository.flush();
	return "all libraries saved";
}
@Override
public Library addLibrarywithSaveAndFlush(Library library) {
return libraryRepository.saveAndFlush(library);	
}
}
