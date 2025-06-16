package todolist;

public class Task {
	private String description;
	private Boolean isDone;
	
	public Task(String description) {
		this.description = description;
		this.isDone = false;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	public void markAsDone() {
		isDone = true;
	}
	
	@Override
	public String toString() {
		return isDone ? "[X]" : "[]";
	}
	
	public String toFileFormat() {
		return description + "|" + isDone;
	}
	
	public static Task fromFileFormat(String line) {
		String[] parts = line.split("\\|");
		Task task = new Task(parts[0]);
		task.isDone = Boolean.parseBoolean(parts[1]);
		return task;
	}
	
	
}
