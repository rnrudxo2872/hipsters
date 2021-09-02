package com.dosters.timeline.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class timelineService {
    
    private final ModelMapper modelMapper;

    public timelineService(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    
    public List write(List writeDTO){

    }





}
