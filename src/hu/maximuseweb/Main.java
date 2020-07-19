package hu.maximuseweb;

public class Main {
    public static void main(String[] args) {
	    Actions.fileToList("balkezesek.csv");
        System.out.println(Actions.task3());
        System.out.println(Actions.task4(1999, 10));
    }
}