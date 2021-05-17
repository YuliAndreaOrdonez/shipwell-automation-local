package com.shipwell.pojos.imagine;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Imaging {
        @Builder.Default
        private String file = "";
        @Builder.Default
        private String shipment_id = "";
        @Builder.Default
        private String document_type = "";
        @Builder.Default
        private String extension_type = "";

}
