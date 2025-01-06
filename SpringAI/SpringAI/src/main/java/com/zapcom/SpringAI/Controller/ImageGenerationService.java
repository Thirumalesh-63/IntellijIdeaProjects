package com.zapcom.SpringAI.Controller;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImageGenerationService {

    @Value("${huggingface.api.key}")
    private String apiKey;

    @Value("${huggingface.api.url}")
    private String apiUrl;

    private final OkHttpClient httpClient = new OkHttpClient();

    public byte[] generateImage(String prompt) throws IOException {
        String json = "{\"inputs\": \"" + prompt + "\"}";
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(apiUrl)
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return response.body().bytes();
//                throw new IOException("Unexpected code " + response);
            }
            return response.body().bytes();
        }
    }
}