package com.winu.staff.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping("")
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Staff> getStaffById(@PathVariable String id) {
        return staffRepository.findById(id);
    }

    @PostMapping("")
    public Staff addStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable String id, @RequestBody Staff staff) {
        staff.setId(id);
        return staffRepository.save(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable String id) {
        staffRepository.deleteById(id);
    }
    @GetMapping("/{id}/attendance")
    public List<StaffAttendance> getAttendanceByStaffId(@PathVariable String id) {
        return attendanceRepository.findByStaffId(id);
    }

    @PostMapping("/{id}/attendance")
    public StaffAttendance addAttendanceForStaff(@PathVariable String id, @RequestBody StaffAttendance attendance) throws NotFoundException {
        Staff staff = staffRepository.findById(id).orElseThrow(() -> {
            return new NotFoundException();
        });
        attendance.setStaffId(id);
        staff.getAttendance().add(attendance);
        staffRepository.save(staff);
        return attendanceRepository.save(attendance);
    }
}


