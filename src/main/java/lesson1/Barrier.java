package lesson1;

/**
 * Препятствие на дистанции (барьер), стоит на определенном метре дистанции и имеет высоту
 */
public class Barrier {
    private final int distanceMeter;
    private final int height;


    public Barrier(int distanceMeter, int height) {
        this.distanceMeter = distanceMeter;
        this.height = height;
    }

    public int getDistanceMeter() {
        return distanceMeter;
    }

    public int getHeight() {
        return height;
    }
}
