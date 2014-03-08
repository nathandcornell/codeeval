import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * FizzBuzz reads the first line of a user-supplied file and uses the three
 * space delimited integers to play a game of FizzBuzz.
 * The first argument is used as the first, or "fizz" number.
 * The second argument is used as the second, or "buzz" number.
 * The third argument is used as the maximum number, upon which the game ends.
 *
 * ** Renamed to "Main" since CodeEval renames the file to "Main.java" after
 *    upload.
 *
 * @author  Nate Cornell
 * @version 0.1
 */
public class Main {

    private static String fizz = "F";
    private static String buzz = "B";
    private static String badInput = "Invalid input. Try again.";
    private static String badFile = "Invalid file. Try again.";
    private static String badArgs = "Invalid arguments. Try again.";
    private static String validArguments = "The first two numbers must be " +
        "between 1 and 20, and the third must be between 21 and 100.";

    /**
     * The main function.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        String filename = args[0];

        int firstNumber  = 0;
        int secondNumber = 0;
        int max          = 0;

        if (filename == null || filename.length() < 2) { 
            System.out.println(badInput);
            return; 
        }

        ArrayList<String> arguments = getArgumentLines(filename);

        if (arguments == null || arguments.size() < 1) { 
            System.out.println(badFile);
            return;
        }

        for (String argumentLine : arguments) {
            String[] argumentArray = argumentLine.split("\\s+");

            if (argumentArray.length < 3) {
                System.out.println(badArgs);
                return;
            }

            firstNumber  = Integer.parseInt(argumentArray[0]);
            secondNumber = Integer.parseInt(argumentArray[1]);
            max          = Integer.parseInt(argumentArray[2]);

            if (   (firstNumber < 1 || firstNumber > 20) 
                || (secondNumber < 1 || secondNumber > 20)
                || (max < 21 || max > 100) ) {

                System.out.println( "Line \"" + argumentLine + 
                        "\" contains invalid arguments.\n" + validArguments);
                continue;
            }

            String message = "";

            for (int i = 1; i <= max; i++) {

                if ( i % firstNumber  == 0 ) { message += fizz; }
                if ( i % secondNumber == 0)  { message += buzz; }
                
                if (i % firstNumber != 0 && i % secondNumber != 0) { 
                    message += String.valueOf(i); 
                }

                if (i < max) message += ' ';
            }

            System.out.println(message);
        }
    }

    /**
     * Returns the argument strings from a given file.
     *
     * @param filename The name of the file
     *
     * @return The arguments lines within the file, or else null if errors
     *         are encountered
     */
    private static ArrayList<String> getArgumentLines(String filename) {
        String arguments = null;
        BufferedReader reader = null;
        ArrayList<String> argumentStrings = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(filename));

            if ( reader == null ) { 
                System.out.println(badInput);
                return null; 
            }

            int i = 0;

            while ((arguments = reader.readLine()) != null && i < 20) {
                argumentStrings.add(arguments);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(badFile);
            return null; 
        }

        try {
            if (reader != null) { reader.close(); }
        } catch (IOException e){
            e.printStackTrace();
        }

        return argumentStrings;
    }
}

