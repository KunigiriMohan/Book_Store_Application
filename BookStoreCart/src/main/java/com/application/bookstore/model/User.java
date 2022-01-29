
package com.application.bookstore.model;
import com.application.bookstore.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @NoArgsConstructor: Annotations to generate NoArgument Constructor
 * @AllArgsConstructor: Annotations to generate All Arguments Constructor
 * @Data : To Generate Getters and Setters
 * @Table : Declaring Table Name
 * @Entity : For Creating Object
 */

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


    /*
     * Method to intialise Details
     * @param userDTO
     */

    public void updateUser(UserDTO userDTO){
        this.mobileNumber= userDTO.getMobileNumber();
        this.password= userDTO.getPassword();
        this.email=userDTO.getEmail();
    }
}

