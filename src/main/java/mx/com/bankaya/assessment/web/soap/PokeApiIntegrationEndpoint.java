package mx.com.bankaya.assessment.web.soap;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesResponse;
import mx.com.bankaya.assessment.service.PokeApiIntegrationService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static mx.com.bankaya.assessment.util.Constants.SoapConstants.POKE_API_URI_NAMESPACE;

@Endpoint
@RequiredArgsConstructor
public class PokeApiIntegrationEndpoint {

    private final PokeApiIntegrationService pokeApiIntegrationService;

    @PayloadRoot(namespace = POKE_API_URI_NAMESPACE, localPart = "pokeApiAbilitiesRequest")
    @ResponsePayload
    public PokeApiAbilitiesResponse pokeApiAbilities(@RequestPayload PokeApiAbilitiesRequest req) {
        return pokeApiIntegrationService.getAbilities(req);
    }

}
