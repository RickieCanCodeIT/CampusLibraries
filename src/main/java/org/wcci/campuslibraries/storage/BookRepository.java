package org.wcci.campuslibraries.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.campuslibraries.resources.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
