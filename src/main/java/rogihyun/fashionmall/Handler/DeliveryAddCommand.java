package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.util.Prompt;

public class DeliveryAddCommand implements Command {

  List<Delivery> deliveryList;

  Prompt prompt;

  public DeliveryAddCommand(Prompt prompt, List<Delivery> list) {
    this.prompt = prompt;
    this.deliveryList = list;
  }

  @Override
  public void execute() {
    Delivery delivery = new Delivery();

    delivery.setNo(prompt.inputInt("번호? "));
    delivery.setDeliveryMethod(prompt.inputString("배송방법?"));
    delivery.setAverageDeliveryDate(prompt.inputString("평균배송일"));

    this.deliveryList.add(delivery);

    System.out.println("저장하였습니다.");
  }
}
