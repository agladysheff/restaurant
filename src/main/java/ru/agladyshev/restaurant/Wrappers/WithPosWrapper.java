package ru.agladyshev.restaurant.Wrappers;

public class WithPosWrapper extends IdWrapper {

    private boolean withpositions;

    public boolean isWithpositions() {
        return withpositions;
    }

    public void setWithpositions(boolean withpositions) {
        this.withpositions = withpositions;
    }
}
