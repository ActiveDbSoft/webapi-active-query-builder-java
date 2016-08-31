
# Sorting

Determines rows order in transformed query. If there aren&#39;t any sortings, the original query sorting is kept.

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**field** | **String** | Column of original query by which transfored query will be sorted. |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | Sort order (ascending or descending). |  [optional]


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
ASC | &quot;asc&quot;
DESC | &quot;desc&quot;




