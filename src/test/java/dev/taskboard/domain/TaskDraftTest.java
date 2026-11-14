package dev.taskboard.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskDraftTest {
  @Test
  void blankTitleIsRejected() {
    assertThrows(IllegalArgumentException.class, () -> new TaskDraft(" " , new TaskStatus.Todo()));
  }
  @Test
  void titleIsStripped() {
      assertEquals("title", new TaskDraft("      title ", new TaskStatus.Todo()).title());
    }

}


