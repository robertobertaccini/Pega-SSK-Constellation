# PegaSample-Cucumber Webdriver Tests

Purpose of this document is to describe the various ways to run `pega-sample tests` locally using `gradle`. As our platform is built by gradle various tasks have been created to use it and to run cucumber-webdriver in a seamless fashion.

### Runs all tests in the local machine using cucumber task:

```bash
[prpc-platform]\[test]\cucumber-webdriver\pega-sample-tests> $ gradle cucumber
```

### Runs tests with `specific tags` in the local machine using cucumber task:

```bash
[prpc-platform]\[test]\cucumber-webdriver\pega-sample-tests> $ gradle cucumber -Dcucumber.options="--tags @tagname"
```

### Runs tests in the local machine with all parameters using cucumber task:

```bash
[prpc-platform]\[test]\cucumber-webdriver\pega-sample-tests> $ gradle cucumber -Pprpcurl=http://veishydcnt00280:8080/prweb/ -Pbrowser=firefox -Pdebugmode=true -Pfullscreen=true -Pvideorecord=false 
```

### Parameters: Following are the parameters that can be passed to cucumberTest gradle task:
| Parameter | Description | Example |
| :---: | :---: | :---: |
| browser | browser to run tests against | -Pbrowser=chrome |
| prpcurl | PRPC instance to run tests against | -Pprpcurl=http://veishydcnt00280:8080/prweb/ |
| debugmmode | enable debug mode when running tests | -Pdebugmode=true |
| fullscreen | enable full-screen mode | -Pfullscreen=true |
| videorecord | enable video record (capture video of tests execution) | -Pvideorecord=false |

## Note: Test uses parameters from ./data/global-settings.properties file if user does not provide parameters in the command line.
