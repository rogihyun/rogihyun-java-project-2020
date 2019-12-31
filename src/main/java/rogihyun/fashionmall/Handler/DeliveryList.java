package rogihyun.fashionmall.Handler;

import java.util.Arrays;
import rogihyun.fashionmall.domain.Delivery;

public class DeliveryList {

  static final int DELIVERY_SIZE = 100;

  Delivery[] list;
  int size = 0;

  public DeliveryList() {
    this.list = new Delivery[DELIVERY_SIZE];
  }

  public DeliveryList(int capacity) {
    if (capacity < DELIVERY_SIZE || capacity > 10000)
      this.list = new Delivery[DELIVERY_SIZE];
    else 
      this.list = new Delivery[capacity];
  }

  public Delivery[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Delivery delivery) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d개 생성하였음!", newCapacity);
    }
    this.list[this.size++] = delivery;
  }
  
  public Delivery get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
}
