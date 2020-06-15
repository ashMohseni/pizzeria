package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author ashkanmohseni
 */
public class Main extends Application {
    
    Stage window;
    
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Pane root2 = FXMLLoader.load(getClass().getResource("login/login.fxml"));
        Font.loadFont("file:resources.Fonts/BebasNeue-Regular.ttf", 120);
        Font.loadFont("file:resources.Fonts/OpenSans-Regular-Regular.ttf", 120);
        Font.loadFont("file:resources.Fonts/OdibeeSans-Regular.ttf", 120);
        Font.loadFont("file:resources.Fonts/Abel-Regular.ttf", 120);
        Scene sceneX = new Scene(root2, 830, 350);
        primaryStage.setMaximized(true);
        window.setScene(sceneX);
        window.setTitle("Pizzeria");
        window.show();
    }
    
}
