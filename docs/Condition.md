
# Condition

Defines a constraint for original query resultset values.

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**field** | **String** | Column of original query to which a constraint will applied. |  [optional]
**conditionOperator** | [**ConditionOperatorEnum**](#ConditionOperatorEnum) | Condition operator. |  [optional]
**values** | **List&lt;String&gt;** | List of values for a constraint. 'IsNull', 'IsNotNull' need no values; 'Between', 'NotBetween' require 2 values; 'In' accepts one or more values; other conditions accept single value only. |  [optional]


<a name="ConditionOperatorEnum"></a>
## Enum: ConditionOperatorEnum
Name | Value
---- | -----
ISNULL | &quot;IsNull&quot;
ISNOTNULL | &quot;IsNotNull&quot;
EQUAL | &quot;Equal&quot;
NOTEQUAL | &quot;NotEqual&quot;
LESS | &quot;Less&quot;
NOTLESS | &quot;NotLess&quot;
LESSEQUAL | &quot;LessEqual&quot;
NOTLESSEQUAL | &quot;NotLessEqual&quot;
GREATER | &quot;Greater&quot;
NOTGREATER | &quot;NotGreater&quot;
GREATEREQUAL | &quot;GreaterEqual&quot;
NOTGREATEREQUAL | &quot;NotGreaterEqual&quot;
BETWEEN | &quot;Between&quot;
NOTBETWEEN | &quot;NotBetween&quot;
IN | &quot;In&quot;
NOTIN | &quot;NotIn&quot;
CONTAINS | &quot;Contains&quot;
DOESNTCONTAIN | &quot;DoesntContain&quot;
STARTSWITH | &quot;StartsWith&quot;
DOESNTSTARTWITH | &quot;DoesntStartWith&quot;
ENDSWITH | &quot;EndsWith&quot;
DOESNTENDWITH | &quot;DoesntEndWith&quot;




