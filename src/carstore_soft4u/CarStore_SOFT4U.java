package carstore_soft4u;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class CarStore_SOFT4U extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Car Store");
        stage.getIcons().add(new Image(CarStore_SOFT4U.class.getResourceAsStream("logo.jpeg")));
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
