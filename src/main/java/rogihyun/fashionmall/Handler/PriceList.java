package rogihyun.fashionmall.Handler;

import java.util.Arrays;
import java.util.Scanner;
import rogihyun.fashionmall.domain.Price;

public class PriceList {
  
  static final int PRICE_SIZE = 100;
  
  Price[] list;
  int size = 0;
  
  public PriceList() {
    this.list = new Price[PRICE_SIZE];
  }
  
  public PriceList(int capacity) { 
  if (capacity < PRICE_SIZE || capacity > 10000)
    this.list = new Price[PRICE_SIZE];
  else 
    this.list = new Price[capacity];
}
  
  public Price[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  public void add(Price price) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = price;
  }
  
  public Price get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
}
