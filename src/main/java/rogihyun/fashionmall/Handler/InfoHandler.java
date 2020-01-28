package rogihyun.fashionmall.Handler;

import rogihyun.fashionmall.domain.Info;
import rogihyun.util.List;
import rogihyun.util.Prompt;

public class InfoHandler {

  List<Info> infoList;

  Prompt prompt;

  public InfoHandler(Prompt prompt, List<Info> list) {
    this.prompt = prompt;
    this.infoList = list;
  }

  public void listInfo() {

    Info[] arr = this.infoList.toArray(new Info[this.infoList.size()]);

    for(Info i : arr) {
      System.out.printf("%s, %s, %s, %s, %s\n",
          i.getGender(), i.getQscore(),
          i.getSell(), i.getLike(), i.getReview());
    }
  }

  public void addInfo() {
    Info info = new Info();

    info.setNo(prompt.inputInt("상품번호? "));
    info.setGender(prompt.inputString("성별? "));
    info.setQscore(prompt.inputString("인기도? "));
    info.setSell(prompt.inputString("판매도? "));
    info.setLike(prompt.inputString("좋아요? "));
    info.setReview(prompt.inputString("리뷰? "));

    infoList.add(info);

    System.out.println("저장하였습니다.");
  }


  public void detailInfo() {
    int index = indexOfInfo(prompt.inputInt("번호는? "));

    if (index == -1) {
      System.out.println("가격이 유효하지 않습니다.");
      return;
    }

    Info info = this.infoList.get(index);

    System.out.printf("상품번호: %s\n", info.getNo());
    System.out.printf("성별: %s\n", info.getGender());
    System.out.printf("인기도: %s\n", info.getQscore());
    System.out.printf("판매도: %s\n", info.getSell());
    System.out.printf("좋아요: %s\n", info.getLike());
    System.out.printf("리뷰: %s\n", info.getReview());
  }

  public void updateInfo() {
    int index = indexOfInfo(prompt.inputInt("상품 인덱스? "));

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    Info oldInfo = this.infoList.get(index);
    Info newInfo = new Info();

    newInfo.setNo(oldInfo.getNo());

    newInfo.setNo(prompt.inputInt(
        String.format("번호(%s)? ", oldInfo.getNo()),
        oldInfo.getNo()));

    newInfo.setGender(prompt.inputString(
        String.format("성별(%s)?", oldInfo.getGender()),
        oldInfo.getGender()));

    newInfo.setQscore(prompt.inputString(
        String.format("인기도(%s)?", oldInfo.getQscore()),
        oldInfo.getQscore()));

    newInfo.setSell(prompt.inputString(
        String.format("판매도(%s)?", oldInfo.getSell()),
        oldInfo.getSell()));

    newInfo.setLike(prompt.inputString(
        String.format("좋아요(%s)?", oldInfo.getLike()),
        oldInfo.getLike()));

    newInfo.setReview(prompt.inputString(
        String.format("좋아요(%s)?", oldInfo.getReview()),
        oldInfo.getReview()));

    if (oldInfo.equals(newInfo)) {
      System.out.println("상품변경을 취소하였습니다.");
      return;
    }
    this.infoList.set(index, newInfo);
    System.out.println("수업을 변경했습니다.");
  }

  public void deleteInfo() {
    int index = indexOfInfo(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시글 인덱스가 유효하지 않습니다.");
      return;
    }

    this.infoList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  private int indexOfInfo(int no) {
    for (int i = 0; i < this.infoList.size(); i++) {
      if (this.infoList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
