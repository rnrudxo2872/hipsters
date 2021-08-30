package com.dosters.interfaces;

import java.util.List;

import com.dosters.dtos.CommonInputDto;

public interface baseService<Dto, Output> {
    public List<? extends Dto> getAll();

    public Dto getOne();

    public Output createOne(Dto entity);
}
