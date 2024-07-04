package fj.utopis.property_service.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ImageCloudServiceImpl implements ImageCloudService{
    private final Cloudinary cloudinary;

    @Override
    public Map<String, String> upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);

        return cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(file);

        fos.write(multipartFile.getBytes());
        fos.close();

        return file;
    }
}
