package rogihyun.fashionmall.Handler;

import java.util.Iterator;
import java.util.List;
import rogihyun.fashionmall.domain.Price;

// "/board/list" 명령어 처리
public class PriceListCommand implements Command {

  List<Price> priceList;

  public PriceListCommand(List<Price> list) {
    this.priceList = list;
  }

  @Override
  public void execute() {
    Iterator<Price> iterator = priceList.iterator();
    while (iterator.hasNext()) {
      Price p = iterator.next();
      System.out.printf("%s, %s, %s\n",
          p.getPricetag(), p.getReduced(), p.getMembership());
    }
  }


}


