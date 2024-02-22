# MARS ROVER

## Requirements

Create an app that will take as an input the 4 moves that a rover can take (assume a 2-dimensional grid) or 0 to exit.
For each move, the rover should move 1 square.

We assume that the rover can start from position (0, 0) and the board is infinite. We also assume that the rover cant go
to negative positions, but this is not a hard requirement for clients who want to try their own solution.

One more requirement is to keep track of previous moves and give the option to 'undo' a move. The history can be for the
last 1000 or more moves (straightforward) but after you can try with infinite history (or say 1B moves).

## Solution

Given solution currently assumes that the user gives input of 1,2,3,4 for directions but that can be improved.

Also, validations and error messages are missing. For example what if someone goes down from 0? or invalid input is
given?

Next, there are 2 solutions provided. The simple Rover, which uses a simple stack for history of moves. Then there is a
paginated stack rover, that uses a custom data structure for better memory usage.

## Extensions

One nice, easy, feature would be to change the direction of the rover after every move. so if the rover turns right
from (0, 0) to (1, 0) then forward should be (2, 0).
Biggest challenge would be for the rover to identify obstacles. So given a set of points where obstacles exist, identify
if the next move is possible or not

## Benchmarking the 2 provided solutions

Rover with PaginatedStack can afford more moves, from memory perspective and also is much faster in every scenario

### 4 tests of 500_000_000 iterations

- Stack -> Fails with java heap space
- ``` 
  PaginatedStack ->
  Starting tests for Rover
  Total heap size for void move: 670.0 MB
  Total execution time for void move: 6671ms
  Total heap size for straight move: 672.0 MB
  Total execution time for straight move: 7269ms
  Total heap size for back and forth move: 1.0 GB
  Total execution time for back and forth move: 10924ms
  Total heap size for diagonal move: 1.1 GB
  Total execution time for diagonal move: 10328ms
  Tests for Rover finished successfully```

### 4 tests of 80_000_000 iterations

- ``` 
  Stack ->
  Starting tests for Rover
  Total heap size for void move: 0 B
  Total execution time for void move: 61ms
  Total heap size for straight move: 687.0 MB
  Total execution time for straight move: 5160ms
  Total heap size for back and forth move: 1.5 GB
  Total execution time for back and forth move: 8786ms
  Total heap size for diagonal move: 1.5 GB
  Total execution time for diagonal move: 9187ms
  Total heap size for move and undo move: 0 B
  Total execution time for move and undo move: 7120ms
  Total heap size for many moves and then undo all: 0 B
  Total execution time for many moves and then undo all: 6530ms
  Tests for Rover finished successfully```
- ``` 
  PaginatedStack ->
  Starting tests for Rover
  Total heap size for void move: 43.0 MB
  Total execution time for void move: 1172ms
  Total heap size for straight move: 37.0 MB
  Total execution time for straight move: 970ms
  Total heap size for back and forth move: 155.0 MB
  Total execution time for back and forth move: 2659ms
  Total heap size for diagonal move: 157.0 MB
  Total execution time for diagonal move: 2435ms
  Total heap size for move and undo move: 0 B
  Total execution time for move and undo move: 1400ms
  Total heap size for many moves and then undo all: 0 B
  Total execution time for many moves and then undo all: 2638ms
  Tests for Rover finished successfully
    --- EDGE CASE OF CREATING AND DESTROYING THE PAGE ---
  Total heap size for move and undo move: 310.0 MB
  Total execution time for move and undo move: 14346ms```

### Limits

- Rover with Stack<Byte> implementation starts failing with OOM kills at around 100_000_000 on my machine
- Rover with PaginatedStack implementation starts failing with OOM kills at around 1_000_000_000 on my machine