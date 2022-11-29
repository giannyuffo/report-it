package com.example.reportit.client.handlers;

public interface RestClientBaseResponseHandler {
    void requestDidFail(int statusCode);
}
