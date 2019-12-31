package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.fashionmall.domain.Info;

public class DeliveryHandler {

   Delivery[] deliveries = new Delivery[DELIVERY_SIZE];
   int deliveryCount = 0;
  
   Scanner input;
   
  static final int DELIVERY_SIZE = 100;
  
  public DeliveryHandler(Scanner input) {
    this.input = input;
    this.deliveries = new Delivery[DELIVERY_SIZE];
  }
  
  public DeliveryHandler(Scanner input, int capacity) {
    this.input = input;
    if (capacity < DELIVERY_SIZE || capacity > 10000)
      this.deliveries = new Delivery[DELIVERY_SIZE];
    else 
      this.deliveries = new Delivery[capacity];
  }

  public  void addDelivery() {
    Delivery delivery = new Delivery();
    
    System.out.print("배송방법? ");
    delivery.setDeliveryMethod(input.nextLine());

    System.out.print("평균배송일");
    delivery.setAverageDeliveryDate(input.nextLine());

    this.deliveries[this.deliveryCount++] = delivery;
    System.out.println("저장하였습니다.");
  }

  public  void listDelivery() {
    for (int i = 0; i < this.deliveryCount; i++) {
      Delivery d = this.deliveries[i];
      System.out.printf("%s, %s \n",
          d.getDeliveryMethod(), d.getAverageDeliveryDate());
    }
  }

}
