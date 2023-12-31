package com.geekster.DoctorAppointmentBookingApp.repo;

import com.geekster.DoctorAppointmentBookingApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer> {
    Patient findFirstByPatientEmail(String newEmail);

}
