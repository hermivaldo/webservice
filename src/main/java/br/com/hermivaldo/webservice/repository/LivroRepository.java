package br.com.hermivaldo.webservice.repository;


import br.com.hermivaldo.webservice.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {


    @Query(value = "SELECT * FROM livro LIMIT ?1", nativeQuery = true)
    List<Livro> buscarPorLimite(int limit);

    @Query(value = "SELECT * FROM `livro` WHERE preco in (?1, ?2) ", nativeQuery = true)
    List<Livro> buscarLimitePreco(double precoIni, double precoFin);
}
