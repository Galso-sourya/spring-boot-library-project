package com.greatlearning.library.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;

public interface LibraryReadService {

	List<Library> getAllLibrary();

	List<Library> getAllLibrariesWithNoBooks();

	Page<Library> getLibrariesPaged();

	Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage);

	List<Library> getLibrariesWithLatestAddedOrder();

	List<Library> getLibrariesCustomSortedById(Direction direction);

	List<Library> getLibrariesCustomSortedByName(Direction direction);

	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBooknames);

}