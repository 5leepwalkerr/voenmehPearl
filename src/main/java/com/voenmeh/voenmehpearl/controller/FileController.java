package com.voenmeh.voenmehpearl.controller;

import com.voenmeh.voenmehpearl.service.FileManipulation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/pearl/file")
public class FileController {

    @Autowired
    private FileManipulation fileManipulation;
    @PostMapping("upload ")
    public ResponseEntity<?> uploadFile(@RequestParam("uploadFile")MultipartFile uploadFile){
        fileManipulation.uploadFile(uploadFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
