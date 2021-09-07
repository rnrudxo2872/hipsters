package com.dosters.timeline.service;

import com.dosters.timeline.dto.writeDTO;
import com.dosters.timeline.repository.timelineRepo;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class timelineServiceImpl implements timelineService {

    private final ModelMapper modelMapper;
    private timelineRepo timelineRepo;

    public timelineServiceImpl(ModelMapper modelMapper, timelineRepo timelineRepo) {
        this.modelMapper = modelMapper;
        this.timelineRepo = timelineRepo;
    }

    @Override
    public String writePost(writeDTO writeDTO) throws Exception {
        return null;
    }
}
