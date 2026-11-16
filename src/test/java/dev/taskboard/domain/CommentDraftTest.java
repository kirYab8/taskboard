package dev.taskboard.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CommentDraftTest {

  @Test
  void EnterEmptyComment() {
    assertThrows(IllegalArgumentException.class, () -> new CommentDraft(" "));
  }

  @Test
  void EnteredCommentIsLonger500Characters() {
    assertThrows(IllegalArgumentException.class, () -> new CommentDraft("x".repeat(501)));
  }

  @Test
  void EnteredCommentSame500Characters() {
    assertDoesNotThrow(() -> new CommentDraft("X".repeat(500)));
  }

  @Test
  void bodyIsStripped() {
    assertEquals("body", new CommentDraft("   body ").body());
  }
}
