import entity.Department;
import entity.Doctor;
import exception.NoSuchDoctorFound;
import app.ConsoleApp;
import service.DoctorService;
import serviceImpl.DoctorServiceImpl;

public class ConsoleApplication implements ConsoleApp
{
    public static void main(String[] args) throws NoSuchDoctorFound {
        ConsoleApplication mainClass = new ConsoleApplication();
        mainClass.run();
    }

    @Override
    public void run() {
        System.out.println(".. Welcome In Hospital Management System ..");

        Department d1 = new Department();
        d1.setName("D1");

        Department d2 = new Department();
        d2.setName("D2");

        Doctor doctor1 = new Doctor();
        doctor1.setTitle("Badwee 1");
        doctor1.setDepartment(d1);

        Doctor doctor2 = new Doctor();
        doctor2.setTitle("Badwee 2");
        doctor2.setDepartment(d1);

            DoctorService doctorService = new DoctorServiceImpl();
        doctorService.addNewDoctor(doctor1);
        //doctorService.addNewDoctor(doctor2);

        Doctor test = doctorService.retrieveDoctorByID(doctor1.getId());
        System.out.println(test.getTitle());

        try {
            doctorService.deleteExistingDoctor(doctor2);
        } catch (NoSuchDoctorFound noSuchDoctorFound) {
            noSuchDoctorFound.printStackTrace();
        }
    }
}
