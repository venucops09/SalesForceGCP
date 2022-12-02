package com.example.salesforcegcp.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FireStoreInitializer {

    @PostConstruct
    public void initialize() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("./sylvan-bonbon-367907-1b1f0ceb5aca.json");

        FirebaseOptions options=new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(fileInputStream)).build();

        FirebaseApp.initializeApp(options);
    }
}
