import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.List;

public class SaveGame {

    private static final String FILEPATH = "resources/Map.txt";

    private Grid grid;

    public SaveGame(Grid grid){
        this.grid = grid;
    }

    public void readFile() {
        BufferedReader reader = null;

        try {

            String line;
            reader = new BufferedReader(new FileReader(FILEPATH));
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            grid.stringToGrid(result.toString());

        } catch (IOException ex) {
            System.err.println("Something went wrong" + ex.getMessage() );
        } finally {

            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeToFile() {

        BufferedWriter writer;

        try {

            writer = new BufferedWriter(new FileWriter(FILEPATH));
            writer.write(grid.toString());
            writer.close();

        } catch (IOException ex) {
            System.err.println("Something went wrong " + ex.getMessage());
        }
    }

}
