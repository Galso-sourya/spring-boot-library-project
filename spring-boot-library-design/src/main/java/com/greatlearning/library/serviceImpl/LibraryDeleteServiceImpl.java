package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;
import com.greatlearning.library.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {
@Autowired
LibraryRepository libraryRepository;
@Override
public String deleteOneLibrary(Library library) {
	libraryRepository.delete(library);
	return "successfully deleted-"+library;
}
@Override
public String pruneTable() {
	libraryRepository.deleteAll();
	return "successfully deleted the wholetable(pruned)";
}
@Override
public String deleteAllThese(List<Library> libraries) {
	libraryRepository.deleteAll(libraries);
	return "successfully deleted only mentioned libraries";
}
@Override
public String deleteLibraryById(Long id) {
	libraryRepository.deleteById(id);
	return "library with id" +id+"is deleted";
}
}
