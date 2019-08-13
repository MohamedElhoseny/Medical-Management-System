package daoImpl;

import dao.DoctorDao;
import entity.Department;
import entity.Doctor;
import entity.Gender;
import exception.NoSuchDoctorFound;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorDaoImpl implements DoctorDao {

    //Dummy Collection of doctors instead of using database
    private Map<String, Doctor> doctors;

    public DoctorDaoImpl(){
        doctors = new HashMap<String, Doctor>();
        //dummy data
        Department dept1 = new Department();
        dept1.setName("Dept 01");

        Department dept2 = new Department();
        dept2.setName("Dept 02");

        Department dept3 = new Department();
        dept3.setName("Dept 03");

        Doctor d1 = new Doctor();
        d1.setFirstName("Mostafa");
        d1.setMiddleName("Sobhy");
        d1.setLastName("Basha");
        d1.setDepartment(dept1);
        d1.setTitle("Badwee");
        d1.setPhone("0123453555");
        d1.setGender(Gender.MALE);
        d1.setAddress("Fesal, Giza, Egypt");
        d1.setBirthDate(LocalDate.now());
        d1.setSpecialty(new String[]{"Student", "Doctor b3d dohr"});

        Doctor d2 = new Doctor();
        d2.setFirstName("Lional");
        d2.setMiddleName("Messi");
        d2.setLastName("Basha");
        d2.setDepartment(dept2);
        d2.setTitle("Messi");
        d2.setPhone("0123453555");
        d2.setGender(Gender.MALE);
        d2.setAddress("Barcelona, Spain");
        d2.setBirthDate(LocalDate.now());
        d2.setSpecialty(new String[]{"Football player", "father", "famous"});

        doctors.put(d1.getId(), d1);
        doctors.put(d2.getId(), d2);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
    }

    @Override
    public Doctor getDoctorByUUID(String uuid) {
        return doctors.get(uuid);
    }

    @Override
    public List<Doctor> getDoctorsByTitle(String title) {
        List<Doctor> doctorList = new ArrayList<>();

        doctors.forEach((id, doctor) -> {
            if(doctor.getTitle().equals(title))
                doctorList.add(doctor);
        });

        return doctorList;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        doctors.forEach((id, doctor) -> { doctorList.add(doctor);});
        return doctorList;
    }

    @Override
    public void updateDoctor(Doctor doctor) throws NoSuchDoctorFound {
        Doctor targetDoctor = doctors.get(doctor.getId());

        if (targetDoctor == null)
            throw new NoSuchDoctorFound(doctor);

        targetDoctor.setAddress(doctor.getAddress());
        targetDoctor.setBirthDate(doctor.getBirthDate());
        targetDoctor.setFirstName(doctor.getFirstName());
        targetDoctor.setMiddleName(doctor.getMiddleName());
        targetDoctor.setLastName(doctor.getLastName());
        targetDoctor.setSpecialty(doctor.getSpecialty());
        targetDoctor.setGender(doctor.getGender());
        targetDoctor.setPhone(doctor.getPhone());
        targetDoctor.setTitle(doctor.getTitle());
        targetDoctor.setCertifications(doctor.getCertifications());
        targetDoctor.setEducations(doctor.getEducations());
        targetDoctor.setLanguages(doctor.getLanguages());
        targetDoctor.setDepartment(doctor.getDepartment());
    }

    @Override
    public void deleteDoctor(Doctor doctor)  throws NoSuchDoctorFound{
        Doctor targetDoctor = doctors.get(doctor.getId());

        if (targetDoctor == null)
            throw new NoSuchDoctorFound(doctor);

        doctors.remove(doctor.getId());
    }
}
