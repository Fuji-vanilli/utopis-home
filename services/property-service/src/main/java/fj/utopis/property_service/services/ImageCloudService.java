package fj.utopis.property_service.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageCloudService {
    Map<String, String> upload(MultipartFile file) throws IOException;
}
