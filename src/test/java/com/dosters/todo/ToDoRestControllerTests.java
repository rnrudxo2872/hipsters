package com.dosters.todo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.dosters.api.todo.ToDoRestController;
import com.dosters.api.todo.service.DostersToDoService;
import com.dosters.api.todo.domain.ToDoEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ToDoRestController.class)
@ExtendWith(MockitoExtension.class)
public class ToDoRestControllerTests {

    MockMvc mvc;

    @MockBean
    DostersToDoService todoService;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new ToDoRestController(todoService))
                .addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
    }

    @Test
    void getAll() throws Exception {
        List<ToDoEntity> todo = new ArrayList<>();
        todo.add(new ToDoEntity(1, "title"));

        when(todoService.getAll()).thenReturn(todo);

        mvc.perform(MockMvcRequestBuilders.get("/api/todo")).andExpect(MockMvcResultMatchers.status().isOk());
        assertTrue(todoService.getAll() == todo);
        System.out.println("됏나?");
    }
}
