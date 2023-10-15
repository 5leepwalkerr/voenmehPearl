package com.voenmeh.voenmehpearl.service.Impl;

import com.voenmeh.voenmehpearl.model.VoenmehFile;
import com.voenmeh.voenmehpearl.repository.VoenmehFileRepository;
import com.voenmeh.voenmehpearl.service.FileManipulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileManipulationImpl implements FileManipulation {
    @Autowired
    private VoenmehFileRepository fileRepository;
    @Override
    public void uploadFile(MultipartFile uploadFile) {
        VoenmehFile voenmehFile = new VoenmehFile();
        try {
            voenmehFile.setFileName(uploadFile.getName());
            voenmehFile.setContentType(uploadFile.getContentType());
            voenmehFile.setFileData(uploadFile.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
