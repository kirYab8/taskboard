package dev.taskboard.domain;

public sealed interface TaskStatus permits TaskStatus.Todo, TaskStatus.InProgress, TaskStatus.Done {

  record Todo() implements TaskStatus {}
  record InProgress() implements TaskStatus {}
  record Done() implements TaskStatus {}

  static TaskStatus parse(String raw) {
    return switch (raw) {
      case "TODO" -> new Todo();
      case "IN_PROGRESS" -> new InProgress();
      case "DONE" -> new Done();
      default -> throw new IllegalStateException("Unknown status: " + raw);
    };
  }
}
