package com.application.bookstore.repository;

import com.application.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Repository : Creating Repository
 */
@Repository
public interface BookStoreCartRepository extends JpaRepository<Book,Long> {

    @Query("select sum(book.bookPrice)from Book book")
    public Long cartValue();
}
