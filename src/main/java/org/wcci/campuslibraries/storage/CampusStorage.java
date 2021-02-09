package org.wcci.campuslibraries.storage;

import org.springframework.stereotype.Service;
import org.wcci.campuslibraries.resources.Campus;

@Service
public class CampusStorage {

    private CampusRepository campusRepo;

    public CampusStorage(CampusRepository campusRepo) {
        this.campusRepo = campusRepo;
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
        campusRepo.deleteById(id);
    }
}
