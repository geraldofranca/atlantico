package com.atlantico.user.commons.util;


import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityToDtoMapper<E extends AbstractEntity, D> {

    protected abstract D convert(E tab);

    protected abstract E convert(D entity);

    public D map(E tab) {
        if (tab == null)
            return null;
        return convert(tab);
    }

    public E unmap(D entity) {
        if (entity == null)
            return null;
        return convert(entity);
    }

    public List<D> map(List<E> list) {
        return list.stream().map((e) -> map(e)).collect(Collectors.toList());
    }

    public List<E> unmap(List<D> list) {
        return list.stream().map((d) -> unmap(d)).collect(Collectors.toList());
    }

}
