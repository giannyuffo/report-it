package com.example.reportit.client.handlers;


import com.example.reportit.client.dtos.UserDTO;

public interface LoginResponseHandler extends RestClientBaseResponseHandler {
    void sessionRequestDidComplete(UserDTO dto);
}
