package me.puneetsingh.problems.others.hard;


import java.util.ArrayList;
import java.util.List;

public class MaximizeVacations {
    static List<GraphNode> lgn = new ArrayList<>();

    public static void main(String[] args) {
        fillGraph(lgn);
        GraphNode s = lgn.get(0);
        List<Integer> holidays = getMaxHolidays(s);
    }

    private static List<Integer> getMaxHolidays(GraphNode s) {
        return null;
    }

    private static void fillGraph(List<GraphNode> lgn) {
        GraphNode g1 = new GraphNode();
        g1.locationId = 1;
        g1.holidays.add(3);g1.holidays.add(10);g1.holidays.add(15);
        GraphNode g2 = new GraphNode();
        g2.locationId = 2;
        g2.holidays.add(1);g2.holidays.add(9);g2.holidays.add(17);
        GraphNode g3 = new GraphNode();
        g3.locationId = 3;
        g3.holidays.add(18);g3.holidays.add(19);g3.holidays.add(20);
        GraphNode g4 = new GraphNode();
        g4.locationId = 4;
        g4.holidays.add(21);g4.holidays.add(25);g4.holidays.add(28);
        GraphNode g5 = new GraphNode();
        g5.locationId = 5;
        g5.holidays.add(7);g5.holidays.add(13);g5.holidays.add(27);

        g1.closeLocations.add(g2);g1.closeLocations.add(g4);
        g2.closeLocations.add(g1);g2.closeLocations.add(g5);
        g3.closeLocations.add(g4);g3.closeLocations.add(g5);
        g4.closeLocations.add(g1);g4.closeLocations.add(g3);
        g5.closeLocations.add(g2);g5.closeLocations.add(g3);

        lgn.add(g1);lgn.add(g2);lgn.add(g3);lgn.add(g4);lgn.add(g5);

    }
}

class GraphNode{
    int  locationId;
    List<Integer> holidays;
    List<GraphNode> closeLocations;
}


