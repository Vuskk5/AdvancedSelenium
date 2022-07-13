package net.bsmch.elements;

import org.openqa.selenium.WebElement;

public class Checkbox {
    private final WebElement element;

    public Checkbox(WebElement element) {
        this.element = element;
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public void toggle() {
        this.element.click();
    }

    public void check() {
        if (!isSelected()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isSelected()) {
            toggle();
        }
    }
}
