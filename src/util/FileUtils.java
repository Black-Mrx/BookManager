package util;


import model.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String FILE_PATH = "books.txt";

    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(Book.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Eroare la citire: " + e.getMessage());
        }
        return books;
    }

    public static void writeBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.write(book.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Eroare la scriere: " + e.getMessage());
        }
    }
}
