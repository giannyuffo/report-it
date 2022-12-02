package com.example.reportit.client.rest.handlers;

public interface CheckConnectionResponseHandler extends RestClientBaseResponseHandler{
    void requestDidComplete(boolean response);
}
