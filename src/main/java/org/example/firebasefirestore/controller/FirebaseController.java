package org.example.firebasefirestore.controller;

import lombok.RequiredArgsConstructor;
import org.example.firebasefirestore.service.FirebaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fire")
public class FirebaseController {

    // TODO: AOP exception handling

    private final FirebaseService firebaseService;

    @PostMapping
    public ResponseEntity<String> postDocument(@RequestParam String documentName) {
        try {
            String result = firebaseService.postDocument(documentName);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllDocuments() {
        try {
            String result = firebaseService.getAllDocuments();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/one")
    public ResponseEntity<String> getDocument(@RequestParam String documentName) {
        try {
            String result = firebaseService.getDocument(documentName);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
