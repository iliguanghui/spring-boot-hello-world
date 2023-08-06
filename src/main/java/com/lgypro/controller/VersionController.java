package com.lgypro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/version")
    public String version() {
        return "legacy version";
    }

    @GetMapping("/v2/version")
    public String newVersion() {
        return "I'm v2\n";
    }
}
