package com.example.codeclan.filelab;

import com.example.codeclan.filelab.models.File;
import com.example.codeclan.filelab.models.Folder;
import com.example.codeclan.filelab.models.Person;
import com.example.codeclan.filelab.repositories.FileRepository;
import com.example.codeclan.filelab.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FilelabApplicationTests {

	@Autowired
	FileRepository fileRepo;

	@Autowired
	PersonRepository personRepo;

	File file;
	Person person;
	Folder folder;

	@BeforeEach
	void setUp() {
	}

	@Test
	void contextLoads() {
	}

	@Test
	void loadingData() {
		folder = new Folder();
		person = new Person("Juan");
		file = new File("myFile", ".txt", 10 );

		personRepo.save(person);
		assertTrue(personRepo.findAll().size() > 0);

		fileRepo.save(file);
		assertTrue(fileRepo.findAll().size() > 0);

	}
}
