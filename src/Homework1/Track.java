package Homework1;

import java.util.Random;

public class Track {
    private float length;

    Random rnd = new Random();

    public float getLength() {
        return length;
    }

    public Track() {
        this.length = (float) rnd.nextInt(100);
    }

    public Track(float lng) {
        this.length = lng;
    }
}
