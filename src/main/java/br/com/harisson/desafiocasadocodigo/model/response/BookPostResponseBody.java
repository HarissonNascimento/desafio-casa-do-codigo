package br.com.harisson.desafiocasadocodigo.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class BookPostResponseBody {


    private final String title;
    private final Double price;
    private final int pages;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private final LocalDate publicationDate;
    private final String authorName;
    private final String categoryName;

    public BookPostResponseBody(@NotBlank String title,
                                @DecimalMin(value = "20.0") Double price,
                                int pages,
                                @NotNull LocalDate publicationDate,
                                @NotBlank String authorName,
                                @NotBlank String categoryName) {
        this.title = title;
        this.price = price;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.authorName = authorName;
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
