# PCBuilder backend

Part of PCBuilder applications

In order to run the backend the following VIEWS should be present in the used MySQL database:
```sql
CREATE VIEW min_daily_price_view AS
    SELECT c.id component_id, cast(pp.pricing_date as DATE) date, min(pp.id) pricepoint_id, min(pp.price) price
    FROM price_point pp
        INNER JOIN product p ON pp.product_id = p.id
        INNER JOIN component c ON p.component_id = c.id
    GROUP BY 1,2;
  
CREATE VIEW max_daily_price_view AS
    SELECT c.id component_id, cast(pp.pricing_date as DATE) date, max(pp.id) pricepoint_id, max(pp.price) price
    FROM price_point pp
        INNER JOIN product p ON pp.product_id = p.id
        INNER JOIN component c ON p.component_id = c.id
    GROUP BY 1,2;
```

The following spring applications properties should be used:

```yaml
server.port = 8090
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jackson.serialization.fail-on-empty-beans=false
spring.datasource.url=?
spring.datasource.username=?
spring.datasource.password=?
```
