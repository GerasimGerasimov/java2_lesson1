package java2_lesson1;

import lesson1.Competitors.*;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;
import java2_lesson1.Team;
import java2_lesson1.Course;

public class MainClass {
    public static void main(String[] args) {
        //создаю персонажей
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        //создаю полосу препятствия
        Obstacle[] obstacles = {new Cross(600), new Wall(5), new Water(1)};
        //Формирую Команду из персонажей
        ITeam team = new Team("Furia", competitors);
        //Из отдельных препятствий, делаю Полосу Препятствий
        ICourse course = new Course(obstacles);
        //Проверяю создание объектов
        System.out.println(team);  //команда и её члены
        System.out.println(course);//полоса препятствий
        //
        course.doIt(team);//проходят полосу препятствий
        team.showResults();//вывод результатов преодоления полосы препятствий для всей команды
    }
}
