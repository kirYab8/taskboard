package dev.taskboard.app;

public final class PinningDemo {

  private static final Object LOCK = new Object();

  public static void main(String[] args) {
    try (var pool = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i < 20; i++) {
        pool.submit(() -> {
          synchronized (LOCK) {
            try {
              Thread.sleep(300);
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
        });
      }
    }
  }
}
