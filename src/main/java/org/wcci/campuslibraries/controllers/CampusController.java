package org.wcci.campuslibraries.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.campuslibraries.resources.Author;
import org.wcci.campuslibraries.resources.Book;
import org.wcci.campuslibraries.resources.Campus;
import org.wcci.campuslibraries.storage.AuthorRepository;
import org.wcci.campuslibraries.storage.BookRepository;
import org.wcci.campuslibraries.storage.CampusStorage;

@RestController
public class CampusController {

    private CampusStorage campusStorage;
    private BookRepository bookRepo;
    private AuthorRepository authorRepo;

    public CampusController(CampusStorage campusStorage, BookRepository bookRepo, AuthorRepository authorRepo) {
        this.campusStorage = campusStorage;
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @GetMapping("/api/campuses")
    public Iterable<Campus> retrieveAllCampuses() {
        return campusStorage.retrieveAllCampuses();
    }

    @GetMapping("/api/campuses/{id}")
    public Campus retrieveCampusById(@PathVariable Long id) {
        return campusStorage.retrieveCampusById(id);
    }

    @PostMapping("/api/campuses")
    public Iterable<Campus> addCampus(@RequestBody Campus campusToAdd) {
        campusStorage.saveCampus(campusToAdd);
        return campusStorage.retrieveAllCampuses();
    }
    @PutMapping("/api/campuses")
    public Iterable<Campus> editCampus(@RequestBody Campus campusToEdit){
        if(campusToEdit.getId()!=null){
            campusStorage.saveCampus(campusToEdit);
        }
        return campusStorage.retrieveAllCampuses();
    }

    @PatchMapping("/api/campuses/{id}/location")
    public Campus changeCampusLocation(@RequestBody String newLocation, @PathVariable Long id){
        Campus campusToChangeName = campusStorage.retrieveCampusById(id);
        campusToChangeName.changeLocation(newLocation);
        campusStorage.saveCampus(campusToChangeName);
        return campusToChangeName;
    }

    @PatchMapping("/api/campuses/{id}/books")
    public Campus changeCampusLocation(@RequestBody Book newBook, @PathVariable Long id){
        for (Author tempAuthor: newBook.getAuthors()) {
            authorRepo.save(tempAuthor);
        }
        Campus campusToAddBook = campusStorage.retrieveCampusById(id);
        newBook.addCampus(campusToAddBook);
        bookRepo.save(newBook);
        return campusToAddBook;
    }


    @DeleteMapping("/api/campuses/{id}")
    public Iterable<Campus> deleteCampusById(@PathVariable Long id) {
        campusStorage.deleteCampousById(id);
        return campusStorage.retrieveAllCampuses();
    }
}
