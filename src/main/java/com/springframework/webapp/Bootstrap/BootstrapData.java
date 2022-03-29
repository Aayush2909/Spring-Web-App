package com.springframework.webapp.Bootstrap;

import com.springframework.webapp.Utils.Address;
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

        Author dummyAuthor01 = new Author("Chetan", "Bhagat");
        Book dummyBook01 = new Book("Two States", "2342356112");

        dummyAuthor01.getBooks().add(dummyBook01);
        dummyBook01.getAuthors().add(dummyAuthor01);

        authorRepository.save(dummyAuthor01);
        bookRepository.save(dummyBook01);

        Author dummyAuthor02 = new Author("Arundhati", "Roy");
        Book dummyBook02 = new Book("The God of Small Things", "4686755211");

        dummyAuthor01.getBooks().add(dummyBook02);
        dummyBook01.getAuthors().add(dummyAuthor02);

        authorRepository.save(dummyAuthor02);
        bookRepository.save(dummyBook02);

        System.out.println("Running Bootstrap!!!");
        System.out.println("Total number of books = " + bookRepository.count());

        // "D-204, Astranium St., Delhi, New Delhi, ZIP-726123"
        Address dummyAddress01 = new Address("D-204, Astranium St.", "Delhi", "New Delhi", "726123");
        Publisher dummyPublisher01 = new Publisher("R.V.K. Publications");
        dummyPublisher01.setAddress(dummyAddress01);

        publisherRepository.save(dummyPublisher01);

        // "32/A, Koylanagar, Dhanbad, Jharkhand, ZIP-826001"
        Address dummyAddress02 = new Address("32/A, Koylanagar", "Dhanbad", "Jharkhand", "826001");
        Publisher dummyPublisher02 = new Publisher("D.J. Sashi");
        dummyPublisher02.setAddress(dummyAddress02);

        publisherRepository.save(dummyPublisher02);

        System.out.println("Total number of publishers = " + publisherRepository.count());
    }
}
