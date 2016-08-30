# ActiveQueryBuilderApi

All URIs are relative to *https://webapi.activequerybuilder.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getQueryColumnsPost**](ActiveQueryBuilderApi.md#getQueryColumnsPost) | **POST** /getQueryColumns | 
[**transformSQLPost**](ActiveQueryBuilderApi.md#transformSQLPost) | **POST** /transformSQL | 


<a name="getQueryColumnsPost"></a>
# **getQueryColumnsPost**
> List&lt;QueryColumn&gt; getQueryColumnsPost(query)



Returns list of columns for the given SQL query.

### Example
```java
// Import classes:
//import webapi.activequerybuilder.ApiException;
//import webapi.activequerybuilder.api.ActiveQueryBuilderApi;


ActiveQueryBuilderApi apiInstance = new ActiveQueryBuilderApi();
SqlQuery query = new SqlQuery(); // SqlQuery | Information about SQL query and it's context.
try {
    List<QueryColumn> result = apiInstance.getQueryColumnsPost(query);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveQueryBuilderApi#getQueryColumnsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | [**SqlQuery**](SqlQuery.md)| Information about SQL query and it&#39;s context. |

### Return type

[**List&lt;QueryColumn&gt;**](QueryColumn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/html

<a name="transformSQLPost"></a>
# **transformSQLPost**
> TransformResult transformSQLPost(transform)



Transforms the given SQL query according to the commands provided in this request. You can add constraints, hide some of the resultset columns, chang sorting or limit rows of resultset. All transformations can only lead to reorganization or limitation of the resultset data. This means that it&#39;s impossible to get transformed SQL that reveals any other data than the data retutned by original query.

### Example
```java
// Import classes:
//import webapi.activequerybuilder.ApiException;
//import webapi.activequerybuilder.api.ActiveQueryBuilderApi;


ActiveQueryBuilderApi apiInstance = new ActiveQueryBuilderApi();
Transform transform = new Transform(); // Transform | SQL transformation parameters and commands.
try {
    TransformResult result = apiInstance.transformSQLPost(transform);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActiveQueryBuilderApi#transformSQLPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **transform** | [**Transform**](Transform.md)| SQL transformation parameters and commands. |

### Return type

[**TransformResult**](TransformResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/xml
 - **Accept**: application/json, text/html

