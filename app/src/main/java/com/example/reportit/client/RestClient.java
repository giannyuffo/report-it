package com.example.reportit.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.reportit.client.dtos.UserDTO;
import com.example.reportit.client.handlers.DefaultErrorHandler;
import com.example.reportit.client.handlers.LoginHandler;

import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {
    private RequestQueue queue;
    private Context context;

    private final String REST_API_BASE_URL = "https://6385caa7beaa6458266881c9.mockapi.io/requestit/v1/";

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

    public void postLoginUser(String latitude, String longitude, LoginHandler handler){
        JSONObject jsonBody = new JSONObject();
        try{
            jsonBody.put("latitude",latitude);
            jsonBody.put("longitude", longitude);
        }catch(JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                REST_API_BASE_URL + "user",
                jsonBody,
                response -> {
                    UserDTO dto = new UserDTO();
                    SharedPreferences sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.apply();
                    handler.sessionRequestDidComplete(dto);
                },new DefaultErrorHandler(handler)
        );
        queue.add(request);
    }
}
