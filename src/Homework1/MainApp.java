package Homework1;

public class MainApp {

    public static void main(String[] args) {
        //Создадим массив объектов
        Object[] arrLifeObj = new Object[]{new Cat("Васька"), new Human("Петька"), new Robot("БоБо"), new Cat("Феликс"), new Human("Изя"), new Robot("Микс")};
        Object[] arrSportObj = new Object[]{new Track(50), new Wall(80), new Wall(), new Track(), new Track(10), new Wall(90)};

        for (Object persona : arrLifeObj) {
            for (Object let : arrSportObj) {
                //Проверим, что наш объект еще не сдох на полосе препятствий
                if (!((Sport) persona).getIsDead())
                    ((Sport) persona).letsMake(let); //Приведем объект к типу Интерфейс и дернем один для всех классов метод
            }
        }

        //Глянем результаты
        System.out.println("\nИтоги забега:");
        for (Object persona : arrLifeObj) {
            System.out.println(persona);
            System.out.println("=====================");
        }
    }
}
