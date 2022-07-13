package net.bsmch.elements;

import com.codeborne.selenide.ElementsContainer;

public class SelenideCheckbox extends ElementsContainer {
    public boolean isSelected() {
        return getSelf().isSelected();
    }

    public void toggle() {
        getSelf().click();
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
