package org.example.again;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class addTaskDialog {

    private static PriorityType priority;
    public TaskClass taskFromDialog;
    @FXML
    private TextField tasknameTF;
    @FXML
    private TextField taskdescTF;

    @FXML
    private Label labelTaskName;
    @FXML
    private Label labelTaskDesc;
    @FXML
    private Label labelTaskPri;

    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;


    @FXML
    public ComboBox<PriorityType> priorityTypeCB = new ComboBox<>();
    @FXML
    private Dialog addDialog;

    public void initialize() {
        priorityTypeCB.getItems().addAll(PriorityType.values());
        priorityTypeCB.setValue(PriorityType.NORMAL);
    }

    @FXML
    void handleAdd() {

        String taskName = tasknameTF.getText().trim();
        if (taskName.isEmpty()) {
            taskName = "fallback task name";
//            return;
        }
        String taskDesc = taskdescTF.getText().trim();
        if (taskDesc.isEmpty()) {
            taskDesc = "fallwwback task desc";
        }

        PriorityType priorityType = priorityTypeCB.getSelectionModel().getSelectedItem();

        // Store the created task in the instance field so HelloController can read it
        taskFromDialog = new TaskClass(taskName, priorityType, taskDesc);

        System.out.println("Adding new task from Dialog");
        if(taskFromDialog != null) {
            System.out.println("task isnt null");
        }else {
            System.out.println("task is null");
        }

        closeWindow();
    }

    void closeWindow() {
        Stage stage = (Stage) tasknameTF.getScene().getWindow();
        stage.close();
    }

    public void handleCancel() {
        taskFromDialog = null;
        closeWindow();
    }

    public TaskClass getTaskFromDialog() {
        System.out.println("getting new task from Dialog ");
//        addDialog.showAndWait();
        return taskFromDialog;
    }


//    String taskText = tasknameTF.getText().trim();
//        if(taskText.isEmpty()){
//            System.out.println("Task text is empty");
//            return;
//        }
//
//        String taskDesc = taskdescTF.getText().trim();
//
//        PriorityType priorityType = priorityTypeCB.getSelectionModel().getSelectedItem();
//
//        TaskClass newTask = new TaskClass(taskText, priorityType, "This is some Desc");
//        tasksList.add(newTask);
//        tasknameTF.clear();
//        taskdescTF.clear();


}
