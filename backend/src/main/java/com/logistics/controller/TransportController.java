package com.logistics.controller;

import com.logistics.entity.TransportTask;
import com.logistics.service.TransportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransportController {

    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping("/transport")
    public List<TransportTask> list() {
        return transportService.getAllTasks();
    }
}
