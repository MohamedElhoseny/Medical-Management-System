package dao;

import entity.Doctor;
import exception.NoSuchDoctorFound;

import java.util.List;

public interface DoctorDao {
    public void addDoctor(Doctor doctor);
    public Doctor getDoctorByUUID(String uuid);
    public List<Doctor> getDoctorsByTitle(String title);
    public List<Doctor> getAllDoctors();
    public void updateDoctor(Doctor doctor) throws NoSuchDoctorFound;
    public void deleteDoctor(Doctor doctor) throws NoSuchDoctorFound;
}
