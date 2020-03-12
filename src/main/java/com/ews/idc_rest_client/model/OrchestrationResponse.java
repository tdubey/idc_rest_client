package com.ews.idc_rest_client.model;

import java.io.Serializable;
import java.util.Map;

public class OrchestrationResponse implements Serializable {
    public Model model;
    public Map<String, String> scores;
    public Map<String, String> reasonCodes;
    public Map<String, String> otherVariables;
}
