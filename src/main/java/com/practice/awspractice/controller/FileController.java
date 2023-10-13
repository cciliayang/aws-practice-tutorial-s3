package com.practice.awspractice.controller;

import com.amazonaws.HttpMethod;
import com.practice.awspractice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/uploadfile")
    public ResponseEntity<String> generateUrl(@RequestParam String extension) {
        return ResponseEntity.ok(fileService.generatePreSignedUrl(
                UUID.randomUUID()+"."+extension, HttpMethod.PUT));
    }

    @GetMapping("/getfileurl")
    public ResponseEntity<String> getUrl(@RequestParam String filename) {
        return ResponseEntity.ok(fileService.generatePreSignedUrl(
                filename, HttpMethod.GET));
    }

}