package br.com.harisson.desafiocasadocodigo.model.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookGetResponseBody {

    @NotNull
    private Long id;
    @NotBlank
    private String title;

    public BookGetResponseBody(@NotNull Long id, @NotBlank String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
