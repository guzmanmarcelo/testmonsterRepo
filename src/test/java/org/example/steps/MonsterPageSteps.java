package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.MonsterPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class MonsterPageSteps {

    private final MonsterPage monsterPage;
    private String monsterName;

    public MonsterPageSteps() {
        monsterPage = MonsterPage.getMonsterPage();
    }

    @Given("I open the Create your monster page")
    public void openCreateMonsterPage() {
        open("http://localhost:3000/");
    }

    @Given("The Create your monster page is opened")
    public void theCreateYourMonsterPageIsOpened() {
        String expectedURL = "http://localhost:3000/";
        monsterPage.isMonsterPageOpened(expectedURL);
    }

    @When("I click the Create Monster button")
    public void iClickTheCreateMonsterButton() {
        monsterPage.clickCreateMonsterButton();
    }

    @Then("I verify that the {string} is displayed")
    public void iVerifyThatTheAllFieldsAreRequiredMessageIsDisplayed(String errorMessage) {
        monsterPage.verifyErrorMessageDisplayed(errorMessage);
    }

    @When("I select a monster with the following values")
    public void iSelectAMonsterWithTheFollowingValues(Map<String, String> monsterValues) {
        monsterName = monsterPage.selectMonster(monsterValues.get("Number"),
                monsterValues.get("Name"),
                monsterValues.get("HP"),
                monsterValues.get("Attack"),
                monsterValues.get("Defense"),
                monsterValues.get("Speed"));
    }

    @Then("I verify the monster is created")
    public void iVerifyTheMonsterIsCreated() {
        monsterPage.isMonsterCreated(monsterName);
    }
}
