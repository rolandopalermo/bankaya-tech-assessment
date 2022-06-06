package mx.com.bankaya.assessment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.exceptions.InternalServerException;
import mx.com.bankaya.assessment.reposity.http.HttpClientDefinition;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokeApiService {

    private final Retrofit retrofit;

    public PokeApiResponseDto findFirstPokemonInfoByName(String pokemonName) {
        try {
            Response<PokeApiResponseDto> response = retrofit.create(HttpClientDefinition.class).findPokemonInfoByName(pokemonName).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                log.error("[findFirstPokemonInfoByName] Pokemon information for name {} is not available: {}", pokemonName, getErrorMessage(response.errorBody()));
                return null;
            }
        } catch (IOException ex) {
            log.error("[findFirstPokemonInfoByName] Unable to fetch pokemon info for name: {}", pokemonName, ex);
            throw new InternalServerException("Unable to fetch pokemon info");
        }
    }

    private String getErrorMessage(ResponseBody responseBody) throws IOException {
        return responseBody == null ? "" : responseBody.string();
    }

}
