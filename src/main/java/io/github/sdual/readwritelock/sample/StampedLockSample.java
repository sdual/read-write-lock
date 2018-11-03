package io.github.sdual.readwritelock.sample;

import java.util.concurrent.locks.StampedLock;

public class StampedLockSample {

  private final StampedLock lock = new StampedLock();

  private int a;
  private int b;

  public void setValue(int a, int b) {
    long stamp = lock.writeLock();

    this.a = a;
    this.b = b;

    lock.unlockWrite(stamp);
  }

  public int calculate() {
    long stamp = lock.tryOptimisticRead();

    int currentA = this.a;
    int currentB = this.b;

    if (!lock.validate(stamp)) {
      stamp = lock.readLock();

      currentA = this.a;
      currentB = this.b;

      lock.unlockRead(stamp);
    }
    return currentA + currentB;
  }

}
