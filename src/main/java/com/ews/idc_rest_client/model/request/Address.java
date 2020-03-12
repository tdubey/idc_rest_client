
package com.ews.idc_rest_client.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    public String street1;

    public String street2;

    public String city;

    public String state;

    public String zip;

    public String country;

}
