package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Delivery;
import rogihyun.util.Prompt;

public class DeliveryDeleteCommand implements Command {

  List<Delivery> deliveryList;

  Prompt prompt;

  public DeliveryDeleteCommand(Prompt prompt, List<Delivery> list) {
    this.prompt = prompt;
    this.deliveryList = list;
  }

  @Override
  public void execute() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    this.deliveryList.remove(index);

    System.out.println("회원을 삭제했습니다.");
  }

  private int indexOfMember(int no) {
    for (int i = 0; i < this.deliveryList.size(); i++) {
      if (this.deliveryList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
