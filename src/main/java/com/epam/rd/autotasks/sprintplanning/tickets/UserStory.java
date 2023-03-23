package com.epam.rd.autotasks.sprintplanning.tickets;
/**
 * UserStory
 * We consider a user story to be a ticket that may contain some dependencies.
 * A dependency is another user story that must be completed first to allow the dependent user story
 * to complete. One provides dependencies of the UserStory via the constructor of the UserStory class.
 * <p>
 * complete() - Like the Ticket#complete() method, this sets the ticket to completed state.
 * The difference is that the user story may not be completed if its dependencies are not completed yet.
 * <p>
 * getDependencies() - Returns a defensive copy of dependencies array.
 * <p>
 * toString() - Returns a String representing this user story, using its id and name.
 * Example: "[US 1] User Registration Entity"
 */
public class UserStory extends Ticket {

    UserStory [] dependencies;
    public UserStory(int id, String name, int estimate, UserStory ...dependOn) {
        super(id, name, estimate);
        this.dependencies = dependOn;
        //throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public void complete() {

        //throw new UnsupportedOperationException("Implement this method");
        boolean foundNotCompleted = false;
        for(UserStory x: dependencies){
            if (!x.isCompleted()) {
                foundNotCompleted = true;
                break;
            }
        }
        completed = !foundNotCompleted;
    }

    public UserStory[] getDependencies() {
        //throw new UnsupportedOperationException("Implement this method");
        UserStory[] copy = new UserStory[dependencies.length];
        System.arraycopy(dependencies, 0, copy, 0, dependencies.length);
        return copy;
    }

    @Override
    public String toString() {
        return "[US " + this.getId() + "]" + " " + this.getName();
        //throw new UnsupportedOperationException("Implement this method");
    }
}
