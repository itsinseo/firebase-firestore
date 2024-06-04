package org.example.firebasefirestore.service;

import java.util.concurrent.ExecutionException;

public interface FirebaseService {
    String postDocument(String documentName) throws ExecutionException, InterruptedException;

    String getAllDocuments() throws ExecutionException, InterruptedException;

    String getDocument(String documentName) throws ExecutionException, InterruptedException;
}
