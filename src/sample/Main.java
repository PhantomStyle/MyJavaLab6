package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {


    @FXML
    private Button start;

    @FXML
    private TextField timeBarSecond;

    @FXML
    private Button reset;

    @FXML
    private Label labelHour;

    @FXML
    private Label labelMin;

    @FXML
    private TextField timeBarMunute;

    @FXML
    private Label labelSec;

    @FXML
    private TextField timeBarHour;

    @FXML
    private Button pause;

    @FXML
    private Pane pane;

    @FXML
    private Text textSec;


    Stage stage;

    private int hours;
    private int minuties;
    private int seconds;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("6 labka");

        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    void initialize() {
//        readTimeBar();
    }

    private void readTimeBar() {
        if (Integer.parseInt(timeBarHour.getText()) < 0
                || Integer.parseInt(timeBarMunute.getText()) > 60
                || Integer.parseInt(timeBarMunute.getText()) < 0
                || Integer.parseInt(timeBarSecond.getText()) > 60
                || Integer.parseInt(timeBarSecond.getText()) < 0) {
            throw new RuntimeException();
        }

        hours = Integer.parseInt(timeBarHour.getText());
        minuties = Integer.parseInt(timeBarMunute.getText());
        seconds = Integer.parseInt(timeBarSecond.getText());
    }

    @FXML
    private void onStart1() throws InterruptedException, IOException {
        //смс тип введи значения


            readTimeBar();

//            for (int i = seconds; i != 0; i--) {
//
//                int finalI = i;
//                Platform.runLater(() -> {
//                    timeBarSecond.setText(String.valueOf(finalI));
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    textSec.setText(String.valueOf(finalI));
//                });
//
//
//                    if (i == 0 && minuties != 0 && minuties >= 0) {
//                        i = 60;
//                        minuties--;
//                        timeBarSecond.setText(String.valueOf(60));
//                        timeBarMunute.setText(String.valueOf(minuties));
//                    }
//
//                    if (i == 0 && minuties == 0 && hours >= 0) {
//                        i = 60;
//                        minuties = 60;
//                        hours--;
//                        timeBarSecond.setText(String.valueOf(60));
//                        timeBarMunute.setText(String.valueOf(60));
//                        timeBarHour.setText(String.valueOf(hours));
//                    }
//
//                    if (i == 0 && minuties == 0 && hours == 0) {
//                        ////окошко с концом
//                    }
//                    labelSec.setText(String.valueOf(i));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//            }



        Timeline time = new Timeline();


        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {


                seconds--;
                timeBarSecond.setText(String.valueOf(seconds));
                if (seconds <= 0) {
                    time.stop();
                }


            }


        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if (time != null) {
            time.stop();
        }
        time.play();
    }

}
