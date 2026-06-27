package com.scoutapp.dto.transfermarkt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransfermarktProfileDto {
    private String id;
    private String name;
    private String fullName;
    private String dateOfBirth;
    private Object placeOfBirth; 
    private Integer age;
    private Object height;
    private List<String> citizenship;
    private Object position;
    private String foot;
    private Map<String, Object> club;
    private Object marketValue;
    private String joined;
    private String contractExpires;
    private List<String> socialMedia;
    private String imageUrl;
    private List<Map<String, Object>> stats;

    public String getClubName() {
        if (club != null && club.get("name") != null) return club.get("name").toString();
        return null;
    }

    public String getPositionName() {
        if (position instanceof String) return (String) position;
        if (position instanceof Map) {
            Map<?, ?> m = (Map<?, ?>) position;
            if (m.get("main") != null) return m.get("main").toString();
        }
        return null;
    }

    public String getMarketValueDisplay() {
        if (marketValue == null) return "N/A";
        if (marketValue instanceof String) return (String) marketValue;
        if (marketValue instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) marketValue;
            if (map.containsKey("display")) return map.get("display").toString();
            if (map.containsKey("value")) return map.get("value").toString();
        }
        if (marketValue instanceof Number) return marketValue.toString();
        return "N/A";
    }
}
