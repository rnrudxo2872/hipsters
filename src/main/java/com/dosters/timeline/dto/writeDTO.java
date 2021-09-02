package com.dosters.timeline.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class writeDTO {
    private Long id;
    private String content;
    
    @Builder
    public writeDTO(Long id, String content){
        this.id = id;
        this.content = content;
    }

}
