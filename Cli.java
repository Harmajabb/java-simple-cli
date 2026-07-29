import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Map;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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
			String arguments = (parts.length < 2) ? "" : parts[1];
			String output = ""; // A variable named output of type String
			if (command.equals("exit") || command.equals("logout")) {
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
						Map<String, String> env = System.getenv();
						for (String key : env.keySet()){
							output += key + " = " + env.get(key) + "\n";
						}
					} else {
    						value = System.getenv(arguments);
    						output= value;
    					if (value == null) {
        					value = "";
    					}
					}
			} else if(command.equals("echo") || command.equals("print")) {
				output= arguments;
			} else if(command.equals("ls")) {
				if(arguments.isEmpty()){
					output= "Not a directory";
				} else {
					File directory = new File(arguments);
					if(directory.isDirectory()) {
						String[] files = directory.list();
							for(String name : files) {
								output += name + "\n";
							}
					} else {
					output = "Not a directory";
					}
				}
			} else if(command.equals("chuck")){
				Path path = Path.of("chuck.txt");
				try {
				List<String> lines = Files.readAllLines(path);
				Random random = new Random();
				int index = random.nextInt(lines.size());
				output = lines.get(index);
				} catch (IOException e) {
				output = "Error : Chuck.txt not found";
				}
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
