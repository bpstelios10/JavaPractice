# Tic-tac-toe

## Requirements

Implement a simple [tic-tac-toe game](https://en.wikipedia.org/wiki/Tic-tac-toe), with a 9-boxes board and two players
go one after the other selecting from 1 to 9.

## Solution

Initial solution implements the main functionality. Players select a box and the new board is printed out. When a player
wins the game ends and a message is printed. If all boxes are filled the game ends

Second step would be to add validations for things like 'what if a player selects a number other than 1-9' or what if
the box is already occupied.
And maybe some smart improvements, like 'dont check for winners if moves are less than 5'

## Extended Functionality

To make it more challenging, we can create a tic-tac-toe for single player, to play against the computer. Of course we
dont want a very clever computer or else it never loses (the possibilities space is very small so it can always at least
tie).

So the next requirement would be to have computer randomly pick one of the empty boxes

And to make it a bit more difficult we can at least make the computer check if the player has 2 in-a-row and stop it. In
cases of 2 such cases at the same time, just pick the first found.

The two previous extensions could be the 'easy' and the 'difficult' levels for player to choose.
