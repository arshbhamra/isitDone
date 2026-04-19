package org.example.again;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TaskBars extends ListCell<TaskClass>{

    private HBox content;
    private CheckBox checkBox;
    private VBox textBox;
    private Label titleLabel;
    private Label descLabel;
    private Button deleteBtn;
    private Label priorityLabel;


    public TaskBars() {
            super();

            // Create UI components
            checkBox = new CheckBox();
            titleLabel = new Label();
            descLabel = new Label();
            deleteBtn = new Button("🗑");
            priorityLabel = new Label();

            titleLabel.setStyle("-fx-font-weight: bold;");
//            descLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: gray;");

            textBox = new VBox(2, titleLabel, descLabel);
            HBox.setHgrow(textBox, Priority.ALWAYS);

            content = new HBox(10, checkBox, textBox,priorityLabel, deleteBtn);
            content.setAlignment(Pos.CENTER_LEFT);

            // Event handlers
            checkBox.setOnAction(e -> {
                TaskClass task = getItem();
                if (task != null) {
                    task.setCompleted(checkBox.isSelected());
                    updateItem(task, false);
                }
            });

            deleteBtn.setOnAction(e -> {
                getListView().getItems().remove(getItem());
            });
        }

        @Override
        protected void updateItem(TaskClass task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setText(null);
                setGraphic(null);
            } else {
                PriorityType OBJpriorityType = task.getTaskPriority();

                titleLabel.setText(task.getTaskName());
                priorityLabel.setText(OBJpriorityType.name());
                descLabel.setText(task.getTaskDescription());
                checkBox.setSelected(task.isCompleted());

                if (task.isCompleted()) {
                    titleLabel.setStyle("-" +
                            "fx-font-weight: bold; -fx-strikethrough: true; -fx-text-fill: gray;");
                } else {
                    titleLabel.setStyle("-fx-font-weight: bold;");
                }

                setGraphic(content);
            }
        }
    }

