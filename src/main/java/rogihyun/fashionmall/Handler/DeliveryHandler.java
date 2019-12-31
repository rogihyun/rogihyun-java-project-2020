package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Delivery;

public class DeliveryHandler {

  DeliveryList deliveryList;

  Scanner input;

  public DeliveryHandler(Scanner input) {
    this.input = input;
    this.deliveryList = new DeliveryList();
  }

  public DeliveryHandler(Scanner input, int capacity) {
    this.input = input;
    this.deliveryList = new DeliveryList(capacity);
  }

  public  void listDelivery() {
    Delivery[] deliverys = this.deliveryList.toArray();
    for (Delivery d: deliverys) {
      System.out.printf("%s, %s \n",
          d.getDeliveryMethod(), d.getAverageDeliveryDate());
    }
  }

  public  void addDelivery() {
    Delivery delivery = new Delivery();

    System.out.print("배송방법? ");
    delivery.setDeliveryMethod(input.nextLine());

    System.out.print("평균배송일");
    delivery.setAverageDeliveryDate(input.nextLine());

   this.deliveryList.add(delivery);

    System.out.println("저장하였습니다.");
  }
}
