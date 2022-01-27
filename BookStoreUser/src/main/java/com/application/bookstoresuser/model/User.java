package com.application.bookstoresuser.model;

import com.application.bookstoresuser.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "user_list")
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;
    private String mobileNumber;
    private String password;
    private String email;

    public User(UserDTO userDTO){
        this.updateUser(userDTO);
    }
    public void updateUser(UserDTO userDTO){
        this.mobileNumber= userDTO.getMobileNumber();
        this.password= userDTO.getPassword();
        this.email=userDTO.getEmail();
    }
}
