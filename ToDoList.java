import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Removed: " + removedTask);
        } else {
            System.out.println("Invalid index. Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
        String command;

        System.out.println("Welcome to the To-Do List!");
        
        do {
            System.out.print("Enter a command (add, remove, view, exit): ");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter the task to add: ");
                    String taskToAdd = scanner.nextLine();
                    toDoList.addTask(taskToAdd);
                    break;

                case "remove":
                    System.out.print("Enter the task number to remove: ");
                    try {
                        int taskNumber = Integer.parseInt(scanner.nextLine());
                        toDoList.removeTask(taskNumber - 1); // Adjust for zero-based index
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "view":
                    toDoList.viewTasks();
                    break;

                case "exit":
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
