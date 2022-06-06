package mx.com.bankaya.assessment.reposity.http;

import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Repository
public interface HttpClientDefinition {

    @GET("{name}")
    Call<PokeApiResponseDto> findPokemonInfoByName(@Path("name") String name);

}
