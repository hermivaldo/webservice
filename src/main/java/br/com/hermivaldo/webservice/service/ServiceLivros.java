package br.com.hermivaldo.webservice.service;

import br.com.hermivaldo.webservice.exception.RecursoNaoEncontrado;
import br.com.hermivaldo.webservice.model.Livro;
import br.com.hermivaldo.webservice.model.LivroSaraiva;
import br.com.hermivaldo.webservice.repository.LivroRepository;
import br.com.hermivaldo.webservice.util.Conversores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLivros {

    @Autowired
    LivroRepository livroRepository;
    ServiceSaraiva serviceSaraiva;

    public ServiceLivros() {
        serviceSaraiva = new ServiceSaraiva();
    }

    public Livro salvarLivro(String sku) throws IOException {
        LivroSaraiva livroSaraiva = serviceSaraiva.buscarSaraivaPorSKU(sku);
        Livro livro = Conversores.converTerSaraivaToLivro(livroSaraiva);
        return livroRepository.save(livro);
    }


    public Livro buscarPorSKU(String sku){
        return livroRepository.findById(sku).orElseThrow(() ->
                new RecursoNaoEncontrado("Livro", "sku", sku));
    }

    public List<Livro> buscarTodos(){
        return livroRepository.findAll();
    }

    public List<Livro> buscarPorPrecoPorFaixa(double precoIni, double precoFin){
        return livroRepository.buscarLimitePreco(precoIni, precoFin);
    }

    public List<Livro> buscarPorLimite(int limite){
        return livroRepository.buscarPorLimite(limite);
    }

    public void deletarLivro(String sku){
        Livro livro = buscarPorSKU(sku);
        livroRepository.delete(livro);
    }
}
