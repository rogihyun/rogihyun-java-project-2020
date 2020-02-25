package rogihyun.fashionmall.Handler;

import java.util.Iterator;
import java.util.List;
import rogihyun.fashionmall.domain.Delivery;

public class DeliveryListCommand implements Command {

  List<Delivery> deliveryList;

  public DeliveryListCommand(List<Delivery> list) {
    this.deliveryList = list;
  }

  @Override
  public void execute() {
    Iterator<Delivery> iterator = deliveryList.iterator();
    while (iterator.hasNext()) {
      Delivery d = iterator.next();
      System.out.printf("%s, %s \n",
          d.getDeliveryMethod(), d.getAverageDeliveryDate());
    }
  }
}
