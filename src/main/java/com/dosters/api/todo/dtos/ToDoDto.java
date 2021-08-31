package com.dosters.api.todo.dtos;

import lombok.Getter;
import lombok.Setter;

public class ToDoDto {

    @Getter
    @Setter
    public static class Post extends ToDoDto {
        private String username;
        private String content;
    }

    @Getter
    @Setter
    public static class Update extends ToDoDto {
        private long id;
        private String preContent;
        private String content;
        private String username;
    }

    @Getter
    @Setter
    public static class Delete extends ToDoDto {
        private long id;
        private String content;
        private String username;
    }

    @Getter
    @Setter
    public static class Info extends ToDoDto {
        private long id;
        private String content;
    }
}
