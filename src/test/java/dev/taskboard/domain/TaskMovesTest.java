package dev.taskboard.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMovesTest {

  @Test
  void fromTodoToInProgressIsTrue() {
    assertTrue(TaskMoves.canMove(new TaskStatus.Todo(), new TaskStatus.InProgress()));
  }

  @Test
  void fromInProgressToDoneIsTrue() {
    assertTrue(TaskMoves.canMove(new TaskStatus.InProgress(), new TaskStatus.Done()));
  }

  @Test
  void fromInProgressToTodoIsTrue() {
    assertTrue(TaskMoves.canMove(new TaskStatus.InProgress(), new TaskStatus.Todo()));
  }

  @Test
  void fromDoneToTodoIsFalse() {
    assertFalse(TaskMoves.canMove(new TaskStatus.Done(), new TaskStatus.Todo()));
  }

  @Test
  void FromDoneToDoneIsFalse() {
    assertFalse(TaskMoves.canMove(new TaskStatus.Done(), new TaskStatus.Done()));
  }
}
