package com.jefr.RandomRiftRoulette.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class WebsiteUser {
    @Id
    private String userName;
    private String hashedPassword;
    @OneToMany(mappedBy = "websiteUser")
    private List<Game> games = new ArrayList<>();


}
