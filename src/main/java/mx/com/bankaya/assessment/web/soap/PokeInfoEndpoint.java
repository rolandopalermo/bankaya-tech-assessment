package mx.com.bankaya.assessment.web.soap;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesResponse;
import mx.com.bakaya.soap.tech_assestment.PokeApiBaseExperienceRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiBaseExperienceResponse;
import mx.com.bakaya.soap.tech_assestment.PokeApiHeldItemsRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiHeldItemsResponse;
import mx.com.bakaya.soap.tech_assestment.PokeApiIdRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiIdResponse;
import mx.com.bankaya.assessment.service.PokeInfoService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static mx.com.bankaya.assessment.util.Constants.SoapConstants.POKE_API_URI_NAMESPACE;

@Endpoint
@RequiredArgsConstructor
public class PokeInfoEndpoint {

    private final PokeInfoService pokeInfoService;

    @PayloadRoot(namespace = POKE_API_URI_NAMESPACE, localPart = "pokeApiAbilitiesRequest")
    @ResponsePayload
    public PokeApiAbilitiesResponse pokeApiAbilities(@RequestPayload PokeApiAbilitiesRequest req) {
        return pokeInfoService.getAbilities(req);
    }

    @PayloadRoot(namespace = POKE_API_URI_NAMESPACE, localPart = "pokeApiBaseExperienceRequest")
    @ResponsePayload
    public PokeApiBaseExperienceResponse pokeApiBaseExperience(@RequestPayload PokeApiBaseExperienceRequest req) {
        return pokeInfoService.getBaseExperience(req);
    }

    @PayloadRoot(namespace = POKE_API_URI_NAMESPACE, localPart = "pokeApiHeldItemsRequest")
    @ResponsePayload
    public PokeApiHeldItemsResponse pokeApiHeldItems(@RequestPayload PokeApiHeldItemsRequest req) {
        return pokeInfoService.getHeldItems(req);
    }

    @PayloadRoot(namespace = POKE_API_URI_NAMESPACE, localPart = "pokeApiIdRequest")
    @ResponsePayload
    public PokeApiIdResponse pokeApiId(@RequestPayload PokeApiIdRequest req) {
        return pokeInfoService.getId(req);
    }

}
