package com.voenmeh.voenmehpearl.controller;

import com.voenmeh.voenmehpearl.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/pearl/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile){
        try{
        fileService.uploadFile(uploadFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("File upload failed");
        }
    }
    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("hello");
    }
}
