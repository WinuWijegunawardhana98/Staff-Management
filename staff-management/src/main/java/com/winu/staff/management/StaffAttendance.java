package com.winu.staff.management;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class StaffAttendance {
    @Id
    private String id;
    private String staffId;
    private LocalDate date;
    private boolean present;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
