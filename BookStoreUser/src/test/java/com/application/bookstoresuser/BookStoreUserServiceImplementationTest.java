package com.application.bookstoresuser;

import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.repository.BookStoreUserRepository;
import com.application.bookstoresuser.serviceimplementation.BookStoreUserServiceImplementation;
import com.application.bookstoresuser.utility.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookStoreUserServiceImplementationTest {
    @InjectMocks
    BookStoreUserServiceImplementation bookStoreUserServiceImplementation;

    @Mock
    BookStoreUserRepository bookStoreUserRepository;

    @Mock
    JwtTokenUtil jwtTokenUtil;

    User user = new User(1L,"8555058332","mohank5","kmohanr5@gmail.com");
    User user1 = new User(2L,"1234567890","mohank5","kmohanr5@gmail.com");

    UserDTO userDTO = new UserDTO("8179800190","Dhoni","google.com");

    /**
     * User Related Test Cases
     */

    @Test
    public void registerUser(){
        Mockito.when(bookStoreUserRepository.save(Mockito.any(User.class))).thenReturn(user);
        User user = bookStoreUserServiceImplementation.createUser(user1);
        assertNotNull(user);
    }


    @Test
    public void deleteBooksByUserId(){
        when(bookStoreUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        bookStoreUserServiceImplementation.deletebyID(user.getID());
        verify(bookStoreUserRepository,times(1)).deleteById(user.getID());
    }

    @Test
    public void loginUser(){
        Mockito.when(bookStoreUserRepository.save(Mockito.any(User.class))).thenReturn(user);
        //when(bookStoreUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        when(bookStoreUserRepository.getUserDetails(user.getMobileNumber(),user.getPassword())).thenReturn(user);
        Mockito.when(jwtTokenUtil.generateToken(user.getMobileNumber())).thenReturn("token");
        String token = bookStoreUserServiceImplementation.generateToken(user);
        assertNotNull(token);
    }

    @Test
    public void getUserById(){
        when(bookStoreUserRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        User userDetails = bookStoreUserServiceImplementation.getUserByID(user.getID());
        assertEquals(user,userDetails);

    }

    @Test
    public void updateUser(){
        when(bookStoreUserRepository.getById(anyLong())).thenReturn((user));
        bookStoreUserServiceImplementation.updateUser(user.getID(),userDTO);
        Mockito.when(bookStoreUserRepository.save(any())).thenReturn(user);
        assertEquals(userDTO.getMobileNumber(),user.getMobileNumber());
    }
}
