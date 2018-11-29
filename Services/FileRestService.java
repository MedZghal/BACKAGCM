package com.perfectsolution.Clinique.Services;

import com.perfectsolution.Clinique.Metier.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.support.*;
import com.perfectsolution.Clinique.Entities.*;
import java.util.*;
import java.util.stream.*;
import org.springframework.http.*;
import org.springframework.core.io.*;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;

@RestController
public class FileRestService
{
    private static final Logger logger;
    @Autowired
    private DBFileUploadMetierImpl DBFileStorageService;
    
    @PostMapping({ "/uploadFile" })
    public UploadFileResponse uploadFile(@RequestParam("file") final MultipartFile file, @RequestParam("num_patient") final int num_patient) {
        final DBFileUpload dbFile = this.DBFileStorageService.storeFile(file, num_patient);
        final String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(dbFile.getId()).toUriString();
        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }
    
    @PostMapping({ "/uploadMultipleFiles" })
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") final MultipartFile[] files, @RequestParam("num_patient") final int num_patient) {
        return Arrays.asList(files).stream().map(file -> this.uploadFile(file, num_patient)).collect((Collector<? super Object, ?, List<UploadFileResponse>>)Collectors.toList());
    }
    
    @GetMapping({ "/downloadFile/{fileId}" })
    public ResponseEntity<Resource> downloadFile(@PathVariable final String fileId) {
        final DBFileUpload dbFile = this.DBFileStorageService.getFile(fileId);
        return (ResponseEntity<Resource>)((ResponseEntity.BodyBuilder)ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType())).header("Content-Disposition", new String[] { "attachment; filename=\"" + dbFile.getFileName() + "\"" })).body((Object)new ByteArrayResource(dbFile.getData()));
    }
    
    @GetMapping({ "/ViewFile/{fileId}" })
    public ResponseEntity<Resource> ViewFile(@PathVariable final String fileId) {
        final DBFileUpload dbFile = this.DBFileStorageService.getFile(fileId);
        return (ResponseEntity<Resource>)((ResponseEntity.BodyBuilder)ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType())).header("Content-Disposition", new String[] { "inline; filename=\"" + dbFile.getFileName() + "\"" })).body((Object)new ByteArrayResource(dbFile.getData()));
    }
    
    @GetMapping({ "/ViewAllFile" })
    public List<DBFileUpload> getAllFile() {
        return this.DBFileStorageService.getAllFile();
    }
    
    @GetMapping({ "/ViewAllFileByPatient" })
    public List<DBFileUpload> getFilebyPatient(@RequestParam final int num_patient) {
        return this.DBFileStorageService.getFilebyPatient(num_patient);
    }
    
    @PostMapping({ "/DeleteFile" })
    public String DeleteFile(@RequestParam final String fileId) {
        this.DBFileStorageService.DeleteFile(fileId);
        return "true";
    }
    
    static {
        logger = LoggerFactory.getLogger((Class)FileRestService.class);
    }
}
