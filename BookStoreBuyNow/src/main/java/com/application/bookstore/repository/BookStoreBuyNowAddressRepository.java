package com.application.bookstore.repository;


import com.application.bookstore.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreBuyNowAddressRepository extends JpaRepository<Address,Long> {
}
