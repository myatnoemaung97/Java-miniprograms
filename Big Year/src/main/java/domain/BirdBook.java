package domain;

import java.util.ArrayList;

public class BirdBook {

    private ArrayList<Bird> birds;

    public BirdBook() {
        this.birds = new ArrayList<>();
    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }

    public void add(Bird bird) {
        birds.add(bird);
    }

    public Bird getBird(String name) {
        for (Bird bird: birds) {
            if (bird.getName().equals(name)) {
                return bird;
            }
        }
        return null;
    }
}
