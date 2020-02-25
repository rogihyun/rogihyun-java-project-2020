package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.util.Prompt;

public class DeliveryUpdateCommand implements Command {

  List<Delivery> deliveryList;

  Prompt prompt;

  public DeliveryUpdateCommand(Prompt prompt, List<Delivery> list) {
    this.prompt = prompt;
    this.deliveryList = list;
  }

  @Override
  public void execute() {
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
