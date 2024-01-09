import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class AdmissionTest extends Application {

    private int score = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the Login window
        GridPane loginPane = new GridPane();
        loginPane.setPadding(new Insets(10, 10, 10, 10));
        loginPane.setVgap(10);
        loginPane.setHgap(10);

        // Add the username label and text field
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);
        TextField usernameField = new TextField();
        GridPane.setConstraints(usernameField, 1, 0);

        // Add the password label and password field
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        // Add the Login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        // Add all the elements to the login pane
        loginPane.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
        loginPane.setAlignment(Pos.CENTER);
        // Create the Login scene and set it as the primary stage
        Scene loginScene = new Scene(loginPane, 300, 200);
        primaryStage.setScene(loginScene);
        primaryStage.show();

        // Create the MCQ page
        VBox mcqPane = new VBox();
        mcqPane.setPadding(new Insets(10, 10, 10, 10));
        mcqPane.setSpacing(10);

        // Add the MCQ questions
        Label question1 = new Label("What is the capital of France?");
        ToggleGroup group1 = new ToggleGroup();
        RadioButton option1a = new RadioButton("London");
        option1a.setToggleGroup(group1);
        RadioButton option1b = new RadioButton("Paris");
        option1b.setToggleGroup(group1);
        RadioButton option1c = new RadioButton("Berlin");
        option1c.setToggleGroup(group1);
        RadioButton option1d = new RadioButton("Madrid");
        option1d.setToggleGroup(group1);

        Label question2 = new Label("What is the largest planet in our solar system?");
        ToggleGroup group2 = new ToggleGroup();
        RadioButton option2a = new RadioButton("Jupiter");
        option2a.setToggleGroup(group2);
        RadioButton option2b = new RadioButton("Saturn");
        option2b.setToggleGroup(group2);
        RadioButton option2c = new RadioButton("Neptune");
        option2c.setToggleGroup(group2);
        RadioButton option2d = new RadioButton("Uranus");
        option2d.setToggleGroup(group2);

        Label question3 = new Label("What is the smallest country in the world?");
        ToggleGroup group3 = new ToggleGroup();
        RadioButton option3a = new RadioButton("Monaco");
        option3a.setToggleGroup(group3);
        RadioButton option3b = new RadioButton("Vatican City");
        option3b.setToggleGroup(group3);
        RadioButton option3c = new RadioButton("San Marino");
        option3c.setToggleGroup(group3);
        RadioButton option3d = new RadioButton("Liechtenstein");
        option3d.setToggleGroup(group3);

        Label question4 = new Label("What is the largest ocean in the world?");
        ToggleGroup group4 = new ToggleGroup();
        RadioButton option4a = new RadioButton("Atlantic Ocean");
        option4a.setToggleGroup(group4);
        RadioButton option4b = new RadioButton("Indian Ocean");
        option4b.setToggleGroup(group4);
        RadioButton option4c = new RadioButton("Arctic Ocean");
        option4c.setToggleGroup(group4);
        RadioButton option4d = new RadioButton("Pacific Ocean");
        option4d.setToggleGroup(group4);

        Label question5 = new Label("What is the highest mountain in the world?");
        ToggleGroup group5 = new ToggleGroup();
        RadioButton option5a = new RadioButton("Mount Kilimanjaro");
        option5a.setToggleGroup(group5);
        RadioButton option5b = new RadioButton("Mount Everest");
        option5b.setToggleGroup(group5);
        RadioButton option5c = new RadioButton("Mount Fuji");
        option5c.setToggleGroup(group5);
        RadioButton option5d = new RadioButton("Mount McKinley");
        option5d.setToggleGroup(group5);
          
            // Add the Submit button
            Button submitButton = new Button("Submit");

            // Add all the elements to the MCQ pane
            VBox vbox = new VBox();
            vbox.getChildren().addAll(question1, option1a, option1b, option1c, option1d,
                question2, option2a, option2b, option2c, option2d,
                question3, option3a, option3b, option3c, option3d,
                question4, option4a, option4b, option4c, option4d,
                question5, option5a, option5b, option5c, option5d,
                submitButton);

            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setContent(vbox);
            scrollPane.setFitToWidth(true);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            // Create the MCQ scene
            Scene mcqScene = new Scene(scrollPane, 500, 500);

            // Set the action for the Login button
            loginButton.setOnAction(e -> {
                /*Screen screen=Screen.getPrimary();
                Rectangle2D bounds = screen.getVisualBounds();
                primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());*/ 
                String username = usernameField.getText();
                String password = passwordField.getText();

            // Check if the username and password are correct
            if (username.equals("admin") && password.equals("password")) {
                primaryStage.setScene(mcqScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username or password");
                alert.setContentText("Please try again");
                alert.showAndWait();
            }
        });

        // Set the action for the Submit button
        submitButton.setOnAction(e -> {
            // Calculate the score
            if (option1b.isSelected()) {
                score++;
            }
            if (option2a.isSelected()) {
                score++;
            }
            if (option3b.isSelected()) {
                score++;
            }
            if (option4d.isSelected()) {
                score++;
            }
            if (option5b.isSelected()) {
                score++;
            }

            // Display the score
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Result");
            alert.setHeaderText("Your score is " + score + "/5");
            alert.showAndWait();
            primaryStage.setScene(loginScene);
            option1a.setSelected(false);
            option1b.setSelected(false);
            option1c.setSelected(false);
            option1d.setSelected(false);
            option2a.setSelected(false);
            option2b.setSelected(false);
            option2c.setSelected(false);
            option2d.setSelected(false);
            option3a.setSelected(false);
            option3b.setSelected(false);
            option3c.setSelected(false);
            option3d.setSelected(false);
            option4a.setSelected(false);
            option4d.setSelected(false);
            option4c.setSelected(false);
            option4b.setSelected(false);
            option5a.setSelected(false);
            option5c.setSelected(false);
            option5d.setSelected(false);
            option5b.setSelected(false);

            // Reset the score
            score = 0;
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
