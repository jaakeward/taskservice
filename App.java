import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    	Scanner input = new Scanner(System.in);
        TaskService tasks = new TaskService();
        tasks.tasksList = new HashMap<String, Task>();
        Task current;
        String choice = "";
        String id;
        while (!choice.equals("9")){
            tasks.displayMenu();
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    tasks.addTask();
                    break;
                case "2":
                    System.out.println("Enter task ID: ");
                    id = input.nextLine();
                    current = tasks.getTask(id);
                    tasks.removeTask(current);
                    break;
                case "3":
                    System.out.println("Enter task ID: ");
                    id = input.nextLine();
                    if (tasks.getTask(id) != null){
                       current = tasks.getTask(id);
                        tasks.displayTask(current);
                        System.out.println("Enter update field (1-4): ");
                        String field = input.nextLine();
                        while (Integer.parseInt(field) > 4 || Integer.parseInt(field) < 1){
                            System.out.println("Please enter valid option (1-4): ");
                            field = input.nextLine();
                        }
                        System.out.println("Enter new info: ");
                        String newInfo = input.nextLine();
                        current = tasks.updateTask(current, field, newInfo); 
                    }
                    else {
                        System.out.println("Invalid ID");
                    }
                    break;
                case "4":
                    System.out.println("Enter task ID: ");
                    id = input.nextLine();
                    current = tasks.getTask(id);
                    tasks.displayTask(current);
                    break;
                case "9":
                    break;
            }
        }


        input.close();
        System.exit(0);

    }
}
