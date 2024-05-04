#!/bin/bash
echo "Running Gherkin Lint"
npx gherkin-lint -c .gherkin-lintrc
echo "Gherkin Lint completed"
exit $?
