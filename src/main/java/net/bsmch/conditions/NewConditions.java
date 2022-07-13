package net.bsmch.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewConditions {
    public static ExpectedCondition<Long> textNumberToBeMoreThan(By locator, long targetNumber) {
        return new ExpectedCondition<>() {
            private long currentNumber = 0;

            public Long apply(WebDriver driver) {
                var element = driver.findElement(locator);
                this.currentNumber = Long.parseLong(element.getText().replace(",", ""));

                if (this.currentNumber >= targetNumber) {
                    return this.currentNumber;
                }
                return null;
            }

            public String toString() {
                return "element to have number value more than " + targetNumber + ". Current value: " + currentNumber;
            }
        };
    }
}
