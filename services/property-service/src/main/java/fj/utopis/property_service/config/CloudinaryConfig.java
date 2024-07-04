package fj.utopis.property_service.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dahmb4dc0");
        config.put("api_key", "863845381824474");
        config.put("api_secret", "g5sjNS3FhSoZuEV4OGRerUwrwNw");
        return new Cloudinary(config);
    }
}
