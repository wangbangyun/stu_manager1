package com.qf.class_service;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.IClassDao;
import com.qf.entity.Class;
import com.qf.seivice.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private IClassDao classDao;
    @Override
    public List<Class> queryAllClass() {
        List<Class> classList = classDao.selectList(new QueryWrapper<Class>());
        return classList;
    }

    @Override
    public String queryNameByCid(int cid) {
        QueryWrapper<Class> wrapper =new QueryWrapper<>();
        wrapper.eq("id",cid);
        Class aClass = classDao.selectOne(wrapper);
        return aClass.getName();
    }
}
