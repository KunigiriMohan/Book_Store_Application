package com.application.bookstore.controller;

import com.application.bookstore.dto.*;
import com.application.bookstore.exception.BookStoreException;
import com.application.bookstore.model.*;
import com.application.bookstore.utility.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @RestController : Defining Class as a RestController
 * @RequestMapping : Defining path of URL
 * @PostMapping : Defining URL path of API and to perform POST operation
 * @GetMapping : Defining URL Path of API
 * @PutMapping : Defining URL Path of API which perform PUT operation
 * @DeleteMapping : Defining URL Path of API which perform DELETE opertion
 * @Autowired : Dependency Injection
 * @Valid : Checking Requested bean is valid or not
 */
@RestController
@RequestMapping("/bookstore")
public class BookStoreMainController {

    /**
     * Autowiring JwtToken for Dependency Injection
     */
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * creating object of PropertyBean to get URL variables;
     */
    private PropertyBean propertyBean;

    /**
     * API for Registering User in BookStore Application
     * @param user
     * @return ResponseEntity of Created Object
     */
    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> userSignUp(@RequestBody User user) {
        User signUpUser = new RestTemplate().postForObject(propertyBean.getSignupURL(), user,User.class);
        if (signUpUser.getMobileNumber() == null) {
            throw new BookStoreException(Message.userAlreadyPresent);
        } else {
            ResponseDTO responseDTO = new ResponseDTO(Message.userRegitered, user, HttpStatus.OK);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }
    }

    /**
     * API for Login User to generate token
     * @param : user
     * @return : ResponseEntity of token
     */
    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody User user) {
        String loginUser = new RestTemplate().postForObject(propertyBean.getLoginURL(), user,String.class);
        if (loginUser == null) {
            throw new BookStoreException(Message.userNotRegistered);
        } else {
            ResponseDTO responseDTO = new ResponseDTO(Message.loginSuccesfull, loginUser, HttpStatus.OK);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }
    }

    /**
     * API for Updating User Details Stored in DB
     * @param userDTO
     * @param id
     * @param token
     * @return ResponseEntity of updated user Details
     */
    @PutMapping("/updateuserbyid/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@RequestBody UserDTO userDTO,@PathVariable("id") Long id,@RequestHeader String token){
        if (jwtTokenUtil.isValidToken(token)){
            try{
                UpdateUserData updateUserData = new UpdateUserData(id,userDTO);
                User user = new RestTemplate().postForObject(propertyBean.getUpdateUserDetailsByIDURL(),updateUserData,User.class);
                ResponseDTO responseDTO = new ResponseDTO(Message.userUpdatedSucessfully,user,HttpStatus.OK);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
            }catch(Exception exception){
                ResponseDTO responseDTO = new ResponseDTO(Message.userNotRegistered,HttpStatus.BAD_REQUEST);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);

            }
        }
        else{
            throw new BookStoreException(Message.loginToPerformOperations);
        }

    }

    /**
     * API for delete User by ID
     * @param id
     * @param token
     * @return : ResponseEntity of Deleted Message
     */
    @DeleteMapping("deletebyid/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Long id,@RequestHeader String token){
        if (jwtTokenUtil.isValidToken(token)){
            try{
                new RestTemplate().delete(propertyBean.getDeleteUserByIdURL(),id);
                ResponseDTO responseDTO = new ResponseDTO(Message.userDeletedSucessfully,HttpStatus.OK);
                return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
            }
            catch (HttpServerErrorException httpServerErrorException){
                ResponseDTO responseDTO = new ResponseDTO(Message.userNotRegistered,HttpStatus.BAD_REQUEST);
                return  new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
            }
        }
        else{
            throw new BookStoreException(Message.userNotRegistered);
        }
    }


    /**
     * API for to get All Books Present in Cart
     * @return : ResponseEntity of List of Books
     */
    @GetMapping("/getallbooks")
    public ResponseEntity<ResponseDTO> withoutLogin(){
        ResponseEntity<Book[]> personList = new RestTemplate().getForEntity(propertyBean.getGetallbooksURL(), Book[].class);
        ResponseDTO responseDTO = new ResponseDTO(Message.allBooksinStore, personList.getBody(), HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * API for Adding Book to Cart from Homepage
     * @param id
     * @param token
     * @return : ResponseEntity of Added Book
     */
    @PostMapping("/addbook/{id}")
    public ResponseEntity<ResponseDTO> addBookToCart(@PathVariable("id") Long id,@RequestHeader String token){
        if (jwtTokenUtil.isValidToken(token)) {
            Book book = new RestTemplate().getForObject(propertyBean.getGetallbookByIDURL(),Book.class,id);
            Book bookinCart = new RestTemplate().postForObject(propertyBean.getAddBookToCartURL(),book,Book.class);
            ResponseDTO responseDTO = new ResponseDTO(Message.bookAddedToCart,bookinCart,HttpStatus.OK);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }
        else{
            throw new BookStoreException(Message.loginToShowCart);
        }
    }

    /**
     * API for Removing Book from Cart
     * @param id
     * @param token
     * @return : Message with whether book is removed or not
     */
    @DeleteMapping("/removebookfromcart/{id}")
    public ResponseEntity<ResponseDTO> removeBookFromCart(@PathVariable("id") Long id,@RequestHeader String token){
        if(jwtTokenUtil.isValidToken(token)){
            try{
                new RestTemplate().delete(propertyBean.getRemoveBookFromCart(),id);
                ResponseDTO responseDTO = new ResponseDTO(Message.bookRemovedFromCart,HttpStatus.OK);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
            }catch(Exception e){
                ResponseDTO responseDTO = new ResponseDTO(Message.bookNotFoundInCart,HttpStatus.BAD_REQUEST);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }
        else{
            throw new BookStoreException(Message.loginToShowCart);
        }
    }

    /**
     * API for show all Books in Cart
     * @param token
     * @return : ResponseEntity all books in Cart
     */
    @GetMapping("/getallbooksincart")
    public ResponseEntity<ResponseDTO> getAllBooksInCart(@RequestHeader String token){
        if (jwtTokenUtil.isValidToken(token)){
                Book[] booksInCart= new RestTemplate().getForObject(propertyBean.getGetAllBookinCart(),Book[].class);
                if (booksInCart.length==0){
                    ResponseDTO responseDTO = new ResponseDTO(Message.noBookFoundinCart,HttpStatus.OK);
                    return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
                }
                else{
                    ResponseDTO responseDTO = new ResponseDTO(Message.booksInCart,booksInCart,HttpStatus.OK);
                    return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
                }
        }
        else {
            throw new BookStoreException(Message.loginToShowCart);
        }
    }

    /**
     * API for buying products in Cart
     * @param token
     * @param addressDTO
     * @return : ResponseEntity of List of products Added for Buying
     */
    @PostMapping("/buyproductsincart")
    public ResponseEntity<ResponseDTO> buyBooksinCart(@RequestHeader String token, @RequestBody AddressDTO addressDTO){
        if (jwtTokenUtil.isValidToken(token)){
            Book[] booksInCart= new RestTemplate().getForObject(propertyBean.getGetAllBookinCart(),Book[].class);
            if (booksInCart.length==0){
                ResponseDTO responseDTO = new ResponseDTO(Message.noBookFoundinCart,HttpStatus.OK);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                OrderDATACart orderDATACart = new OrderDATACart();
                orderDATACart.setAddressDTO(addressDTO);
                orderDATACart.setBook(booksInCart);
                String result = new RestTemplate().postForObject(propertyBean.getBuyNowBookFromCart(),orderDATACart,String.class);
                ResponseDTO responseDTO = new ResponseDTO(Message.bookAddedForBuying,result,HttpStatus.OK);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
            }
        }
        else{
            throw new BookStoreException(Message.loginToShowCart);
        }
    }

    /**
     * API for buying Book from Home Page
     * @param id
     * @param addressDTO
     * @return : ResponseEntity of Book Buyed
     */
    @PostMapping("/buybookfromhomepage/{id}")
    public ResponseEntity<ResponseDTO> buyProduct(@PathVariable("id") Long id,@RequestBody AddressDTO addressDTO){
        Book book = new RestTemplate().getForObject(propertyBean.getGetallbookByIDURL(),Book.class,id);
        OrderDATA orderDATA = new OrderDATA();
        orderDATA.setBook(book);
        orderDATA.setAddressDTO(addressDTO);
        String bookBuyed = new RestTemplate().postForObject(propertyBean.getBuyNowBookURL(),orderDATA,String.class);
        ResponseDTO responseDTO = new ResponseDTO(Message.bookAddedForBuying,bookBuyed,HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
