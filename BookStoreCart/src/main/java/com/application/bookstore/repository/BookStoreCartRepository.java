package com.application.bookstore.repository;

import com.application.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Repository : Creating Repository
 */
@Repository
public interface BookStoreCartRepository extends JpaRepository<Book,Long> {

    @Query("select sum(book.bookPrice)from Book book")
    public Long cartValue();

    @Query("select book from Book book where book.user.iD=:userid")
    List<Book> getBooksByUserID(@Param("userid") Long iD);

    @Transactional
    @Modifying
    @Query("delete from Book book where book.user.iD=:userid")
    void deleteBooksByUserIDinCart(@Param("userid") Long iD);
}