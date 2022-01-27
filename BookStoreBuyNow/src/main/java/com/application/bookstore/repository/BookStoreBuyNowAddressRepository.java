package com.application.bookstore.repository;


import com.application.bookstore.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @Repository : Creating Repository
 */
public interface BookStoreBuyNowAddressRepository extends JpaRepository<Address,Long> {
}
