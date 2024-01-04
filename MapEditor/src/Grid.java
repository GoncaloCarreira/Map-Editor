import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Grid {

    private int cols;
    private int rows;
    public Rectangle[][] grid;
    private boolean[][] isPainted;
    private Rectangle rectangle;
    List<Rectangle> gridList = Collections.synchronizedList(new ArrayList<Rectangle>());


    //CONSTRUCTOR
    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        makeGrid();
        this.isPainted = new boolean[cols][rows];
        this.gridList = Collections.synchronizedList(new ArrayList<>());
    }

    //METHODS
    public void makeGrid() {

        grid = new Rectangle[cols][rows];

        int x = Utils.PADDING;
        int y = Utils.PADDING;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.rectangle = new Rectangle(x + i * Utils.CELL_SIZE, y + j * Utils.CELL_SIZE, Utils.CELL_SIZE, Utils.CELL_SIZE);
                rectangle.setColor(Color.BLACK);
                rectangle.draw();
                grid[i][j] = rectangle;
            }
        }
    }

    public void paintColor(Rectangle playerRectangle) {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle currentRectangle = grid[i][j];
                if (currentRectangle.getX() == playerRectangle.getX() &&
                        currentRectangle.getY() == playerRectangle.getY()) {
                    currentRectangle.setColor(Color.BLUE);
                    currentRectangle.fill();
                    gridList.add(currentRectangle);
                    isPainted[i][j] = true;
                }
            }
        }
    }

    public void deleteRectangle(Rectangle playerRectangle) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Rectangle currentRectangle = grid[i][j];
                if (currentRectangle.getX() == playerRectangle.getX() &&
                        currentRectangle.getY() == playerRectangle.getY()) {
                    currentRectangle.setColor(Color.BLACK);
                    currentRectangle.draw();
                    isPainted[i][j] = false;                }
            }
        }
    }

    public void deleteAll() {

        for (Rectangle rectangle : gridList) {
            rectangle.setColor(Color.BLACK);
            rectangle.draw();
        }
        gridList.clear();
        resetIsPainted();
    }

    public void stringToGrid(String s) {
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char currentChar = s.charAt(index);
                if (currentChar == '1') {
                    Rectangle currentRectangle = grid[j][i];
                    currentRectangle.setColor(Color.BLUE);
                    currentRectangle.fill();
                    gridList.add(currentRectangle);
                    isPainted[j][i] = true;
                } else {
                    isPainted[j][i] = false;
                }
                index++;
            }
            index++;
        }
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                strBuilder.append(isPainted[j][i] ? "1" : "0");
            }
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }


    private void resetIsPainted() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                isPainted[i][j] = false;
            }
        }
    }
}



