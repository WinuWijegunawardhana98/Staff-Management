package com.winu.staff.management;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends MongoRepository<StaffAttendance, String> {
    List<StaffAttendance> findByStaffId(String staffId);
}
