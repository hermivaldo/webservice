package br.com.hermivaldo.webservice.util;

import br.com.hermivaldo.webservice.model.Livro;
import br.com.hermivaldo.webservice.model.LivroSaraiva;

public abstract class Conversores {

    public static Livro converTerSaraivaToLivro(LivroSaraiva livroSaraiva){

        Livro livro = new Livro();

        livro.setMarca(livroSaraiva.getBrand());
        livro.setNome(livroSaraiva.getName());
        livro.setSku(livroSaraiva.getSku());

        return livro;
    }
}
