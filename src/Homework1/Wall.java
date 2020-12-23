package Homework1;

import java.util.Random;

public class Wall {
    private float height;

    Random rnd = new Random();

    public float getHeight() {
        return height;
    }

    public Wall(){
        this.height = (float) rnd.nextInt(100);
    }

    public Wall(float height){
        this.height = height;
    }

}
