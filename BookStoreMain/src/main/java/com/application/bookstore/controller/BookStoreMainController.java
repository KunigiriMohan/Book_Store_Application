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

@RestController
@RequestMapping("/bookstore")
public class BookStoreMainController {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PropertyBean propertyBean;

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


    @GetMapping("/getallbooks")
    public ResponseEntity<ResponseDTO> withoutLogin(){
        ResponseEntity<Book[]> personList = new RestTemplate().getForEntity(propertyBean.getGetallbooksURL(), Book[].class);
        ResponseDTO responseDTO = new ResponseDTO(Message.allBooksinStore, personList.getBody(), HttpStatus.OK);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

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
