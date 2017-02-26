package com.fizzbuzz.controller;

public class JsonResponse {

    private final String result;

    public JsonResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
