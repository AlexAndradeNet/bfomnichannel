#/bin/sh

caffeinate -d
./gradlew clean test --rerun-tasks
killall caffeinate
killall chromedriver
echo -n "\a"

exit 0
