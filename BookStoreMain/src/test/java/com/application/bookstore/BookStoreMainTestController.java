package com.application.bookstore;

import com.application.bookstore.dto.ResponseDTO;
import com.application.bookstore.dto.UserDTO;
import com.application.bookstore.model.User;
import com.application.bookstore.utility.JwtTokenUtil;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BookStoreMainTestController {

    @Mock
    JwtTokenUtil jwtTokenUtil;

    @InjectMocks
    BookStoreMainTestController bookStoreMainTestController;

    User user = new User(1L,"8555058332","mohank5","kmohanr5@gmail.com");
    User user1 = new User(2L,"1234567890","mohank5","kmohanr5@gmail.com");

    UserDTO userDTO = new UserDTO("8179800190","Dhoni","google.com");

    @Test
    public void userSignUp() throws JSONException {
        String result = "{\n" +
                "    \"message\": \"User Created\",\n" +
                "    \"data\": {\n" +
                "        \"id\": null,\n" +
                "        \"mobileNumber\": \"7396399163\",\n" +
                "        \"password\": \"raju8179\",\n" +
                "        \"email\": \"kmohanr5@gmail.com\"\n" +
                "    },\n" +
                "    \"httpStatus\": \"OK\"\n" +
                "}";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<User> request = new HttpEntity<User>(user1,headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/bookstore/signup",request,String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        JSONAssert.assertEquals(result,response.getBody(),false);

    }
}
