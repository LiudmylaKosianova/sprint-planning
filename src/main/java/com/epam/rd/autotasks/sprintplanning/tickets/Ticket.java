package com.epam.rd.autotasks.sprintplanning.tickets;
/**
 * Ticket
 * Every ticket has an id, a name and an estimate of hours to complete it.
 * One provides them via the constructor of the Ticket class.
 * Also, a ticket may be completed or not. When a ticket is created, it is not completed.
 * getId() - Returns the id of the ticket.
 * getName() - Returns the name of the ticket.
 * getEstimate() - Returns the estimate of the ticket.
 * isCompleted() - Returns true if the ticket is completed, false otherwise.
 * complete() - Sets the ticket to completed state.
 */

public class Ticket {
    private String  name;
    private int id, estimate;
    protected boolean completed = false;

    public Ticket(int id, String name, int estimate) {
        //throw new UnsupportedOperationException("Implement this method");
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {

        //throw new UnsupportedOperationException("Implement this method");
        return id;
    }

    public String getName() {

        //throw new UnsupportedOperationException("Implement this method");
        return name;
    }

    public boolean isCompleted() {

        //throw new UnsupportedOperationException("Implement this method");
        return completed;
    }

    public void complete() {

        //throw new UnsupportedOperationException("Implement this method");
        completed = true;
    }

    public int getEstimate() {

        //throw new UnsupportedOperationException("Implement this method");
        return estimate;
    }
}
