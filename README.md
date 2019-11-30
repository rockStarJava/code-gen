# code-gen


## Overview
- This Application takes json as input and generates API tester class

## Tech/framework used
* Java 1.8
* velocity template engine
* google java formatter

## Components
* **Specification .java** : this pojo for the json provided 
* **testclass generator** : reads the json provided and generates test class
* **info.json** : sample input json
* **SampleTest.vm** : velocity template.

## Pre-requisities


## How To:
```
**To start the application**

```java
mvn clean install

```
or run this class from IDE

```java
TestClassGenerator.java

```

## Testing
 Create your Json for the testing and provide as input to TestClassGenerator
 
 
## Json Explained
For every new URL you want to test
- **name** - provide name of the testclass you want to generate
- **packagename** Packagename in which this generated test class will be placed
- **url**  : main url ( do not add path params etc)
    * **method** : this can be repeated multiple time
        + **name**	 : this name will be used as test method name
        + **operation** : GET or POST
        + **status** : expected status  200 or 201 or whatever
        + **url**	   : optional , add pathparms in the url here
        + **pathParm** : boolean true or false indicating if there are path params
        + **pathparams** : repeat this for each path param
             + **paramName** : name should be same as the param name in url	
             + **type**      : indicate String/number/boolean etc
             + **value**     : value to be substituted 
        + **validate**   : repeat this for every validation that needs to be done on the result
             + **Field**	:field name in the response	
             + **type**	    :indicate String/number/boolean etc
             + **value	**  : expected value 
        + **body**    : optional add post request body here
  