package com.atlantico.user.gateway.service;

public interface MessageService {

    void sendMessage(String queue, Object message);
}
