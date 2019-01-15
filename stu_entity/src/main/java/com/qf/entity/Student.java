package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class Student  implements Serializable {
    private  int id;
    private  String name;
    private  int age;
    private  int cid;
    @TableField(exist = false)
    private  String cname;
}
