package net.bsmch.locators;

import org.openqa.selenium.By;

public class NewLocators {
    public static class ByDataTestId extends By.ByXPath {
        private final String dataTestId;

        public ByDataTestId(String dataTestId) {
            super("//*[@data-test-id='%s']".formatted(dataTestId));
            this.dataTestId = dataTestId;
        }

        @Override
        public String toString() {
            return "By.dataTestId: " + this.dataTestId;
        }
    }

    public static By dataTestId(String dataTestId) {
        return new ByDataTestId(dataTestId);
    }
}
