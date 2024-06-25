package com.greatlearning.library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryCountService;
import com.greatlearning.library.service.LibraryCreateService;
import com.greatlearning.library.service.LibraryDeleteService;
import com.greatlearning.library.service.LibraryExistService;
import com.greatlearning.library.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner{
@Autowired
LibraryReadService libraryReadServiceImpl;
@Autowired
LibraryCreateService createServiceImpl;
@Autowired
LibraryCountService countServiceImpl;
@Autowired
LibraryExistService existServiceImpl;
@Autowired
LibraryDeleteService deleteServiceImpl;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("hi");
	}

	@Override
	public void run(String... args) throws Exception {
		//GreatLearning greatLearning=new GreatLearning();	
		//greatLearning.setCourseName("designing micro services with spring boot");
		//greatLearning.setCourseType("it");
		//System.out.println("great learning object"+greatLearning);
		//System.out.println("get method for course name------"+greatLearning.getCourseName());
		//GreatLearning greatLearningUsingAllArgsConst=new GreatLearning("designing micro services with spring boot","it");	
		//System.out.println("great learning object with all arguments constructor---------"+greatLearningUsingAllArgsConst);
		//tele design pattern
		//GreatLearning greatLearningTeleDesignPattern=new GreatLearning("designing tele design","iT");	
		//System.out.println("telescopic design pattern"+greatLearningTeleDesignPattern);
		//GreatLearning greatLearningWithBuilderPattern=GreatLearning.builder().courseName("learn builder pattern")
				//.courseType("information technology").build();
		/*GreatLearning greatLearningComplexObject=GreatLearning.builder().courseName("complex object creation with builder pattern")
				.courseType("information technology")
				.instructorName(FullName.builder().firstName("samarth").lastName("narula").build())
				.build();
		log.info("Great Learning Complex Object Creation->{}", greatLearningComplexObject);*/
		//readServiceImplMethodsExecution();
		//createServiceImplMethodsExecution();
		//countServiceImplMethodsExecution();
		//existServiceImplMethodsExecution();
		//log.info("deleted one library->{}", deleteServiceImpl.deleteOneLibrary(Library.builder().id(6l)
				//.commaSeparatedBooknames("d").name("z").build()));
		//log.info("deleted one library->{}", deleteServiceImpl.pruneTable());
		//List<Library> libraries=new ArrayList<Library>();
		//libraries.add(Library.builder().id(6l)
				//.commaSeparatedBooknames("d").name("z").build());
		//log.info("deleted these libraries->{}", deleteServiceImpl.deleteAllThese(libraries));
		log.info("deleted the library by id->{}", deleteServiceImpl.deleteLibraryById(2l));
	}

	private void existServiceImplMethodsExecution() {
		log.info("check  library if exist by id->{}", existServiceImpl.ckeckLibraryExistsById(10l));
		log.info("check  library if exist by example or name->{}", existServiceImpl.ckeckLibraryExistsByExample("zz"));
	}

	private void countServiceImplMethodsExecution() {
		log.info("count the number of libraries->{}", countServiceImpl.countLibraries());
		log.info("count libraries with no books->{}", countServiceImpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		log.info("persist a single library->{}",createServiceImpl
				.addSingleLibrary(Library.builder().id(7l).name("h").commaSeparatedBooknames("i,j,k").build()));
		List<Library> libraries=new ArrayList<Library>();
		libraries.add(Library.builder().id(8l).name("l").commaSeparatedBooknames("m").build());
		libraries.add(Library.builder().id(9l).name("n").commaSeparatedBooknames("m").build());
		log.info("persist all libraries->{}",createServiceImpl
				.addAllLibraries(libraries));
		log.info("persist a library with save and flush combined->{}",createServiceImpl
				.addLibrarywithSaveAndFlush(Library.builder().id(10l).name("o").commaSeparatedBooknames("p,q").build()));
	}

	private void readServiceImplMethodsExecution() {
		log.info("fetch all libraries->{}", libraryReadServiceImpl.getAllLibrary());
		log.info("fetch all libraries with no books->{}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
		Page<Library> page= libraryReadServiceImpl.getLibrariesPaged();
		List<Library> libraries=page.get().collect(Collectors.toList());
		log.info("fetch libraries in paged format->{}", libraries);//page number starts with 0 as indexing
		log.info("fetch libraries in custom paged format->{}", libraryReadServiceImpl.getLibrariesCustomPaged(1,2)
				.get().collect(Collectors.toList()));
		//log.info("fetch libraries with latest added order->{}", libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("fetch libraries custom sorted by id->{}", libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.ASC));
		log.info("fetch libraries sorted and with these books->{}", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("d").get().collect(Collectors.toList()));
	}

	
}
