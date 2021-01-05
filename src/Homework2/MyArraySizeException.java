package Homework2;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(Throwable throwable) {
        super(throwable);
    }

    public  MyArraySizeException(String str){
        super(str);
    }

}
