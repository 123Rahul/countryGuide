package com.ambeyindustry.countryguide;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<Country> loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream stream = context.getAssets().open("countries.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCountriesFromJSON(json);
    }

    private static ArrayList<Country> getCountriesFromJSON(String jsonString) {
        if (TextUtils.isEmpty(jsonString)) {
            return null;
        }

        String name;
        String capital;
        String domain;
        String region;
        String alpha2Code, alpha3Code;
        String timezone;
        String nativeName;
        String currency;
        String language;
        String demonym;
        String callingCode;
        String population;
        String lat, lng;
        String area;
        String gini;
        String flag;

        ArrayList<Country> countries = new ArrayList<>();
        Country country;
        try {
            JSONArray CountryArray = new JSONArray(jsonString);
            for (int i = 0; i < CountryArray.length(); i++) {
                JSONObject object = (JSONObject) CountryArray.getJSONObject(i);
                name = object.getString("name");
                capital = object.getString("capital");
                region = object.getString("region");
                alpha2Code = object.getString("alpha2Code");
                alpha3Code = object.getString("alpha3Code");
                timezone = object.getJSONArray("timezones").getString(0);
                nativeName = object.getString("nativeName");
                demonym = object.getString("demonym");
                population = object.getString("population");
                if (object.getJSONArray("callingCodes").length() > 0)
                    callingCode = object.getJSONArray("callingCodes").getString(0);
                else
                    callingCode = "-";
                currency = object.getJSONArray("currencies").getJSONObject(0).getString("name");
                language = object.getJSONArray("languages").getJSONObject(0).getString("name");
                domain = object.getJSONArray("topLevelDomain").getString(0);
                if (object.getJSONArray("latlng").length() > 0) {
                    lat = object.getJSONArray("latlng").getString(0);
                    lng = object.getJSONArray("latlng").getString(1);
                } else {
                    lat = "0";
                    lng = "0";
                }
                area = object.getString("area");
                gini = object.getString("gini");
                if (gini.equals("null"))
                    gini = "-";
                flag = alpha3Code.toLowerCase();
                country = new Country(name, capital, domain, region, alpha2Code, alpha3Code, timezone, nativeName,
                        currency, language, demonym, callingCode, population, lat, lng, area, gini, flag);
                countries.add(country);
            }
        } catch (JSONException exc) {
            Log.e("HttpUtil: ", exc.toString());
        }
        return countries;
    }
}
