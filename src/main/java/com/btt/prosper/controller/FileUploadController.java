package com.btt.prosper.controller;


import com.btt.prosper.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class FileUploadController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String bucketName = "prosper-btt-test";
        String key = file.getOriginalFilename(); // You can customize the key as needed

        String eTag = null;
        try {
            eTag = s3Service.uploadFile(bucketName, key, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("File uploaded successfully. ETag: " + eTag);
    }

    @GetMapping("/download/{key}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String key) {
        String bucketName = "prosper-btt-test";
        byte[] res = s3Service.downloadFile(bucketName, key);
        return ResponseEntity.ok().contentType(MediaType.valueOf("image/jpeg")).body(res);

    }
}
