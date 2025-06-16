package todolist;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ToDoListManager manager = new ToDoListManager();
		manager.loadTasksFromFile("tasks.txt");
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while (running) {
			System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Delete Task");
            System.out.println("4. View Pending Tasks");
            System.out.println("5. View Completed Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
                System.out.print("Enter task description: ");
                String description = scanner.nextLine();
                manager.addTask(description);
                System.out.println("Task added.");
                break;

            case 2:
                System.out.print("Enter the task index to mark as done: ");
                int doneIndex = scanner.nextInt();
                scanner.nextLine();
                manager.markTaskAsDone(doneIndex);
                System.out.println("Task marked as done.");
                break;

            case 3:
                System.out.print("Enter the task index to delete: ");
                int deleteIndex = scanner.nextInt();
                scanner.nextLine();
                manager.deleteTask(deleteIndex);
                System.out.println("Task deleted.");
                break;

            case 4:
                System.out.println("Pending Tasks:");
                manager.viewPendingTasks();
                break;

            case 5:
                System.out.println("Completed Tasks:");
                manager.viewCompletedTasks();
                break;

            case 6:
                manager.saveTasksToFile("tasks.txt");
                System.out.println("Tasks saved. Exiting...");
                running = false;
                break;

            default:
                System.out.println("Invalid option. Please try again.");
            }
            
		}
		
		scanner.close();
	}
}
