package com.zjx.entity;

/**
 * @Description C依赖A
 * @Author Carson Cheng
 * @Date 2019/4/2 10:00
 * @Version V1.0
 **/
public class StudentC {

    private StudentA studentA;

    public StudentC() {
    }

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }

    public StudentA getStudentA() {
        return studentA;
    }

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }
}
