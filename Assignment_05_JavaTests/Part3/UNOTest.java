import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class UNOTest {

    GameBoard game = new GameBoard();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
     *
     */

    @Test
            public void setPlayerNameTest() {
        GameBoard game = new GameBoard();
        game.setPlayerList() = new Player[1];

        String user = "Max";
        InputStream in = new ByteArrayInputStream(user.getBytes());
        System.setIn(in);

        game.setPlayerName("Max", 1)

        Assert.assertEquals("Max", game.getPlayerList()[0].getName());
        Assert.assertEquals(1, game.getPlayerList()[0].getTurnOrder());
    }

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
        @Test
    public void caughtUNO(){
            GameBoard game = new GameBoard();
            Player player0 = setPlayerName("Max", 1)
            Player[] players = {player0};
            Card c = new Card(BLUE, ZERO);
            players[0].setHand() = {c};
            players[0].setUno() = false;
            caughtThreadEvent t1 = new caughtThreadEvent();
            String user = "caught\n1";
            InputStream in = new ByteArrayInputStream(user.getBytes());
            System.setIn(in);

            Assert.assertEquals(1, players[0].getHand().size());
            Assert.assertFalse(players[0].getUno());
    }


    @Test
    public void addCard(){
        GameBoard game = new GameBoard();
        Deck deck = new Deck();
        deck.setCards() = new ArrayList<Card>();
        Card card = new Card(BLUE, ZERO);
        deck.addCard(card);

        Assert.assertEquals(new Card(BLUE, ZERO), deck.getCards()[0]);
    }

    @Test
    public void getStartHand(){
        GameBoard game = new GameBoard();
        Player player0 = setPlayerName("Max", 1);
        game.setPLayerList() = {player0};
        game.getPlayerList()[0].setStartingHand();
        Assert.assertEquals(7,game.getPlayerList()[0].getHand().size());
    }

    @Test
    public void playCardOnTop(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        Player player2 = setPlayerName("Moritz", 2);
        game.setPLayerList() = {player1, player2};
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(BLUE, ZERO);
        Card card2 = new Card(RED, TWO);
        Card card3 = new Card(GREEN, NINE);
        Card card4 = new Card(BLACK, WILD);
        discardPile.setCards() = {onTop};

        game.getPlayerList()[0].setCards() = {card1};
        game.getPlayerList()[1].setCards() = {card2, card3, card4};

        thrown.expect(InputMismatchException.class);
        thrown.expectMessage("Card can't be played. Play another card or draw one.");
        game.getPlayerList()[0].playCard(0);

        game.getPlayerList()[1].playCard(0);
        Assert.assertEquals(card2, discardPile.getCards()[discardPile.getCards().size-1]);

        game.getPlayerList()[1].setCards() = {card2, card3, card4};
        game.getPlayerList()[1].playCard(1);
        Assert.assertEquals(card2, discardPile.getCards()[discardPile.getCards().size-1]);

        game.getPlayerList()[1].setCards() = {card2, card3, card4};
        game.getPlayerList()[1].playCard(2);
        Assert.assertEquals(card2, discardPile.getCards()[discardPile.getCards().size-1]);
    }

    @Test
    public void drawTwo(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        Player player2 = setPlayerName("Moritz", 2);
        game.setPLayerList() = {player1, player2};
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(RED, DRAW_TWO);
        Card card2 = new Card(RED, TWO);
        Card card3 = new Card(GREEN, NINE);
        discardPile.setCards() = {onTop};

        game.getPlayerList()[0].setCards() = {card1, card2};
        game.getPlayerList()[1].setCards() = {card3};

        game.getPlayerList()[0].playCard(0);
        Assert.assertEquals(3, game.getPlayerList()[1].getCards().size());
    }

    @Test
    public void chooseColor(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        game.setPLayerList() = {player1};
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(BLACK, WILD);
        Card card2 = new Card(RED, TWO);
        discardPile.setCards() = {onTop};

        game.getPlayerList()[0].setCards() = {card1, card2};

        game.getPlayerList()[0].playCard(0);

        String user = "BLUE";
        InputStream in = new ByteArrayInputStream(user.getBytes());
        System.setIn(in);
        Assert.assertEquals(BLUE, UNOGameState.getColor());
    }

    @Test
    public void yellUno(){
        GameBoard game = new GameBoard();
        Player player1 = setPlayerName("Max", 1);
        game.setPLayerList() = {player1};
        Deck discardPile = new Deck();
        Card onTop = new Card(RED, NINE);
        Card card1 = new Card(BLACK, WILD);
        Card card2 = new Card(RED, TWO);
        discardPile.setCards() = {onTop};

        game.getPlayerList()[0].setCards() = {card1, card2};

        game.getPlayerList()[0].playCard(1);

        String user = "UNO";
        InputStream in = new ByteArrayInputStream(user.getBytes());
        System.setIn(in);
        Assert.assertTrue(game.getPlayerList()[0].getUno());
    }
}
