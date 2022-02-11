package cucumber;

import managers.PageObjectManager;
import managers.WDriverManager;

public class TestContext {
    private WDriverManager wDriverManager;
    private PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;

    public TestContext(){
        wDriverManager = new WDriverManager();
        pageObjectManager = new PageObjectManager(wDriverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

    public WDriverManager getWDriverManager() {
        return wDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

}