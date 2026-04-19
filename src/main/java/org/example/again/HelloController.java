package org.example.again;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.Dialog;
import java.io.IOError;
import java.io.IOException;
import java.util.ResourceBundle;

//import static org.example.again.addTaskDialog.priority;
import org.example.again.TaskClass;
public class HelloController {
    @FXML
    static ObservableList<TaskClass> tasksList;
    //    @FXML
//    private TextField tasknameTF;
//    @FXML
//    private TextField taskdescTF;
//
//    @FXML
//    private Dialog addDialog;
//
//    @FXML
//    private Label labelTaskName;
//    @FXML
//    private Label labelTaskDesc;
//    @FXML
//    private Label labelTaskPri;
//@FXML
//private ComboBox<PriorityType> priorityTypeCB = new ComboBox<>();
    private static PriorityType priority;
    @FXML
    private Label welcomeText;
    @FXML
    private Label isitdoneHeading;
    @FXML
    private Button addButton;
    @FXML
    private ListView<TaskClass> TaskListView = new ListView<>(tasksList);

    private TaskClass newTask;

    static void dummyData() {

        tasksList.add(new TaskClass("taskNumber1", priority.LOW, "This is some Desc"));
        tasksList.add(new TaskClass("taskNumber2", priority.LOW, "This is some Desc"));
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
//    TaskListView.setStyle("-fx-background-color: #20B2AA; -fx-background-radius: 15px; -fx-text-fill: #ffffff;");

    private void onHeadingClick() {
        isitdoneHeading.setEffect(new Glow(3));
    }

    @FXML
    public void initialize() {
        tasksList = FXCollections.observableArrayList();
        TaskListView.setItems(tasksList);
        TaskListView.setCellFactory(param -> new TaskBars());
        dummyData();

//        priorityTypeCB.getItems().addAll(PriorityType.values());
//        priorityTypeCB.setValue(PriorityType.NORMAL);

    }

    public void addTaskDialog() throws IOException {
        System.out.println(getClass().getResource("/org/example/again/addTaskDialog.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/again/addTaskDialog.fxml"));
        Parent root = loader.load();
        addTaskDialog controller = loader.getController();

        double height = 600;
        double width = 600;
        Stage stage = new Stage();
        stage.setTitle("Add Task");
        stage.setScene(new Scene(root, width, height));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

//        addTaskDialog controller = new addTaskDialog();
        System.out.println();
        System.out.println("Dialog called worked~");
        System.out.println("making new task form dialog");

//        newTask = new TaskClass(controller.getTaskFromDialog());
        TaskClass newTask = controller.getTaskFromDialog();
        if (newTask == null) {
            System.out.println("task is null");
        } else {
            System.out.println(newTask.getTaskName());
            System.out.println("made new task form dialog");
        }
        if (newTask != null) {
            System.out.println("new task added");
//            System.out.println(tasksList.get(2));
            tasksList.add(newTask);
        }
        if (newTask == null) {

            System.out.println("New task not added");
        }
    }

}
