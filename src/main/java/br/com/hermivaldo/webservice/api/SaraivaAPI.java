package br.com.hermivaldo.webservice.api;

import br.com.hermivaldo.webservice.model.LivroSaraiva;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SaraivaAPI {

    @GET("/sc/produto/pdp/{sku}/0/0/1/")
    public Call<LivroSaraiva> getLivrosPorSKU(@Path("sku") String sku);
}
