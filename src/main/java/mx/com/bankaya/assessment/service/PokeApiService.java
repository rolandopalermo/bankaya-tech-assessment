package mx.com.bankaya.assessment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.exceptions.ServiceFault;
import mx.com.bankaya.assessment.exceptions.ServiceFaultException;
import mx.com.bankaya.assessment.reposity.http.HttpClientDefinition;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static mx.com.bankaya.assessment.util.Constants.SoapConstants.ERROR;

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
                String errorMessage = getErrorMessage(response.errorBody());
                log.error("[findFirstPokemonInfoByName] Pokemon information for name {} is not available: {}", pokemonName, errorMessage);
                throw new ServiceFaultException(ERROR, new ServiceFault(
                        errorMessage, "Pokemon information for name " + pokemonName + " is not available"));
            }
        } catch (Exception ex) {
            log.error("[findFirstPokemonInfoByName] Unable to fetch pokemon info for name: {}", pokemonName, ex);
            throw new ServiceFaultException(ERROR, new ServiceFault(
                    "INTERNAL_SERVER_ERROR", "Unable to fetch pokemon info for name " + pokemonName));
        }
    }

    private String getErrorMessage(ResponseBody responseBody) throws IOException {
        return responseBody == null ? "" : responseBody.string();
    }

}
