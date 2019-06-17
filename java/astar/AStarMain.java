package astar; 

import astar.AStar;

public class AStarMain {
    
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        AStar astar = new AStar(8, 6);
        astar.setOrigin(2, 2);
        astar.setDestination(6, 2);
        astar.setBlocked(4, 0);
        astar.setBlocked(4, 1);
        astar.setBlocked(4, 2);
        astar.setBlocked(4, 3);
        astar.setBlocked(5, 3);
        astar.setBlocked(5, 4);
        astar.setBlocked(3, 3);
        astar.setBlocked(2, 3);
        astar.setBlocked(1, 3);
        astar.setBlocked(1, 2);
        astar.setBlocked(1, 1);
        astar.setBlocked(2, 1);
        astar.findPath();
        astar.print();
        System.out.println("Time : " + (System.currentTimeMillis() - startTime));
    }
}
