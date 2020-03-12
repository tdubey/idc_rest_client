
package com.ews.idc_rest_client.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Identification {

    public String idType;

    public String idValue;

    public String idState;

    public String idCountry;

}
