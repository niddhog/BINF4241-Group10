# JavaTests
## Part 01

### 1.1
All processes are on the GameBoard class. To setup the game we need to know the number players, their names and the boardsize, which at least has 7 squares by our definition. It's actually an arbitrary number. Theres is also at least one ladder set on the board. The numbers of the ladders (#squares/7) and snakes (#squares/13) are derived. <br /> <br />
The inputs of the user can throw an exception, but the program forces the user to repeat his input until the a correct one will be accepted. We don't consider that behaviour as a bug. From our perspective there can not be made so many mistakes from the user.  <br /> <br />
While we build our board with the given number of squares, we also generate the derived number of snakes and ladders. To set the ladders and snakes correctly we generate a subarray of the positions of the squares, which are not part of the snakes, ladders, start or winning squares by resize this subarray until all snakes and ladders. Therefore, it's not possible to end in a infinite loop, when multiple players land on the beginning square, that also contains a ladder or to win the game by landing on a certain square. <br /> <br />
Within of the resized subarray the beginning of the ladders picks randomly between the first and second last square. The end picks between next bigger picked beginning square and to the last square of the subarray. It works for the snake the other way around for the beginning and end square. 
Afterwards the picked positions are deleted on the temporary subarray as update for the next loop to set a ladder or a snake. So the initial state are made and printed for the user before the first turn. <br /> <br />
We consider the case if there would be more snakes and ladders than squares to put them on board. This case will never occur in our program. We have at most (#squares/7) ladders +(#squares/13) squares < ((#squares-2)/2). <br /> <br />
The simulated game derives at every turn of the player, where its next position is by a randomized dice. The dice throw is printed with the the players position before the derivation of the new position of the dice throw.
Here due to some cases, a case distinction occurs:
1. If the current position of the player is occupied, then set it on 0 for unoccupied
2. If a player oversteps the board, he has to move from the winning square back.
3. If a player lands on a snake or a ladders, then the player jumps to a certain square.
4. If a player lands on an occupied square, then the players position will be set on 0 (start square)
Else, the player moves to the square and set square occupied
5. If the player lands on the last square, it prints the final state and breaks the loop

### 1.2
numberOfPlayers() will test, if the method setPlayerNumber() takes the input "2" correctly as integer 2.

 anyStringName() test, whether input "Max" and "Moritz" as names for the function setPlayerName(2) is saved in string array of length 2 correctly. 

 leastBoardSize() tests, whether the size of the board is 7, if setBoardSize() takes the input "7".

 rantIntWrongMinMax() asserts an exception, if the integer min as parameter is greater than max for the method randInt().

 rantIntBetweenMinMax() tests, if the integers min is equal or smaller than max as input for function randInt(min, max), then the output is in the range of these two integers.

 isSnakeSquare() tests, if a given square is an snake or not

 isLadderSquare() tests, if a given square is an ladder or not

In resizeArray() we assert the squares at position 1 turns into a ladder with a leap to square 2, hence, the new subarray deletes these two positions from subarray. (first and last positions can't be chosen from resizeArray() method)

### 1.3

Main concern is the inputs from the user to set the game up. Every input will be tested and afterwards a possible game process will be derived. A design question may be, whether it's necessary to force the user to insert an input until it's correct. <br />
We expect a size of at least 7 squares to build the board, though it's not necessary, because the board needs at least 2: a start square and winning square. We don't consider that case really as bug. If we would take it as bug, it would follow, there were no ladders and snakes. It wouldn't affect the other rules.<br />

## Part 02

To fix the code efficiently we start to fix the methods with the least dependencies. Therefore, we start the methods inside of the "GameBoard" class. 

##### maskTwice testcase

```java
    if (board[row][col] != null) {
      return true;
    } else {
      board[row][col] = player;
      return false;
    }
```

The mark() methods tests, whether the position is already marked or not. If it isn´t marked, we mark the position and return true, else false. So we correct the condition to return a true statement:

```java
       if (board[row][col] != null) {
      return false;
    } else {
      board[row][col] = player;
      return true;
    }
```

In the testcase getOpenPositions() we iterate over all positions und add all empty ones.
##### getOpenPositions() testcase
```java
  public List<Position> getOpenPositions() {
    ArrayList<Position> positions = new ArrayList<Position>();
    for (int row = 0; row < ROWS; row++) {
      for (int col = 1; col < COLS; col++) {
        if (board[row][col] == null) {
          positions.add(new Position(row, col));
        }
      }
    }
    return positions;
  }
```

We can see in the code above, it begins to iterate at the second coloumn position instead at the first, so we would miss some positions. So, we change "1" to "0".
```java
        for (int col = 0; col < COLS; col++) {
```
Afterwards all test cases of "GameBoardTest" passed by two corrections.



##### isOverWin

```java
  public boolean hasWin(Player player) {
    for (int i = 0; i < 3; i++) {
      if (completesRow(player, i) || completesColumn(player, i)) {
        return false;
      }
    }
    return completesDiagonal(player);
  }
```

```java
      if (completesRow(player, i) || completesColumn(player, i)) {
        return true;
      }
```

##### hasWinDiagonal

```java
  private boolean completesDiagonal(Player player) {
    Player center = board.getMark(1, 1);
    if (player != center) {
      return false;
    }
    return (board.getMark(0, 0) == center && center == board.getMark(1, 2))
        || (board.getMark(0, 2) == center && center == board.getMark(2, 0));
  }
```

```java
    return (board.getMark(0, 0) == center && center == board.getMark(2, 2))
        || (board.getMark(0, 2) == center && center == board.getMark(2, 0));
```
##### startingPlayerIsX()
```java
  public Player getCurrentPlayer() {
    Player randomPlayer = Player.O;
    currentPlayer = randomPlayer;
    return currentPlayer;
  }
```
```java
  public Player getCurrentPlayer() {
    return currentPlayer;
  }
```

## Part 03

#### 3.1.
The number of players: accepts only an `integer between 2-10`
only a setter for int numberOfPlayers = input of the user
the method changes only value of numberOfPlayers <br />
<br />

every player can be named by a sting input, if the input is empty, then the default name `"Player " + int turnOrder` 
The name of the player should be set on the input
The name of the player should be either a given input from the console or the default expression<br />

`playCard(int position)` within the `ArrayList<> hand` by choosing the position of the card: an integer between `0 and Arraylength.size-1`, so only integers are accepted
<br />
If the player would insert an integer out of range, we expect this as drawCard() from Draw Pile, so either the plays a card from his hand or draw a card <br />
1. case: card can be played and hand.size() decrements -1
2. case: draw a card and can not be played hand.size() increments +1
3. case: draw a card and can be played, so hand.size() stays

Afterwards add the points of the played card to the scoreboard of the player<br/>

`If (ArrayList<> hand.size == 1)` set `boolean uno = false`, if the player insert "UNO!" set the `boolean uno = true` <br />
If "UNO!" is said, then the boolean uno = true, saying uno with more than one card should not affect th repetition of "UNO!", when only one card left<br/>

If "caught" is inserted, then a list of players in turn order pops up and to invoke caughtUNO(integer turnOrder) it's necessary to put an integer in range of 1 to numberOfPlayers
Any other input will cancel the caught state<br/>
Output would be a message either "Player " + player.getName + " is caught and draws two cards!", "Player " + player.getName + " said UNO!" or "Player " + player.getName + " has more than one card!"<br/>

For the case Wild Card and Wild Draw 4, the inputs `"RED", "YELLOW, "GREEN", "BLUE"` are expected, so for the user it pops up a list of the possible input, any other input won't be accepted <br/>
For example the attribute Symbol symbol changes from WILD to RED, symbol should always one of the following values `"RED", "YELLOW, "GREEN", "BLUE"`<br/>

If a Wild Draw 4 occurs, then the player(challenger), which carries the Draw 4 action, has the possibility to doubt/challenge the illegal move with only "yes" or "no", if the challenger calls "no", he draws 4 cards as usual, by calling "yes" the challenge(Player wildPlayer, Player challenger) method decides, whether wildPlayer must draw 4 cards cause of the illegal move or the challenger must draw 6 cards cause the move was legal