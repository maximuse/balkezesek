package hu.maximuseweb;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class Actions {
    private static ArrayList<Player> list;

    private static ArrayList<Player> getList() {
        return list;
    }

    private static void setList(ArrayList<Player> list) {
        Actions.list = list;
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
}