package com.jefr.RandomRiftRoulette.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class WebsiteUser {
    @Id
    @GeneratedValue
    @Size(min = 4,  max = 15, message = "Username must be between 4 and 15 characters long")
    private String userName;
    @Email
    private String email;
    private String hashedPassword;
    @OneToMany(mappedBy = "websiteUser")
    private List<Game> games = new ArrayList<>();

    public WebsiteUser(String username, String email, String unhashedPassword) {

        this.userName = username;
        this.email = email;
        this.hashedPassword = unhashedPassword;
    }



}
