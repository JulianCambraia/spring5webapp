package juliancambraia.springframework.spring5webapp.bootstrap;

import juliancambraia.springframework.spring5webapp.domain.Author;
import juliancambraia.springframework.spring5webapp.domain.Book;
import juliancambraia.springframework.spring5webapp.domain.Publisher;
import juliancambraia.springframework.spring5webapp.repository.AuthorRepository;
import juliancambraia.springframework.spring5webapp.repository.BookRepository;
import juliancambraia.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        System.out.println("Started in Bootstrap");

        // Publisher
        Publisher publisher = new Publisher("New Publication 1", "Rua Antônio Cesário da Rocha", "Belo Horizonte", "Minas Gerais", "30750170");
        // salvar primeiro a entidade Publisher para não emitir Detached ou Transient
        publisherRepository.save(publisher);
        // Authors
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johson");
        Book noEJB = new Book("J2EE Development without EJB", "39393939459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());

        System.out.println("Publisher Number  of Books: " + publisher.getBooks().size());
    }
}
