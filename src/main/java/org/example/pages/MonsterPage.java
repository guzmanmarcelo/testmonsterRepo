package org.example.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MonsterPage {

    public static MonsterPage getMonsterPage() {
        return new MonsterPage();
    }

    private final SelenideElement monsterNameTextBox = $("div[data-testid='monster-name'] div input");
    private final SelenideElement monsterHPTextBox = $("div[data-testid='hp-value'] div input");
    private final SelenideElement monsterAttackTextBox = $("div[data-testid='attack-value'] div input");
    private final SelenideElement monsterDefenseTextBox = $("div[data-testid='defense-value'] div input");
    private final SelenideElement monsterSpeedTextBox = $("div[data-testid='speed-value'] div input");
    private final SelenideElement createMonsterButton = $("button[data-testid='btn-create-monster']");
    private final SelenideElement errorMessageLabel = $("div[data-testid='alert-required-fields']");
    private final ElementsCollection monsterNamesLabel = $$("p[data-testid='card-monster-name']");

    private SelenideElement getMonsterSelector(String monsterNumber) {
        return $("div[data-testid='monster-" + monsterNumber + "']");
    }

    /**
     * Selects the monster values
     *
     * @param monsterNumber the monster number
     * @param monsterName the monster name
     * @param monsterHP the monster HP
     * @param monsterAttack the monster attack
     * @param monsterDefense the monster defense
     * @param monsterSpeed the monster speed
     */
    public String selectMonster(String monsterNumber, String monsterName, String monsterHP, String monsterAttack, String monsterDefense, String monsterSpeed) {
        getMonsterSelector(monsterNumber).shouldBe(Condition.visible.because("The monster number text box is not visible")).click();
        monsterNameTextBox.should(Condition.visible.because("The monster name text box is not visible")).val(monsterName);
        monsterHPTextBox.should(Condition.visible.because("The monster HP text box is not visible")).val(monsterHP);
        monsterAttackTextBox.should(Condition.visible.because("The monster attack text box is not visible")).val(monsterAttack);
        monsterDefenseTextBox.should(Condition.visible.because("The monster defense text box is not visible")).val(monsterDefense);
        monsterSpeedTextBox.should(Condition.visible.because("The monster speed text box is not visible")).val(monsterSpeed);
        return monsterName;
    }

    /**
     * Clicks the Create Monster button
     */
    public void clickCreateMonsterButton() {
        createMonsterButton.shouldBe(Condition.enabled.because("The create monster button is not enabled")).click();
    }

    /**
     * Verifies if the current page is equal to the expected
     *
     * @param url expectedURL
     */
    public void isMonsterPageOpened(String url) {
        String currentURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertThat(url, equalTo(currentURL));
    }

    /**
     * Verifies if an error message is displayed
     *
     * @param errorMessage the error message to check
     */
    public void verifyErrorMessageDisplayed(String errorMessage) {
        errorMessageLabel.shouldBe(Condition.visible.because("The error message is not displayed")).shouldHave(Condition.exactText(errorMessage));
    }

    public void isMonsterCreated(String monsterName) {
        monsterNamesLabel.shouldHave(CollectionCondition.sizeGreaterThan(0).because("The size of the monster list is less than 0")).
                shouldHave(CollectionCondition.itemWithText(monsterName).because("The " + monsterName + " is not created"));
    }
}
