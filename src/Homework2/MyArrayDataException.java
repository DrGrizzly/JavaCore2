package Homework2;

public class MyArrayDataException extends Exception{

    private final int row;
    private final int col;

    public int getCol() {
        return col;
    }
    public int getRow(){
        return  row;
    }

    public MyArrayDataException(Throwable throwable){
        super(throwable);
        this.col = -1;
        this.row = -1;
    }

    public  MyArrayDataException(String str, int row, int col,Throwable throwable){
        super(str, throwable);
        this.col = col;
        this.row = row;
    }

}
