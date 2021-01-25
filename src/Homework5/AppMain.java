package Homework5;

public class AppMain {
    static final int size = 10000000;
    static final int h = size / 2;

    private static float[] initArray(float[] newArr){
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = 1f;
        }
        return newArr;
    }

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        arr = initArray(arr);

        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(float)(arr[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
        }

        long timeStop = System.currentTimeMillis();
        System.out.println("Время выполнения в одном потоке: " + (timeStop - timeStart));

        arr = initArray(arr); //заполним единицами

        Thread tTask1 = new  Thread(new ThreadTask(a1));
        Thread tTask2 = new  Thread(new ThreadTask(a2));

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        timeStart = System.currentTimeMillis();

        tTask1.start();
        tTask2.start();

        tTask1.join();
        tTask2.join();

        timeStop = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время выполнения параллельно: " + (timeStop - timeStart));

    }

    static class ThreadTask extends Thread{
        private float[] arrMas;

        public ThreadTask(float[] arr){
            arrMas = arr;
        }
        @Override
        public void run() {
            for (int i = 0; i < arrMas.length; i++) {
                arrMas[i]=(float)(arrMas[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
            }
            System.out.println("task finish");
        }
    }


}
