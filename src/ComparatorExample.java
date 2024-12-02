/*
* Comparators are used to compare two objects.
 *
 * */
import java.util.*;
class Checker implements Comparator<Player> {

    // Sorting the player according to their score (Descending), if the score is same, then sorting alphabetically
    public int compare(Player p1, Player p2) {
        if (p1.score == p2.score)
            return p1.name.compareTo(p2.name);
        else
            return p2.score - p1.score;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class ComparatorExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (Player value : player) {
            System.out.printf("%s %s\n", value.name, value.score);
        }
    }
}