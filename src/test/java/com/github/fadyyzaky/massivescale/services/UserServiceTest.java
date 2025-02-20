package com.github.fadyyzaky.massivescale.services;

import com.github.fadyyzaky.massivescale.models.User;
import com.github.fadyyzaky.massivescale.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void createUser_withValidInput_shouldReturnSameNameAndEmail() {
        User inputUser = new User("Alice Smith", 28, "alice@example.com");
        User expectedUser = new User("123e4567-e89b-12d3-a456-426614174000", "Alice Smith", 28, "alice@example.com");

        when(userRepository.save(inputUser)).thenReturn(expectedUser);

        User actualUser = userService.createUser(inputUser);

        assertEquals("Alice Smith", actualUser.getName(), "User name should match the input");
        assertEquals("alice@example.com", actualUser.getEmail(), "User email should match the input");
    }
}
