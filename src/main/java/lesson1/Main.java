package lesson1;

public class Main {
    public static void main(String[] args) {

        Barrier[] barriers = new Barrier[4];
        barriers[0] = new Barrier(2, 1);
        barriers[1] = new Barrier(6, 3);
        barriers[2] = new Barrier(15, 5);
        barriers[3] = new Barrier(16, 10);

        Course course = new Course(20, barriers);

        Competitor[] competitors = new Competitor[4];
        competitors[0] = new Competitor("Алекс", 12, 40);
        competitors[1] = new Competitor("Вован", 11, 19);
        competitors[2] = new Competitor("Бориска", 9, 25);
        competitors[3] = new Competitor("Евгеша", 4, 30);
        Team team = new Team("Крутые перцы", competitors);

        team.runDistance(course);
        team.printTeamInfo();


    }
}
