package com.logistics.service;

import com.logistics.entity.TransportTask;
import com.logistics.mapper.TransportMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    private final TransportMapper transportMapper;

    public TransportService(TransportMapper transportMapper) {
        this.transportMapper = transportMapper;
    }

    public List<TransportTask> getAllTasks() {
        return transportMapper.selectAll();
    }
}
