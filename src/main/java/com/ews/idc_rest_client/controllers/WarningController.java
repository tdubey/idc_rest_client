package com.ews.idc_rest_client.controllers;

import com.ews.idc_rest_client.model.OrchestrationResponse;
import com.ews.idc_rest_client.model.request.IdvRequest;
import com.ews.idc_rest_client.services.IDCService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/warnings")
public class WarningController {

    IDCService idcService;

    public WarningController(IDCService idcService) {
        this.idcService = idcService;
    }

    @PostMapping
    public OrchestrationResponse getResponse(@RequestBody IdvRequest idvRequest)
    {
        return idcService.getResponse(idvRequest);
    }
}
