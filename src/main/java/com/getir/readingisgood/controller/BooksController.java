package com.getir.readingisgood.controller;

import com.getir.readingisgood.dto.BookDto;
import com.getir.readingisgood.service.BookService;
import com.getir.readingisgood.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BooksController {

    private BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addbook")
    public Result addbook(@Valid @RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @PostMapping("/updatebookstock")
    public Result updateBookStock(@Valid @RequestBody BookDto bookDto) {
        return bookService.updateBookStock(bookDto);
    }

}