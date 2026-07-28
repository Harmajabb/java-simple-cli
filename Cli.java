import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cli {

    // The main method is the entry point of the program. Rules regarding the main method:
    //     - public: so the JVM can access it from "outside"
    //     - static: so it can be called without creating an object (class scoped)
    //     - void: it doesn't return a value (aka procedure)
    //     - main: the required method name
    //     - String[] args: so it can receive command-line arguments
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
		System.out.print("> "); // Prompt
		while (true) { // Infinite loop
			String input = scanner.nextLine(); // Get input from console as a string
			String[] parts = input.split(" ", 2);
			String command = parts[0];
			String arguments;
			if (parts.length < 2) {
			arguments = "";
			} else {
			arguments = parts[1];
			}
			String output = ""; // A variable named output of type String
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} else if(command.equals("date")){
				LocalDate date = LocalDate.now();
				output= date.toString();
			} else if(command.equals("time")){
				LocalTime time = LocalTime.now();
				output= time.toString();
			} else if(command.equals("datetime")){
				LocalDateTime datetime = LocalDateTime.now();
				output= datetime.toString();
			} else if(command.equals("useraccount")){
				String username = System.getProperty("user.name");
				output= username;
			} else if(command.equals("userhome")){
				String userhome = System.getProperty("user.home");
				output= userhome;
			} else if(command.equals("os")){
				String osName = System.getProperty("os.name");
				String osVersion = System.getProperty("os.version");
				String os = osName + " (" + osVersion + ")";
				output= os;
			} else if(command.equals("printenv")){
				String value;
					if (arguments.length() < 1) {
						value = "";
					} else {
    						value = System.getenv(arguments);
    					if (value == null) {
        					value = "";
    					}
					}
				output= value;
			} else if(command.equals("echo")) {
				output= arguments;
			} else {
				// String concatenation
				output = "Command '" + command + "' not found.";
			}
			System.out.println(output); // Print with new line (ln)
			System.out.print("> "); // Prompt
		}
		scanner.close(); // Best practice, always close a stream when no more needed
		System.out.println("Bye!");
    }

}
