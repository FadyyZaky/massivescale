package com.github.fadyyzaky.massivescale.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fadyyzaky.massivescale.models.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private static final String FILE_PATH = "users.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<User> findAll() {
        try {
            File file = new ClassPathResource(FILE_PATH).getFile();
            return objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to read users.json");
        }
    }

    public Optional<User> findById(String id) {
        return findAll().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public User save(User user) {
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
