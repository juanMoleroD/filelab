package com.example.codeclan.filelab.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "folders")
@NoArgsConstructor
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @OneToMany(mappedBy = "folder") // mapped by folder?
    private List<File> files;
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Folder(String title, Person person) {
        this.title = title;
        this.person = person;
        this.files = new ArrayList<>();
    }

    public void addFile(File file) {
        this.files.add(file);
    }
}
