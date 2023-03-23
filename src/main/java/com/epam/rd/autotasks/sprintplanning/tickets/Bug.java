package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
UserStory userStory;
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        //throw new UnsupportedOperationException("Implement this method");
        if(userStory==null || !userStory.isCompleted()){
            return null;
        }else{
            return new Bug(id,name,estimate,userStory);
        }
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        //throw new UnsupportedOperationException("Implement this method");
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        //throw new UnsupportedOperationException("Implement this method");
        return "[Bug " + this.getId() + "] " + this.userStory.getName()+": "+this.getName();
    }
}
