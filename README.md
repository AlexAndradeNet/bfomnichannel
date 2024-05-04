# com-blanckfactor-blog

![Company logo](docs/assets/company-logo.png)

AlexAndrade.Net Repository

## Description

(SerenityBDD + Cucumber + Selenium + Java + Gradle) / ScreenPlay Pattern.

Multithreading, parallel execution, and more.

## Execution

Regular execution:

```bash
./gradlew clean test
```

Execution without caching

```bash
./gradlew clean test --rerun-tasks
```

### Static Analysis

To run the static analysis tools, you can run the following command:

```bash
./gradlew test sonar 
```

To check the results, you can open the following URL in your browser:

```bash
open target/site/serenity/index.html
```

### Features checking

To mantain the features written in Gherkin up to date, you can run the following command:

```bash
sh scripts/gherkin-lint.sh
```

## Contributing

If you find this repo useful here's how you can help:

1. Send a Pull Request with your awesome new features and bug fixes
2. Wait for a Coronita :beer: you deserve it.
