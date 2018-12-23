package com.aakash.mail.client;

import static spark.Spark.get;

public class EmailService {
    public static void main(String[] args) {
        get("/login", (request, response) -> "Hello login");

    }
}
