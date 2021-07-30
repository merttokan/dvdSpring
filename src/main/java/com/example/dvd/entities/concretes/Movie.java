package com.example.dvd.entities.concretes;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "movies")
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "media")
    private String media;

    @Column(name = "languages")
    private String languages;

    public Movie(String title, String releaseDate, String genre, String description, String media, String languages) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.description = description;
        this.media = media;
        this.languages = languages;
    }
}
