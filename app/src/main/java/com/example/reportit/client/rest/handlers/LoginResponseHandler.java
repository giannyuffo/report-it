package com.example.reportit.client.rest.handlers;


import com.example.reportit.client.rest.dtos.UserDTO;

public interface LoginResponseHandler extends RestClientBaseResponseHandler {
    void sessionRequestDidComplete(UserDTO dto);
}
