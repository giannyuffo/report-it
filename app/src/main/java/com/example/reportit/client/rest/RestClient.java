package com.example.reportit.client.rest;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reportit.client.rest.dtos.UserDTO;
import com.example.reportit.client.rest.handlers.CheckConnectionResponseHandler;
import com.example.reportit.client.rest.handlers.DefaultErrorHandler;
import com.example.reportit.client.rest.handlers.LoginResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {
    private RequestQueue queue;
    private Context context;

    //private final String REST_API_BASE_URL = "https://6385caa7beaa6458266881c9.mockapi.io/requestit/v1";
    private final String REST_API_BASE_URL = "https://api.simplecheck.es/v1";

    private static RestClient instance = null;

    private RestClient(Context context){
        this.queue = Volley.newRequestQueue(context);
        this.context = context;
    }
    public static RestClient getInstance(Context context){
        if(instance == null)
            instance = new RestClient(context);
        return instance;
    }

    public void checkConnection(CheckConnectionResponseHandler handler){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                REST_API_BASE_URL,
                null,
                response -> handler.requestDidComplete(true), new DefaultErrorHandler(handler)
        );
        queue.add(request);

    }

    public void postLoginUser(String code , String longitude, String latitude, LoginResponseHandler handler){
        JSONObject jsonBody = new JSONObject();
        try{
            jsonBody.put("code", code);
            jsonBody.put("longitude", longitude);
            jsonBody.put("latitude",latitude);
        }catch(JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                REST_API_BASE_URL + "/user",
                jsonBody,
                response -> {
                    UserDTO dto = new UserDTO(response);
                    handler.sessionRequestDidComplete(dto);
                },new DefaultErrorHandler(handler)
        );
        queue.add(request);
    }
    public void postReport(){

    }
}
