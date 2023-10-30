package com.voenmeh.voenmehpearl.controller;

import com.voenmeh.voenmehpearl.model.VoenmehUser;
import com.voenmeh.voenmehpearl.repository.VoenmehUserRepository;
import com.voenmeh.voenmehpearl.service.FileManipulation;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/pearl/file")
public class FileController {
    @Autowired
    private FileManipulation fileManipulation;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("uploadFile")MultipartFile uploadFile){
        fileManipulation.uploadFile(uploadFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("hello");
    }
}
