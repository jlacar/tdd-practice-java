# TDD Practice - Tennis Scoring Refactoring (Legacy) 

(Adapted from the Tennis Refactoring exercise on https://cyber-dojo.org)

The local tennis club has recently acquired two smaller tennis clubs. You have been employed by the tennis club to help integrate the tournament scoring systems used by the three clubs. Management has decided to install a new scoreboard system at all three clubs to save costs. However, due to certain complexities which we'll go into detail later, retiring and replacing the old scoring systems and is not an option at the moment. Therefore, the current scoring system at each club needs to work with the new scoreboard system. Where necessary, new features need to be added to get full integration with the new scoreboard system. 

Your first challenge is to make sure all the scoring programs can fully integrate with the new scoreboard system.

## The Exercise

This is going to be a multi-phase exercise, with each phase building on what you did in the previous phase, just like in the real world. 

### Phase 1 - Characterize the existing programs

After looking through the source code, you find that none of the current codebases have any unit tests. Before you do anything therefore, you decide to write characterization tests so that you have a safety net for refactoring.

This is the first phase of this exercise. When you're done, you should have tests that cover a significant percentage of the main scoring logic from each of the clubs.

### Phase 2 - Make each version work with a common Scoreboard API

TBD 

### Phase 3 - Add new features that can be used with each scoring program

TBD 

## Summary of Tennis scoring

A full set of rules for scoring tennis can be found here:
https://www.usta.com/en/home/improve/tips-and-instruction/national/tennis-scoring-rules.html

For, some general terminology.

The player serving in a game is said to "have service" or simply "has serve" and is referred to as the "server."

The player who is not serving in a game is said to be "receiving service" or simply "receiving" and is referred to as the "receiver."

The player who serves first in a match is said to have "first service" or "first serve."

A player will have service for the whole game. Service alternates between sides for each game played under normal conditions. Service rules will be different for certain tiebreak conditions.

For the purposes of this exercise, focus on implementing these rules first:

1. A game is won by the first player to have won at least four points
   in total and at least two points more than the opponent.
2. The running score of each game is described in the following manner: zero points is "Love", one point is "Fifteen", two points is "Thirty", and three points is "Forty".
3. If at least three points have been scored by each player, that is, they each have gotten to "Forty" and the
   scores are equal, the score is “Deuce”.
4. If at least three points have been scored by each side and a player has one more point than their opponent, the score of the game is “Advantage” for the player in the lead.
5. Scores are always given in server-receiver order. That is, if the server has 0 points and the receiver has 2 points, the score will be given as "Love-Thirty". Likewise, if the server has 2 points and the receiver has 0 points, the score will be given as "Thirty-Love."
6. When scores are tied at less than three points, the score is given as "<score> all". For example, if the players are tied at Fifteen, the score is given as "Fifteen all". If they both have zero, the score is given as "Love all".

## Possible new features to implement

1. When the scores are past "deuce" and a player has the advantage, the score will be given as "advantage server" if the server has the lead or "advantage receiver" if the receiver has the lead.
2. Track how many break points each player earns (for receiver) or saves (for server) when a game goes to deuce.
3. Track how many match points each player earns (for the imminent winner) or saves (for the imminent loser).
4. Score entire sets.
5. Score entire matches.
6. Be able to handle advantage set scoring.
7. Be able to handle tiebreak set scoring.

