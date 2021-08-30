package com.dosters.api.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dosters.dtos.CommonOutput;
import com.dosters.api.todo.domain.ToDoEntity;
import com.dosters.api.todo.dtos.ToDoDto;
import com.dosters.api.todo.repository.ToDoRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DostersToDoService implements ToDoService {

    private final Logger logger = LoggerFactory.getLogger(DostersToDoService.class);
    private final ToDoRepository todoRepository;
    private final ModelMapper modelMapper;

    public DostersToDoService(ToDoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ToDoDto.Info> getAll() {
        List<ToDoEntity> findResult = todoRepository.findAll();
        List<ToDoDto.Info> retList = findResult.stream().map(entity -> modelMapper.map(entity, ToDoDto.Info.class))
                .collect(Collectors.toList());
        logger.info(findResult.toString());
        logger.info(retList.toString());
        return retList;
    }

    @Override
    public ToDoDto getOne() {
        Optional<ToDoEntity> test = todoRepository.findById(1L);
        if (test.isPresent()) {
            ToDoEntity testImpl = test.get();
            logger.info(testImpl.toString());
        }
        return null;
    }

    @Override
    public CommonOutput createOne(ToDoDto todoDto) {
        ToDoEntity todo = new ToDoEntity();
        todo.setContent("test");
        todoRepository.save(todo);
        logger.info("넣었다!");
        return null;
    }
}
