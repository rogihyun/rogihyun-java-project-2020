package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Price;

public class priceHandler {

  static final int PRICE_SIZE = 100;
  static Price[] prices = new Price[PRICE_SIZE];
  static int priceCount = 0;
  public static Scanner keyboard;
  
  public static void addPrice() {
    Price price = new Price();

    System.out.print("번호? ");
    price.no = keyboard.nextInt();

    keyboard.nextLine(); 
    
    System.out.print("상품가격? ");
    price.pricetag = keyboard.nextLine();
    
    System.out.print("세일가격? ");
    price.reduced = keyboard.nextLine();

    System.out.print("회원가격? ");
    price.membership = keyboard.nextLine();

    prices[priceCount++] = price;
    System.out.println("저장하였습니다.");
  }      
  
  public static void listPrice() {
    for (int i = 0; i < priceCount; i++) {
      Price p = prices[i];
      System.out.printf("%s, %s, %s\n", 
          p.pricetag, p.reduced, p.membership);
    }
  }


}
