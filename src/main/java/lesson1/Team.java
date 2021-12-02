package lesson1;

/**
 * Команда участников, которые бегут по полосе препятствий, умеет запускать своих бегунов на дистанцию
 */
public class Team {
    private final String name;
    private final Competitor[] competitors;

    public Team(String name, Competitor[] competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public void printTeamInfo() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Результат команды:");
        for (Competitor comp : competitors) {
            System.out.println("Участник " + comp.getName() + ": " + comp.isSuccess() + " " + comp.getResultString());
        }
    }

    public void runDistance(Course course) {
        System.out.println("Команда '" + this.name + "' НАЧИНАЕТ проходить полосу препятствий");

        for (Competitor comp : competitors) {
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("  Участник " + comp.getName() + " НАЧИНАЕТ проходить полосу препятствий");

            comp.run(course);

            System.out.println("  Участник " + comp.getName() + " ЗАКОНЧИЛ проходить полосу препятствий");
        }

        System.out.println("Команда " + this.name + " ЗАКОНЧИЛА проходить полосу препятствий");
    }

}
