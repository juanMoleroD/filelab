package com.example.codeclan.filelab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "persons")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnoreProperties("folders")
    @OneToMany(mappedBy = "person")
    private List<Folder> folders;


    public Person(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }
}
