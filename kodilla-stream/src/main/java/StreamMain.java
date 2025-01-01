import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumberGenerator;
import com.kodilla.stream.person.People;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        System.out.println("Testing poem beautifier: ");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String text1 = "Lorem ipsum";
        String text2 = "Another lorem ipsum";
        String text3 = "Yet another lorem ipsum";
        String text4 = "Final lorem ipsum";
        poemBeautifier.beautify(text1, poem -> poem.toLowerCase());
        poemBeautifier.beautify(text2, poem -> "ABC " + poem + " ABC");
        poemBeautifier.beautify(text3, poem -> poem.toUpperCase());
        poemBeautifier.beautify(text4, poem -> "\n----------\n" + poem + "\n---------");

        System.out.println("\n Working with streams:");
        People.getList().stream().forEach(System.out::println);
        People.getList().stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("\nTesting streams on self-made objects:");
        BookDirectory bookDirectory = new BookDirectory();
        bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        Map<String, Book> theResultMapOfBooks = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


        System.out.println("\nUsing streams to transform the list of ForumUser objects and display it:");
        Forum.getForumUsers().stream()
                .filter(user -> user.getGender() == 'M')
                .filter(user -> LocalDate.now().getYear() - user.getDateOfBirth().getYear() >= 20)
                .filter(user -> user.getNumPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getId, user -> user))
                .entrySet().stream()
                .forEach(entry -> System.out.println("Map key: " + entry.getKey() + "\nMap value: " + entry.getValue()));

    }
}
