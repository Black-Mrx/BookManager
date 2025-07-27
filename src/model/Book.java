package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return id + ". \"" + title + "\" de " + author + " (" + year + ")";
    }

    public String toFileString() {
        return id + ";" + title + ";" + author + ";" + year;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(";");
        return new Book(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                Integer.parseInt(parts[3])
        );
    }
}
