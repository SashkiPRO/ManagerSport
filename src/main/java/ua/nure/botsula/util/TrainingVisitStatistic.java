package ua.nure.botsula.util;


import ua.nure.botsula.model.Message;
import ua.nure.botsula.model.User;

import java.util.Iterator;

/**
 * Created by Alexandr on 12.06.2017.
 */
public class TrainingVisitStatistic {
    private User user;
    private int trainingVisited;
    private int trainingMissed;
    private int total;
    private double percentVisitedTraining;
    public TrainingVisitStatistic() {
    }

    public TrainingVisitStatistic(User user) {
        this.user = user;

        getTotalTraining();
        getVisitedTraining();
        getMissedTraining();
        getVisitedPercent();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;


    }

    private void getTotalTraining(){

        for(Iterator<Message> iterator = user.getMessages().iterator();iterator.hasNext();){
            if (iterator.next().getEvent().getType().equals("TRAINING")){
                total++;
            }
        }
    }

    private void getVisitedTraining(){
        for(Iterator<Message> iterator = user.getMessages().iterator();iterator.hasNext();){
            Message temp= iterator.next();
            if (temp.getEvent().getType().equals("TRAINING")){
                if (temp.getStatus().equals("read"))
                    trainingVisited++;
            }
        }
    }
    private void getMissedTraining(){
        for(Iterator<Message> iterator = user.getMessages().iterator(); iterator.hasNext();){
            if (iterator.next().getEvent().getType().equals("TRAINING")){
                if (iterator.next().getStatus().equals("disagree"))
                    trainingMissed++;
            }
        }
    }
    private void getVisitedPercent(){

        percentVisitedTraining= (trainingVisited*100/total);
    }

    public int getTrainingVisited() {
        return trainingVisited;
    }

    public void setTrainingVisited(int trainingVisited) {
        this.trainingVisited = trainingVisited;
    }

    public int getTrainingMissed() {
        return trainingMissed;
    }

    public void setTrainingMissed(int trainingMissed) {
        this.trainingMissed = trainingMissed;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPercentVisitedTraining() {
        return percentVisitedTraining;
    }

    public void setPercentVisitedTraining(double percentVisitedTraining) {
        this.percentVisitedTraining = percentVisitedTraining;
    }
}
