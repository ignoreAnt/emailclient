package com.aakash.gmail.client.utils;

import com.aakash.gmail.client.service.UserService;

import static spark.Spark.get;

public class Routes {

    private Routes(){}

    public static void init() {
        get("/hello",(request, response) -> "Hello World!");
        get("/users",(request, response) -> UserService.getAllUsers(), new JSONTransformer());
    }
}
