package todolist;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class ToDoListManager {
	private ArrayList<Task> tasks;
	
	public ToDoListManager() {
		tasks = new ArrayList<>();
	}
	
	public void addTask(String description) {
		tasks.add(new Task(description));
	}
	
	public void markTaskAsDone(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.get(index).markAsDone();
		}
	}
	
	public void deleteTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.remove(index);
		}
	}
	
	public void viewPendingTasks() {
		for (int i = 0; i < tasks.size(); i++) {
			if (!tasks.get(i).isDone()) {
				System.out.println(i + ". " + tasks.get(i));
			}
		}
	}
	
	public void viewCompletedTasks() {
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).isDone()) {
				System.out.println(i + ". " + tasks.get(i));
			}
		}
	}
	
	public void saveTasksToFile(String filename) {
		try (PrintWriter writer = new PrintWriter(filename)) {
			for (Task task : tasks) {
				writer.println(task.toFileFormat());
			}
		} catch (Exception e) {
			System.out.println("Error saving tasks: " + e.getMessage());
		}
	}
	
	public void loadTasksFromFile(String filename) {
		tasks.clear();
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			
		} catch (Exception e) {
			System.out.println("Error loading tasks: " + e.getMessage());
		}
	}
}
