package com.example.reportit.client.rest.dtos;

import com.example.reportit.client.rest.helpers.JWUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class UserDTO {
    private String code;
    private String longitude;
    private String latitude;
    private String token;
    private JSONObject tokeDecoded;

    public UserDTO(JSONObject token){
        try{
            this.token = token.getString("token");
            this.tokeDecoded = JWUtils.decoded(this.token);

            this.code = tokeDecoded.getString("code");
            this.longitude = tokeDecoded.getString("longitude");
            this.latitude = tokeDecoded.getString("latitude");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getCode() {
        return code;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getToken() {
        return token;
    }
}
