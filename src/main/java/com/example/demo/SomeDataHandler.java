package com.example.demo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SomeDataHandler extends BaseTypeHandler<SomeData> {

    private final JsonMapper jsonMapper;

    public SomeDataHandler(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SomeData parameter, JdbcType jdbcType) throws SQLException {
        try {
            String json = jsonMapper.writeValueAsString(parameter);
            ps.setString(i, json);
        } catch (Exception e) {
            throw new SQLException("Error serializing SomeData to JSON", e);
        }
    }

    @Override
    public SomeData getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String raw = rs.getString(columnName);
        return parseJson(raw);
    }

    @Override
    public SomeData getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String raw = rs.getString(columnIndex);
        return parseJson(raw);
    }

    @Override
    public SomeData getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String raw = cs.getString(columnIndex);
        return parseJson(raw);
    }


    private SomeData parseJson(String raw) throws SQLException {
        if (raw == null || raw.isBlank()) {
            return null;
        }
        try {
            JsonNode node = jsonMapper.readTree(raw);

            Integer a = null;
            JsonNode aNode = node.get("a");
            if (aNode != null && !aNode.isNull()) {
                a = aNode.asInt();
            }


            String b = parseRaw(node.get("b"));

            return new SomeData(a, b);
        } catch (Exception e) {
            throw new SQLException("Failed to parse JSON for SomeData: " + raw, e);
        }
    }

    private String parseRaw(JsonNode node) {
        if (node == null || node.isNull()) {
            return null;
        }
        if (node.isNumber()) {
            return "数字 " + node.asInt();
        }
        if (node.isBoolean()) {
            return "布尔 " + node.asBoolean();
        }
        if (node.isString()) {
            return "字符串 " + node.asString();
        }
        if (node.isArray()) {
            return "数组 " + node.asString();
        }
        // 兜底：处理 Object 或其他类型
        return "未知类型 " + node.asString();
    }
}