package com.example.dvd.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private int artId;

    @NotNull
    @Column(name = "art_full_name")
    private String artFullName;

    @Column(name = "role")
    private String role;

    @ManyToMany
    @JoinTable(
            name = "casting",
            joinColumns = @JoinColumn(name = "art_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    Set<Movie> playedMovies;

    public String getArtFullName() {
        return artFullName;
    }

    public void setArtFullName(String artFullName) {
        this.artFullName = artFullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
