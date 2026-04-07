import java.io.*;

public class FileOperationsDemo {

    public static void writeFile() {
        try {
            FileWriter fw = new FileWriter("test.txt");
            fw.write("Hello, this is written to file!");
            fw.close();
            System.out.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void appendFile() {
        try {
            FileWriter fw = new FileWriter("test.txt", true);
            fw.write("\nThis line is appended!");
            fw.close();
            System.out.println("File appended successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String line;
            System.out.println("\nReading file content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void fileNotFoundDemo() {
        try {
            FileReader fr = new FileReader("nofile.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nFile not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        writeFile();        
        appendFile();       
        readFile();         
        fileNotFoundDemo(); 

    }
}
