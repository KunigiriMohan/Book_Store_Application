package com.application.bookstore;

import com.application.bookstore.dto.AddressDTO;
import com.application.bookstore.dto.ResponseDTO;
import com.application.bookstore.dto.UserDTO;
import com.application.bookstore.model.Book;
import com.application.bookstore.model.User;
import com.application.bookstore.utility.JwtTokenUtil;
import com.sun.net.httpserver.HttpsParameters;
import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BookStoreMainTestController {

    @Mock
    JwtTokenUtil jwtTokenUtil;

    @InjectMocks
    BookStoreMainTestController bookStoreMainTestController;


    User user = new User(1L,"8555058332","mohank5","kmohanr5@gmail.com");
    User user1 = new User(2L,"9876543210","mohank5","kmohanr5@gmail.com");

    UserDTO userDTO = new UserDTO("8555058332","mohank5","kmohanr5@gmail.com");

    Book book1 =new Book(1L,"The Psychology of Money",240l,"Housel Morgan","2014",user);
    Book book2 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);
    Book book3 =new Book(1L,"The Intelligent Investor",100L,"graham","2014",user);

    AddressDTO addressDTO = new AddressDTO("Mohan","5/223","Adoni","Andhra Pradesh","518301","8555058332");

    @Order(1)
    @Test
    public void userSignUp() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"User Created\",\n" +
                "    \"data\": {\n" +
                "        \"id\": null,\n" +
                "        \"mobileNumber\": \"8555058332\",\n" +
                "        \"password\": \"mohank5\",\n" +
                "        \"email\": \"kmohanr5@gmail.com\"\n" +
                "    },\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        /*HttpEntity<String> request = new HttpEntity<String>(result,headers);*/
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/bookstore/signup",request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }


    @Order(2)
    @Test
    public void loginUser(){
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/bookstore/login",HttpMethod.POST,request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Order(3)
    @Test
    public void updateUser() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"User Detials Updated Successfully\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"mobileNumber\": \"8555058332\",\n" +
                "        \"password\": \"mohank5\",\n" +
                "        \"email\": \"kmohanr5@gmail.com\"\n" +
                "    },\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4NTU1MDU4MzMyIiwiaWF0IjoxNjQzODUwNTEyfQ.9Z6IIFpjZuT_5ZpZdYnfJXUemiF_nacmkKiQnYHDOUs");

        //Long iD = 1L;
        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/bookstore/updateuserbyid/1",HttpMethod.PUT,request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }


    @Order(4)
    @Test
    public void goToHomePage() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"Books in Store\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"bookName\": \"Indian Polity for Civil Services and Other State Examinations\",\n" +
                "            \"bookPrice\": 672,\n" +
                "            \"bookAuthor\": \"Laxmikanth M\",\n" +
                "            \"publishedYear\": \"2021\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"bookName\": \"Rich Dad Poor Dad\",\n" +
                "            \"bookPrice\": 243,\n" +
                "            \"bookAuthor\": \"Kiyosaki Robert T\",\n" +
                "            \"publishedYear\": \"2017\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"bookName\": \"The Psychology of Money\",\n" +
                "            \"bookPrice\": 240,\n" +
                "            \"bookAuthor\": \"Housel Morgan\",\n" +
                "            \"publishedYear\": \"2020\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"bookName\": \"The Intelligent Investor\",\n" +
                "            \"bookPrice\": 449,\n" +
                "            \"bookAuthor\": \"Graham Benjamin\",\n" +
                "            \"publishedYear\": \"2003\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"bookName\": \"The Intelligent Investor\",\n" +
                "            \"bookPrice\": 449,\n" +
                "            \"bookAuthor\": \"Graham Benjamin\",\n" +
                "            \"publishedYear\": \"2003\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 6,\n" +
                "            \"bookName\": \"The Intelligent Investor\",\n" +
                "            \"bookPrice\": 449,\n" +
                "            \"bookAuthor\": \"Graham Benjamin\",\n" +
                "            \"publishedYear\": \"2003\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 7,\n" +
                "            \"bookName\": \"The Intelligent Investor\",\n" +
                "            \"bookPrice\": 449,\n" +
                "            \"bookAuthor\": \"Graham Benjamin\",\n" +
                "            \"publishedYear\": \"2003\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 8,\n" +
                "            \"bookName\": \"The Intelligent Investor\",\n" +
                "            \"bookPrice\": 449,\n" +
                "            \"bookAuthor\": \"Graham Benjamin\",\n" +
                "            \"publishedYear\": \"2003\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/bookstore/getallbooks",String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }

    @Order(5)
    @Test
    public void addBooktoCart() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"Book Added To Cart\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 2,\n" +
                "        \"bookName\": \"The Psychology of Money\",\n" +
                "        \"bookPrice\": 240,\n" +
                "        \"bookAuthor\": \"Housel Morgan\",\n" +
                "        \"publishedYear\": \"2020\",\n" +
                "        \"user\": {\n" +
                "            \"id\": 1,\n" +
                "            \"mobileNumber\": \"8555058332\",\n" +
                "            \"password\": \"mohank5\",\n" +
                "            \"email\": \"kmohanr5@gmail.com\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4NTU1MDU4MzMyIiwiaWF0IjoxNjQzODUwNTEyfQ.9Z6IIFpjZuT_5ZpZdYnfJXUemiF_nacmkKiQnYHDOUs");

        HttpEntity<Book> request = new HttpEntity<Book>(book1,headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/bookstore/addbook/3?quantity=2&userid=1",request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }

    @Order(6)
    @Test
    public void getAllBookinCart() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"Books Present in Cart\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"bookName\": \"The Psychology of Money\",\n" +
                "            \"bookPrice\": 240,\n" +
                "            \"bookAuthor\": \"Housel Morgan\",\n" +
                "            \"publishedYear\": \"2020\",\n" +
                "            \"user\": {\n" +
                "                \"id\": 1,\n" +
                "                \"mobileNumber\": \"8555058332\",\n" +
                "                \"password\": \"mohank5\",\n" +
                "                \"email\": \"kmohanr5@gmail.com\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"bookName\": \"The Psychology of Money\",\n" +
                "            \"bookPrice\": 240,\n" +
                "            \"bookAuthor\": \"Housel Morgan\",\n" +
                "            \"publishedYear\": \"2020\",\n" +
                "            \"user\": {\n" +
                "                \"id\": 1,\n" +
                "                \"mobileNumber\": \"8555058332\",\n" +
                "                \"password\": \"mohank5\",\n" +
                "                \"email\": \"kmohanr5@gmail.com\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"value\": 480,\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4NTU1MDU4MzMyIiwiaWF0IjoxNjQzODUwNTEyfQ.9Z6IIFpjZuT_5ZpZdYnfJXUemiF_nacmkKiQnYHDOUs");

        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/bookstore/getallbooksincart/1",HttpMethod.GET,request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }

    @Order(7)
    @Test
    public void buyBooksinHomepage() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"Book Added For Buying\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"bookName\": \"Indian Polity for Civil Services and Other State Examinations\",\n" +
                "        \"bookPrice\": 672,\n" +
                "        \"bookAuthor\": \"Laxmikanth M\",\n" +
                "        \"publishedYear\": \"2021\"\n" +
                "    },\n" +
                "    \"value\": 672,\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4NTU1MDU4MzMyIiwiaWF0IjoxNjQzODUwNTEyfQ.9Z6IIFpjZuT_5ZpZdYnfJXUemiF_nacmkKiQnYHDOUs");

        HttpEntity<AddressDTO> request = new HttpEntity<AddressDTO>(addressDTO,headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/bookstore/buybookfromhomepage/1",request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }


    @Order(8)
    @Test
    public void removeBookById() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"Book Removed From Cart Successfully\",\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4NTU1MDU4MzMyIiwiaWF0IjoxNjQzODUwNTEyfQ.9Z6IIFpjZuT_5ZpZdYnfJXUemiF_nacmkKiQnYHDOUs");


        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/bookstore/removebookfromcart/1",HttpMethod.DELETE,request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }

    @Order(9)
    @Test
    public void deleteUserById() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"User Deleted Successfully\",\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token","eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI4NTU1MDU4MzMyIiwiaWF0IjoxNjQzODUwNTEyfQ.9Z6IIFpjZuT_5ZpZdYnfJXUemiF_nacmkKiQnYHDOUs");


        HttpEntity<User> request = new HttpEntity<User>(user,headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8081/bookstore/deletebyid/1",HttpMethod.DELETE,request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);
    }

}
