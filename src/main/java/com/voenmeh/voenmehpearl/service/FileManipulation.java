package com.voenmeh.voenmehpearl.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileManipulation {
    void uploadFile(MultipartFile file);
}
