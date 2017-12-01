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
        String metadataGuid = "b3207f4f-b1f4-4dc2-979b-7724ed2d0221";
        String sql = "Select customer_id, first_name From customer";

        ActiveQueryBuilderApi apiInstance = new ActiveQueryBuilderApi();
        SqlQuery query = new SqlQuery(); // SqlQuery | Information about SQL query and it's context.
        query.setGuid(metadataGuid);
        query.setText(sql);

        List<QueryColumn> columns = apiInstance.getQueryColumnsPost(query);
        System.out.println(columns);
        
        Transform transform = new Transform();
        transform.setGuid(metadataGuid);
        transform.setSql(sql);

        ConditionGroup filter = new ConditionGroup();

        Condition condition = new Condition();
        condition.setField("customer_id");
        condition.setConditionOperator(Condition.ConditionOperatorEnum.GREATER);
        condition.setValues(Arrays.asList("10"));

        filter.setConditions(Arrays.asList(condition));

        Pagination page = new Pagination();
        page.setSkip(2);
        page.setTake(3);

        Sorting order = new Sorting();
        order.setField("customer_id");
        order.setOrder(Sorting.OrderEnum.ASC);

        transform.setFilter(filter);
        transform.setPagination(page);
        transform.setSortings(Arrays.asList(order));

        TransformResult result = api.transformSQLPost(transform);
        System.out.println(result);
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

