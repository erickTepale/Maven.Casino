# ZCW-Casino
* Objective:
  * To create a casino simulation.

## Minimum Viable Product (MVP)
* Your application must have at the very least 4 games:
  * Go Fish a card game
  * BlackJack a card game
  * io.zipcoder.casino.DiceGames.Craps.Craps a dice game
  * An additional dice game

## Specs
* The project should include some concept of
  * `Player` class
    * `Player` objects should be created upon input from a user.
  * `io.zipcoder.casino.utilities.Game` interface
    * Contract which ensures that a class enforces some aspect of _playing_.
  * `io.zipcoder.casino.utilities.GamblingGame` interface
    * Contract which ensures that a game enforces some aspect of _waging money_.
  * `GamblingPlayer` interface
    * Contract which ensures that a player has some ability to _wage money_.
  * The `utilities.Console` class should NOT be modified. It should be _wrapped_ or encapsulated by other classes.
  
 

## Developmental Notes
* `io.zipcoder.casino.CardGames.GoFish.GoFish` is a friendly game and should not involve gambling.
* `BlackJack` and `io.zipcoder.casino.CardGames.GoFish.GoFish` are both card games and should therefore inherit from a common `io.zipcoder.casino.CardGames.UtilitiesCards.CardGame`.
* Any common logic or fields between the games should live io.zipcoder.casino.CardGames.UtilitiesCards.CardGame class, **not** BlackJack **nor** io.zipcoder.casino.CardGames.GoFish.GoFish.
* You must have a completed and approved UML diagram before you proceed to do any development
* All public methods should be tested.
