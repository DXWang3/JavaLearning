package lab6.creatures;

import lab6.huglife.Creature;
import lab6.huglife.Direction;
import lab6.huglife.Action;
import lab6.huglife.Occupant;
import lab6.huglife.HugLifeUtils;

import java.awt.Color;
import java.util.Map;
import java.util.List;

/**
 * Created by davidwang on 3/12/15.
 */



public class Clorus extends Creature {
    private int r = 34;
    private int g = 0;
    private int b = 231;

    public Clorus(double e) {
        super("clorus");
        energy = e;
    }

    public Color color(){
        return color(r,g,b);
    }

    public void attack(Creature c){
        energy+=c.energy();
    }

    public void move() {
        energy -=0.03;
    }

    public Creature replicate() {
        Clorus baby = new Clorus(energy/2);
        energy=energy/2;
        return baby;
    }

    public void stay() {
        energy -=0.01;
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        if (empties.size()==0){
            return new Action(Action.ActionType.STAY);
        }
        List<Direction> food = getNeighborsOfType(neighbors, "plip");

        if (food.size()>0){
            return new Action(Action.ActionType.ATTACK, food.get((int)(Math.random()*food.size())));
        }

        if (energy>=1){
            return new Action(Action.ActionType.REPLICATE, empties.get(0));
        }

        return new Action(Action.ActionType.MOVE, empties.get(0));
    }
}
