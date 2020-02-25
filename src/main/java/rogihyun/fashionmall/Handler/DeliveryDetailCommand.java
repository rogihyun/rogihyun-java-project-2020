package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.util.Prompt;

public class DeliveryDetailCommand implements Command {

  List<Delivery> deliveryList;

  Prompt prompt;

  public DeliveryDetailCommand(Prompt prompt, List<Delivery> list) {
    this.prompt = prompt;
    this.deliveryList = list;
  }

  @Override
  public void execute() {
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

  private int indexOfDelivery(int no) {
    for (int i = 0; i < this.deliveryList.size(); i++) {
      if (this.deliveryList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
