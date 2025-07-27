package service;

import model.Book;
import util.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books;

    public BookService() {
        this.books = FileUtils.readBooks();
    }

    public void addBook(Book book) {
        books.add(book);
        FileUtils.writeBooks(books);
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
        FileUtils.writeBooks(books);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
