package hu.maximuseweb;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

class Actions {
    private static ArrayList<Player> list;
    private static int year;

    private static ArrayList<Player> getList() {
        return list;
    }

    private static void setList(ArrayList<Player> list) {
        Actions.list = list;
    }

    private static int getYear() {
        return year;
    }

    private static void setYear(int year) {
        Actions.year = year;
    }

    static void fileToList(String fileName) {
        ArrayList<Player> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            row = raf.readLine();
            String[] slice;

            while (row != null) {
                slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

                list.add(new Player(slice[0], slice[1], slice[2], Integer.parseInt(slice[3]), Integer.parseInt(slice[4])));

                row = raf.readLine();
            }

            raf.close();

            setList(list);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static String task3() {
        return "3. feladat: " + Actions.getList().size();
    }

    private static String[] getSplittedDate(String date) {
        return date.split("-");
    }

    static String task4(int year, int month) {
        String[] date;
        double heightInCm;
        StringBuilder result = new StringBuilder();

        for (Player player : Actions.getList()) {
            date = getSplittedDate(player.getLastPlay());

            if (year == Integer.parseInt(date[0]) && month == Integer.parseInt(date[1])) {
                heightInCm = player.getHeight() * 2.54;
                result.append("\n\t").append(player.getName()).append(", ").append(String.format("%.1f", heightInCm)).append(" cm");
            }
        }

        return "4. feladat: " + result;
    }

    static void task5() {
        System.out.println("5. feladat:");

        Scanner s = new Scanner(System.in);
        int year;
        boolean firstRun = true;
        boolean error = true;

        do {
            System.out.print((firstRun) ? "\tKérek egy 1990 és 1999 közötti évszámot!: " : "\tHibás adat! Kérek egy 1990 és 1999 közötti évszámot!: ");
            firstRun = false;
            year = s.nextInt();

            if (year >= 1990 && year <= 1999) {
                error = false;
                setYear(year);
            }
        }
        while (error);
    }

    static String task6() {
        String[] firstPlay;
        String[] lastPlay;
        double avg = 0;
        int counter = 0;

        for (Player player : Actions.getList()) {
            firstPlay = getSplittedDate(player.getFirstPlay());
            lastPlay = getSplittedDate(player.getLastPlay());

            if (getYear() >= Integer.parseInt(firstPlay[0]) && getYear() <= Integer.parseInt(lastPlay[0])) {
                avg += player.getWeight();
                counter++;
            }
        }

        avg /= counter;

        return "6. feladat: " + String.format("%.2f", avg) + " font";
    }
}