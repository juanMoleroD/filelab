package com.example.codeclan.filelab.controllers;

import com.example.codeclan.filelab.models.Person;
import com.example.codeclan.filelab.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonControlller {

    @Autowired
    PersonRepository repo;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPeople(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }
}
