package entity;

public class Staff extends Person
{
    private String[] educations;
    private String[] certifications;
    private String[] languages;
    private Department department;

    public String[] getEducations() {
        return educations;
    }

    public void setEducations(String[] educations) {
        this.educations = educations;
    }

    public String[] getCertifications() {
        return certifications;
    }

    public void setCertifications(String[] certifications) {
        this.certifications = certifications;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
