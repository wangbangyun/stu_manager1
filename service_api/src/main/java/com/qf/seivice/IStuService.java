package com.qf.seivice;

import com.qf.entity.Student;

import java.util.List;

public interface IStuService {
    int inserStu(Student student);
    List<Student> queryAllStu();
}
