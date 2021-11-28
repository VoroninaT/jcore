package lesson1;

/**
 * Полоса с препятствиями, имеет длину и содержит барьеры
 */
public class Course {
    private final int distance;
    private final Barrier[] barriers;


    public Course(int distance, Barrier[] barriers) {
        this.distance = distance;
        this.barriers = barriers;
    }

    public int getDistance() {
        return distance;
    }

    public Barrier getBarrier(int distanceMeter) {
        for (Barrier barrier : barriers) {
            if (barrier.getDistanceMeter() == distanceMeter) {
                return barrier;
            }
        }
        return null;
    }
}
