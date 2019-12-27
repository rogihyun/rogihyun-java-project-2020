package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Delivery;

public class DeliveryHandler {

   Delivery[] deliveries = new Delivery[DELIVERY_SIZE];
   int deliveryCount = 0;
  
  static final int DELIVERY_SIZE = 100;
  public static Scanner keyboard;

  public  void addDelivery() {
    Delivery delivery = new Delivery();
    
    System.out.print("배송방법? ");
    delivery.deliveryMethod = keyboard.nextLine();

    System.out.print("평균배송일");
    delivery.averageDeliveryDate = keyboard.nextLine();

    this.deliveries[this.deliveryCount++] = delivery;
    System.out.println("저장하였습니다.");
  }

  public  void listDelivery() {
    for (int i = 0; i < this.deliveryCount; i++) {
      Delivery d = this.deliveries[i];
      System.out.printf("%s, %s \n",
          d.deliveryMethod, d.averageDeliveryDate);
    }
  }

}
