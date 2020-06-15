package fx.login;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.ERROR;
import javafx.scene.control.Button;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Info;

/**
 * FXML Controller class
 *
 * @author ashkan mohseni
 */
public class LoginController implements Initializable {

    @FXML private Button sign_in;
    @FXML private Label sign_up;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private ImageView gitHub;

    Info info = new Info();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Sign_in(ActionEvent event) throws IOException {
        String user = username.getText().trim();
        String pass = password.getText().trim();

        //Check if the username exists and if so check if the pass matches
        if (info.getUserpass().containsKey(user)) {
            String storedPass = info.getUserpass().get(user);
            // If password is right
            if (storedPass.equals(pass)) {
                Parent signUp = FXMLLoader.load(getClass().getResource("../pizzeria.fxml"));
                Scene scene = new Scene(signUp, 1500, 870);
                scene.getStylesheets().add(this.getClass().getResource("../pizzeria.css").toExternalForm());

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.setTitle("successful login");
                window.setMaximized(true);
                window.show();
            } // If password is not right
            else {
                alert("The entered password is wrong!");
            }
        }
        // If username doesn't exist
        if (!(info.getUserpass().containsKey(user))) {
            alert("The username is not valid!");
        }

    }

    // To transfer to the sign up page
    @FXML
    private void sign_up(MouseEvent event) throws IOException {

        Parent signUp = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(this.getClass().getResource("../pizzeria.css").toExternalForm());

        //This line gets the stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.setTitle("Sign up");
        window.setMaximized(true);
        window.show();

    }

    // A method to show the alerts easier
    private Alert alert(String alertText) {
        Alert alert = new Alert(ERROR, alertText, OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../pizzeria.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.show();
        return alert;
    }

    // To transfer to my gitHub account once the icon is clicked
    @FXML
    private void git(MouseEvent event) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("https://github.com/ashMohseni"));
    }

    // The gitHub icon effect
    @FXML
    private void gitEffect(MouseEvent event) {
        // entering imageView 
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.18);
        gitHub.setEffect(colorAdjust);
        // exiting imageView
        gitHub.addEventFilter(MouseEvent.MOUSE_EXITED, eh -> {
            gitHub.setEffect(null);
        });
    }

}
