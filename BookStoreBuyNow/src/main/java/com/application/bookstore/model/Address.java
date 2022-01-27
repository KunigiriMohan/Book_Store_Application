package com.application.bookstore.model;

import com.application.bookstore.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address_table")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String mobileNumber;

    public Address(AddressDTO addressDTO){
        this.name = addressDTO.getName();
        this.address = addressDTO.getAddress();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.pinCode = addressDTO.getPinCode();
        this.mobileNumber = addressDTO.getMobileNumber();
    }
}
