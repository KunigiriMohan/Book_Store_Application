package com.application.bookstoresuser.serviceimplementation;

import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.exception.BookStoreException;
import com.application.bookstoresuser.exception.UserNotFoundException;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.repository.BookStoreUserRepository;
import com.application.bookstoresuser.service.BookStoreUserService;
import com.application.bookstoresuser.utility.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 */
@Service
public class BookStoreUserServiceImplementation implements BookStoreUserService {

    /**
     * Autowiring to Save Data in Repository
     */
    @Autowired
    BookStoreUserRepository bookStoreUserRepository;

    /**
     * Autowiring JwtTokenUtil to Creating Token
     */
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * implementing method creatingUser in DB
     */
    @Override
    public User createUser(User user){
        if(bookStoreUserRepository.findAll().size()==0){
            return bookStoreUserRepository.save(user);
        }
        else{
            User userDetails=bookStoreUserRepository.getUserDetails(user.getMobileNumber());
            if(userDetails==null){
                return bookStoreUserRepository.save(user);
            }
            else{
                throw new BookStoreException("User Already Present");
            }
        }
    }

    /**
     * implementing method generatingToken
     */
    @Override
    public String generateToken(User user) {
        User userDetails = bookStoreUserRepository.getUserDetails(user.getMobileNumber() ,user.getPassword());
        if(userDetails==null){
            throw new UserNotFoundException("User Not Found");
        }
        else{
            return jwtTokenUtil.generateToken(user.getMobileNumber());
        }
    }

    /**
     * Method to Delete User by id
     * @param id
     */
    @Override
    public void deletebyID(Long id) {
        try {
            bookStoreUserRepository.deleteById(id);
        }catch (Exception exception){
            throw new UserNotFoundException("User Not Found ");
        }
    }

    /**
     * Method to update User Details
     * @param id
     * @param userDTO
     * @return : Stored User Object
     */
    @Override
    public User updateUser(Long id,  UserDTO userDTO) {
        try{
            User user = bookStoreUserRepository.getById(id);
            user.updateUser(userDTO);
            return bookStoreUserRepository.save(user);
        }catch (Exception exception){
            throw new UserNotFoundException("User Not Found ");
        }
    }

    /**
     * Method to get User by userid
     * @param id
     * @return : User details of that userid
     */
    @Override
    public User getUserByID(Long id) {
        try{
            return bookStoreUserRepository.findById(id).get();
        }catch (Exception exception){
            throw new UserNotFoundException("User Not Found ");
        }
    }
}
