package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Delivery;

public class DeliveryHandler {

  static final int DELIVERY_SIZE = 100;
  static Delivery[] deliveries = new Delivery[DELIVERY_SIZE];
  static int deliveryCount = 0;
  
  public static Scanner keyboard;

  public static void addDelivery() {
    Delivery delivery = new Delivery();
    
    System.out.print("배송방법? ");
    delivery.deliveryMethod = keyboard.nextLine();

    System.out.print("평균배송일");
    delivery.averageDeliveryDate = keyboard.nextLine();

    deliveries[deliveryCount++] = delivery;
    System.out.println("저장하였습니다.");
  }

  public static void listDelivery() {
    for (int i = 0; i < deliveryCount; i++) {
      Delivery d = deliveries[i];
      System.out.printf("%s, %s \n",
          d.deliveryMethod, d.averageDeliveryDate);
    }
  }

}
