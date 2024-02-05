import java.util.HashMap;
import java.util.Scanner;

public class TaskService {

    
    public HashMap<String, Task> tasksList;
    Scanner input = new Scanner(System.in);
    
    public TaskService() {
        tasksList = new HashMap<String, Task>();
    }
    public Task getTask(String id) {
        try {
            return tasksList.get(id);
        }
        catch (NullPointerException e){
            return null;
        }
    }
    public void displayMenu() {
        System.out.println("Enter choice: \n" +
                        "1: Add Task\n" + 
                        "2: Remove Task\n" +
                        "3: Update Task info\n" +
                        "4: View Task info\n" +
                        "9: Exit");
    }
    public void addTask() {
        String taskID;
        String[] taskInfo = new String[2];
        System.out.println("Enter Task ID: ");
        taskID = input.nextLine();
        if (!tasksList.keySet().contains(taskID)){
            System.out.println("Enter task name: ");
            taskInfo[0] = input.nextLine();
            System.out.println("Enter task description: ");
            taskInfo[1] = input.nextLine();
            if (verifyInput(taskInfo[0], taskInfo[1])) {
            Task ta = new Task(taskID, taskInfo[0], taskInfo[1]);
            tasksList.put(taskID, ta);
            }
        }
        else {
            System.out.println("Invalid input");
        }
    }
    public void addTask(Task ta) {
    	try {
    		if (isUnique(ta, ta.taskID) && verifyInput(ta.taskName, ta.taskDesc)) {
    			tasksList.put(ta.taskID, ta);
    		}
    		else {
    			System.out.println("Invalid Task");
    		}
    	}catch (NullPointerException e) {
    	}
    }
    public void removeTask(Task ta) {
    	try {
    		tasksList.remove(ta.taskID);
    	}catch (NullPointerException e) {		
    	}
    }
    public void displayTask(Task ta){
        try{
            System.out.println("Task ID: " + ta.taskID + 
                "\n1. Name: " + ta.taskInfo[0] +
                "\n2. Description: " + ta.taskInfo[1]);
        }catch(NullPointerException e){
        } 
    }
    public Task updateTask(Task ta, String option, String newInfo) {
        try {
            switch (option) {
                case "1":
                    ta = new Task(ta.taskID, newInfo, ta.taskInfo[1]);
                    if (verifyInput(newInfo, ta.taskInfo[1])) {
                    	removeTask(ta);
                    	addTask(ta);
                    }
                    break;
                case "2": 
                    ta = new Task(ta.taskID, ta.taskInfo[0], newInfo);
                    if (verifyInput(ta.taskInfo[0], newInfo)) {
	                	removeTask(ta);
	                	addTask(ta);
	                }
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }catch (NullPointerException e){
        }
        return ta;
    }
    private boolean isUnique(Task ta, String tID) {
    	try {
    		if (tasksList.keySet().contains(tID)){
    			return false;
    		}
    		else if(tID == null) {
    			return false;
    		}
    		else if(tID.length() > 10) {
    			return false;
    		}
    		return true;
    	}catch(NullPointerException e) {
    		return false;
    	} 
    }
    private boolean verifyInput(String name, String desc)
    {
        boolean verified = true;
        if ((name == null) || (name.length() > 20)){
            System.out.println("Task name error (max 20 characters)");
            verified = false;
        }
        if ((desc == null) || (desc.length() > 50)){
            System.out.println("Task description error (max 50 characters)");
            verified = false;
        }
        return verified;
    }
}