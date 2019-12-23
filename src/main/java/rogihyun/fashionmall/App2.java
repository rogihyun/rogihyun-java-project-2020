package rogihyun.fashionmall;

import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    class Delivery {
      String deliveryMethod;
      String averageDeliveryDate; 
    }
    
    final int SIZE = 100;

    Delivery[] deliveries = new Delivery[SIZE];
    
    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      
      count++;

      Delivery delivery = new Delivery();
      
      
      System.out.print("배송방법? ");
      delivery.deliveryMethod = keyboard.nextLine();

      System.out.print("평균배송일");
      delivery.averageDeliveryDate = keyboard.nextLine();

      deliveries[i] = delivery;
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    System.out.println();

    for (int i = 0; i < count; i++) {
      Delivery delivery = deliveries[i];
      System.out.printf("%s, %s \n",
          delivery.deliveryMethod, delivery.averageDeliveryDate
          );
    }

    keyboard.close();
  }
}
