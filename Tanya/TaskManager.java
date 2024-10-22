
import javax.swing.JOptionPane;

public class TaskManager {
    private MyList<String> taskList;
    public TaskManager() {
        taskList = new MyList<>(); 
    }
    //menu
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        //Prompt until user selects to exit
        boolean exit = false;
        while (!exit) {
            String choice = JOptionPane.showInputDialog(
                    "Task Manager\n1. Add a Task\n2. View Tasks\n3. Remove a Task\n" +
                    "4. Remove all Tasks\n5. Exit\nPlease enter the number of your choice: ");
            if (choice != null) {
                switch (choice) {
                    case "1":
                        taskManager.addTask();
                        break;
                    case "2":
                        taskManager.viewTasks();
                        break;
                    case "3":
                        taskManager.removeTask();
                        break;
                    case "4":
                        taskManager.removeAllTasks();
                        break;
                    case "5":
                        exit = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No such option. Please enter a number between 1 and 5.");
                        break;
                }
            } else {
                exit = true;
            }
        }
    }

    
    
    //Add a task
    public void addTask() {
        String taskDescription = JOptionPane.showInputDialog("Enter task:");
        if (taskDescription != null && !taskDescription.trim().isEmpty()) {
            taskList.add(taskDescription);  
            JOptionPane.showMessageDialog(null, "Task added.");
        } else {
            JOptionPane.showMessageDialog(null, "You haven't added a task.");
        }
    }
    //method to view tasks
    public void viewTasks() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks.");
        } else {
            String tasksList = buildTasksList();
            JOptionPane.showMessageDialog(null, "Tasks:\n" + tasksList);
        }
    }

    //remove task
    public void removeTask() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task list is empty.");
            return;
        }
        //display all tasks
        String tasksList = buildTasksList();
        String input = JOptionPane.showInputDialog(null, "Current Tasks:\n" + tasksList + "\nEnter task number to remove:");
        try {
            int taskNumber = Integer.parseInt(input);
            if (taskNumber > 0 && taskNumber <= taskList.getLength()) {
                taskList.remove(taskNumber - 1);  
                JOptionPane.showMessageDialog(null, "Task removed.");
            } else {
                JOptionPane.showMessageDialog(null, "No such task.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number.");
        }
    }

    //remove all tasks
    public void removeAllTasks() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks to remove.");
        } else {
            taskList.clear(); 
            JOptionPane.showMessageDialog(null, "Removed all tasks.");
        }
    }

    
    //helper method to build a list of tasks
    private String buildTasksList() {
        StringBuilder tasksList = new StringBuilder();
        for (int i = 0; i < taskList.getLength(); i++) {
            tasksList.append((i + 1) + ". " + taskList.getEntry(i) + "\n"); 
        }
        return tasksList.toString();
    }
}
