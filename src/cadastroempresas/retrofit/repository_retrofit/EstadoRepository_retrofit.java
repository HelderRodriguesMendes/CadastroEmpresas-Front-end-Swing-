/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroempresas.retrofit.repository_retrofit;

import cadastroempresas.retrofit.model_retrofit.Estado_retrofit;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author helde
 */
public interface EstadoRepository_retrofit {

    @GET("api/v1/localidades/estados")
    Call<List<Estado_retrofit>> getEstados();
}
