package com.example.demo.webRes;


import com.example.demo.Service.FileStorageService;
import com.example.demo.domain.FileStorage;
import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api")
public class FileStorageResources {
    private final FileStorageService fileStorageService;

    @Value("${upload.folder}")
    private String uploadFolder;


    public FileStorageResources(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file")MultipartFile multipartFile){
        fileStorageService.save(multipartFile);
        return ResponseEntity.ok(multipartFile.getOriginalFilename()+" file saqlandi");
    }

    @GetMapping("/preview/{hashId}")
    public ResponseEntity preview(@PathVariable String hashId) throws IOException {
        FileStorage fileStorage =  fileStorageService.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; fileName=\""+ URLEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .body(new FileUrlResource(String.format("%s/%s",
                        uploadFolder,
                        fileStorage.getUploadPath())));
    }

    @GetMapping("/download/{hashId}")
    public ResponseEntity download(@PathVariable String hashId) throws IOException {
        FileStorage fileStorage =  fileStorageService.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+ URLEncoder.encode(fileStorage.getName()))
                .contentType(MediaType.parseMediaType(fileStorage.getContentType()))
                .body(new FileUrlResource(String.format("%s/%s",
                        uploadFolder,
                        fileStorage.getUploadPath())));
    }

    @DeleteMapping("/delete/{hashId}")
    public ResponseEntity delete(@PathVariable String hashId){
        fileStorageService.delete(hashId);
        return ResponseEntity.ok("ochdi");
    }
}
