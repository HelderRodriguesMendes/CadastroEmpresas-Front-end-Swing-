/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroempresas.retrofit.repository_retrofit;

import java.util.List;
import model.City;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author helde
 */
public interface CityRepository {
    @GET("/city/findAllCityState/name?")
    Call<List<City>> getCitysCadastrados_state(@Query("name") String name);
    
    @POST("/city/cadastrar")
    Call<Boolean> salvar(@Body City city);
    
    @PUT("/city/alterar/{id}")
    Call<Boolean> alterar(@Path("id") Long id, @Body City city);
    
    @GET("/city/findAllCity")
    Call<List<City>> getCitysCadastrados();
    
    @GET("/city/findAllCity/name")
    Call<List<City>> getCitysCadastrados_name(@Query("name") String name);
}
