/*
 * Полоса препятствий.
 * 
 * @author Gerasimov V Gerasim
 */
package java2_lesson1;

import lesson1.Competitors.Competitor;
import lesson1.obstacles.Obstacle;//препятствия
import java2_lesson1.Team;//команда

/**
 *
 * 
 */
interface ICourse {
    void doIt(ITeam team);
}

public class Course implements ICourse {
    protected Obstacle[] obstacles;//массив препятствий
    
    /**
     * Конструктор
     * @param obstacles полоса препятствий 
     */
    Course (Obstacle[] obstacles){
        this.obstacles = obstacles;
    }
    
    /** 
     * Обход полосы препятствий
     * @param team Команда
     */
    public void doIt(ITeam team){
        //прохожу полосу препятствий, запоминаю результ членов команды
        //для каждого препятствия
        for (Obstacle o: obstacles) {
            System.out.println("------------------");
            System.out.println("Препятствие:"+o);
            for (Competitor c: team.getMembers()){
                o.doIt(c);//пускаю члена команды преодолевать препятствие
            }
            team.saveObstacleResult(o);//Сохранение результата команды
        }
    }
    
    @Override
    public String toString() {
        String res = "Полоса препятствий:";
        for (Obstacle o: obstacles){
            res += "\n |"+o.toString();
        }
        return res;
    }
}
