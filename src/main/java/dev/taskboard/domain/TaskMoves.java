package dev.taskboard.domain;

public final class TaskMoves {

  private TaskMoves() {}

  public static boolean canMove(TaskStatus from, TaskStatus to) {
    return switch (from) {
      case TaskStatus.Todo() -> to instanceof TaskStatus.InProgress;
      case TaskStatus.InProgress() -> to instanceof TaskStatus.Done ||
              to instanceof TaskStatus.Todo;
      case TaskStatus.Done() -> false;
    };
  }
}
