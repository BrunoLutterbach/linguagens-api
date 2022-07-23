package br.com.brunolutterbach.linguagensapi.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "principaisLinguagens")
public class Linguagem {

    @Id
    private String id;
    private String title;
    private String image;
    private String ranking;
    private Integer votes;

    public Linguagem(String title, String image, String ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
        this.votes = 0;
    }

    public Linguagem() {

    }

    public void adicionarVoto() {
        this.votes++;
    }
}
