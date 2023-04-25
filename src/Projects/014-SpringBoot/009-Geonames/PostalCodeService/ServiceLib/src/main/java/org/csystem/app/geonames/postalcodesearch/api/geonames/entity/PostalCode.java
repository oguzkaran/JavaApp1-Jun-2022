package org.csystem.app.geonames.postalcodesearch.api.geonames.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostalCode {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminCode2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminCode1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminName2;

    public double lng;

    public String countryCode;

    public String postalCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminName1;

    @JsonProperty("ISO3166-2")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String iSO31662;

    public String placeName;

    public double lat;
}
