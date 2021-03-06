package Homework1;

import java.util.Random;

public class Cat implements Sport {
    private String name;
    private boolean isDead = false;
    private float jumpLimit;
    private float runLimit;

    Random rnd = new Random();

    public Cat(String name) {
        this.name = name;
        this.jumpLimit = (float) rnd.nextInt(100);
        this.runLimit = (float) rnd.nextInt(100);
    }

    public boolean getIsDead() {
        return isDead;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() > jumpLimit) {
            isDead = true;
            System.out.printf("Кот %s не смог подпрыгнуть на %f метров и сдох %n", this.name,wall.getHeight());
            return;
        }
        System.out.printf("Кот %s подпрыгнул на %f метров %n", this.name, wall.getHeight());
    }

    @Override
    public void run(Track track) {
        if (track.getLength() > runLimit) {
            isDead = true;
            System.out.printf("Кот %s не смог пробежать %f метров и сдох %n", this.name,track.getLength());
            return;
        }
        System.out.printf("Кот %s пробежал %f метров %n", this.name, track.getLength());
    }

    @Override
    public void letsMake(Object let) {
        if (let instanceof Wall) {
            jump((Wall) let);
        } else if (let instanceof Track) {
            run((Track) let);
        } else {
            isDead = true; //Если неизвестное препятствие - то разбился об него насмерть
        }
    }

    public String toString() {
        return "Кот" + "\nИмя: " + this.name + "\nМакс.прыжок: " + this.jumpLimit + "\nМакс.бег: " + this.runLimit + "\nСостояние: " + (isDead ? "Сдох" : "Живой");
    }
}
