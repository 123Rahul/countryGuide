package com.ambeyindustry.countryguide;

import android.os.Parcelable;

import java.io.Serializable;

public class Country implements Serializable {
    public String name;
    public String capital;
    public String domain;
    public String region;
    public String alpha2Code, alpha3Code;
    public String timezone;
    public String nativeName;
    public String currency;
    public String language;
    public String demonym;
    public String callingCode;
    public String population;
    public String lat, lng;
    public String area;
    public String gini;
    public String flag;

    public Country(String name, String capital, String domain, String region, String alpha2Code, String alpha3Code,
                   String timezone, String nativeName, String currency, String language, String demonym,
                   String callingCode, String population, String lat, String lng, String area, String gini, String flag) {
        this.name = name;
        this.capital = capital;
        this.domain = domain;
        this.region = region;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.timezone = timezone;
        this.nativeName = nativeName;
        this.currency = currency;
        this.language = language;
        this.demonym = demonym;
        this.callingCode = callingCode;
        this.population = population;
        this.lat = lat;
        this.lng = lng;
        this.area = area;
        this.gini = gini;
        this.flag = flag;
    }
}
