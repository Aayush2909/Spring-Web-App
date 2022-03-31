package com.springframework.webapp.bootstrap;

import com.springframework.webapp.utils.Address;
import com.springframework.webapp.domain.Author;
import com.springframework.webapp.domain.Book;
import com.springframework.webapp.domain.Publisher;
import com.springframework.webapp.repositories.AuthorRepository;
import com.springframework.webapp.repositories.BookRepository;
import com.springframework.webapp.repositories.PublisherRepository;
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

        System.out.println("Running Bootstrap!!!");

        Author dummyAuthor01 = new Author("Chetan", "Bhagat");
        Book dummyBook01 = new Book("Two States", "2342356112");

        dummyAuthor01.getBooks().add(dummyBook01);
        dummyBook01.getAuthors().add(dummyAuthor01);

        authorRepository.save(dummyAuthor01);
        bookRepository.save(dummyBook01);

        Author dummyAuthor02 = new Author("Arundhati", "Roy");
        Book dummyBook02 = new Book("The God of Small Things", "4686755211");

        dummyAuthor02.getBooks().add(dummyBook02);
        dummyBook02.getAuthors().add(dummyAuthor02);

        authorRepository.save(dummyAuthor02);
        bookRepository.save(dummyBook02);

        // "D-204, Astranium St., Delhi, New Delhi, ZIP-726123"
        Address dummyAddress01 = new Address("D-204, Astranium St.", "Delhi", "New Delhi", "726123");
        Publisher dummyPublisher01 = new Publisher("R.V.K. Publications");
        dummyPublisher01.setAddress(dummyAddress01);

        dummyBook01.setPublisher(dummyPublisher01);
        dummyPublisher01.getBooks().add(dummyBook01);

        publisherRepository.save(dummyPublisher01);

        // "32/A, Koylanagar, Dhanbad, Jharkhand, ZIP-826001"
        Address dummyAddress02 = new Address("32/A, Koylanagar", "Dhanbad", "Jharkhand", "826001");
        Publisher dummyPublisher02 = new Publisher("D.J. Sashi");
        dummyPublisher02.setAddress(dummyAddress02);

        dummyBook02.setPublisher(dummyPublisher01);
        dummyPublisher02.getBooks().add(dummyBook02);

        publisherRepository.save(dummyPublisher02);

        Book dummyBook03 = new Book("Shiva:Trilogy", "2536123123");
        Author dummyAuthor03 = new Author("Amit", "Trivedi");

        dummyAuthor03.getBooks().add(dummyBook03);
        dummyBook03.getAuthors().add(dummyAuthor03);
        dummyBook03.setPublisher(dummyPublisher01);
        dummyPublisher01.getBooks().add(dummyBook03);

        authorRepository.save(dummyAuthor03);
        bookRepository.save(dummyBook03);
        publisherRepository.save(dummyPublisher01);

        Book dummyBook04 = new Book("Five Point Someone", "123144322");
        dummyBook04.getAuthors().add(dummyAuthor01);
        dummyAuthor01.getBooks().add(dummyBook04);
        dummyBook04.setPublisher(dummyPublisher01);
        dummyPublisher01.getBooks().add(dummyBook04);

        authorRepository.save(dummyAuthor01);
        bookRepository.save(dummyBook04);
        publisherRepository.save(dummyPublisher01);

        System.out.println("Total number of books = " + bookRepository.count());
        System.out.println("Total number of publishers = " + publisherRepository.count());
        System.out.println("Total books of publisher 1 = " + dummyPublisher01.getBooks().size());

    }
}
