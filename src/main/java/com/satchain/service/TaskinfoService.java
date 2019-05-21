package com.satchain.service;

import com.satchain.dao.TaskinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskinfoService {
    @Autowired
    private TaskinfoMapper taskinfoMapper;


}
