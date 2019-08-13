package entity;

public class Doctor extends Staff
{
    private String[] specialty;


    public String[] getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String[] specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Dr: "+getTitle();
    }
}
