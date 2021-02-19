package br.com.harisson.desafiocasadocodigo.model.request;

import br.com.harisson.desafiocasadocodigo.annotation.ExistById;
import br.com.harisson.desafiocasadocodigo.annotation.UniqueValue;
import br.com.harisson.desafiocasadocodigo.model.domain.Author;
import br.com.harisson.desafiocasadocodigo.model.domain.Book;
import br.com.harisson.desafiocasadocodigo.model.domain.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class BookPostRequestBody {

    @NotBlank(message = "The field 'title' is mandatory")
    @UniqueValue(domainClass = Book.class, fieldName = "title", message = "The title already taken")
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
    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "The ISBN already registered")
    private String isbn;
    @NotNull(message = "The field 'publicationDate' is mandatory")
    @Future(message = "It must be a future date")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private LocalDate publicationDate;
    @NotNull(message = "The field 'category' is mandatory")
    @ExistById(domainClass = Category.class, idFieldName = "id", message = "Category not found")
    private Long categoryId;
    @NotNull(message = "The field 'author' is mandatory")
    @ExistById(domainClass = Author.class, idFieldName = "id", message = "Author not found")
    private Long authorId;

    public BookPostRequestBody(@NotBlank String title,
                               @NotBlank @Size(max = 500) String introduction,
                               @NotNull String summary,
                               @DecimalMin(value = "20.0") Double price,
                               @Min(value = 100) @NotNull int pages,
                               @NotBlank String isbn,
                               @NotNull Long categoryId,
                               @NotNull Long authorId) {
        this.title = title;
        this.introduction = introduction;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public Book toBook(EntityManager entityManager) {
        Category category = entityManager.find(Category.class, this.categoryId);
        Author author = entityManager.find(Author.class, this.authorId);
        return new Book(this.title, this.introduction, this.summary, this.price, this.pages, this.isbn, this.publicationDate, category, author);
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

}
