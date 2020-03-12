
package ccom.ews.idc_rest_client.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {

    public String phoneType;

    public String phoneNumber;

}
