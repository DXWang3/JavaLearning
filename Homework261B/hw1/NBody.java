package Homework261B.hw1;

/**
 * Created by davidwang on 2/28/15.
 */
public class NBody {

    // Read in starting info
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        In in = new In(filename);
        int totalPlanets = in.readInt();
        double radius = in.readDouble();
        Planet[] allPlanets = new Planet[totalPlanets];
        for (int i = 0; i < totalPlanets; i++) {
            allPlanets[i] = getPlanet(in);
        }
        StdDraw.setCanvasSize();
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (int i = 0; i < totalPlanets; i++){
            allPlanets[i].draw();
        }
        double time = 0;
        while (time < T) {
            for (int i = 0; i < totalPlanets; i++) {
                allPlanets[i].setNetForce(allPlanets);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < totalPlanets; i++){
                allPlanets[i].update(dt);
                allPlanets[i].draw();
            }
            StdDraw.show(10);
            time = time + dt;
        }
        System.out.println(totalPlanets);
        System.out.println(String.format("%.2e", radius));
        for (int i = 0; i < totalPlanets; i++){
            System.out.println(String.format("%11.4e %11.4e %11.4e %11.4e %11.4e %12s",
                    allPlanets[i].x, allPlanets[i].y, allPlanets[i].xVelocity,
                    allPlanets[i].yVelocity, allPlanets[i].mass, allPlanets[i].img));
        }
    }

    public static Planet getPlanet(In reader) {
        return new Planet(reader.readDouble(), reader.readDouble(),
                reader.readDouble(), reader.readDouble(),
                reader.readDouble(), reader.readString());
    }
}