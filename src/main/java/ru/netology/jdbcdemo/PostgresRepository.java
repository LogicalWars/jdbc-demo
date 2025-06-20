package ru.netology.jdbcdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostgresRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public String findProductNameByCustomerName(String customerName) {
        String sqlQuery = UtilReadSqlFile.read("dml_script.sql");
        MapSqlParameterSource params = new MapSqlParameterSource("name", customerName);
        List<String> result = jdbcTemplate.query(sqlQuery, params, (RowMapper) (rs, rowNum) -> rs.getString("product_name"));
        return result.stream().findFirst().orElse("Not found");
    }
}
