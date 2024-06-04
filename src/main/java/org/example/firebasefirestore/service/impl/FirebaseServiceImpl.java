package org.example.firebasefirestore.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.example.firebasefirestore.entity.DeliveryFood;
import org.example.firebasefirestore.service.FirebaseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseServiceImpl implements FirebaseService {

    // TODO: null checking

    @Override
    public String postDocument(String documentName) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = firestore.collection("documents").document(documentName);
        Map<String, Object> data = new HashMap<>();
        DeliveryFood deliveryFood = DeliveryFood.builder()
                .type("chicken")
                .brand("KFC")
                .price(1500L)
                .build();
        data.put("deliveryFood", deliveryFood);
        ApiFuture<WriteResult> writeResult = documentReference.set(data);

        return String.valueOf(writeResult.get());
    }

    @Override
    public String getAllDocuments() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> query = firestore.collection("documents").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        StringBuilder sb = new StringBuilder();
        for (QueryDocumentSnapshot document : documents) {
            sb.append(document.getId()).append('\n');
            sb.append(document.getData()).append('\n');
        }

        return sb.toString();
    }

    @Override
    public String getDocument(String documentName) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = firestore.collection("documents").document(documentName).get();

        return String.valueOf(documentSnapshotApiFuture.get().getData());
    }
}
