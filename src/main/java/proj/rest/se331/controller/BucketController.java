package proj.rest.se331.controller;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import proj.rest.se331.util.CloudStorageHelper;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorageHelper;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadImage(@RequestParam(value = "file") MultipartFile file) throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorageHelper.getImageUrl(file,"se331-final-project.appspot.com"));
    }
    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadImageComponent(@RequestParam(value = "image")MultipartFile file) throws  IOException, ServletException{
        return ResponseEntity.ok(this.cloudStorageHelper.getStorageImageDto(file,"se331-final-project.appspot.com"));
    }
    @PostMapping("/uploadAnnounceFile")
    public ResponseEntity<?> uploadFile(@RequestParam(value = "file")MultipartFile file) throws IOException {
        return ResponseEntity.ok(this.cloudStorageHelper.getFileUrl(file,"se331-final-project.appspot.com"));
    }
    @PostMapping("/uploadAnnouncement")
    public ResponseEntity<?> uploadAnnouncement(@RequestParam(value = "file")MultipartFile file) throws IOException {
        return ResponseEntity.ok(this.cloudStorageHelper.getStorageFileDto(file,"se331-final-project.appspot.com"));
    }
}
