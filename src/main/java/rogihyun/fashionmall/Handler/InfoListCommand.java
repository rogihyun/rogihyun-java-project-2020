package rogihyun.fashionmall.Handler;

import java.util.Iterator;
import java.util.List;
import rogihyun.fashionmall.domain.Info;

public class InfoListCommand implements Command {

  List<Info> infoList;

  public InfoListCommand(List<Info> list) {
    this.infoList = list;
  }

  @Override
  public void execute() {
    Iterator<Info> iterator = infoList.iterator();
    while (iterator.hasNext()) {
      Info l = iterator.next();
      System.out.printf("%d, %s, %s ~ %s, %d\n", l.getNo(), l.getGender(), l.getQscore(),
          l.getSell(), l.getLike(), l.getReview());
    }
  }
}


