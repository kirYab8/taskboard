package dev.taskboard.domain;

public record TaskDraft(
        String title,
        TaskStatus status
) {
  public TaskDraft {
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("title must not be blank");
    }
    title = title.strip();
    if (status == null) {
      throw new IllegalArgumentException("status is required");
    }
  }
}
