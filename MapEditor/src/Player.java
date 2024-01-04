import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Color;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Player implements KeyboardHandler {

    private Grid grid;

    private SaveGame saveGame;;

    private Rectangle rectangle;

    private Boolean isPainted = false;


    public Player(Grid grid) {
        this.grid = grid;
        this.rectangle = new Rectangle(Utils.PADDING, Utils.PADDING, Utils.CELL_SIZE, Utils.CELL_SIZE);
        this.rectangle.setColor(Color.RED);
        this.rectangle.fill();
        this.saveGame = new SaveGame(grid);
        keyboardInit();
    }

    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        //Right key setup
        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(rightKeyPressed);


        //Left key setup
        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(leftKeyPressed);


        //Up key setup
        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(upKeyPressed);


        //Down key setup
        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(downKeyPressed);

        //Space key setup
        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(spaceKeyPressed);


        //Delete key setup
        KeyboardEvent dKeyPressed = new KeyboardEvent();
        dKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        dKeyPressed.setKey(KeyboardEvent.KEY_D);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(dKeyPressed);


        //Reset key setup
        KeyboardEvent rKeyPressed = new KeyboardEvent();
        rKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rKeyPressed.setKey(KeyboardEvent.KEY_R);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(rKeyPressed);


        //Reset key setup
        KeyboardEvent qKeyPressed = new KeyboardEvent();
        qKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        qKeyPressed.setKey(KeyboardEvent.KEY_Q);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(qKeyPressed);


        //Reset key setup
        KeyboardEvent sKeyPressed = new KeyboardEvent();
        sKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        sKeyPressed.setKey(KeyboardEvent.KEY_S);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(sKeyPressed);


        //Reset key setup
        KeyboardEvent lKeyPressed = new KeyboardEvent();
        lKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        lKeyPressed.setKey(KeyboardEvent.KEY_L);

        //Add listener to keyboard to listen to right key when pressed
        keyboard.addEventListener(lKeyPressed);
    }


    @Override
    public void keyPressed(KeyboardEvent e) {

        int key = e.getKey();
        switch (key) {
            case KeyboardEvent.KEY_RIGHT:
                rectangle.translate(Utils.CELL_SIZE, 0);
                break;
            case KeyboardEvent.KEY_LEFT:
                rectangle.translate(-Utils.CELL_SIZE, 0);
                break;
            case KeyboardEvent.KEY_UP:
                rectangle.translate(0, -Utils.CELL_SIZE);
                break;
            case KeyboardEvent.KEY_DOWN:
                rectangle.translate(0, Utils.CELL_SIZE);
                break;
            case KeyboardEvent.KEY_SPACE:
                grid.paintColor(rectangle);
                break;
            case KeyboardEvent.KEY_D:
                grid.deleteRectangle(rectangle);
                break;
            case KeyboardEvent.KEY_R:
                grid.deleteAll();
                break;
            case KeyboardEvent.KEY_S:
                saveGame.writeToFile();
                break;
            case KeyboardEvent.KEY_L:
                saveGame.readFile();
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(-1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){}
}







