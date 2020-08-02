package juliancambraia.springframework.spring5webapp.bootstrap;

import juliancambraia.springframework.spring5webapp.domain.Author;
import juliancambraia.springframework.spring5webapp.domain.Book;
import juliancambraia.springframework.spring5webapp.domain.Publisher;
import juliancambraia.springframework.spring5webapp.repository.AuthorRepository;
import juliancambraia.springframework.spring5webapp.repository.BookRepository;
import juliancambraia.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johson");
        Book noEJB = new Book("J2EE Development without EJB", "39393939459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher publisher1 = new Publisher("New Publication 1", "Rua Antônio Cesário da Rocha", "Belo Horizonte", "Minas Gerais", "30750170");
        Publisher publisher2 = new Publisher("New Publication 2", "Rua Antônio Cesário da Rocha", "Belo Horizonte", "Minas Gerais", "30750170");
        Publisher publisher3 = new Publisher();
        publisher3.setName("New Publisher 3");
        publisher3.setAddressLine1("Rua Antônio Cesário da Rocha, 33");
        publisher3.setCity("Belo Horizonte");
        publisher3.setState("Minas Gerais");
        publisher3.setZip("30750170");

        publisherRepository.saveAll(Arrays.asList(publisher1, publisher2, publisher3));


        System.out.println("Number of Publisher: " + publisherRepository.count());
    }
}
