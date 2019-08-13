package serviceImpl;

import dao.DoctorDao;
import daoImpl.DoctorDaoImpl;
import entity.Doctor;
import exception.NoSuchDoctorFound;
import service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService
{
    private DoctorDao doctorDao;

    public DoctorServiceImpl(){
        doctorDao = new DoctorDaoImpl();
    }


    public void addNewDoctor(Doctor newDoctor){
        doctorDao.addDoctor(newDoctor);
    }

    public void updateExistingDoctor(Doctor updatedDoctor) throws NoSuchDoctorFound {
        doctorDao.updateDoctor(updatedDoctor);
    }

    public void deleteExistingDoctor(Doctor doctor) throws NoSuchDoctorFound{
        doctorDao.deleteDoctor(doctor);
    }

    public Doctor retrieveDoctorByID(String uuid){
        return doctorDao.getDoctorByUUID(uuid);
    }

    @Override
    public List<Doctor> retrieveAllDoctors() {
        return doctorDao.getAllDoctors();
    }

    public List<Doctor> retrieveDoctorByTitle(String title){
        return doctorDao.getDoctorsByTitle(title);
    }
}
