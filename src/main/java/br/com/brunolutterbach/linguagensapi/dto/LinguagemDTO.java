package br.com.brunolutterbach.linguagensapi.dto;

import br.com.brunolutterbach.linguagensapi.model.Linguagem;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class LinguagemDTO {

    private String title;
    private String image;

    public LinguagemDTO(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public static List<LinguagemDTO> converter(List<Linguagem> linguagens) {
        return linguagens.stream().map(linguagem -> new LinguagemDTO(linguagem.getTitle(), linguagem.getImage())).collect(toList());
    }
}

