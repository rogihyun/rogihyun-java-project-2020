package rogihyun.fashionmall;

import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    class Price {
      String pricetag;   //상품가격
      String reduced;     //세일가격
      String membership;  //회원가격
      
    }

    final int SIZE = 100;

    Price[] Prices = new Price[SIZE];

    int count = 0;

    for (int i = 0; i < SIZE; i++) {

      count++;

      Price price = new Price();


      System.out.print("상품가격? ");
      price.pricetag = keyboard.nextLine();

      System.out.print("세일가격? ");
      price.reduced = keyboard.nextLine();

      System.out.print("회원가격? ");
      price.membership = keyboard.nextLine();

      Prices[i] = price;

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    System.out.println();

    for (int i = 0; i < count; i++) {
      Price price = Prices[i];
      System.out.printf("%s, %s, %s\n",
          price.pricetag, price.reduced, 
          price.membership);
    }

    keyboard.close();
  }
}
