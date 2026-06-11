package com.scoutapp.dto.transfermarkt;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class TransfermarktPlayerDto {
    private String id;
    private String name;
    private Object club; // Can be String or Map
    private String position;
    private Integer age;
    private List<String> nationality;
    private String imageUrl;
    private Object marketValue; // Can be String, Map, or Number

    public String getClubName() {
        if (club instanceof String) return (String) club;
        if (club instanceof Map) {
            return (String) ((Map<?, ?>) club).get("name");
        }
        return null;
    }

    public String getMarketValueDisplay() {
        if (marketValue instanceof String) return (String) marketValue;
        if (marketValue instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) marketValue;
            if (map.containsKey("display")) return (String) map.get("display");
            if (map.containsKey("value")) return map.get("value").toString();
        }
        if (marketValue instanceof Number) return marketValue.toString();
        return null;
    }
}
