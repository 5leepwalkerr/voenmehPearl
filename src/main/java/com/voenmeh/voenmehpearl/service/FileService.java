package com.voenmeh.voenmehpearl.service;

import com.voenmeh.voenmehpearl.model.VoenmehFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    VoenmehFile uploadFile(MultipartFile file) throws IOException;
}
