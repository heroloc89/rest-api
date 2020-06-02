package com.example.restapi.services.impl;

import com.example.restapi.services.AuthorizationService;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.util.store.FileDataStoreFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizationServiceImpl implements AuthorizationService {
    private GoogleAuthorizationCodeFlow flow;
    private FileDataStoreFactory dataStoreFactory;

    @Override
    public boolean isUserAuthenticated() throws Exception {
        return false;
    }

    @Override
    public Credential getCredentials() throws IOException {
        return null;
    }

    @Override
    public String authenticateUserViaGoogle() throws Exception {
        return null;
    }

    @Override
    public void exchangeCodeForTokens(String code) throws Exception {

    }

    @Override
    public void removeUserSession(HttpServletRequest request) throws Exception {

    }
}
