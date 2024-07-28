package co.edu.unbosque.model.dsa.recursion.main;

public class HanoiTowerMain {
    public static void main(String[] args) {

        hanoiTower(10,1,2,3);

    }

    public static void hanoiTower(int n, int tower1, int tower2, int tower3 ) {
        if((n == 1)){
            System.out.println("Move from " + tower1 + " to " + tower3);
        }else{
            hanoiTower((n - 1), tower1 , tower3 , tower2);
            System.out.println("Move from " + tower1 + " to " + tower3);
            hanoiTower((n - 1), tower2 , tower1 , tower3);
        }
    }
}
