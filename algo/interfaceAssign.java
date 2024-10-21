package TanyaA1_3475_001;

public interface ListInterface<T> {
 //method add(newEntry): adds a new entry to the end of the list.
	    public void add(T newEntry);
//method add(newPosition, newEntry): Adds a new entry to the list at a given position.
	    public void add(int newPosition, T newEntry);
//method remove(givenPosition): Removes the entry at a given position from the list.
	    public T remove(int givenPosition);
//method clear(): Removes all entries from the list.
	    public void clear();
//method replace(givenPosition, newEntry): Replaces the entry at a given position in the list with a given entry.
	    public void replace(int givenPosition, T newEntry);
//method getEntry(givenPosition): Retrieves the entry at a given position in the list.
	    public T getEntry(int givenPosition);
//method toArray(): Retrieves all entries in the list in their current order.
	    public T[] toArray();
//method contains(anEntry): Sees whether the list contains a given entry.
	    public boolean contains(T anEntry);
//method getLength(): Gets the number of entries in the list.
	    public int getLength();
//method isEmpty(): Sees whether the list is empty.
	    public boolean isEmpty();
}


package TanyaA1_3475_001;
import java.util.Arrays;
public class MyList<T> implements ListInterface<T> {
	private T[] list;
    private int size;
    private static final int MAXSIZE = 20;
//constructor
	public MyList() {
		list = (T[]) new Object[MAXSIZE];
		size = 0;
	}
//Adds a new entry to the end of the list.
	@Override
	public void add(T newEntry) {
		if (size < MAXSIZE) {
			list[size] = newEntry;
			size++;
		}
		
	}
    //Adds a new entry to the list at a given position
	@Override
	public void add(int newPosition, T newEntry) {
		if (newPosition >= 0 && newPosition <= size) {
			if (size < MAXSIZE) {
				for (int i = size; i > newPosition; i--) {
					list[i] = list[i - 1];
				}
				list[newPosition] = newEntry;
				size++;
			}
		}
		
	}
	//Removes the entry at a given position from the list.
	
	@Override
	public T remove(int givenPosition) {
		T result = null;
		if (givenPosition >= 0 && givenPosition < size) {
			result = list[givenPosition];
			for (int i = givenPosition; i < size - 1; i++) {
				list[i] = list[i + 1];
			}
			list[size - 1] = null;
			size--;
		}
		return result;
	}
	//Removes all entries from the list.
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			list[i] = null;
		}
		size = 0;	
	}
	//Replaces the entry at a given position in the list with a given entry.
	@Override
	public void replace(int givenPosition, T newEntry) {
		if (givenPosition >= 0 && givenPosition < size) {
			list[givenPosition] = newEntry;
		}
		
	}
	//Retrieves the entry at a given position in the list
	@Override
	public T getEntry(int givenPosition) {
		T result = null;
		if (givenPosition >= 0 && givenPosition < size) {
			result = list[givenPosition];
		}
		return result;
	}
//Retrieves all entries in the list in their current order.
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			result[i] = list[i];
		}
		return result;
	}
//Sees whether the list contains a given entry.
	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		for (int i = 0; i < size; i++) {
			if (list[i].equals(anEntry)) {
				found = true;
				break;
			}
		}
		return found;
	}
//Gets the number of entries in the list
	@Override
	public int getLength() {
		return size;
	}
//Sees whether the list is empty.
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Test:
    public static void main(String[] args) {
	 MyList<String> myList = new MyList<>();
     myList.add("Alice");
     myList.add("Connor");
     myList.add("Lyra");
     System.out.println("add(T newEntry): " + Arrays.toString(myList.toArray()));
     myList.add(1, "Sky");
     System.out.println("add(int newPosition, T newEntry): " + Arrays.toString(myList.toArray()));
     myList.remove(2);
     System.out.println("remove(int givenPosition): " + Arrays.toString(myList.toArray()));
     myList.replace(0, "Marshall");
     System.out.println("replace(int givenPosition, T newEntry): " + Arrays.toString(myList.toArray()));
     System.out.println("contains(T anEntry=Lyra): " + myList.contains("Lyra"));
     System.out.println("contains(T anEntry=Tom): " + myList.contains("Tom"));
     System.out.println("getLength(): " + myList.getLength());
     System.out.println("isEmpty(): " + myList.isEmpty());
     myList.clear();
     System.out.println("toArray(): " + Arrays.toString(myList.toArray()));
 }
}
        


package TanyaA1_3475_001;

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
