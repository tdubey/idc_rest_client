package com.ews.idc_rest_client.services;

import com.ews.idc_rest_client.model.OrchestrationResponse;
import com.ews.idc_rest_client.model.request.IdvRequest;

public interface IDCService {

    OrchestrationResponse getResponse(IdvRequest request);
}
