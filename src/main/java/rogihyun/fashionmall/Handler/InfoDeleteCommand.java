package rogihyun.fashionmall.Handler;

import java.util.List;
import rogihyun.fashionmall.domain.Info;
import rogihyun.util.Prompt;

public class InfoDeleteCommand implements Command {

  List<Info> infoList;

  Prompt prompt;

  public InfoDeleteCommand(Prompt prompt, List<Info> list) {
    this.prompt = prompt;
    this.infoList = list;
  }

  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    this.infoList.remove(index);

    System.out.println("수업을 삭제했습니다.");
  }

  private int indexOfLesson(int no) {
    for (int i = 0; i < this.infoList.size(); i++) {
      if (this.infoList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}


