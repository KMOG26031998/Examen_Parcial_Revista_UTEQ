package com.example.examenparcial;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Servidor {
    @GET("journals.php")
    Call<List<Revistas>> getRevistas();
}
