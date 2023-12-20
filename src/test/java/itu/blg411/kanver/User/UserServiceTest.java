package itu.blg411.kanver.User;

import itu.blg411.kanver.user.UserService;
import itu.blg411.kanver.user.model.User;
import itu.blg411.kanver.user.model.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Transactional
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User newUser = new User();
        newUser.setEmail("john.doe@example.com");
        newUser.setTcNo("12345678901");

        when(userRepository.existsByEmail(newUser.getEmail())).thenReturn(false);
        when(userRepository.existsByTcNo(newUser.getTcNo())).thenReturn(false);
        when(userRepository.save(newUser)).thenReturn(newUser);

        User createdUser = userService.createUser(newUser);

        assertNotNull(createdUser);
        assertEquals(0, createdUser.getDonationCount());

        verify(userRepository, times(1)).existsByEmail(newUser.getEmail());
        verify(userRepository, times(1)).existsByTcNo(newUser.getTcNo());
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    void testCreateUserWithExistingEmail() {
        User newUser = new User();
        newUser.setEmail("john.doe@example.com");

        when(userRepository.existsByEmail(newUser.getEmail())).thenReturn(true);

        assertThrows(ResponseStatusException.class, () -> userService.createUser(newUser));

        verify(userRepository, times(1)).existsByEmail(newUser.getEmail());
        verify(userRepository, never()).existsByTcNo(anyString());
        verify(userRepository, never()).save(any());
    }
}
