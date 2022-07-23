package br.com.brunolutterbach.linguagensapi.repository;

import br.com.brunolutterbach.linguagensapi.model.Linguagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {

    Optional<Linguagem> findByRanking(String ranking);

    Linguagem getReferenceByRanking(String ranking);

    Linguagem findFirstByOrderByRankingDesc();

    Linguagem findByTitle(String title);

    Optional<Linguagem> findIdByRanking(String ranking);
}
