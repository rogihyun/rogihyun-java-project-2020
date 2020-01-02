package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Delivery;

public class DeliveryHandler {

  ArrayList deliveryList;

  Scanner input;

  public DeliveryHandler(Scanner input) {
    this.input = input;
    this.deliveryList = new ArrayList();
  }

  public DeliveryHandler(Scanner input, int capacity) {
    this.input = input;
    this.deliveryList = new ArrayList(capacity);
  }

  public void listDelivery() {
    Object[] arr = this.deliveryList.toArray();
    for (Object obj : arr) {
      Delivery d = (Delivery) obj;
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
