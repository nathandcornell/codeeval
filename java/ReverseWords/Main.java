import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        String filename = args[0];
        
        if (filename == null || filename.length() < 1) { return; }

        ArrayList<String> lines = getLines(filename);

        if (lines == null || lines.size() < 1) { return; }

        for (String line : lines) {
            String lineReversed = "";

            String[] lineArray = line.split("\\s+");

            for (int i = lineArray.length - 1; i >= 0; i--) {
                lineReversed += lineArray[i];

                if (i > 0) { lineReversed += " "; }
            }

            System.out.println(lineReversed);
        }
    }

    /**
     * Returns the lines from a given file.
     *
     * @param filename The name of the file
     *
     * @return The lines within the file, or else null if errors
     *         are encountered
     */
    private static ArrayList<String> getLines(String filename) {
        String line = null;
        BufferedReader reader = null;
        ArrayList<String> lines = new ArrayList<String>();

        try {
            reader = new BufferedReader(new FileReader(filename));

            if ( reader == null ) { return null; }

            while ((line = reader.readLine()) != null) {
                if (line.length() < 1) { continue; }

                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null; 
        }

        try {
            if (reader != null) { reader.close(); }
        } catch (IOException e){
            e.printStackTrace();
        }

        return lines;
    }
}

