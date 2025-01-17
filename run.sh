export USERNAME="AUTUser@flightmgmt.com"
export PASSWORD="<<yourpassword>>"
export TARGET_URL="<<yourserver>>/prweb/app/FlightManagementSolTest/"
export SELENIUM_GRID_URL="http://localhost:5555/wd/hub"

mvn test -q -Dbrowser="chrome" -DTargetURL=$TARGET_URL -DSeleniumGridURL=$SELENIUM_GRID_URL  -Dusername=%USERNAME% -Dpassword=%PASSWORD%
