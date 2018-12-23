package com.aakash.gmail.client.utils

import com.google.gson.Gson
import spark.ResponseTransformer

class JSONTransformer implements ResponseTransformer {

    Gson gson = new Gson()
    @Override
    String render(Object model) throws Exception {
        return gson.toJson(model)
    }
}
