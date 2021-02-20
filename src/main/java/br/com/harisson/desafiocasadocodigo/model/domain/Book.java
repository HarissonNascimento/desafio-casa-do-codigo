package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.BookDetailsGetResponseBody;
import br.com.harisson.desafiocasadocodigo.model.response.BookGetResponseBody;
import br.com.harisson.desafiocasadocodigo.model.response.BookPostResponseBody;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false, length = 500)
    private String introduction;
    @Column(nullable = false)
    private String summary;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private int pages;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private LocalDate publicationDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(@NotBlank String title,
                @NotBlank @Size(max = 500) String introduction,
                @NotNull String summary,
                @DecimalMin(value = "20.0") Double price,
                @Min(value = 100) @NotNull int pages,
                @NotBlank String isbn, @NotNull LocalDate publicationDate,
                @NotNull Category category,
                @NotNull Author author) {
        this.title = title;
        this.introduction = introduction;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    @Deprecated
    protected Book() {
    }

    public BookPostResponseBody toBookPostResponseBody() {
        return new BookPostResponseBody(this.title, this.price, this.pages, this.publicationDate, this.author.getName(), this.category.getName());
    }

    public BookGetResponseBody toBookGetResponseBody() {
        return new BookGetResponseBody(this.id, this.title);
    }

    public BookDetailsGetResponseBody toBookDetailsGetResponseBody() {
        return new BookDetailsGetResponseBody(this.title, this.price, this.introduction, this.author.getName(), this.author.getDescription(), this.pages, this.isbn);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getSummary() {
        return summary;
    }

    public Double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
