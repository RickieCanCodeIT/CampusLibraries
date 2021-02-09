package org.wcci.campuslibraries.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "authors")
    @JsonIgnore
    private Set<Book> books;

    protected Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public Set<Book> getBooks() {
        return books;
    }
}
