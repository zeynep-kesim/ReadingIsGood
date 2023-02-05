package com.getir.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private int bookId;
    private String bookName;
    private String bookAuthor;
    private Double bookPrice;
    private int bookStock;

}