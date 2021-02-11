package org.wcci.campuslibraries.storage;

import org.springframework.stereotype.Service;
import org.wcci.campuslibraries.resources.Book;
import org.wcci.campuslibraries.resources.Campus;

@Service
public class CampusStorage {

    private CampusRepository campusRepo;
    private BookRepository bookRepo;

    public CampusStorage(CampusRepository campusRepo, BookRepository bookRepo) {
        this.campusRepo = campusRepo;
        this.bookRepo = bookRepo;
    }

    public Campus retrieveCampusById(Long id) {
        return campusRepo.findById(id).get();
    }

    public Iterable<Campus> retrieveAllCampuses() {
        return campusRepo.findAll();
    }

    public void saveCampus(Campus campusToSave) {
        campusRepo.save(campusToSave);
    }

    public void deleteCampousById(Long id) {
        Campus tempCampus = retrieveCampusById(id);
        for (Book tempBook : tempCampus.getBooks()) {
            bookRepo.delete(tempBook);
        }
        campusRepo.deleteById(id);
    }
}
