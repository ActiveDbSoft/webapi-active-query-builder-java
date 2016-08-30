/**
 * QueryBuilderApi
 * Active Query Builder Web API lets create, analyze and modify SQL queries for different database servers using RESTful HTTP requests to a cloud-based service. It requires SQL execution context (information about database schema and used database server) to be stored under the registered account at https://webapi.activequerybuilder.com/.
 *
 * OpenAPI spec version: 1.1.3
 * Contact: support@activedbsoft.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package webapi.activequerybuilder.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines a constraint for original query resultset values.
 */
@ApiModel(description = "Defines a constraint for original query resultset values.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-08-22T16:57:14.000+06:00")
public class Condition   {
  @JsonProperty("field")
  private String field = null;

  /**
   * Condition operator.
   */
  public enum ConditionOperatorEnum {
    ISNULL("IsNull"),
    
    ISNOTNULL("IsNotNull"),
    
    EQUAL("Equal"),
    
    NOTEQUAL("NotEqual"),
    
    LESS("Less"),
    
    NOTLESS("NotLess"),
    
    LESSEQUAL("LessEqual"),
    
    NOTLESSEQUAL("NotLessEqual"),
    
    GREATER("Greater"),
    
    NOTGREATER("NotGreater"),
    
    GREATEREQUAL("GreaterEqual"),
    
    NOTGREATEREQUAL("NotGreaterEqual"),
    
    BETWEEN("Between"),
    
    NOTBETWEEN("NotBetween"),
    
    IN("In"),
    
    NOTIN("NotIn"),
    
    LIKE("Like"),
    
    NOTLIKE("NotLike");

    private String value;

    ConditionOperatorEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @JsonProperty("conditionOperator")
  private ConditionOperatorEnum conditionOperator = null;

  @JsonProperty("values")
  private List<String> values = new ArrayList<String>();

  public Condition field(String field) {
    this.field = field;
    return this;
  }

   /**
   * Column of original query to which a constraint will applied.
   * @return field
  **/
  @ApiModelProperty(example = "null", value = "Column of original query to which a constraint will applied.")
  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public Condition conditionOperator(ConditionOperatorEnum conditionOperator) {
    this.conditionOperator = conditionOperator;
    return this;
  }

   /**
   * Condition operator.
   * @return conditionOperator
  **/
  @ApiModelProperty(example = "null", value = "Condition operator.")
  public ConditionOperatorEnum getConditionOperator() {
    return conditionOperator;
  }

  public void setConditionOperator(ConditionOperatorEnum conditionOperator) {
    this.conditionOperator = conditionOperator;
  }

  public Condition values(List<String> values) {
    this.values = values;
    return this;
  }

   /**
   * List of values for a constraint. \"IsNull\", \"IsNotNull\" need no values; \"Between\", \"NotBetween\" require 2 values; \"In\" accepts one or more values; other conditions accept single value only.
   * @return values
  **/
  @ApiModelProperty(example = "null", value = "List of values for a constraint. \"IsNull\", \"IsNotNull\" need no values; \"Between\", \"NotBetween\" require 2 values; \"In\" accepts one or more values; other conditions accept single value only.")
  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Condition condition = (Condition) o;
    return Objects.equals(this.field, condition.field) &&
        Objects.equals(this.conditionOperator, condition.conditionOperator) &&
        Objects.equals(this.values, condition.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, conditionOperator, values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Condition {\n");
    
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    conditionOperator: ").append(toIndentedString(conditionOperator)).append("\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

