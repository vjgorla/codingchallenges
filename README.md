# Coding Challenges

## Snake cube puzzle
The snake cube is a mechanical puzzle, a chain of 27 cubelets, connected by an elastic band running 
through them. Each cubelet can rotate freely on only one axis. The aim of the puzzle is to arrange the chain in such a 
way that they will form 3 x 3 x 3 cube.

![Snake Cube](http://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Snakecube_1.jpg/220px-Snakecube_1.jpg)
![Snake Cube](http://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Snakecube_2.jpg/220px-Snakecube_2.jpg)

See [CubePuzzle.java](java/CubePuzzle.java)

## Einstein's Puzzle
Albert Einstein supposedly said that 98% of the people in the world couldn't solve this one: 
There are 5 houses sitting next to each other, each with a different color, occupied by 5 guys, 
each from a different country, and with a favorite drink, cigarette, and pet. Here are the facts: 
* The British occupies the red house.
* The Swedish owns a dog.
* The Danish drinks tea.
* The green house is on the left of the white house.
* The owner of the green house drinks coffee.
* The person who smokes "Pall Mall" owns a bird.
* The owner of the yellow house smokes "Dunhill".
* The owner of the middle house drinks milk.
* The Norwegian occupies the 1st house.
* The person who smokes "Blend" lives next door to the person who owns a cat.
* The person who owns a horse live next door to the person who smokes "Dunhill".
* The person who smokes "Blue Master" drinks beer.
* The German smokes "Prince".
* The Norwegian lives next door to the blue house.
* The person who smokes "Blend" lives next door to the person who drinks water.
The question is: Who owns the fish?

See [EinsteinPuzzle.java](java/EinsteinPuzzle.java)

## Farmer puzzle
A farmer has a forty kilogramme stone that he uses to weigh food for his animals on a scale. One day, 
he loans the stone to his neighbour. A few days later, the neighbour returns the stone and apologises 
to the farmer because his stone is now broken in four pieces. The farmer responds "Please don't apologise, 
you have actually made my life easier because with these four pieces, I can now measure any weight 
between one and forty kilos".

Some clarifications:
The four weights are integers (whole numbers, without fractional digits).
The weights we can measure between one and forty kilos are in one kilo increment.
They are measured in one session (otherwise, you could measure forty kilos with a one kilo stone 
by performing forty measurements).

The question is: how much do these four individual pieces weigh?

See [FarmerPuzzle.java](java/FarmerPuzzle.java)

## Sudoku
Sudoku is a logic-based, combinatorial number-placement puzzle. The objective is to fill a 9x9 grid 
with digits so that each column, each row, and each of the nine 3x3 sub-grids that compose the grid contains 
all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which 
typically has a unique solution.

See [Sudoku.java](java/Sudoku.java)

## Eight queens puzzle
The eight queens puzzle is the problem of placing eight chess queens on an 8x8 chessboard so that no two 
queens attack each other. Thus, a solution requires that no two queens share the same row, column, or diagonal.

See [EightQueensPuzzle.java](java/EightQueensPuzzle.java)

## A* algorithm
A* (pronounced A Star) algorithm is a technique for finding the best path through a maze given an origin and a known destination.
I have implemented it in java and created an applet to demonstrate how it works. Have a play with it.
This implementation is based on the article [A* Pathfinding for Beginners](http://www.policyalmanac.org/games/aStarTutorial.htm)
There are also links to the source below.
 
* Double click in a box to make it the origin (green)
* CTRL + Double click makes a box as destination (red)
* Single clicking on a box, or dragging over a series of boxes creates walls
* Click the Find Path button to find the nearest path between origin and destination

![A*](http://qtechsolutions.com.au/vijaygorla/codingchallenges/astar/astar1.png)
![A*](http://qtechsolutions.com.au/vijaygorla/codingchallenges/astar/astar2.png)

* [AStar.java](java/astar/AStar.java)
* [Node.java](java/astar/Node.java)
* [AStarDemo.java](java/astar/AStarDemo.java)
* [AStarMain.java](java/astar/AStarMain.java)
* [AStarTest.java](java/astar/AStarTest.java)

## Tent Puzzle
[Tent Puzzle PDF](http://qtechsolutions.com.au/vijaygorla/codingchallenges/tentpuzzle/TentPuzzle.pdf)

See [TentPuzzle.java](java/TentPuzzle.java)

