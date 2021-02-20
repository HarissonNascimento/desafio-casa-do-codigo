package br.com.harisson.desafiocasadocodigo.model.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookDetailsGetResponseBody {

    @NotBlank
    private String title;
    @NotNull
    private Double price;
    @NotBlank
    private String introduction;
    @NotBlank
    private String authorName;
    @NotBlank
    private String authorDescription;
    @NotNull
    private int pages;
    @NotBlank
    private String isbn;

    public BookDetailsGetResponseBody(@NotBlank String title,
                                      @NotNull Double price,
                                      @NotBlank String introduction,
                                      @NotBlank String authorName,
                                      @NotBlank String authorDescription,
                                      @NotNull int pages,
                                      @NotBlank String isbn) {
        this.title = title;
        this.price = price;
        this.introduction = introduction;
        this.authorName = authorName;
        this.authorDescription = authorDescription;
        this.pages = pages;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }
}
