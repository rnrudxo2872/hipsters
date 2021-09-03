package com.dosters.api.todo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.dosters.dtos.CommonOutput;
import com.dosters.api.todo.domain.ToDoEntity;
import com.dosters.api.todo.dtos.ToDoDto;
import com.dosters.api.todo.dtos.ToDoDto.Post;
import com.dosters.api.todo.repository.ToDoRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return retList;
    }

    @Override
    @Transactional(readOnly = true)
    public ToDoDto.Info getOne(long id) {
        try {
            ToDoEntity entity = todoRepository.getOne(id);
            ToDoDto.Info dto = modelMapper.map(entity, ToDoDto.Info.class);
            logger.info(entity.toString());

            return dto;
        } catch (Exception e) {
            e.printStackTrace();

            CommonOutput error = new ToDoDto.Info();
            error.setStatus(false, "데이터를 불러오는데 실패했습니다.");
            return (ToDoDto.Info) error;
        }
    }

    @Override
    public CommonOutput createOne(ToDoDto todoDto) {
        ToDoEntity todo = new ToDoEntity();
        ToDoDto temp = new ToDoDto.Post();
        temp = todoDto;
        ToDoDto.Post response = (Post) temp;
        logger.info("error =>> {}", temp.error);
        logger.info("getContent() =>> {}", response.getContent());
        // todo.setContent("test");
        // todoRepository.save(todo);
        // logger.info("넣었다!");
        return CommonOutput.getStatus(true, null);
    }
}
