package com.geekster.DoctorAppointmentBookingApp.controller;

import com.geekster.DoctorAppointmentBookingApp.model.Patient;
import com.geekster.DoctorAppointmentBookingApp.model.dto.AuthenticationInputDto;
import com.geekster.DoctorAppointmentBookingApp.model.dto.ScheduleAppointmentDTO;
import com.geekster.DoctorAppointmentBookingApp.model.dto.SignInInputDTO;
import com.geekster.DoctorAppointmentBookingApp.service.AppointmentService;
import com.geekster.DoctorAppointmentBookingApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    AppointmentService appointmentService;


    //sign up
    @PostMapping("patient/signup")
    public String patientSignUp(@RequestBody Patient patient)
    {
        return patientService.patientSignUp(patient);
    }



    //sign in
    @PostMapping("patient/signIn")
    public String patientSignIn(@RequestBody SignInInputDTO signInInput)
    {
        return patientService.patientSignIn(signInInput);
    }


    //sign out
    @DeleteMapping("patient/signOut")
    public String patientSignOut(@RequestBody AuthenticationInputDto authInfo)
    {
        return patientService.patientSignOut(authInfo);
    }


    //schedule an appointment

    @PostMapping("patient/appointment/schedule")
    public String scheduleAppointment(@RequestBody ScheduleAppointmentDTO scheduleAppointmentDTO)
    {
        return appointmentService.scheduleAppointment(scheduleAppointmentDTO.getAuthInfo(),scheduleAppointmentDTO.getAppointment());
    }

    @DeleteMapping("patient/appointment/{appointment}/cancel")
    public String cancelAppointment(@RequestBody AuthenticationInputDto authInfo, @PathVariable Integer appointment)
    {
        return appointmentService.cancelAppointment(authInfo,appointment);
    }
}
