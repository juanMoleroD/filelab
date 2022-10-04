package com.example.codeclan.filelab.controllers;

import com.example.codeclan.filelab.models.Folder;
import com.example.codeclan.filelab.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    FolderRepository repo;

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolderById(@PathVariable Long id) {
        return new ResponseEntity<>(repo.findById(id), HttpStatus.OK);
    }

    @PostMapping("/folders")
    public ResponseEntity<Folder> saveFolder(@RequestBody Folder folder) {
        return new ResponseEntity<>(repo.save(folder), HttpStatus.CREATED);
    }

}
