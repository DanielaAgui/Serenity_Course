package todomvc.pageobjects;

import org.openqa.selenium.By;

class TodoMvcVariables {
    static final By ITEM_FIELD = By.cssSelector(".new-todo");
    static final By NEW_FIELD = By.cssSelector(".todo-list li");
    static final By ITEM_COUNT = By.xpath("//span[@class='todo-count']/strong");

    public static By FIELD_BUTTON(String text) {
        return By.linkText(text);
    }
}