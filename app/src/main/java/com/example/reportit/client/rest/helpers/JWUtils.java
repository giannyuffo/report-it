package com.example.reportit.client.rest.helpers;

import android.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class JWUtils {
    public static JSONObject decoded(String JWTEncoded) {
        try {
            String[] split = JWTEncoded.split("\\.");
            return getJson(split[1]);
        } catch (UnsupportedEncodingException | JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject getJson(String strEncoded) throws UnsupportedEncodingException, JSONException {
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        String aux = new String(decodedBytes, StandardCharsets.UTF_8);
        return new JSONObject(aux);
    }
}
