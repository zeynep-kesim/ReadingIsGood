package com.getir.readingisgood.dao;

import com.getir.readingisgood.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findAllBy();

}