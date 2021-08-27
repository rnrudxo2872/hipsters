package com.dosters.interfaces;

import java.util.List;

public interface baseService<Entity, Output> {
    public List<Entity> getAll();

    public Entity getOne();

    public Output createOne(Entity entity);
}
