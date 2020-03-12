
package com.ews.idc_rest_client.model.request;

import java.util.List;

public class IdvRequest {

    public String taxId;

    public String lastName;

    public String middleName;

    public String firstName;

    public String dob;

    public List<Identification> identifications = null;

    public List<Address> addresses = null;

    public List<ccom.ews.idc_rest_client.model.request.Phone> phones = null;

}
