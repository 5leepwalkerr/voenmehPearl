package com.voenmeh.voenmehpearl.service.Impl;

import com.voenmeh.voenmehpearl.model.VoenmehFile;
import com.voenmeh.voenmehpearl.repository.VoenmehFileRepository;
import com.voenmeh.voenmehpearl.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private VoenmehFileRepository fileRepository;
    @Override
    public VoenmehFile uploadFile(MultipartFile uploadFile) throws IOException {
        VoenmehFile voenmehFile = new VoenmehFile();
            voenmehFile.setFileName(StringUtils.cleanPath(uploadFile.getOriginalFilename()));
            voenmehFile.setContentType(uploadFile.getContentType());
            voenmehFile.setFileData(uploadFile.getBytes());
            voenmehFile.setFileCreationTime(new Date());
        return fileRepository.save(voenmehFile);
    }
}
