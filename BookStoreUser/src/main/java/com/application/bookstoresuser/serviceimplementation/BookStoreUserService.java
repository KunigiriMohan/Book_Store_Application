package com.application.bookstoresuser.serviceimplementation;

import com.application.bookstoresuser.dto.UserDTO;
import com.application.bookstoresuser.exception.BookStoreException;
import com.application.bookstoresuser.model.User;
import com.application.bookstoresuser.repository.BookStoreUserRepository;
import com.application.bookstoresuser.service.IBookStoreUserService;
import com.application.bookstoresuser.utility.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 */
@Service
public class BookStoreUserService implements IBookStoreUserService {

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
            throw new BookStoreException("User Not Found");
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
        bookStoreUserRepository.deleteById(id);
    }

    /**
     * Method to update User Details
     * @param id
     * @param userDTO
     * @return
     */
    @Override
    public User updateUser(Long id, UserDTO userDTO) {
        User user = bookStoreUserRepository.getById(id);
        user.updateUser(userDTO);
        return bookStoreUserRepository.save(user);
    }

    @Override
    public User getUserByID(Long id) {
        return bookStoreUserRepository.findById(id).get();
    }
}
