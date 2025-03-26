package com.kodilla.kodilla_spring.reader;

public final class Reader {
    final Book theBook;

    public Reader(final Book theBook) {
        this.theBook = theBook;
    }

    public void read() {
        System.out.println("Reading: " + theBook.getTitle());
    }
}
