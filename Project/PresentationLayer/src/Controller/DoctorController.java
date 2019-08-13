package Controller;

import entity.Doctor;
import entity.Gender;
import exception.NoSuchDoctorFound;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import service.DoctorService;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class DoctorController implements Initializable
{
    @FXML
    private TextField title;
    @FXML
    private TextField address;
    @FXML
    private TextField fname;
    @FXML
    private TextField phone;
    @FXML
    private TextField mname;
    @FXML
    private TextField lname;
    @FXML
    private DatePicker bdate;
    @FXML
    private ComboBox<Gender> gender;
    @FXML
    private ComboBox<Doctor> doctors;
    @FXML
    private Button clear;
    @FXML
    private Label output;
    @FXML
    private TextArea specialty;
    @FXML
    private TextField searchTitle;

    private DoctorService doctorService;
    private Doctor currentDoctor;

    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
        currentDoctor = null;
    }


    @FXML
    void addNewDoctor(ActionEvent event) {
        if (title.getText().isEmpty())
            output.setText("Please Enter at least the title of new doctor !");
        else if (currentDoctor != null)
            output.setText("Doctor is already exists !");
        else {
            currentDoctor = new Doctor();
            getInputs(currentDoctor);
            doctorService.addNewDoctor(currentDoctor);
            resetInputs();
            output.setText("New Doctor is added Successful.");
        }
    }

    @FXML
    void deleteExistingDoctor(ActionEvent event) {
        if (currentDoctor == null)
            output.setText("Please select a doctor to delete !");
        else {
            try {
                doctorService.deleteExistingDoctor(currentDoctor);
                resetInputs();
                output.setText("Doctor is deleted successfully.");
            } catch (NoSuchDoctorFound noSuchDoctorFound) {
                output.setText("Doctor is not found, Please Add First !");
            }
        }
    }

    @FXML
    void searchDoctorByTitle(ActionEvent event) {
        String doctitle = searchTitle.getText();

        List<Doctor> docs = doctorService.retrieveDoctorByTitle(doctitle);

        if (docs.size() > 0) {
            currentDoctor = docs.get(0);
            setInputs(currentDoctor);
            output.setText("Doctor found with title : "+ doctitle);
        }else
            output.setText("No Doctor found with title : "+ doctitle);
    }

    @FXML
    void selectExistingDoctor(ActionEvent event) {
        currentDoctor = doctors.getSelectionModel().getSelectedItem();
        if (currentDoctor != null)
            setInputs(currentDoctor);
    }

    @FXML
    void updateExistingDoctor(ActionEvent event) {
        if (currentDoctor == null)
            output.setText("Please select a doctor to update !");
        else {
            try {
                getInputs(currentDoctor);
                doctorService.updateExistingDoctor(currentDoctor);
                resetInputs();
                output.setText("Doctor is updated successfully.");
            } catch (NoSuchDoctorFound noSuchDoctorFound) {
                output.setText("Doctor is not found, Please Add First !");
            }
        }
    }



    private void getInputs(Doctor targetDoctor){
        targetDoctor.setAddress(address.getText());
        targetDoctor.setLastName(lname.getText());
        targetDoctor.setFirstName(fname.getText());
        targetDoctor.setMiddleName(mname.getText());
        targetDoctor.setPhone(phone.getText());
        targetDoctor.setTitle(title.getText());


        String spec = specialty.getText();
        String[] specs = spec.split("\n");
        targetDoctor.setSpecialty(specs);


        targetDoctor.setGender(gender.getValue());
        targetDoctor.setBirthDate(bdate.getValue());

        /*targetDoctor.setCertifications(doctor.getCertifications());
        targetDoctor.setEducations(doctor.getEducations());
        targetDoctor.setLanguages(doctor.getLanguages());
        targetDoctor.setDepartment(doctor.getDepartment());*/
    }
    private void setInputs(Doctor targetDoctor){
        address.setText(targetDoctor.getAddress());
        lname.setText(targetDoctor.getLastName());
        fname.setText(targetDoctor.getFirstName());
        mname.setText(targetDoctor.getMiddleName());
        phone.setText(targetDoctor.getPhone());
        title.setText(targetDoctor.getTitle());

        String[] specs = targetDoctor.getSpecialty();
        specialty.setText("");
        for (String spec : specs) {
            specialty.setText(specialty.getText() + spec + "\n");
        }

        gender.setValue(targetDoctor.getGender());
        bdate.setValue(targetDoctor.getBirthDate());

        /*targetDoctor.setCertifications(doctor.getCertifications());
        targetDoctor.setEducations(doctor.getEducations());
        targetDoctor.setLanguages(doctor.getLanguages());
        targetDoctor.setDepartment(doctor.getDepartment());*/
    }
    private void resetInputs(){
        address.clear();
        lname.clear();
        fname.clear();
        mname.clear();
        phone.clear();
        title.clear();
        specialty.clear();
        searchTitle.clear();
        bdate.setValue(LocalDate.now());
        gender.setValue(null);
        currentDoctor = null;
        doctors.getItems().clear();
        doctors.getItems().addAll(doctorService.retrieveAllDoctors());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set default values
        bdate.setValue(LocalDate.now());
        gender.getItems().addAll(FXCollections
                .observableArrayList(Gender.values()));
        clear.setOnAction(event -> resetInputs());
        resetInputs();
    }
}
