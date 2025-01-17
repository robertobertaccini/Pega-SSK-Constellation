set USERNAME="AUTUser@flightmgmt.com"
set PASSWORD="PASSWORD"
set TARGET_URL="SERVER/prweb/app/FlightManagementSolTest/"
set SELENIUM_GRID_URL="http://localhost:5555/wd/hub"

mvn test -q -Dbrowser="chrome" -DTargetURL=%TARGET_URL% -Dusername=%USERNAME% -Dpassword=%PASSWORD% -DSeleniumGridURL=http://localhost:5555/wd/hub