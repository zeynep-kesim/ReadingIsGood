package com.getir.readingisgood.service;

import com.getir.readingisgood.dto.BookDto;
import com.getir.readingisgood.utilities.results.Result;

public interface BookService {

    Result addBook(BookDto bookDto);

    Result updateBookStock(BookDto bookDto);

}