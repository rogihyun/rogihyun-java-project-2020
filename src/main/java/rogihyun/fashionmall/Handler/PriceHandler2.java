package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Info;
import rogihyun.fashionmall.domain.Price;

public class PriceHandler2 {
  
  ArrayList priceList;
  
   Scanner input;
  
  public PriceHandler2(Scanner input) {
    this.input = input;
    this.priceList = new ArrayList();
  }
  
  public PriceHandler2(Scanner input, int capacity) {
    this.input = input;
    this.priceList = new ArrayList(capacity);
  }
  
  public  void listPrice() {
    Object[] arr = this.priceList.toArray();
    for (Object obj : arr) {
      Price p =(Price) obj;
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
