# Goldcar

Example project with Cucumber, Selenide, JUnit4, Maven and Allure.

## Execution

``` Shell
mvn clean test
```

The browser can be specified in selenide.properties or by running the command:

``` Shell
mvn clean test "-Dselenide.browser=firefox"
```

## Report

There are multiple reports configured.

### Cucumber report

Can be found at `target/cucumber-report.html`

It can also be published online by modifying the cucumber property *cucumber.publish.enabled* to true.

### Allure report

Allure files are created at `target/allure-results`

The project is configured with a Maven plugin that downloads and starts the Allure local server to visualize the report.
Simply run the following command after an execution:

``` Shell
mvn allure:serve
```

The following command generates an HTML file at `target/site/allure-maven/index.html`

``` Shell
mvn allure:report
```

### Selenide report

If something fails, selenide takes a screenshot in png and html formats.

It can be found at `target/selenide/reports`
