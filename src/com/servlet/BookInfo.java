package com.servlet;

public class BookInfo {
    private String BookName;
    private String BookSrc;
    private String Details;
    private boolean isNew;
    private boolean isPromo;
    private boolean isSpecial;

    public BookInfo(String BookName, String BookSrc, String Details, boolean isNew, boolean isPromo, boolean isSpecial) {
        this.BookName = BookName;
        this.BookSrc = BookSrc;
        this.Details = Details;
        this.isNew = isNew;
        this.isPromo = isPromo;
        this.isSpecial = isSpecial;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookSrc() {
        return BookSrc;
    }

    public void setBookSrc(String bookSrc) {
        BookSrc = bookSrc;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
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
