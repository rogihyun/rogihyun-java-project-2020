package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Info;
import rogihyun.fashionmall.domain.Price;

public class PriceHandler2 {

   Price[] prices = new Price[PRICE_SIZE];
   int priceCount = 0;
  
   Scanner input;
   
  static final int PRICE_SIZE = 100;
  
  public PriceHandler2(Scanner input) {
    this.input = input;
    this.prices = new Price[PRICE_SIZE];
  }
  
  public PriceHandler2(Scanner input, int capacity) {
    this.input = input;
    if (capacity < PRICE_SIZE || capacity > 10000)
      this.prices = new Price[PRICE_SIZE];
    else 
      this.prices = new Price[capacity];
  }
  
  public  void addPrice() {
    Price price = new Price();

    System.out.print("번호? ");
    price.setNo(input.nextInt());

    input.nextLine(); 
    
    System.out.print("상품가격? ");
    price.setPricetag(input.nextLine());
    
    System.out.print("세일가격? ");
    price.setReduced(input.nextLine());

    System.out.print("회원가격? ");
    price.setMembership(input.nextLine());

    this.prices[this.priceCount++] = price;
    System.out.println("저장하였습니다.");
  }      
  
  public  void listPrice() {
    for (int i = 0; i < this.priceCount; i++) {
      Price p = this.prices[i];
      System.out.printf("%s, %s, %s\n", 
          p.getPricetag(), p.getReduced(), p.getMembership());
    }
  }


}
