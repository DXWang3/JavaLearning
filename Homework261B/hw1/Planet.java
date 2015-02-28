package Homework261B.hw1;

/**
 * Created by davidwang on 2/28/15.
 */
public class Planet {

    // Class Variables
    public double x;
    public double y;
    public double xVelocity;
    public double yVelocity;
    public double mass;
    public String img;
    public double xNetForce;
    public double yNetForce;
    public double xAccel;
    public double yAccel;

    // Planet Constructor
    public Planet(double xPos, double yPos, double xVel,
                  double yVel, double m, String planImg) {
        this.x = xPos;
        this.y = yPos;
        this.xVelocity = xVel;
        this.yVelocity = yVel;
        this.mass = m;
        this.img = planImg;
    }

    // Calculates Distance between two planets
    public double calcDistance(Planet compPlan) {
        double xDist = this.x - compPlan.x;
        double yDist = this.y - compPlan.y;
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }

    // Calculates the force exrted between two planets
    public double calcPairwiseForce(Planet compPlan) {
        return 6.67e-11 * this.mass * compPlan.mass
                / Math.pow(this.calcDistance(compPlan), 2);
    }

    // Calculates the X force between two planets
    public double calcPairwiseForceX(Planet compPlan) {
        return this.calcPairwiseForce(compPlan) * (compPlan.x - this.x)
                / this.calcDistance(compPlan);
    }

    // Calculates the Y force between two planets
    public double calcPairwiseForceY(Planet compPlan) {
        return this.calcPairwiseForce(compPlan) * (compPlan.y - this.y)
                / this.calcDistance(compPlan);
    }

    // Calculates the Net force and sets it to instance variables
    public void setNetForce(Planet[] netF) {
        for (int i = 0; i < netF.length; i++) {
            if (this != netF[i]) {
                this.xNetForce = this.xNetForce + this.calcPairwiseForceX(netF[i]);
                this.yNetForce = this.yNetForce + this.calcPairwiseForceY(netF[i]);
            }
        }
    }

    // Draws the planet at the correct location
    public void draw() {
        StdDraw.picture(this.x, this.y, ("images/" + this.img).toString());
    }

    public void update(double dt) {
        this.xAccel = this.xNetForce / this.mass;
        this.yAccel = this.yNetForce / this.mass;
        this.xVelocity = this.xVelocity + dt * this.xAccel;
        this.yVelocity = this.yVelocity + dt * this.yAccel;
        this.x = this.x + dt * this.xVelocity;
        this.y = this.y + dt * this.yVelocity;
        this.xNetForce = 0.0;
        this.yNetForce = 0.0;
    }
}
