import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
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
			String command = scanner.nextLine(); // Get input from console as a string
			String output = ""; // A variable named output of type String
			if (command.equals("exit")) {
				break; // Forces exit of the while loop
			} else if(command.equals("date")){
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(sdf.format(date));
			} else if(command.equals("time")){
				LocalTime time = LocalTime.now();
				System.out.println(time);
			} else if(command.equals("datetime")){
				LocalDateTime datetime = LocalDateTime.now();
				System.out.println(datetime);
			} else if(command.equals("useraccount")){
				String username = System.getProperty("user.name");
				System.out.println(username);
			} else if(command.equals("userhome")){
				String userhome = System.getProperty("user.home");
				System.out.println(userhome);
			} else if(command.equals("os")){
				String osName = System.getProperty("os.name");
				String osVersion = System.getProperty("os.version");
				String os = osName + " (" + osVersion + ")";
				System.out.println(os);
			} else if(command.startsWith("printenv")){
				String[] parts = command.split(" ");
				String varName;
				String value;
					if (parts.length < 2) {
						value = "";
					} else {
    						varName = parts[1];
    						value = System.getenv(varName);
    					if (value == null) {
        					value = "";
    					}
					}
				System.out.println(value);
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
