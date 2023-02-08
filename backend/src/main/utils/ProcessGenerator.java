import java.lang.ProcessBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.Locale;
import java.io.File;

public class ProcessGenerator {

    public ProcessGenerator() {}
    private ProcessBuilder pb = new ProcessBuilder();
    private String OS = (System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH));
    private String errorString = "";
    private boolean buildSuccess = false;
    
    /*
    * Set the command to be called on a new process.
      If doTest is set to true, perform testing. Otherwise, only compile the project.
    */
    private void setProcessGoal(boolean doTest) {
        String command;
        if (doTest) {
            command = "mvn test";
        }
        else {
            command = "mvn clean install -DskipTests=true";
        }

        //Command executed in terminal depends on OS. Currently, Windows and Linux is supported.
        if (OS.indexOf("win") >= 0) {
            pb.command("cmd", "/c",command);
        }
        else {
            pb.command(command);
        }
    }

    private void runProcess() {
        try {
            Process pr = pb.start();

            try (BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()))) {
                String currentLine;
                StringBuilder result = new StringBuilder();
                while ((currentLine = input.readLine()) != null){
                    if (currentLine.contains("[ERROR]")){
                        result.append(currentLine);
                        result.append(System.getProperty("line.separator"));
                    }
                }
                errorString = result.toString();
                if (result.length() > 0) {
                    buildSuccess = false;
                }
                else {
                    buildSuccess = true;
                }
              }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
    * Set the directory in which the process will attempt to compile and test the project.
    */
    public void setDirectory(File directory) {
        pb.directory(directory);
    }

    /*
    * Start a new process which compiles the project in the chosen directory and stores any errors.
    */
    public void compileProject() {
        setProcessGoal(false);
        runProcess();
    }

    /*
    * Start a new process which tests the project in the chosen directory and stores any errors.
    */
    public void testProject() {
        setProcessGoal(true);
        runProcess();
    }

    /*
    * Return the process status as a boolean.
      If a compilation/test has been run and produced no errors, returns true.
      Otherwise, returns false.
    */
    public boolean getStatus() {
        return buildSuccess;
    }

    /*
    * Return the process errors as a string.
      Errors produced during Maven compilation are separated by a newline.
      If there are no errors, outputs null.
    */
    public String getErrors() {
        if (errorString.length() > 0) {
            return errorString;
        }
        else {
            return null;
        }
    }
}