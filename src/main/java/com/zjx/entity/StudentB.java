package com.zjx.entity;

/**
 * @Description B依赖C
 * @Author Carson Cheng
 * @Date 2019/4/2 10:00
 * @Version V1.0
 **/
public class StudentB {

    private StudentC studentC;

    public StudentB() {
    }

    public StudentC getStudentC() {
        return studentC;
    }

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }


}
