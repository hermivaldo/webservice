package br.com.hermivaldo.webservice.controller;


import br.com.hermivaldo.webservice.exception.RecursoNaoEncontrado;
import br.com.hermivaldo.webservice.model.Livro;
import br.com.hermivaldo.webservice.model.LivroSaraiva;
import br.com.hermivaldo.webservice.service.ServiceLivros;
import br.com.hermivaldo.webservice.service.ServiceSaraiva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.hermivaldo.webservice.repository.LivroRepository;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class LivroController {

    @Autowired
    ServiceLivros serviceLivros;

    @GetMapping("/book")
    public List<Livro> getList() throws IOException {
        return serviceLivros.buscarTodos();
    }

    @PostMapping("/book")
    public Livro criarLivro(@Valid @RequestBody String sku) throws IOException {
        return serviceLivros.salvarLivro(sku);
    }

    @GetMapping(value = "/book/{sku}")
    public Livro buscarPorSKU(@PathVariable(value = "sku") String sku){
        return serviceLivros.buscarPorSKU(sku);
    }

    @GetMapping(value = "/book/limite/{limite}")
    public List<Livro> buscarPorLimite(@PathVariable(value = "limite") int limite){
        return serviceLivros.buscarPorLimite(limite);
    }

    @GetMapping(value = "/book/{precoIni}/{precoFim}")
    public List<Livro> buscarPorFaixaPreco(@PathVariable(value = "precoIni") int precoIni,
                                           @PathVariable(value = "precoFim") int precoFin){
        return serviceLivros.buscarPorPrecoPorFaixa(precoIni, precoFin);
    }

    @DeleteMapping(value = "/book/{sku}")
    public ResponseEntity<?> deletarLivro(@PathVariable(value = "sku") String sku){
        return ResponseEntity.ok().build();
    }



}
