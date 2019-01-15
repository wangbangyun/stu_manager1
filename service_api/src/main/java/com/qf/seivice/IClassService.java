package com.qf.seivice;

import com.qf.entity.Class;

import java.util.List;

public interface IClassService {
    List<Class> queryAllClass();
    String queryNameByCid(int cid);
}
