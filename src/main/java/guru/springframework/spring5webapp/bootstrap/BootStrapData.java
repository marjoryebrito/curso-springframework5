package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author andrew = new Author("Andrew", "Tanenbaum");
        Book   cnet  = new Book("Computer Networks", "123123");

        andrew.getBooks().add(cnet);
        cnet.getAuthors().add(andrew);

        authorRepository.save(andrew);
        bookRepository.save(cnet);

        Author ben = new Author("Ben", "Clark");
        Book   rtfm = new Book("RTFM", "147852");

        ben.getBooks().add(rtfm);
        rtfm.getAuthors().add(ben);

        authorRepository.save(ben);
        bookRepository.save(rtfm);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
