package exception;

import entity.Doctor;

public class NoSuchDoctorFound extends Exception {
    public NoSuchDoctorFound(Doctor doctor){
        super("There is no doctor found with uuid = "+doctor.getId());
    }
}
