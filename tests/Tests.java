import org.junit.runner.JUnitCore;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import webapi.activequerybuilder.*;
import webapi.activequerybuilder.api.*;
import webapi.activequerybuilder.model.*;

import java.util.Arrays;
import java.util.List;

public class Tests {
    ActiveQueryBuilderApi api;
    Transform transform;
    String guid = "b3207f4f-b1f4-4dc2-979b-7724ed2d0221";
    String sql = "select customer_id, first_name, last_name, create_date from customer";

    public static void main(String[] args) {
        JUnitCore.main("Tests");
    }

    @Before
    public void setUp() {
        api = new ActiveQueryBuilderApi();
        transform = new Transform();

        transform.setGuid(guid);
        transform.setSql(sql);
    }

    @After
    public void tearDown() {
        api = null;
        transform = null;
    }

    @Test
    public void avgTest() throws Exception {
        Totals avg = new Totals();
        avg.setField("first_name");
        avg.setAggregate(Totals.AggregateEnum.AVG);

        transform.setTotals(Arrays.asList(avg));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "Select Avg(q.first_name) as first_nameavg From (Select customer.customer_id customer_id, customer.first_name first_name, customer.last_name last_name, customer.create_date create_date From customer) q";
        Assert.assertEquals(correct.toLowerCase(), result.getTotals().toLowerCase());
    }

    @Test
    public void countTest() throws Exception {
        Totals count = new Totals();
        count.setField("first_name");
        count.setAggregate(Totals.AggregateEnum.COUNT);

        transform.setTotals(Arrays.asList(count));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "Select Count(q.first_name) as first_namecount From (Select customer.customer_id customer_id, customer.first_name first_name, customer.last_name last_name, customer.create_date create_date From customer) q";
        Assert.assertEquals(correct.toLowerCase(), result.getTotals().toLowerCase());
    }

    @Test
    public void maxTest() throws Exception {
        Totals max = new Totals();
        max.setField("first_name");
        max.setAggregate(Totals.AggregateEnum.MAX);

        transform.setTotals(Arrays.asList(max));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "Select Max(q.first_name) as first_namemax From (Select customer.customer_id customer_id, customer.first_name first_name, customer.last_name last_name, customer.create_date create_date From customer) q";
        Assert.assertEquals(correct.toLowerCase(), result.getTotals().toLowerCase());
    }

    @Test
    public void minTest() throws Exception {
        Totals min = new Totals();
        min.setField("first_name");
        min.setAggregate(Totals.AggregateEnum.MIN);

        transform.setTotals(Arrays.asList(min));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "Select Min(q.first_name) as first_namemin From (Select customer.customer_id customer_id, customer.first_name first_name, customer.last_name last_name, customer.create_date create_date From customer) q";
        Assert.assertEquals(correct.toLowerCase(), result.getTotals().toLowerCase());
    }

    @Test
    public void sumTest() throws Exception {
        Totals sum = new Totals();
        sum.setField("first_name");
        sum.setAggregate(Totals.AggregateEnum.SUM);

        transform.setTotals(Arrays.asList(sum));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "Select Sum(q.first_name) as first_namesum From (Select customer.customer_id customer_id, customer.first_name first_name, customer.last_name last_name, customer.create_date create_date From customer) q";
        Assert.assertEquals(correct.toLowerCase(), result.getTotals().toLowerCase());
    }

    @Test
    public void orderTest() throws Exception {
        Sorting sort = new Sorting();
        sort.setField("customer_id");
        sort.setOrder(Sorting.OrderEnum.ASC);

        transform.setSortings(Arrays.asList(sort));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "Select customer.customer_id, customer.first_name, customer.last_name, customer.create_date From customer order by customer.customer_id";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void orderDescTest() throws Exception {
        Sorting sort = new Sorting();
        sort.setField("customer_id");
        sort.setOrder(Sorting.OrderEnum.DESC);

        transform.setSortings(Arrays.asList(sort));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "Select customer.customer_id, customer.first_name, customer.last_name, customer.create_date From customer order by customer.customer_id desc";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void pageTest() throws Exception {
        Pagination page = new Pagination();
        page.setSkip(2);
        page.setTake(3);

        transform.setPagination(page);

        TransformResult result = api.transformSQLPost(transform);

        String correct = "select customer.customer_id, customer.first_name, customer.last_name, customer.create_date from customer limit 3 offset 2";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void hideColumnTest() throws Exception {
        HiddenColumn column = new HiddenColumn();
        column.setField("first_name");

        transform.setHiddenColumns(Arrays.asList(column));

        TransformResult result = api.transformSQLPost(transform);

        String correct = "select q.customer_id, q.last_name, q.create_date from (select customer.customer_id customer_id, customer.first_name first_name, customer.last_name last_name, customer.create_date create_date from customer) q";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void filterContainsTest() throws Exception {
        ConditionGroup filter = new ConditionGroup();

        Condition condition = new Condition();
        condition.setField("first_name");
        condition.setConditionOperator(Condition.ConditionOperatorEnum.CONTAINS);
        condition.setValues(Arrays.asList("Orlando"));

        filter.setConditions(Arrays.asList(condition));

        transform.setFilter(filter);

        TransformResult result = api.transformSQLPost(transform);

        String correct = "select customer.customer_id, customer.first_name, customer.last_name, customer.create_date from customer where customer.first_name like '%Orlando%'";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void filterLessTest() throws Exception {
        ConditionGroup filter = new ConditionGroup();

        Condition condition = new Condition();
        condition.setField("customer_id");
        condition.setConditionOperator(Condition.ConditionOperatorEnum.LESS);
        condition.setValues(Arrays.asList("5"));

        filter.setConditions(Arrays.asList(condition));

        transform.setFilter(filter);

        TransformResult result = api.transformSQLPost(transform);

        String correct = "select customer.customer_id, customer.first_name, customer.last_name, customer.create_date from customer where customer.customer_id < 5";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void filterBetweenTest() throws Exception {
        ConditionGroup filter = new ConditionGroup();

        Condition condition = new Condition();
        condition.setField("customer_id");
        condition.setConditionOperator(Condition.ConditionOperatorEnum.BETWEEN);
        condition.setValues(Arrays.asList("1", "5"));

        filter.setConditions(Arrays.asList(condition));

        transform.setFilter(filter);

        TransformResult result = api.transformSQLPost(transform);

        String correct = "select customer.customer_id, customer.first_name, customer.last_name, customer.create_date from customer where customer.customer_id between 1 and 5";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void filterIsNotNullTest() throws Exception {
        ConditionGroup filter = new ConditionGroup();

        Condition condition = new Condition();
        condition.setField("customer_id");
        condition.setConditionOperator(Condition.ConditionOperatorEnum.ISNOTNULL);

        filter.setConditions(Arrays.asList(condition));

        transform.setFilter(filter);

        TransformResult result = api.transformSQLPost(transform);

        String correct = "select customer.customer_id, customer.first_name, customer.last_name, customer.create_date from customer where customer.customer_id is not null";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void conditionGroupTest() throws Exception {
        ConditionGroup filter = new ConditionGroup();

        ConditionGroup conditionGroup = new ConditionGroup();
        conditionGroup.setJunctionType(ConditionGroup.JunctionTypeEnum.AND);

        Condition condition1 = new Condition();
        condition1.setField("customer_id");
        condition1.setConditionOperator(Condition.ConditionOperatorEnum.ISNULL);

        Condition condition2 = new Condition();
        condition2.setField("customer_id");
        condition2.setConditionOperator(Condition.ConditionOperatorEnum.ISNOTNULL);

        conditionGroup.setConditions(Arrays.asList(condition1, condition2));

        filter.setConditionGroups(Arrays.asList(conditionGroup));

        transform.setFilter(filter);

        TransformResult result = api.transformSQLPost(transform);

        String correct = "select customer.customer_id, customer.first_name, customer.last_name, customer.create_date from customer where (customer.customer_id is null) and (customer.customer_id is not null)";
        Assert.assertEquals(correct.toLowerCase(), result.getSql().toLowerCase());
    }

    @Test
    public void invalidColumnTest() throws Exception {
        Totals sum = new Totals();
        sum.setField("id1");
        sum.setAggregate(Totals.AggregateEnum.SUM);

        transform.setTotals(Arrays.asList(sum));

        TransformResult result = api.transformSQLPost(transform);

        Assert.assertEquals("QueryTransformer does't contain id1", result.getError());
    }

    @Test
    public void getFieldsTest() throws Exception {
        SqlQuery query = new SqlQuery();
        query.setGuid(guid);
        query.setText(sql);

        List<QueryColumn> fields = api.getQueryColumnsPost(query);

        Assert.assertEquals(fields.size(), 4);
        Assert.assertEquals("customer_id", fields.get(0).getName());
        Assert.assertEquals("smallint", fields.get(0).getDataType());
        Assert.assertEquals("create_date", fields.get(3).getName());
        Assert.assertEquals("datetime", fields.get(3).getDataType());
    }
}
