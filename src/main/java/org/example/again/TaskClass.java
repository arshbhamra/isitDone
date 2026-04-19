package org.example.again;


enum PriorityType {
    HIGH,
    NORMAL,
    LOW
}

public class TaskClass {

    private String taskDes;
    private String taskName;
    private boolean isCompleted;
    private PriorityType priority;


    TaskClass(String taskName, PriorityType priority, String taskDes) {
        this.taskName = taskName;
        this.isCompleted = false;
        this.taskDes = taskDes;
        this.priority =  priority;
    }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public PriorityType getTaskPriority() {
        return priority;
    }
    public void setTaskPriority(PriorityType priority) {
        this.priority = priority;
    }

    public String getTaskDescription() { return taskDes; }
    public void setTaskDescription(String taskDescription) {
        this.taskDes = taskDescription;
    }
}
