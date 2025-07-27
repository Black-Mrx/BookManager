import model.Book;
import service.BookService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookService bookService = new BookService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> addBook();
                case 2 -> listBooks();
                case 3 -> removeBook();
                case 0 -> {
                    System.out.println("📕 La revedere!");
                    return;
                }
                default -> System.out.println("❌ Opțiune invalidă.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n📚 Meniu Book Manager:");
        System.out.println("1. Adaugă carte");
        System.out.println("2. Afișează toate cărțile");
        System.out.println("3. Șterge carte după ID");
        System.out.println("0. Ieșire");
        System.out.print("Alege opțiunea: ");
    }

    private static void addBook() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Titlu: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("An publicare: ");
        int year = Integer.parseInt(scanner.nextLine());

        Book book = new Book(id, title, author, year);
        bookService.addBook(book);
        System.out.println("✅ Carte adăugată cu succes!");
    }

    private static void listBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("📭 Nu există cărți în listă.");
        } else {
            System.out.println("\n📖 Lista cărților:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void removeBook() {
        System.out.print("ID-ul cărții de șters: ");
        int id = Integer.parseInt(scanner.nextLine());
        bookService.removeBook(id);
        System.out.println("🗑️ Carte ștearsă cu succes.");
    }
}
