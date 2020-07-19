package hu.maximuseweb;

class Player {
    private String name;
    private String firstPlay;
    private String lastPlay;
    private int weight;
    private int height;

    Player(String name, String firstPlay, String lastPlay, int weight, int height) {
        this.name = name;
        this.firstPlay = firstPlay;
        this.lastPlay = lastPlay;
        this.weight = weight;
        this.height = height;
    }

    String getName() {
        return name;
    }

    String getFirstPlay() {
        return firstPlay;
    }

    String getLastPlay() {
        return lastPlay;
    }

    int getWeight() {
        return weight;
    }

    int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + "'" +
                ", firstPlay='" + firstPlay + "'" +
                ", lastPlay='" + lastPlay + "'" +
                ", weight=" + weight +
                ", height=" + height +
                "}\n";
    }
}