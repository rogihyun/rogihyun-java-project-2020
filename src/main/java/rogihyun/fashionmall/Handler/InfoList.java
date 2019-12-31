package rogihyun.fashionmall.Handler;

import java.util.Arrays;
import rogihyun.fashionmall.domain.Info;

public class InfoList {
  
  static final int DEFAULT_CAPACITY = 4;
  
  private Info[] list;
  private int size = 0;
  
  public InfoList() {
    this.list = new Info[DEFAULT_CAPACITY];
  }
  
  public InfoList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Info[DEFAULT_CAPACITY];
    else 
      this.list = new Info[capacity];
  }
  
  public Info[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  public void add(Info info) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을  %d개 생성하였음!\n", newCapacity);
    }
    this.list[this.size++] = info;
  }
  
  public Info get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
}
