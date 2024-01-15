package ru.teamscore.java23.json;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({"id", "userName", "fullName"})
public class User {
    private String userName;
    private UUID id;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;
    private boolean banned;
    @JsonIgnore
    public String token;
    private List<Post> posts = new ArrayList<>();

    @JsonGetter("fullName")
    public String getName() {
        return firstName + " " + lastName;
    }

    @JsonSetter("fullName")
    private void setName(String name) {
        String[] parts = name.split(" ");
        if (parts.length > 0) {
            setFirstName(parts[0]);
        }
        if (parts.length > 1) {
            setLastName(parts[1]);
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonIgnore
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonIgnore
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Post> getPosts() {
        return posts.stream().toList();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void addPosts(List<Post> posts) {
        this.posts.addAll(posts);
    }

    @Override
    public String toString() {
        return "User{" +
                "\n  userName='" + userName + '\'' +
                "\n  id=" + id +
                "\n  firstName='" + firstName + '\'' +
                "\n  lastName='" + lastName + '\'' +
                "\n  birthDate=" + birthDate +
                "\n  banned=" + banned +
                "\n  token='" + token + '\'' +
                "\n  posts=" + posts +
                '}';
    }
}
