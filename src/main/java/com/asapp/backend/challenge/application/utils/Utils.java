package com.asapp.backend.challenge.application.utils;

import com.asapp.backend.challenge.application.exceptions.MalformedURIException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Utils {

    public static void validateURI(String url) {
        try {
            new URL(url).toURI();
        } catch (URISyntaxException | MalformedURLException e) {
            throw new MalformedURIException(e.getMessage());
        }
    }

}
