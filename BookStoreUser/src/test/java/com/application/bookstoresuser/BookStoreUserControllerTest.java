package com.application.bookstoresuser;

import com.application.bookstoresuser.controller.BookStoreController;
import com.application.bookstoresuser.dto.UpdateUserData;
import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.service.IBookStoreUserService;
import com.application.bookstoresuser.serviceimplementation.BookStoreUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookStoreUserControllerTest {

    @Mock
    IBookStoreUserService iBookStoreUserService;

    @InjectMocks
    BookStoreController bookStoreController;

    User user = new User(1L,"8555058332","mohank5","kmohanr5@gmail.com");
    User user1 = new User(2L,"1234567890","mohank5","kmohanr5@gmail.com");

    UserDTO userDTO = new UserDTO("8555058332","mohank5","google.com");
    UpdateUserData updateUserData = new UpdateUserData(user.getID(), userDTO);

    /*List<Book> booksInCart = new ArrayList<>();*/

    @Test
    public void createUser(){
        when(iBookStoreUserService.createUser(Mockito.any(User.class))).thenReturn(user);
        User userCreated = bookStoreController.generateUser(user);
        assertEquals(user,userCreated);
    }

    @Test
    public void deleteUserById(){
        bookStoreController.deleteUser(anyLong());
        verify(iBookStoreUserService,times(1)).deletebyID(anyLong());
    }

    @Test
    public void updateUserById(){
        when(iBookStoreUserService.updateUser(anyLong(),Mockito.any(UserDTO.class))).thenReturn(user);
        User userUpdated = bookStoreController.updateUser(updateUserData);
        assertEquals(user,userUpdated);
    }

    @Test
    public void loginUser(){
        when(iBookStoreUserService.generateToken(Mockito.any(User.class))).thenReturn(("Token"));
        String generatedToken = bookStoreController.loginUser(user);
        assertNotNull(generatedToken);
    }

    @Test
    public void getUserById(){
        when(iBookStoreUserService.getUserByID(anyLong())).thenReturn(user);
        User userGot = bookStoreController.getUserById(anyLong());
        assertNotNull(userGot);
    }
}
