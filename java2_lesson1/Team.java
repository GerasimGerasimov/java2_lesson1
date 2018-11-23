/*
 * Команда
 * 
 * @author Gerasimov V Gerasim
 */
package java2_lesson1;

import lesson1.Competitors.Competitor;//персонажи
import lesson1.obstacles.Obstacle;//препятствия
import java.util.ArrayList;

/**
 *
 * 
 */
interface ITeam {
    void areOnDistanse();
    Competitor[] getMembers();
    void saveObstacleResult(Obstacle obstacle);
    void showResults();
}

public class Team implements ITeam{
    protected String name;//название команды
    protected Competitor[] members;//члены команды
    
    
    public class memberResult {
        public Competitor member;//член команды
        public Boolean result;//результат        
    }
    
    public class ObstacleResults {
        public Obstacle obstacle;//испытание
        public ArrayList <memberResult> mr;//участвующие члены команды и их результаты
        
        ObstacleResults (Obstacle obstacle){
            this.obstacle = obstacle;
            mr = new ArrayList<>();//создаю членов команды и их достижений для этого испытания
        }
        
        public void addMembersAndResult(){
            for (Competitor m: members){
                memberResult res = new memberResult();
                res.member = m;
                res.result = m.isOnDistance();//результат
                mr.add(res);//добавил члена и его результат   
            }
        }
    }

    //результаты команды по всем препятствиям на полосе
    protected ArrayList <ObstacleResults> obstacles;
    
    Team (String name, Competitor[] members) {
        this.name = name;
        this.members = members;
        this.obstacles = new ArrayList<>();//создаю список достижений
    }
    
    /**
     * Возвращает членов команды
     * @return members массив члены команды
     */
    public Competitor[] getMembers(){
        return this.members;
    }
    
    /**
     * Сохраняет результаты преодоления препятствия
     * @param obstacle препятствие
     */
    public void saveObstacleResult(Obstacle obstacle){
        ObstacleResults res = new ObstacleResults(obstacle);      
        res.addMembersAndResult();
        this.obstacles.add(res);//добавил в "достижения и результаты"
    }
    
    /**
     * Показывает результаты преодоления полосы препятствий 
     */
    public void showResults(){
        System.out.println("Результаты преодоления Полосы Препятствий:");
        for (ObstacleResults res: this.obstacles){
            System.out.println(res.obstacle);
            for (memberResult mr: res.mr){
                System.out.println(" | "+mr.member+" : "+(mr.result?"преодолел":"не осилил"));   
            }
        }
    }
    
    /**
     * выводит информацию о членах команды Прошедших дистанцию
     */
    public void areOnDistanse(){
        System.out.println("Прошли дистанцию:");
        for (Competitor member : members){
            if (member.isOnDistance()) {
                System.out.println(member);
            }
        }
    }
    
    @Override
    public String toString() {
        String res = "Команда: "+name;
        for (Competitor member : members){
            res += "\n |"+member.toString();
        }
        return res;
    }
}
