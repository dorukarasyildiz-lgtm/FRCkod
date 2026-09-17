import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int balance = 100;
        int bet;
        int payout;
        String[] row = new String[0];

        System.out.println("Welcome to javaslots!");
        System.out.println("Symbols: a,b,c,d");


        while(balance > 0){
            System.out.println("Enter your bet: ");
            bet = scanner.nextInt();
            if(bet < 0){
                System.out.println("Your bet cannot be negative");
            }
            else if(bet > balance){
                System.out.println("Your bet cannot be higher than your balance");
            }
            else{
                balance -= bet;
                System.out.println(balance);
            }
            System.out.println("Spinning");
             row = spin();
             spinrow(row);
            payout = getpayout(row,bet);
            if(payout > 0){
                balance += payout;
                System.out.println("You have won: " + balance);
            }
            else {
                System.out.println("you lost this round");
            }
        }
        scanner.close();
    }
    static String[] spin(){
        String[] sembols = {"a","b","c","d"};
        String[] row = new String[3];
        Random random = new Random();
        for(int i = 0; i < 3; i++){
            row[i] = sembols[random.nextInt(sembols.length)];
        }
        System.out.println(row[0]  + row[1] + row[2]);
        return row;

    }
    static String[] spinrow(String[] row) {
        System.out.println(" " + String.join("|" , row));
        return row;
    }
   static int getpayout(String[] row, int bet){
       if (row[0].equals(row[1]) && row[0].equals(row[2])){
           return switch (row[0]){
               case "a" -> bet * 5;
               case "b" -> bet * 10;
               case "c" -> bet * 20;
               case "d" -> bet * 25;
               default -> 0;
           };
       }
       if(row[0].equals(row[1]) || row[0].equals(row[2]) || row[1].equals(row[2])){
           return switch (
                   row[0].equals(row[1]) ? row[0] :
                           row[0].equals(row[2]) ? row[0] :
                                   row[1]
                   ){
               case "a" -> bet * 2;
               case "b" -> bet * 3;
               case "c" -> bet * 5;
               case "d" -> bet * 8;
               default -> 0;
           };
       }
       return 0;
   }
}
