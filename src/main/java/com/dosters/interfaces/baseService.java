package com.dosters.interfaces;

import java.util.List;

import com.dosters.dtos.CommonOutput;

public interface baseService<Dto, Output extends CommonOutput> {
    public List<? extends Dto> getAll();

    public Output getOne(long id);

    public Output createOne(Dto entity);
}
