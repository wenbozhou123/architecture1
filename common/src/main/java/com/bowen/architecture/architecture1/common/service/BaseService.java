package com.bowen.architecture.architecture1.common.service;

import com.bowen.architecture.architecture1.common.dao.BaseDAO;
import com.bowen.architecture.architecture1.common.vo.BaseModel;
import com.bowen.architecture.architecture1.pageutil.Page;

import java.util.List;

public class BaseService<M, QM extends BaseModel> implements IBaseService<M, QM> {
    private BaseDAO dao = null;
    public BaseDAO getDao() {
        return dao;
    }

    public void setDao(BaseDAO dao) {
        this.dao = dao;
    }

    public void create(M cm) {
        dao.create(cm);
    }

    public void update(M cm) {
        dao.update(cm);
    }

    public void delete(int uuid) {
        dao.delete(uuid);
    }

    public M getByUuid(int uuid) {
        return (M) dao.getByUuid(uuid);
    }

    public Page<M> getByConditionPage(QM qm) {
        List<M> list = dao.getByConditionPage(qm);
        qm.getPage().setResult(list);
        return qm.getPage();
    }
}
