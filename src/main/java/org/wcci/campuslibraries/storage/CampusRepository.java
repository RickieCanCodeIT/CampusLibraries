package org.wcci.campuslibraries.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.campuslibraries.resources.Campus;

public interface CampusRepository extends CrudRepository<Campus, Long> {

}
