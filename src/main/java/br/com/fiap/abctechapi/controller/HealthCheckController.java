package br.com.fiap.abctechapi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.abctechapi.component.VersionComponent;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    private final VersionComponent versionComponent;

    public HealthCheckController(@Autowired VersionComponent versionComponent) {
        this.versionComponent = versionComponent;
    }

    @GetMapping
    public ResponseEntity<Object> status() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("version")
    public ResponseEntity<String> version() throws IOException {
        return ResponseEntity.ok(versionComponent.getNameVersion());
    }

}
