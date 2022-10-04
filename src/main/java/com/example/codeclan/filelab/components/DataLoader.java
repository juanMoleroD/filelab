package com.example.codeclan.filelab.components;

import com.example.codeclan.filelab.models.File;
import com.example.codeclan.filelab.models.Folder;
import com.example.codeclan.filelab.models.Person;
import com.example.codeclan.filelab.repositories.FileRepository;
import com.example.codeclan.filelab.repositories.FolderRepository;
import com.example.codeclan.filelab.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepo;

    @Autowired
    PersonRepository personRepo;

    @Autowired
    FolderRepository folderRepo;

    public DataLoader(){}

    public void run(ApplicationArguments args) {
        fileRepo.deleteAll();
        folderRepo.deleteAll();
        personRepo.deleteAll();

        Person person1 = new Person("Juan");
        personRepo.save(person1);

        Person person2 = new Person("Delia");
        personRepo.save(person2);

        Folder folder1 = new Folder("juan folder", person1);
        folderRepo.save(folder1);

        Folder folder2 = new Folder("delia folder", person2);
        folderRepo.save(folder2);

        File file1 = new File("file1", ".txt", 20, folder1);
        File file2 = new File("file2", ".txt", 10, folder1);
        File file3 = new File("file3", ".txt", 15, folder1);

        File file4 = new File("file4", ".txt", 25, folder2);
        File file5 = new File("file5", ".txt", 5, folder2);
        File file6 = new File("file6", ".txt", 10, folder2);

        fileRepo.saveAll(Arrays.asList(file1,file2,file3,file4, file5, file6));

    }
}
