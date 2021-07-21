package com.spring.upload_file.service;

import com.spring.upload_file.exception.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;

    public String uploadFile(MultipartFile file) {

        //kiểm tra file rỗng hay ko!
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
        }

        String fileName = file.getOriginalFilename();
        try {
            var is = file.getInputStream();
            Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s", fileName);
            throw new StorageException(msg, e);
        }
        return fileName;
    }

    public void deleteFile(String file) {
        File myObj = new File(path + file);
        myObj.delete();
    }
}
