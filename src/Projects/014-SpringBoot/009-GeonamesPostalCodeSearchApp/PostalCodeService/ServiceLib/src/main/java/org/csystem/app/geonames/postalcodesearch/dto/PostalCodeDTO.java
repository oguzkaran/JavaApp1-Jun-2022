package org.csystem.app.geonames.postalcodesearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PostalCodeDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminCode2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminCode1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminName2;

    public double longitude;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminName1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String plate;

    public String placeName;

    public double latitude;
}
