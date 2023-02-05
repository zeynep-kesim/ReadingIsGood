package com.getir.readingisgood.service;

import com.getir.readingisgood.dao.BookDao;
import com.getir.readingisgood.dto.BookDto;
import com.getir.readingisgood.model.Book;
import com.getir.readingisgood.utilities.constants.Messages;
import com.getir.readingisgood.utilities.results.ErrorResult;
import com.getir.readingisgood.utilities.results.Result;
import com.getir.readingisgood.utilities.results.SuccessResult;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookDao bookDao;

    private ModelMapper modelMapper;

    @Autowired
    public BookServiceImpl(BookDao bookDao, ModelMapper modelMapper) {
        this.bookDao = bookDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDao, Book.class);
        bookDao.save(book);
        logger.info("Book Name : " + bookDto.getBookName(), "Book Author :" + bookDto.getBookAuthor());
        return new SuccessResult(Messages.BOOK_ADDED);
    }

    @Override
    public Result updateBookStock(BookDto bookDto) {

        List<Book> bookList = bookDao.findAllBy();

        if (!bookList.isEmpty()) {
            logger.info("Book Name : " + bookDto.getBookName(), "Book Author :" + bookDto.getBookAuthor(), "Book Stock :" + bookDto.getBookStock());
            bookDao.save(new Book(bookDto.getBookId(), bookDto.getBookName(), bookDto.getBookAuthor(), bookDto.getBookPrice(), bookDto.getBookStock()));
            return new SuccessResult(Messages.BOOK_STOCK_UPDATED);
        } else {
            return new ErrorResult(Messages.BOOK_NOT_FOUND);
        }

    }

}