package com.winu.staff.management;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Staff {
    @Id
    private String id;
    private String name;
    private String position;
    private int age;
    private List<StaffAttendance> attendance;

    public List<StaffAttendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<StaffAttendance> attendance) {
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
