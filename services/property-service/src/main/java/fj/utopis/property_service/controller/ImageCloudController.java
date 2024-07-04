package fj.utopis.property_service.controller;

import fj.utopis.property_service.services.ImageCloudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

import static fj.utopis.property_service.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class ImageCloudController {
    private final ImageCloudService imageCloudService;

    @PostMapping("upload-image")
    public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") final MultipartFile file) throws IOException {
        return ResponseEntity.ok(imageCloudService.upload(file));
    }
}
