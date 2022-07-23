package br.com.brunolutterbach.linguagensapi.controllers;

import br.com.brunolutterbach.linguagensapi.dto.LinguagemDTO;
import br.com.brunolutterbach.linguagensapi.dto.form.AtualizarLinguagem;
import br.com.brunolutterbach.linguagensapi.model.Linguagem;
import br.com.brunolutterbach.linguagensapi.repository.LinguagemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

    private final LinguagemRepository linguagemRepository;

    public LinguagemController(LinguagemRepository linguagemRepository) {
        this.linguagemRepository = linguagemRepository;
    }

    // Buscar por ranking
    @GetMapping({"/{ranking}"})
    public Optional<Linguagem> buscarPorRanking(@PathVariable String ranking) {
        return this.linguagemRepository.findByRanking(ranking);
    }

    // Listar todas as linguagens
    @GetMapping()
    public List<LinguagemDTO> listar() {
        List<Linguagem> linguagens = linguagemRepository.findAll(Sort.by("ranking"));
        return LinguagemDTO.converter(linguagens);
    }

    // Cadastrar uma linguagem
    @PostMapping()
    public ResponseEntity<Linguagem> cadastrar(@RequestBody Linguagem linguagem, UriComponentsBuilder uriBuilder) {
        linguagemRepository.save(linguagem);
        return ResponseEntity.created(uriBuilder.path("/linguagens/{ranking}").buildAndExpand(linguagem.getRanking()).toUri()).build();
    }

    // Atualizar uma linguagem
    @PutMapping("/{ranking}")
    public ResponseEntity<Linguagem> atualizar(@PathVariable String ranking, @RequestBody AtualizarLinguagem form) {
        Optional<Linguagem> optional = linguagemRepository.findByRanking(ranking);
        if (optional.isPresent()) {
            Linguagem linguagem = form.atualizar(ranking, linguagemRepository);
            linguagemRepository.save(linguagem);
            return ResponseEntity.ok(linguagem);
        }
        return ResponseEntity.notFound().build();
    }

    // Adicionar votos a uma linguagem a cada acesso pelo nome
    @PatchMapping("/{title}")
    public ResponseEntity<Linguagem> adicionarVotes(@PathVariable String title) {
        Optional<Linguagem> optional = Optional.ofNullable(linguagemRepository.findByTitle(title));
        if (optional.isPresent()) {
            Linguagem linguagem = optional.get();
            if (linguagem.getVotes() == null) {
                linguagem.setVotes(1);
            } else {
                linguagem.adicionarVoto();
            }
            linguagemRepository.save(linguagem);
            return ResponseEntity.ok(linguagem);
        }
        return ResponseEntity.notFound().build();
    }


    // Deletar uma linguagem
    @DeleteMapping("/{ranking}")
    public ResponseEntity<Void> deletar(@PathVariable String ranking) {
        Optional<Linguagem> optional = linguagemRepository.findByRanking(ranking);
        if (optional.isPresent()) {
            linguagemRepository.delete(optional.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
