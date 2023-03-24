package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.ArrayList;
//**Important restriction:** Note that in this exercise you **may not** use *Collections* and *Streams*.

public class Sprint {
    public int capacity, ticketsLimit;
    public int countCapacity, countTicketsLimit;
    public int lastIndex = 0;
    Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {

        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
    }

    /**
     * checks if total amount of tickets less than tickets limit.
     * @return true, if they are less
     */
    protected boolean limitsNotReached (){
        return countTicketsLimit < ticketsLimit;
    }


    protected boolean isAccepted(UserStory userStory){
        for(Ticket x: tickets){
            if(x!=null && x.getId() == userStory.getId()
                    && x.getName() == userStory.getName()){
                return true;
            }
        }
        return false;
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

        for(UserStory us: userStory.getDependencies()){
            //check, if they are not completed &&  if they are already accepted
            if(!us.isCompleted() && isAccepted(us)){
                return true;
            }
        }
        return false;
    }

    /**
     * accepts a userStory, if it is not `null`, not completed
     * and its uncompleted dependencies are already accepted to the sprint.
     * @param userStory
     * @return true, if the user story is accepted, false otherwise
     */

    public boolean addUserStory(UserStory userStory) {

        if(userStory!=null && !userStory.isCompleted()
                &&  limitsNotReached() && (countCapacity+userStory.getEstimate())<=capacity
                && uncompletedDependenciesAccepted(userStory) ){

            //add userStory to Ticket[] tickets;
            tickets[lastIndex]=userStory;
            countCapacity = countCapacity+userStory.getEstimate();
            lastIndex++;
            countTicketsLimit++;
            return true;
        }else{ return false;}
    }

    /**
     * accepts a bug, if it is not `null` and not completed.
     * @param bugReport
     * @return `true` if the bug is accepted, `false` otherwise.
     */
    public boolean addBug(Bug bugReport) {

        if(bugReport!=null && !bugReport.isCompleted()
                && limitsNotReached() && (countCapacity + bugReport.getEstimate()) <= capacity){
            //add bugReport to Ticket[] tickets;
            tickets[lastIndex]=bugReport;
            countCapacity = countCapacity + bugReport.getEstimate();
            lastIndex++;
            countTicketsLimit++;
            return true;
        }else{
            return false;}
    }

    /**
     *   Make sure the order of tickets is as they were accepted to the sprint.
     * @return a defensive copy of the array of the sprint tickets.
     */
    public Ticket[] getTickets() {

        int newLength = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                newLength++;
            }
        }
        Ticket [] copy = new Ticket[newLength];
        System.arraycopy(tickets, 0, copy, 0, newLength);
        return copy;
    }

    public int getTotalEstimate() {
        int total = 0;
        for(Ticket x: tickets){
            if(x!=null) { total = total+x.getEstimate();}
        }
        return total;
    }
}
