package com.bowen.architecture.architecture1.common.service;

import com.bowen.architecture.architecture1.common.dao.BaseDAO;
import com.bowen.architecture.architecture1.common.vo.BaseModel;
import com.bowen.architecture.architecture1.pageutil.Page;

import java.util.List;

public interface IBaseService<M, QM extends BaseModel> {
    public void create(M cm);
    public void update(M cm);
    public void delete(int uuid);

    public M getByUuid(int uuid);
    public Page<M> getByConditionPage(QM qm);
}
