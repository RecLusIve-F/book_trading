package com.servlet.Info;

import com.entity.Book;

/**
 * 书本信息
 */
public class BookInfo {
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

    public BookInfo(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }
}
