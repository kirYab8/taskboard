package dev.taskboard.domain;

public record CommentDraft (
        String body
) {
  public CommentDraft {
    if (body == null || body.isBlank()) {
      throw new IllegalArgumentException("Введен пустой комментарий");
    }
    body = body.strip();
    if (body.length() > 500) {
      throw new IllegalArgumentException("Длина комментария не должна превышать 500 символов");
    }
  }
}
