package com.ews.idc_rest_client.services;

import com.ews.idc_rest_client.model.OrchestrationResponse;
import com.ews.idc_rest_client.model.request.IdvRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;

@Service
public class IDCServiceImpl implements IDCService {

    RestTemplate restTemplate;

    private final String idcURI = "orchestrate/IDCONFIDENCE/v1.0/";

    @Value("${service.client.url}")
    private String servicesHostName;


    public IDCServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public OrchestrationResponse getResponse(IdvRequest request) {

        String resourceURL = servicesHostName + idcURI;

        ResponseEntity<OrchestrationResponse> response = restTemplate.exchange(resourceURL, HttpMethod.POST, new HttpEntity<IdvRequest>(request, getStandardHeaders()), OrchestrationResponse.class);

        return response.getBody();
    }

    private HttpHeaders getStandardHeaders() {
        HttpHeaders headers = new HttpHeaders();


        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        headers.set("x-earlywarning-tracking", "{\"tracking\": [ { \"id\": \"003\", \"type\": \"OrgReportingUnit\" }, { \"id\": \"S438439\", \"type\": \"InquirySystemTrackingIdentifier\" } ] }");
        headers.set("x-earlywarning-requesters", "{\"requesters\":{\"client\":\"122104817\",\"system\":\"01EEE4CC\"}}");


        return headers;
    }
}
