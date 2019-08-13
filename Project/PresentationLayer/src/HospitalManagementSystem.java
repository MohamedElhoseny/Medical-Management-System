import Controller.DoctorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import app.FXApp;
import service.DoctorService;
import serviceImpl.DoctorServiceImpl;

public class HospitalManagementSystem implements FXApp {


    @Override
    public Stage getPrimaryStage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/doctor.fxml"));

            //Inject service layer to UI Layer
            DoctorService doctorService = new DoctorServiceImpl();
            DoctorController controller = new DoctorController(doctorService);
            loader.setController(controller);

            primaryStage.setTitle("HospitalManagementSystem");
            primaryStage.setScene(new Scene((Parent)loader.load()));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return primaryStage;
    }
}
