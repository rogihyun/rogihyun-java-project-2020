package rogihyun.fashionmall.Handler;

import rogihyun.fashionmall.domain.Delivery;
import rogihyun.util.AbstractList;
import rogihyun.util.Prompt;

public class DeliveryHandler {

  AbstractList<Delivery> deliveryList;

  Prompt prompt;

  public DeliveryHandler(Prompt prompt, AbstractList<Delivery> list) {
    this.prompt = prompt;
    this.deliveryList = list;
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

    delivery.setNo(prompt.inputInt("번호? "));
    delivery.setDeliveryMethod(prompt.inputString("배송방법?"));
    delivery.setAverageDeliveryDate(prompt.inputString("평균배송일"));

    this.deliveryList.add(delivery);

    System.out.println("저장하였습니다.");
  }

  public void detailDelivery() {
    int index = indexOfDelivery(prompt.inputInt("상품번호"));

    if(index == -1) {
      System.out.println("상품이 품절되었습니다.");
      return;
    }

    Delivery delivery = this.deliveryList.get(index);

    System.out.printf("번호: %d\n", delivery.getNo());
    System.out.printf("배송방법: %s\n", delivery.getDeliveryMethod());
    System.out.printf("평균배송일: %s\n", delivery.getAverageDeliveryDate());
  }

  public void deleteDelivery() {

    int index = indexOfDelivery(prompt.inputInt("배송정보? "));

    if (index == -1) {
      System.out.println("배송정보가 유효하지 않습니다.");
      return;
    }

    this.deliveryList.remove(index);

    System.out.println("배송을 삭제했습니다.");
  }

  public void updateDelivery() {

    int index = indexOfDelivery(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("회원 인덱스가 유효하지 않습니다.");
      return;
    }

    Delivery oldDelivery = this.deliveryList.get(index);
    Delivery newDelivery = new Delivery();

    newDelivery.setDeliveryMethod(prompt.inputString(
        String.format("배송방법(%s)? ", oldDelivery.getDeliveryMethod()),
        oldDelivery.getDeliveryMethod()));

    newDelivery.setAverageDeliveryDate(prompt.inputString(
        String.format("평균배송일(%s)? ", oldDelivery.getAverageDeliveryDate()),
        oldDelivery.getAverageDeliveryDate()));


    if (oldDelivery.equals(newDelivery)) {
      System.out.println("회원을 변경했습니다.");
      return;
    }
    this.deliveryList.set(index, newDelivery);
    System.out.println("회원 변경을 취소하였습니다.");
  }


  private int indexOfDelivery(int no) {
    for (int i = 0; i < this.deliveryList.size(); i++) {
      if (this.deliveryList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
