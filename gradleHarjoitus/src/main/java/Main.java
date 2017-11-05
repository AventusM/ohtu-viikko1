import java.util.*;
import ohtu.Multiplier;
public class Main {
  public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      //System.out.print("Nimesi? ");
      Multiplier kolme = new Multiplier(3);
      System.out.println("Anna luku: ");
      int luku = input.nextInt();
      System.out.println("luku kertaa kolme on " + kolme.multipliedBy(luku));

      //String nimi = input.nextLine();
      //System.out.println("Moikka " + nimi);
  }
}
