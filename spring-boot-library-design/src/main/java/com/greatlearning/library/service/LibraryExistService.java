package com.greatlearning.library.service;

public interface LibraryExistService {

	boolean ckeckLibraryExistsById(Long id);

	boolean ckeckLibraryExistsByExample(String commaSeparatedBooknames);

}