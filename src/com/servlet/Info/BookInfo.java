package com.servlet.Info;

import com.entity.Book;

/**
 * 书本信息
 */
public class BookInfo extends Book {
    private Book book;
    private boolean isNew;
    private boolean isPromo;
    private boolean isSpecial;

    public BookInfo(Book book, boolean isNew, boolean isPromo, boolean isSpecial) {
        this.book = book;
        this.isNew = isNew;
        this.isPromo = isPromo;
        this.isSpecial = isSpecial;
    }

}
