# webapi.activequerybuilder

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>webapi.activequerybuilder</groupId>
    <artifactId>webapi.activequerybuilder</artifactId>
    <version>1.1.2</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "webapi.activequerybuilder:webapi.activequerybuilder:1.1.2"
```

### Others

Manually install the following JARs:

* webapi.activequerybuilder-1.1.2.jar
* lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import webapi.activequerybuilder.*;
import webapi.activequerybuilder.auth.*;
import webapi.activequerybuilder.model.*;
import webapi.activequerybuilder.api.ActiveQueryBuilderApi;

import java.io.File;
import java.util.*;

public class ActiveQueryBuilderApiExample {

    public static void main(String[] args) {
        
        ActiveQueryBuilderApi apiInstance = new ActiveQueryBuilderApi();
        SqlQuery query = new SqlQuery(); // SqlQuery | Information about SQL query and it's context.
        try {
            List<QueryColumn> result = apiInstance.getQueryColumnsPost(query);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActiveQueryBuilderApi#getQueryColumnsPost");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://webapi.activequerybuilder.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ActiveQueryBuilderApi* | [**getQueryColumnsPost**](docs/ActiveQueryBuilderApi.md#getQueryColumnsPost) | **POST** /getQueryColumns | 
*ActiveQueryBuilderApi* | [**transformSQLPost**](docs/ActiveQueryBuilderApi.md#transformSQLPost) | **POST** /transformSQL | 


## Documentation for Models

 - [Condition](docs/Condition.md)
 - [ConditionGroup](docs/ConditionGroup.md)
 - [HiddenColumn](docs/HiddenColumn.md)
 - [Pagination](docs/Pagination.md)
 - [QueryColumn](docs/QueryColumn.md)
 - [Sorting](docs/Sorting.md)
 - [SqlQuery](docs/SqlQuery.md)
 - [Totals](docs/Totals.md)
 - [Transform](docs/Transform.md)
 - [TransformResult](docs/TransformResult.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

support@activedbsoft.com

