package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.ArrayList;
//**Important restriction:** Note that in this exercise you **may not** use *Collections* and *Streams*.

public class Sprint {
    public int capacity, ticketsLimit, countCapacity, countTicketsLimit;
    Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {

        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
    }

    /**
     * checks if tickets total estimate less than time capacity
     * and if total amount of tickets less than tickets limit.
     * @return true, if they are less
     */
    protected boolean limitsNotReached (){
        return countTicketsLimit < ticketsLimit && countCapacity < capacity;
    }

    /**
     * @param userStory
     * @return true, if uncompleted dependencies of given UserStory
     * are already accepted to the sprint
     */
    protected boolean uncompletedDependenciesAccepted(UserStory userStory){
        //check, if userStory has any dependencies
        if(userStory.getDependencies().length==0){
            return true;
        }

        for(UserStory x: userStory.getDependencies()){
            //check, if they are not completed
            //check, if they are already accepted
        }
        return false;
    }

    public boolean addUserStory(UserStory userStory) {

        if(userStory!=null && !userStory.isCompleted()
                &&  limitsNotReached()
                && uncompletedDependenciesAccepted(userStory) ){

            //add userStory to Ticket[] tickets;
            countTicketsLimit++;
            countCapacity = countCapacity+userStory.getEstimate();
            return true;
        }else{ return false;}
    }

    public boolean addBug(Bug bugReport) {

        if(bugReport!=null && !bugReport.isCompleted()
                && limitsNotReached()){
            //add bugReport to Ticket[] tickets;
            countTicketsLimit++;
            countCapacity = countCapacity + bugReport.getEstimate();
            return true;
        }else{
            return false;}
    }

    public Ticket[] getTickets() {
        throw new UnsupportedOperationException("Implement this method");
    }

    public int getTotalEstimate() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
