package dev.taskboard.app;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class IoCompare {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("virtualMs=" + run(Executors.newVirtualThreadPerTaskExecutor()));
    System.out.println("platformMs=" + run(Executors.newFixedThreadPool(4)));
  }

  private static long run(ExecutorService pool) throws InterruptedException {
    Instant started = Instant.now();
    for (int i = 0; i < 20; i++) {
      pool.submit(() -> {
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      });
    }
    pool.shutdown();
    pool.awaitTermination(1, TimeUnit.MINUTES);
    return Duration.between(started, Instant.now()).toMillis();
  }
}
