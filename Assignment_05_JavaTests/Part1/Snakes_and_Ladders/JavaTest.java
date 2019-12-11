package Snakes_and_Ladders;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import java.io.ByteArrayInputStream;

import Snakes_and_Ladders.GameBoard;
import Snakes_and_Ladders.Player;
import Snakes_and_Ladders.square;


import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * @author Christian
 * @author Thanh Cong
 * @author Filip
 * @version 1.0
 */

public class JavaTest {

    private GameBoard board;

    /**
     * In case we would take a closer look to the properties of exceptions
     */

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * For the unit testing we need preparation to test the methods.
     */

    @Before
    public void setup(){board = new GameBoard();}

    /*
    @Test
    public void noNumberOfPlayers(){
    GameBoard board = new GameBoard();

    String user = "5";
    InputStream in = new ByteArrayInputStream(user.getBytes());
    System.setIn(in);

    thrown.expect(InputMismatchException.class);
    thrown.expectMessage("You did not enter a whole number...");
    board.setPlayerNumber();
    }
    */

    /**
     * It tests, whether the user input is equal to the number of players
     */

    @Test
    public void numberOfPlayers(){
    GameBoard board = new GameBoard();

    String user = "2";
    InputStream in = new ByteArrayInputStream(user.getBytes());
    System.setIn(in);

    Assert.assertEquals(2, board.setPlayerNumber());
    }

    /**
     * {@link #anyStringName()} tests, if the names of the players are saved correctly within the array
     */

    @Test
    public void anyStringName(){
    GameBoard board = new GameBoard();

    String name1 = "Max\nMoritz";
    //String name2 = "Moritz";
        InputStream in1 = new ByteArrayInputStream(name1.getBytes());
    System.setIn(in1);
      //  InputStream in2 = new ByteArrayInputStream(name2.getBytes());
        //System.setIn(in2);

    Player[] playerList;
            playerList = GameBoard.setPlayerName(2);

    Assert.assertEquals("Max", playerList[0].getName());
        Assert.assertEquals("Moritz", playerList[1].getName());
    }

    /*
    @Test
    public void wrongBoardInput(){
    GameBoard board = new GameBoard();

    String user = "A\n7";
    InputStream in = new ByteArrayInputStream(user.getBytes());
    System.setIn(in);

    thrown.expect(InputMismatchException.class);
    thrown.expectMessage("You did not enter a whole number...");
    board.setBoardSize();
    }
     */

    /**
     * {@link #leastBoardSize()} tests, if the expected user input is correct
     */

    @Test
        public void leastBoardSize(){
    GameBoard board = new GameBoard();

    String user = "7";
    InputStream in = new ByteArrayInputStream(user.getBytes());
    System.setIn(in);

    Assert.assertEquals(7, board.setBoardSize());
    }

    /**
     * {@link #rantIntWrongMinMax()} throws an exception by asserting the integer min is greater than max
     */

    @Test
    public void rantIntWrongMinMax(){
    GameBoard board = new GameBoard();
    int min = 5;
    int max = 4;

    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("max has to be greater equal to min");
    board.randInt(min, max);
    }

    /**
     * {@link #rantIntBetweenMinMax()} tests, if the random picked integer is within the given range
     */

    @Test
    public void rantIntBetweenMinMax(){
    GameBoard board = new GameBoard();
    int min = 5;
    int max = 5;

    Assert.assertEquals(5, board.randInt(min, max));

    min = 0;
    max = 3;

    Assert.assertTrue(0 <= board.randInt(min, max));
    Assert.assertTrue(3 >= board.randInt(min, max));

    }

    /**
     * {@link #isSnakeSquare()} tests the method, whether a {@link square} is a {@link SnakeSquare} or not
     */

    @Test
    public void isSnakeSquare(){
    GameBoard board = new GameBoard();

    square[] table = new square[]
            {new square(0, 1),
                    new square(1, 0),
                    new SnakeSquare(2, 0, 3),
                    new square(3, 0),
                    new square(4, 0),
                    new LadderSquare(5, 0, 4),
                    new square(6, 0)};
    Assert.assertTrue(board.isSnake(table[2]));
    Assert.assertFalse(board.isSnake(table[1]));
    }

    /**
     * {@link #isLadderSquare()} tests the method, whether a {@link square} is a {@link LadderSquare} or not
     */

    @Test
    public void isLadderSquare(){
    GameBoard board = new GameBoard();

        square[] table = new square[]
                {new square(0, 1),
                        new square(1, 0),
                        new SnakeSquare(2, 0, 3),
                        new square(3, 0),
                        new square(4, 0),
                        new LadderSquare(5, 0, 4),
                        new square(6, 0)};
    Assert.assertTrue(board.isLadder(table[5]));
        Assert.assertFalse(board.isLadder(table[3]));
    }

    /**
     * {@link #resizeArray()} tests, whether the length and the correct positions are in the new array
     */

    @Test
    public void resizeArray() {
        GameBoard board = new GameBoard();
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        int[] image = array;
        int[] tempArray = new int[image.length - 2];
        int tempStart = 1;      //board.randInt(1, tempArray.length - 3);
        int tempEnd = 2;        //board.randInt(tempStart+1,snakeLadderArray.length-2);

        int [] example = new int[]{0, 3, 4, 5, 6};
        int [] test = board.resizeArray(image, tempArray, array[tempStart], array[tempEnd], "ladder");
        Assert.assertEquals(example[0], test[0]);
        Assert.assertEquals(example[1], test[1]);
        Assert.assertEquals(example[2], test[2]);
        Assert.assertEquals(example[3], test[3]);
        Assert.assertEquals(example[4], test[4]);

    }
}

