package io.github.sdual.readwritelock.sample;

import java.util.concurrent.locks.StampedLock;

public class Point {

  private double x;
  private double y;
  private final StampedLock sl = new StampedLock();

  void distanceFromOrigin() {
    long stamp = sl.tryOptimisticRead();

    double currentX = x;
    double currentY = y;

    if (!sl.validate(stamp)) {
      stamp = sl.readLock();
      try {
        currentX = x;
        currentY = y;
      } finally {
        sl.unlockRead(stamp);
      }
    }
  }

}
