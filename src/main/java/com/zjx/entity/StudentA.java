package com.zjx.entity;

/**
 * @Description A依赖B
 * @Author Carson Cheng
 * @Date 2019/4/2 10:00
 * @Version V1.0
 **/
public class StudentA {

    private StudentB studentB;

    public StudentA() {
    }

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }

    public StudentB getStudentB() {
        return studentB;
    }

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }
}
