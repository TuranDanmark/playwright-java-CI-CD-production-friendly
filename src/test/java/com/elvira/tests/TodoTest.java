package com.elvira.tests;

import com.elvira.base.BaseTest;
import com.elvira.pages.TodoPage;
import com.elvira.utils.TestListener;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import io.qameta.allure.*;

@ExtendWith(TestListener.class)
@Epic("Todo App")
@Feature("Todo Management")
public class TodoTest extends BaseTest {

@Tag("smoke")
@Test
@Story("User can add todo")
@Description("Verify that user can add a new todo item")
@Severity(SeverityLevel.CRITICAL)
void userCanAddTodoItem() {
TodoPage todoPage = new TodoPage(page);
todoPage.navigate();
todoPage.addTodo("Learn Playwright");
assertThat(todoPage.getTodoItems()).hasCount(1);
}

@Tag("smoke")
@Test
@Story("User can add todo")
@Description("Verify that user can add a new todo item")
@Severity(SeverityLevel.CRITICAL)
void userCanAddTodo() {
    page.navigate("https://demo.playwright.dev/todomvc");

    TodoPage todoPage = new TodoPage(page);
    todoPage.addTodo("Buy milk");

    assertThat(page.locator("text=Buy milk")).isVisible();
}

@Tag("smoke")
@Test
@Story("User can add todo")
@Description("Verify that user can add a new todo item")
@Severity(SeverityLevel.CRITICAL)
void userCanCompleteTodo() {
    TodoPage todoPage = new TodoPage(page);
    todoPage.navigate();

    todoPage.addTodo("Task 1");
    todoPage.toggleTodo(0);

    assertThat(todoPage.getTodoItems().first()).hasClass("completed");

}

@Tag("smoke")
@Test
@Story("User can add todo")
@Description("Verify that user can add a new todo item")
@Severity(SeverityLevel.CRITICAL)
void userCanFilterCompletedTasks() {

    TodoPage todoPage = new TodoPage(page);

    todoPage.navigate();

    todoPage.addTodo("Active Task");
    todoPage.addTodo("Completed Task");

    todoPage.toggleTodo(1); // отмечаем вторую как выполненную

    todoPage.clickCompletedFilter();


    assertThat(todoPage.getVisibleTodos()).hasCount(1);
    assertThat(todoPage.getVisibleTodos().first()).hasText("Completed Task");
}

}

