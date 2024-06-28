package fj.utopis.gateway_service.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class GatewayController {

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("login");
    }
}
