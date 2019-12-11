import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * @author Christian
 * @author Thanh Cong
 * @author Filip
 * @version 1.0
 */

public class UNOTest {

    GameBoard game = new GameBoard();

    /**
     * In case we would take a closer look to the properties of exceptions
     */

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * For the unit testing we need preparation to test the methods.
     */

    @Before
    public void setup() {
        game = new GameBoard();
    }

    /**
     * We expect inserting an integer 2-10 is correct, otherwise it runs in a loop until a correct input is generated
     */

    @Test
    public void numberOfPlayers(){
        GameBoard game = new GameBoard();

        String user = "2";
        InputStream in = new ByteArrayInputStream(user.getBytes());
        System.setIn(in);

        Assert.assertEquals(2, game.setPlayerNumber());
    }

    /**
     * It tests, whether the name is saved correctly with the right position of the turn order
     */

    @Test
            public void setPlayerNameTest() {
        GameBoard game = new GameBoard();
        game.setPlayerList() = new Player[1];

        String user = "Max";
        InputStream in = new ByteArrayInputStream(user.getBytes());
        System.setIn(in);

        game.setPlayerName("Max", 1);

        Assert.assertEquals("Max", game.getPlayerList()[0].getName());
        Assert.assertEquals(1, game.getPlayerList()[0].getTurnOrder());
    }

    /**
     * It checks the initial deck creation.
     */

    @Test
    public void createDeckTest() {
        GameBoard game = new GameBoard();

        ArrayList<Card> deckTest = new ArrayList<Card>() {
            {
                add(new Card(BLUE, ZERO));
                add(new Card(BLUE, ONE));
                add(new Card(BLUE, TWO));
                add(new Card(BLUE, THREE));
                add(new Card(BLUE, FOUR));
                add(new Card(BLUE, FIVE));
                add(new Card(BLUE, SIX));
                add(new Card(BLUE, SEVEN));
                add(new Card(BLUE, EIGHT));
                add(new Card(BLUE, NINE));
                add(new Card(BLUE, ONE));
                add(new Card(BLUE, TWO));
                add(new Card(BLUE, THREE));
                add(new Card(BLUE, FOUR));
                add(new Card(BLUE, FIVE));
                add(new Card(BLUE, SIX));
                add(new Card(BLUE, SEVEN));
                add(new Card(BLUE, EIGHT));
                add(new Card(BLUE, NINE));

                add(new Card(GREEN, ZERO));
                add(new Card(GREEN, ONE));
                add(new Card(GREEN, TWO));
                add(new Card(GREEN, THREE));
                add(new Card(GREEN, FOUR));
                add(new Card(GREEN, FIVE));
                add(new Card(GREEN, SIX));
                add(new Card(GREEN, SEVEN));
                add(new Card(GREEN, EIGHT));
                add(new Card(GREEN, NINE));
                add(new Card(GREEN, ONE));
                add(new Card(GREEN, TWO));
                add(new Card(GREEN, THREE));
                add(new Card(GREEN, FOUR));
                add(new Card(GREEN, FIVE));
                add(new Card(GREEN, SIX));
                add(new Card(GREEN, SEVEN));
                add(new Card(GREEN, EIGHT));
                add(new Card(GREEN, NINE));

                add(new Card(RED, ZERO));
                add(new Card(RED, ONE));
                add(new Card(RED, TWO));
                add(new Card(RED, THREE));
                add(new Card(RED, FOUR));
                add(new Card(RED, FIVE));
                add(new Card(RED, SIX));
                add(new Card(RED, SEVEN));
                add(new Card(RED, EIGHT));
                add(new Card(RED, NINE));
                add(new Card(RED, ONE));
                add(new Card(RED, TWO));
                add(new Card(RED, THREE));
                add(new Card(RED, FOUR));
                add(new Card(RED, FIVE));
                add(new Card(RED, SIX));
                add(new Card(RED, SEVEN));
                add(new Card(RED, EIGHT));
                add(new Card(RED, NINE));

                add(new Card(YELLOW, ZERO));
                add(new Card(YELLOW, ONE));
                add(new Card(YELLOW, TWO));
                add(new Card(YELLOW, THREE));
                add(new Card(YELLOW, FOUR));
                add(new Card(YELLOW, FIVE));
                add(new Card(YELLOW, SIX));
                add(new Card(YELLOW, SEVEN));
                add(new Card(YELLOW, EIGHT));
                add(new Card(YELLOW, NINE));
                add(new Card(RED, ONE));
                add(new Card(RED, TWO));
                add(new Card(RED, THREE));
                add(new Card(RED, FOUR));
                add(new Card(RED, FIVE));
                add(new Card(RED, SIX));
                add(new Card(RED, SEVEN));
                add(new Card(RED, EIGHT));
                add(new Card(RED, NINE));

                add(new Card(BLUE, DRAW_TWO));
                add(new Card(BLUE, DRAW_TWO));
                add(new Card(GREEN, DRAW_TWO));
                add(new Card(GREEN, DRAW_TWO));
                add(new Card(RED, DRAW_TWO));
                add(new Card(RED, DRAW_TWO));
                add(new Card(YELLOW, DRAW_TWO));
                add(new Card(YELLOW, DRAW_TWO));

                add(new Card(BLUE, REVERSE));
                add(new Card(BLUE, REVERSE));
                add(new Card(GREEN, REVERSE));
                add(new Card(GREEN, REVERSE));
                add(new Card(RED, REVERSE));
                add(new Card(RED, REVERSE));
                add(new Card(YELLOW, REVERSE));
                add(new Card(YELLOQ, REVERSE));


                add(new Card(BLUE, SKIP));
                add(new Card(BLUE, SKIP));
                add(new Card(GREEN, SKIP));
                add(new Card(GREEN, SKIP));
                add(new Card(RED, SKIP));
                add(new Card(RED, SKIP));
                add(new Card(YELLOW, SKIP));
                add(new Card(YELLOW, SKIP));

                add(new Card(BLACK, WILD));
                add(new Card(BLACK, WILD));
                add(new Card(BLACK, WILD));
                add(new Card(BLACK, WILD));

                add(new Card(BLACK, DRAW_FOUR));
                add(new Card(BLACK, DRAW_FOUR));
                add(new Card(BLACK, DRAW_FOUR));
                add(new Card(BLACK, DRAW_FOUR));


            }};
            for (Card c : deckTest) {
                Assert.assertTrue(game.createDeckTest().contains(c));

            }
        }

    /**
     *The method {@link #caughtUNO()} checks, if the conditions for succesful "caught" are satisfied.
     */

    @Test
    public void caughtUNO(){
            GameBoard game = new GameBoard();
            Player player0 = setPlayerName("Max", 1);
            Player[] players = {player0};
            Card c = new Card(BLUE, ZERO);
            players[0].setHand().add(c);
            players[0].setUno() = false;
            caughtThreadEvent t1 = new caughtThreadEvent();
            String user = "caught\n1";
            InputStream in = new ByteArrayInputStream(user.getBytes());
            System.setIn(in);

            Assert.assertEquals(1, players[0].getHand().size());
            Assert.assertFalse(players[0].getUno());
    }

    /**
     * It checks, whether a card is added to a deck.
     */

    @Test
    public void addCard(){
        GameBoard game = new GameBoard();
        Deck deck = new Deck();
        deck.setCards() = new ArrayList<Card>();
        Card card = new Card(BLUE, ZERO);
        deck.addCard(card);

        Assert.assertEquals(new Card(BLUE, ZERO), deck.getCards()[0]);
    }

    /**
     * The starting hand should contain 7 cards by invoking the method.
     */

    @Test
    public void getStartHand(){
        GameBoard game = new GameBoard();
        Player player0 = setPlayerName("Max", 1);
        game.setPLayerList().add(player0);
        game.getPlayerList()[0].setStartingHand();
        Assert.assertEquals(7,game.getPlayerList()[0].getHand().size());
    }

    /**
     * It tests three possibilities, whether the top of the discard pile is equal to the played card from the player or
     * the played violates the UNO rule and throws a exception.
     */

    @Test
    public void playCardOnTop(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        Player player2 = setPlayerName("Moritz", 2);
        game.setPLayerList().add(player1);
        game.setPLayerList().add(player2);
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(BLUE, ZERO);
        Card card2 = new Card(RED, TWO);
        Card card3 = new Card(GREEN, NINE);
        Card card4 = new Card(BLACK, WILD);
        discardPile.setCards().add(onTop);

        game.getPlayerList()[0].setCards().add(card1);
        game.getPlayerList()[1].setCards().add(card2);
        game.getPlayerList()[1].setCards().add(card3);
        game.getPlayerList()[1].setCards().add(card4);

        thrown.expect(InputMismatchException.class);
        thrown.expectMessage("Card can't be played. Play another card or draw one.");
        game.getPlayerList()[0].playCard(0);

        game.getPlayerList()[1].playCard(0);
        Assert.assertEquals(card2, discardPile.getCards()[discardPile.getCards().size-1]);

        game.getPlayerList()[1].setCards() = new ArrayList<Card>();
        game.getPlayerList()[1].setCards().add(card2);
        game.getPlayerList()[1].setCards().add(card3);
        game.getPlayerList()[1].setCards().add(card4);
        game.getPlayerList()[1].playCard(1);
        Assert.assertEquals(card3, discardPile.getCards()[discardPile.getCards().size-1]);

        game.getPlayerList()[1].setCards() = new ArrayList<Card>();
        game.getPlayerList()[1].setCards().add(card2);
        game.getPlayerList()[1].setCards().add(card3);
        game.getPlayerList()[1].setCards().add(card4);
        game.getPlayerList()[1].playCard(2);
        Assert.assertEquals(card4, discardPile.getCards()[discardPile.getCards().size-1]);
    }

    /**
     * It tests, if next player draws two cards by the DRAW_TWO card.
     */

    @Test
    public void drawTwo(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        Player player2 = setPlayerName("Moritz", 2);
        game.setPLayerList().add(player1);
        game.setPLayerList().add(player2);
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(RED, DRAW_TWO);
        Card card2 = new Card(RED, TWO);
        Card card3 = new Card(GREEN, NINE);
        discardPile.setCards().add(onTop);

        game.getPlayerList()[0].setCards().add(card1);
        game.getPlayerList()[0].setCards().add(card2);
        game.getPlayerList()[1].setCards().add(card3);

        game.getPlayerList()[0].playCard(0);
        Assert.assertEquals(3, game.getPlayerList()[1].getCards().size());
    }

    /**
     * It tests, whether the game state holds, by choosing a color.
     */

    @Test
    public void chooseColor(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        game.setPLayerList().add(player1);
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(BLACK, WILD);
        Card card2 = new Card(RED, TWO);
        discardPile.setCards().add(onTop);

        game.getPlayerList()[0].setCards().add(card1);
        game.getPlayerList()[0].setCards().add(card2);

        game.getPlayerList()[0].playCard(0);

        String user = "BLUE";
        InputStream in = new ByteArrayInputStream(user.getBytes());
        System.setIn(in);
        Assert.assertEquals(BLUE, UNOGameState.getColor());
    }

    /**
     * If "UNO" is yelled, then the boolean uno for the player should change to true.
     */

    @Test
    public void yellUno(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        game.setPLayerList().add(player1);
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(BLACK, WILD);
        Card card2 = new Card(RED, TWO);
        discardPile.setCards().add(onTop);

        game.getPlayerList()[0].setCards().add(card1);
        game.getPlayerList()[0].setCards().add(card2);

        game.getPlayerList()[0].playCard(1);

        String user = "UNO";
        InputStream in = new ByteArrayInputStream(user.getBytes());
        System.setIn(in);
        Assert.assertTrue(game.getPlayerList()[0].getUno());
    }
}
