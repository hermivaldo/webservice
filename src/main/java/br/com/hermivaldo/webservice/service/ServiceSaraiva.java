package br.com.hermivaldo.webservice.service;

import br.com.hermivaldo.webservice.api.SaraivaAPI;
import br.com.hermivaldo.webservice.exception.RecursoNaoEncontrado;
import br.com.hermivaldo.webservice.model.LivroSaraiva;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.management.RuntimeErrorException;
import java.io.IOException;
import java.io.PrintStream;

public class ServiceSaraiva {

    public synchronized LivroSaraiva buscarSaraivaPorSKU(String sku) throws IOException {
        Retrofit build = new Retrofit.Builder()
                .baseUrl("https://api.saraiva.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SaraivaAPI saraivaAPI = build.create(SaraivaAPI.class);
        Call<LivroSaraiva> skuTask = saraivaAPI.getLivrosPorSKU(sku);
        LivroSaraiva livroSaraiva = skuTask.execute().body();
        validarLivro(livroSaraiva, sku);
        return livroSaraiva;
    }

    private void validarLivro(LivroSaraiva livroSaraiva, String sku){
        if (livroSaraiva.getSku() == null){
            throw new RecursoNaoEncontrado(LivroSaraiva.class.getSimpleName(), "SKU", sku);
        }
    }

}
