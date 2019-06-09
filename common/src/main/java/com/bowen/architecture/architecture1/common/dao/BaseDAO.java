package com.bowen.architecture.architecture1.common.dao;

import java.util.List;

public interface BaseDAO<M, QM> {
    public void create(M cm);
    public void update(M cm);
    public void delete(int uuid);

    public M getByUuid(int uuid);
    public List<M> getByConditionPage(QM qm);
}
