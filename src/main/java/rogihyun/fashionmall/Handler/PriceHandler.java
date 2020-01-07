package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Info;
import rogihyun.fashionmall.domain.Price;
import rogihyun.util.ArrayList;

public class PriceHandler {
  
  ArrayList<Price> priceList;
  
   Scanner input;
  
  public PriceHandler(Scanner input) {
    this.input = input;
    this.priceList = new ArrayList<>();
  }
  
  public PriceHandler(Scanner input, int capacity) {
    this.input = input;
    this.priceList = new ArrayList<>(capacity);
  }
  
  public  void listPrice() {
    Price[] arr = this.priceList.toArray(new Price[] {});
    for (Price p : arr) {
      System.out.printf("%s, %s, %s\n", 
          p.getPricetag(), p.getReduced(), p.getMembership());
    }
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

    this.priceList.add(price);
    
    System.out.println("저장하였습니다.");
  }      
  


}