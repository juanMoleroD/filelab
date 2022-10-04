package com.example.codeclan.filelab.controllers;

import com.example.codeclan.filelab.models.File;
import com.example.codeclan.filelab.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository repo;

    @GetMapping("/files")
    public ResponseEntity<List<File>> getALlFiles(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Optional<File>> getFileById(@PathVariable Long id) {
        return new ResponseEntity<>(repo.findById(id), HttpStatus.OK);
    }

    @PostMapping("/files")
    public ResponseEntity<File> saveFile(@RequestBody File file) {
        return new ResponseEntity<>(repo.save(file), HttpStatus.CREATED);
    }
}
