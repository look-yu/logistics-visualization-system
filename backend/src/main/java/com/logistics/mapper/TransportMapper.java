package com.logistics.mapper;

import com.logistics.entity.TransportTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransportMapper {

    List<TransportTask> selectAll();
}
