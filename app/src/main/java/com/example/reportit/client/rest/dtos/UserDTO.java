package com.example.reportit.client.rest.dtos;

import com.example.reportit.client.rest.helpers.JWUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class UserDTO {
    private int userCode;
    private String code;
    private String longitude;
    private String latitude;
    private String token;
    private JSONObject tokenDecoded;

    public UserDTO(JSONObject token){
        try{
            this.token = token.getString("token");
            this.tokenDecoded = JWUtils.decoded(this.token);

            this.userCode = tokenDecoded.getInt("userCode");
            this.code = tokenDecoded.getString("code");
            this.longitude = tokenDecoded.getString("longitude");
            this.latitude = tokenDecoded.getString("latitude");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public int getUserCode() {
        return userCode;
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
