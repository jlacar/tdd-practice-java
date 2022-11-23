# TDD Practice - Tennis Scoring Refactoring (Legacy) 

Source: Adapted from exercise on https://cyber-dojo.org

Tennis has a rather quirky scoring system, and to newcomers it
can be a little difficult to keep track of. The local tennis club has
some code that is currently being used during matches they host. They have 
recently acquired two smaller tennis clubs, and they two each have a similar 
programs.

You have been employed by the tennis club to ensure that all three codebases 
can be used with the new scoreboard displays they are installing at all three 
clubs to modernize their facilities. All three programs need to work with the
new scoreboard system. Replacing the current programs at the newly acquire clubs
is not an option at this time due to certain complexities, so you have to find 
an interim solution for integrating all three scoring systems.

## The Exercise

This is going to be a multi-phase exercise, with each phase meant to build on 
what was done in the previous phase.

### Phase 1 - Characterize the code bases

The current code bases have no tests. This means that you don't know if the programs
even work or not. Your first task is to understand how each version of the scoring 
program works by writing characterization tests.

### Phase 2 - Make each version work with a common Scoreboard API

TBD 

### Phase 3 - Add new features that can be used with each scoring program

TBD 

## Summary of Tennis scoring

1. A game is won by the first player to have won at least four points
   in total and at least two points more than the opponent.
2. The running score of each game is described in a manner peculiar
   to tennis: scores from zero to three points are described as “love”,
   “fifteen”, “thirty”, and “forty”, respectively.
3. If at least three points have been scored by each player, and the
   scores are equal, the score is “deuce”.
4. If at least three points have been scored by each side and a player
   has one more point than his opponent, the score of the game is “advantage” for the player in the lead.
5. The player serving in a game is said to "have service" or simply "has serve." The opposing player is said to be "receiving service" or simply "receiving."
6. The player who serves first in a match is said to have "first service" or "first serve."
7. A player will have service for an entire game. Service alternates between players throughout the match.
8. Scores are always given in server-receiver order. That is, if the player who has service has 0 points and the receiving player has 2 points, the score will be given as "Love-Thirty". Conversely, if the server has 2 points and the receiver has 0 points, the score will be given as "Thirty-Love."

## New Features needed

1. When the scores are past "deuce" and a player has the advantage, the score will be given as "advantage server" if the server has the lead or "advantage receiver" if the receiver has the lead.
2. Track how many break points each player earns (for receiver) or saves (for server) when a game goes to deuce.
3. Track how many match points each player earns (for the imminent winner) or saves (for the imminent loser).
4. Score entire sets.
5. Score entire matches.
6. Be able to handle advantage set scoring.
7. Be able to handle tiebreak set scoring.

See: https://www.usta.com/en/home/improve/tips-and-instruction/national/tennis-scoring-rules.html
