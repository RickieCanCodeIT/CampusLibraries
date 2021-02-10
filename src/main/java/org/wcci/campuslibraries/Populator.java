package org.wcci.campuslibraries;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.campuslibraries.resources.Author;
import org.wcci.campuslibraries.resources.Book;
import org.wcci.campuslibraries.resources.Campus;
import org.wcci.campuslibraries.storage.AuthorRepository;
import org.wcci.campuslibraries.storage.BookRepository;
import org.wcci.campuslibraries.storage.CampusStorage;

@Component
public class Populator implements CommandLineRunner {

    private CampusStorage campusStorage;
    private AuthorRepository authorRepo;
    private BookRepository bookRepo;

    public Populator(CampusStorage campusStorage, AuthorRepository authorRepo, BookRepository bookRepo) {
        this.campusStorage = campusStorage;
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Campus columbus = new Campus("Columbus", "Java");
        campusStorage.saveCampus(columbus);
        Campus cleveland = new Campus("Cleveland", "C#");
        campusStorage.saveCampus(cleveland);
        Campus moon = new Campus("THE MOON", "Ruby");
        campusStorage.saveCampus(moon);
        Campus canada = new Campus("Italy", "Ruby");
        campusStorage.saveCampus(canada);

        Author kathySierra = new Author("Kathy Sierra");
        authorRepo.save(kathySierra);
        Author bertBates = new Author("Bert Bates");
        authorRepo.save(bertBates);
        Author ericFreeman = new Author("ericFreeman");
        authorRepo.save(ericFreeman);
        Author elisabethRobson = new Author("Elisabeth Robson");
        authorRepo.save(elisabethRobson);
        Author kent = new Author("Kent Beck");
        authorRepo.save(kent);
        Author martin = new Author("Martin Fowler");
        authorRepo.save(martin);
        Author sandi = new Author("Sandi Metz");
        authorRepo.save(sandi);

        bookRepo.save(new Book(columbus, "Head First Java", "Head First Java is a complete learning experience in Java and object-oriented programming.",
                true, kathySierra, bertBates));
        bookRepo.save(new Book(columbus, "Head First Design Patterns", "At any given moment, someone struggles with " +
                "the same software design problems you have.  And, chances are, someone has already solved your " +
                "problem.  This edition of Head First Design Patterns shows you tried-and-true, road-tested patterns " +
                "used by developers to create functional, elegant, reusable, and flexible software.", true,
                ericFreeman, elisabethRobson));
        bookRepo.save(new Book(columbus, "Test Driven Development By Example", "The first book on TDD, a pillar that " +
                "still stands to this day on the topic.", true, kent));
        bookRepo.save(new Book(columbus, "Refactoring", "A treatise on reformatting code, code smells, and good design " +
                "idioms", true, martin));
        bookRepo.save(new Book(cleveland, "Test Driven Development By Example", "The first book on TDD, a pillar that " +
                "still stands to this day on the topic.", true, kent));
        bookRepo.save(new Book(canada, "Refactoring", "A treatise on reformatting code, code smells, and good design " +
                "idioms", true, martin));
        bookRepo.save(new Book(moon, "Practical Object-Oriented Design in Ruby", "A great read on object-oriented " +
                "programming and testing.", true, sandi));
        bookRepo.save(new Book(moon, "99 Bottles of OOP: A Practical Guide to Object-Oriented Design Using Ruby",
                "99 Bottles of OOP is a practical guide to writing cost-effective, maintainable, and pleasing " +
                        "object-oriented code.", true, sandi));
        bookRepo.save(new Book(moon, "Test Driven Development By Example", "The first book on TDD, a pillar that " +
                "still stands to this day on the topic.", true, kent));
        bookRepo.save(new Book(moon, "Refactoring", "A treatise on reformating code, code smells, and good design " +
                "idioms", true, martin));
    }
}
