import entity.Department;
import entity.Doctor;
import entity.Gender;
import javafx.application.Application;
import javafx.stage.Stage;
import app.FXApp;

import java.time.LocalDate;

public class JavafxApplication extends Application
{
    private FXApp javaFxApplication;
    private Stage primaryStage;

    @Override
    public void init() throws Exception {
        System.out.println("Starting HospitalManagementSystem Application ..");
        javaFxApplication = new HospitalManagementSystem();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = javaFxApplication.getPrimaryStage(primaryStage);
        this.primaryStage.show();
    }


    @Override
    public void stop() throws Exception {
        System.out.println("Stopping HospitalManagementSystem Application ..");
        javaFxApplication = null;
        primaryStage.hide();
    }
}