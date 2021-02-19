package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.BookPostResponseBody;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The field 'title' is mandatory")
    private String title;
    @NotBlank(message = "The field 'introduction' is mandatory")
    @Size(max = 500)
    private String introduction;
    @NotNull
    private String summary;
    @DecimalMin(value = "20.0", message = "The field 'price' is mandatory and has minimum value of 20.0")
    private Double price;
    @Min(value = 100, message = "The minimum number of pages is 100")
    @NotNull(message = "The field 'pages' is mandatory")
    private int pages;
    @NotBlank(message = "The field 'isbn' is mandatory")
    private String isbn;
    @NotNull(message = "The field 'publicationDate' is mandatory")
    private LocalDate publicationDate;
    @NotNull(message = "The field 'category' is mandatory")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @NotNull(message = "The field 'author' is mandatory")
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
}
