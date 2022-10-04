package com.example.codeclan.filelab;

import com.example.codeclan.filelab.models.File;
import com.example.codeclan.filelab.models.Folder;
import com.example.codeclan.filelab.models.Person;
import com.example.codeclan.filelab.repositories.FileRepository;
import com.example.codeclan.filelab.repositories.FolderRepository;
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

	@Autowired
	FolderRepository folderRepo;

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
		person = new Person("Juan");
		personRepo.save(person);
		assertTrue(personRepo.findAll().size() > 0);

		folder = new Folder("myFolder", person);
		folderRepo.save(folder);
		assertTrue(folderRepo.findAll().size() > 0);

		file = new File("myFile", ".txt", 10 , folder);
		fileRepo.save(file);
		assertTrue(fileRepo.findAll().size() > 0);

	}
}
