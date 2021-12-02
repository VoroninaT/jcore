package lesson1;

/**
 * Участник команды, умеет бегать по полосе препятствий
 */
public class Competitor {
    private final String name;
    private final int maxJumpHeight;
    private final int maxDistance;

    private String resultString;
    private boolean success;


    public Competitor(String name, int maxJumpHeight, int maxDistance) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxDistance = maxDistance;
    }

    public String getName() {
        return name;
    }

    public String getResultString() {
        return resultString;
    }

    public boolean isSuccess() {
        return success;
    }

    public void run(Course course) {
        for (int i = 1; i <= course.getDistance(); i++) {

            if (i >= this.maxDistance) {
                System.out.println("    " + this.name + " выдохся на метре дистанции = " + i);
                this.resultString = "Выдохся на метре дистанции = " + i;
                this.success = false;
                return;
            }

            Barrier b = course.getBarrier(i);
            if (b != null) {
                boolean result = takeBarrier(b);
                if (!result) {
                    System.out.println("    " + this.name + " НЕ перепрыгнул барьер высотой " + b.getHeight() + " на метре дистанции = " + i);
                    this.resultString = "НЕ перепрыгнул барьер высотой " + b.getHeight() + " на метре дистанции = " + i;
                    this.success = false;
                    return;
                } else {
                    System.out.println("    " + this.name + " ПЕРЕПРЫГНУЛ барьер высотой " + b.getHeight() + " на метре дистанции = " + i);
                }
            }
        }
        System.out.println("      " + this.name + "Прошел дистанцию " + course.getDistance() + " успешно");
        this.resultString = "Прошел дистанцию " + course.getDistance() + " успешно";
        this.success = true;
    }

    private boolean takeBarrier(Barrier barrier) {
        return this.maxJumpHeight > barrier.getHeight();
    }
}
