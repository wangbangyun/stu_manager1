package com.qf.student_provider.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.entity.Student;
import com.qf.seivice.IClassService;
import com.qf.seivice.IStuService;
import com.qf.student_provider.dao.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StudentServiceImpl implements IStuService {
    @Autowired
    private IStudentDao studentDao;
    @Reference
    private IClassService classService;
    @Override
    public int inserStu(Student student) {
        int insert = studentDao.insert(student);
        return insert;
    }

    @Override
    public List<Student> queryAllStu() {
        List<Student> students = studentDao.selectList(null);
        for (Student student: students){
            String cname = classService.queryNameByCid(student.getCid());
            student.setCname(cname);
        }
        return students;
    }
}
