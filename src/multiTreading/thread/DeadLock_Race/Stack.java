package multiTreading.thread.DeadLock_Race;

import java.util.Arrays;

public class Stack {

  private int arr[];
  private int head = -1;
  final int size;

  /**
   * constructor
   * 
   * @param size
   */
  public Stack(int size) {
    this.size = size;
    this.arr = new int[size];

    for (int i = 0; i < size; i++)
      arr[i] = -1;
    
      System.out.println("Stack Created as " + this.toString());
  }

  /**
   * check if stack is emtpy
   * 
   * @return boolean
   */
  public boolean isEmpty() {
    return head < 0;
  }

  public boolean isFull() {
    return head >= size - 1;
  }

  public int pop() {

    int res = Integer.MIN_VALUE;
    if (!isEmpty()) {
      try {
        Thread.currentThread().sleep(1000);
      } catch (InterruptedException e) {
      }
      res = arr[head];
      arr[head--] = 0;
      System.out.println(Thread.currentThread().getName() + " <- popped(" + res + ") " + this.toString());
    } else {
      System.err.println(Thread.currentThread().getName() + " cant pop head=" + head + "\n");
    }
    return res;
  }

  public boolean push(int x) {
   
      if (!isFull()) {
        try {
          Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
        }

        arr[++head] = x;
        System.out.println(Thread.currentThread().getName() + " -> added (" + x + ") " + this.toString());
        return true;
      } else {
        System.err.println(Thread.currentThread().getName() + " cant add head=" + head + "\n");
        return false;
      }
  }

  @Override
  public String toString() {
    return Arrays.toString(arr) + "\n";
  }
}
