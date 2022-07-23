package br.com.brunolutterbach.linguagensapi.dto.form;

import br.com.brunolutterbach.linguagensapi.model.Linguagem;
import br.com.brunolutterbach.linguagensapi.repository.LinguagemRepository;
import lombok.Data;

@Data
public class AtualizarLinguagem {

    private String title;
    private String image;
    private String ranking;


    public Linguagem atualizar(String ranking, LinguagemRepository linguagemRepository) {
        Linguagem linguagem = linguagemRepository.getReferenceByRanking(ranking);
        linguagem.setTitle(this.title);
        linguagem.setImage(this.image);
        linguagem.setRanking(this.ranking);
        return linguagem;
    }



}
