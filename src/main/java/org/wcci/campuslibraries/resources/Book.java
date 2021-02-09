package org.wcci.campuslibraries.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
@Entity
public class Book {
    @ManyToOne
    @JsonIgnore
    private Campus campus;
    private String title;
    @Lob
    private String summary;
    private boolean available;
    @ManyToMany
    private Set<Author> authors;
    @Id
    @GeneratedValue
    private Long id;

    protected Book(){}
    public Book(Campus campus, String title, String summary, boolean available, Author... authors) {
        this.campus = campus;
        this.title = title;
        this.summary = summary;
        this.available = available;
        this.authors = Set.of(authors);
    }

    public Campus getCampus() {
        return campus;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public boolean isAvailable() {
        return available;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "campus=" + campus +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", available=" + available +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return available == book.available &&
                Objects.equals(campus, book.campus) &&
                Objects.equals(title, book.title) &&
                Objects.equals(summary, book.summary) &&
                Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campus, title, summary, available, id);
    }
}
