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

package webapi.activequerybuilder.api;

import com.sun.jersey.api.client.GenericType;

import webapi.activequerybuilder.ApiException;
import webapi.activequerybuilder.ApiClient;
import webapi.activequerybuilder.Configuration;
import webapi.activequerybuilder.model.*;
import webapi.activequerybuilder.Pair;

import webapi.activequerybuilder.model.SqlQuery;
import webapi.activequerybuilder.model.QueryColumn;
import webapi.activequerybuilder.model.Transform;
import webapi.activequerybuilder.model.TransformResult;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-08-22T16:57:14.000+06:00")
public class ActiveQueryBuilderApi {
  private ApiClient apiClient;

  public ActiveQueryBuilderApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ActiveQueryBuilderApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * 
   * Returns list of columns for the given SQL query.
   * @param query Information about SQL query and it&#39;s context. (required)
   * @return List<QueryColumn>
   * @throws ApiException if fails to make API call
   */
  public List<QueryColumn> getQueryColumnsPost(SqlQuery query) throws ApiException {
    Object localVarPostBody = query;
    
    // verify the required parameter 'query' is set
    if (query == null) {
      throw new ApiException(400, "Missing the required parameter 'query' when calling getQueryColumnsPost");
    }
    
    // create path and map variables
    String localVarPath = "/getQueryColumns".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "text/html"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json", "text/xml"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<QueryColumn>> localVarReturnType = new GenericType<List<QueryColumn>>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * 
   * Transforms the given SQL query according to the commands provided in this request. You can add constraints, hide some of the resultset columns, chang sorting or limit rows of resultset. All transformations can only lead to reorganization or limitation of the resultset data. This means that it&#39;s impossible to get transformed SQL that reveals any other data than the data retutned by original query.
   * @param transform SQL transformation parameters and commands. (required)
   * @return TransformResult
   * @throws ApiException if fails to make API call
   */
  public TransformResult transformSQLPost(Transform transform) throws ApiException {
    Object localVarPostBody = transform;
    
    // verify the required parameter 'transform' is set
    if (transform == null) {
      throw new ApiException(400, "Missing the required parameter 'transform' when calling transformSQLPost");
    }
    
    // create path and map variables
    String localVarPath = "/transformSQL".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json", "text/html"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json", "text/xml"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<TransformResult> localVarReturnType = new GenericType<TransformResult>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}