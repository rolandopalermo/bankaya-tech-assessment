package mx.com.bankaya.assessment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class RetrofitConfig {

    @Value("${pokemon.api.base-url}")
    private String pokeApiBaseUrl;

    private final ObjectMapper objectMapper;

    @Bean
    public Retrofit pokemonRetrofit() {
        return new Retrofit.Builder().baseUrl(pokeApiBaseUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(okHttpClient())
                .build();
    }

    private OkHttpClient okHttpClient() {
        return new OkHttpClient
                .Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                //.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

}
