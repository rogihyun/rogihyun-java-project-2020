package rogihyun.fashionmall.Handler;

import java.util.Scanner;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.util.ArrayList;

public class DeliveryHandler {

  ArrayList<Delivery> deliveryList;

  public Scanner input;

  public DeliveryHandler(Scanner input) {
    this.input = input;
    this.deliveryList = new ArrayList<>();
  }

  public void listDelivery() {
   Delivery[] arr = this.deliveryList.toArray(new Delivery[] {});
    for (Delivery d : arr) {
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
  
  public void detailDelivery() {
    System.out.println("상품 리스트");
    int index = input.nextInt();
    input.nextLine();
    
    Delivery delivery = this.deliveryList.get(index);
    
    if(delivery == null) {
      System.out.println("상품이 품절되었습니다.");
      return;
    }
    System.out.printf("배송방법: %d\n", delivery.getDeliveryMethod());
    System.out.printf("평균배송일: %d\n", delivery.getAverageDeliveryDate());
  }
  
  public void deleteDelivery() {
    System.out.print("회원 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); 
    
    Delivery delivery = this.deliveryList.get(index);
    
    if (delivery == null) {
      System.out.println("회원 인덱스가 유효하지 않습니다.");
      return;
    }
    
    this.deliveryList.remove(index);
    
    System.out.println("회원을 삭제했습니다.");
  }
  public void updateDelivery() {
    System.out.print("회원 인덱스? ");
    int index = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    Delivery oldDelivery = this.deliveryList.get(index);
    
    if (oldDelivery == null) {
      System.out.println("회원 인덱스가 유효하지 않습니다.");
      return;
    }
    
    boolean changed = false;
    String inputStr = null;
    Delivery newDelivery = new Delivery();
    
    newDelivery.setNo(oldDelivery.getNo());
    
    System.out.printf("배송방법", oldDelivery.getDeliveryMethod());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newDelivery.setDeliveryMethod(oldDelivery.getDeliveryMethod());
    } else {
      newDelivery.setDeliveryMethod(inputStr);
      changed = true;
    }
    
    System.out.printf("평균배송일", oldDelivery.getAverageDeliveryDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newDelivery.setAverageDeliveryDate(oldDelivery.getAverageDeliveryDate());
    } else {
      newDelivery.setAverageDeliveryDate(inputStr);
      changed = true;
    }
    
    if (changed) {
      this.deliveryList.set(index, newDelivery);
      System.out.println("회원을 변경했습니다.");
    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
    
  }
}