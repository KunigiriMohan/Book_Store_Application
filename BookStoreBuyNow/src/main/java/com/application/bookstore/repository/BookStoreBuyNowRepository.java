package com.application.bookstore.repository;


import com.application.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Repository : Creating Repository
 */
public interface BookStoreBuyNowRepository extends JpaRepository<Book,Long> {
    @Query("select sum(book.bookPrice)from Book book")
    public Long cartValue();
}
