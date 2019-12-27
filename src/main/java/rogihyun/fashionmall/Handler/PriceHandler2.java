package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Price;

public class PriceHandler2 {

   Price[] prices = new Price[PRICE_SIZE];
   int priceCount = 0;
  
  static final int PRICE_SIZE = 100;
  public static Scanner keyboard;
  
  public  void addPrice() {
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

    this.prices[this.priceCount++] = price;
    System.out.println("저장하였습니다.");
  }      
  
  public  void listPrice() {
    for (int i = 0; i < this.priceCount; i++) {
      Price p = this.prices[i];
      System.out.printf("%s, %s, %s\n", 
          p.pricetag, p.reduced, p.membership);
    }
  }


}
