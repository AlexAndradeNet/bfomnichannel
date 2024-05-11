#/bin/sh

caffeinate -t 0 &
./gradlew clean test --rerun-tasks  
killall caffeinate
killall chromedriver
echo -n "\a"

exit 0
