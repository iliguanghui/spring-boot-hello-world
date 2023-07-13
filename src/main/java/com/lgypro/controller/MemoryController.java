package com.lgypro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemoryController {
    List<byte[]> memoryList = new ArrayList<>();
    static int _100MB = 100 * 1024 * 1024;

    @PostMapping("/allocate")
    public String allocateMemory(@RequestParam(name = "size", defaultValue = "100") int desiredSize) {
        int count = desiredSize / 100;
        for (int i = 0; i < count; i++) {
            memoryList.add(new byte[_100MB]);
        }
        return String.format("allocate %d MB memory", count * 100);
    }

    @PostMapping("/release")
    public String releaseMemory(@RequestParam(name = "size", defaultValue = "100") int desiredSize) {
        int count = desiredSize / 100;
        if (count > 0) {
            memoryList.subList(0, count).clear();
        }
        return String.format("release %d MB memory", count * 100);
    }
}
