package Homework2;

import java.nio.channels.ScatteringByteChannel;

public class MainApp {
    public static void main(String[] args) {
        String[][] arrM = new String[4][4];
        arrM[0][0]= "1";
        arrM[0][1]= "2";
        arrM[1][0]= "1";
        arrM[1][1]= "3";
        try {
            System.out.printf("Сумма всех элементов равна %d", ArrayConvert(arrM));
        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage());
        } catch (MyArrayDataException ex) {
            System.out.println(ex.getMessage()+" ячейка массива с адресом: "+ex.getRow()+": "+ex.getCol());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Возвращать будем ошибку общего класса Exception, т.к собственные являются наследниками этого класса
    public static int ArrayConvert(String[][] arr) throws Exception {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива");
        }
        int total = 0;
        int i = 0;
        int j = 0;
        try {
            for (i = 0; i < arr.length; i++) {
                for (j = 0; i < arr[i].length; j++) {
                    total += Integer.parseInt(arr[i][j]);
                }
            }
            return  total;
        } catch (Exception e) {
            throw new MyArrayDataException("Ошибка преобразования значения в число ", i, j, e);
        }
    }

}

