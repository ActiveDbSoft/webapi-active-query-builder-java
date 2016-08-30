
# ConditionGroup

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**junctionType** | [**JunctionTypeEnum**](#JunctionTypeEnum) | Type of junction. All &#x3D; AND; Any &#x3D; OR. |  [optional]
**conditions** | [**List&lt;Condition&gt;**](Condition.md) | List of conditions to join. |  [optional]
**conditionGroups** | [**List&lt;ConditionGroup&gt;**](ConditionGroup.md) | List of nested condition groups to join them with a different boolean operator. |  [optional]


<a name="JunctionTypeEnum"></a>
## Enum: JunctionTypeEnum
Name | Value
---- | -----
AND | &quot;And&quot;
OR | &quot;Or&quot;
ANY | &quot;Any&quot;
ALL | &quot;All&quot;



