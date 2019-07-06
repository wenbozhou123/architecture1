package com.bowen.architecture.architecture1.storeMgr.service;


import com.bowen.architecture.architecture1.common.service.IBaseService;

import com.bowen.architecture.architecture1.storeMgr.vo.StoreModel;
import com.bowen.architecture.architecture1.storeMgr.vo.StoreQueryModel;

public interface IStoreService extends IBaseService<StoreModel,StoreQueryModel>{
    public StoreModel getByGoodsUuid(int goodsUuid);
}

