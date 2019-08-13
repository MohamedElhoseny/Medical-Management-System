package service;

import entity.Doctor;
import exception.NoSuchDoctorFound;

import java.util.List;

public interface DoctorService
{
    public void addNewDoctor(Doctor newDoctor);

    public void updateExistingDoctor(Doctor updatedDoctor) throws NoSuchDoctorFound;

    public void deleteExistingDoctor(Doctor doctor) throws NoSuchDoctorFound;

    public Doctor retrieveDoctorByID(String uuid);

    public List<Doctor> retrieveAllDoctors();

    public List<Doctor> retrieveDoctorByTitle(String title);

}
