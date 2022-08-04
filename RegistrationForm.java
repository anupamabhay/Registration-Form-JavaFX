import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistrationForm extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Setting title of the stage
        stage.setTitle("Registration Form");

        //Creating new grid pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); //aligning grid to the center
        grid.setHgap(15); //setting horizontal gap b/w cols
        grid.setVgap(10); //setting vertical gap b/w cols
        grid.setPadding(new Insets(25,15,25,15)); //setting the grid padding
        grid.setMinSize(500,500); //setting the min size of the grid
        grid.setStyle("-fx-background-color:#948fbc;");

        //Creating new label for the name
        Label  userName = new Label("Name:");
        grid.add(userName,0,1);
        //creating new text field for username
        TextField userNameTxt = new TextField();
        grid.add(userNameTxt,1,1);
        //DOB
        DatePicker datePicker = new DatePicker();
        //Label for DOB
        Label DOB = new Label("DOB:");
        grid.add(DOB,0,2);
        grid.add(datePicker,1,2);

        //Label for ToggleGroup of Radio Buttons
        Label gender = new Label("Gender:");
        grid.add(gender,0,3);

        //Radio Button
        ToggleGroup radioGroup = new ToggleGroup();
        RadioButton radioBtn = new RadioButton("Male");
        RadioButton radioBtn2 = new RadioButton("Female");
        radioBtn.setToggleGroup(radioGroup);
        radioBtn2.setToggleGroup(radioGroup);
        grid.add(radioBtn,1,3);
        grid.add(radioBtn2,1,4);

        //Label for Skill checkboxes
        Label LabelChb = new Label("Skills:");
        grid.add(LabelChb,0,5);

        //Skill checkboxes
        CheckBox chb = new CheckBox("Java");
        CheckBox chb2 = new CheckBox("JavaScript");
        CheckBox chb3 = new CheckBox("Python");
        chb.setIndeterminate(false);
        chb2.setIndeterminate(false);
        chb3.setIndeterminate(false);
        //adding checkboxes to the grid
        grid.add(chb,1,5);
        grid.add(chb2,2,5);
        grid.add(chb3,3,5);

        //Label for Qualification
        Label LabelQual = new Label("Qualification:");
        //Qualifications Drop-down menu
        ChoiceBox qual = new ChoiceBox();
        qual.getItems().addAll("B.A","B.Tech","BCA","Diploma","MBBS","PhD");
        grid.add(LabelQual,0,6);
        grid.add(qual,1,6);

        //HBox to contain both buttons
        HBox hb = new HBox();
        hb.setSpacing(15);
        hb.setAlignment(Pos.BOTTOM_LEFT);
        hb.setPrefWidth(70);
        //Register Button
        Button btn = new Button("Register");
        btn.setMinWidth(hb.getPrefWidth());
        btn.setMaxWidth(Double.MAX_VALUE);
        //Quit Button
        Button quitBtn = new Button("Quit");
        quitBtn.setMinWidth(hb.getPrefWidth());
        btn.setMaxWidth(Double.MAX_VALUE);
        //Adding both buttons to HBox and adding the HBox to the grid
        hb.getChildren().setAll(quitBtn,btn);
        grid.add(hb,0,7);

        //Text to be shown on button click
        final Text actionTxt = new Text("Registration Successful!");
        //Button click events
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actionTxt.setFill(Color.valueOf("#a02641"));
                actionTxt.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 15));
                grid.add(actionTxt,1,7);
            }
        });
        quitBtn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        //Styling components
        btn.setStyle("-fx-background-color: #331760; -fx-text-fill: white;");
        userName.setStyle("-fx-font: normal bold 12px 'Helvetica' ");
        DOB.setStyle("-fx-font: normal bold 12px 'Helvetica' ");
        gender.setStyle("-fx-font: normal bold 12px 'Helvetica' ");
        LabelChb.setStyle("-fx-font: normal bold 12px 'Helvetica' ");
        LabelQual.setStyle("-fx-font: normal bold 12px 'Helvetica' ");

        //Creating new scene and adding it to the stage
        Scene scn = new Scene(grid, 300, 275);
        stage.setScene(scn);
        stage.show();
        stage.setMinWidth(600);
        stage.setMaxHeight(1000);
    }
    public static void main(String[] args) {
        launch();
    }
}
