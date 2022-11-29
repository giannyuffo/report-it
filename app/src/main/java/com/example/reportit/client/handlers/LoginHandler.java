package com.example.reportit.client.handlers;


import com.example.reportit.client.dtos.UserDTO;

public interface LoginHandler extends RestClientBaseResponseHandler {
    void sessionRequestDidComplete(UserDTO dto);
}
