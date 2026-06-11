package com.scoutapp.dto.transfermarkt;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class TransfermarktProfileDto {
    private String id;
    private String name;
    private String fullName;
    private String dateOfBirth;
    private Object placeOfBirth; // Can be Map with city/country
    private Integer age;
    private String height;
    private List<String> citizenship;
    private String position;
    private String foot;
    private Map<String, Object> club;
    private Object marketValue;
    private String joined;
    private String contractExpires;
    private List<String> socialMedia;
    private String imageUrl;
    private List<TransfermarktStatDto> stats;

    @Data
    public static class TransfermarktStatDto {
        private Object competition; // Can be String or Map
        private Integer appearances;
        private Integer goals;
        private Integer assists;
        private Integer yellowCards;
        private Integer redCards;
        private Integer minutesPlayed;

        public String getCompetitionName() {
            if (competition instanceof String) return (String) competition;
            if (competition instanceof Map) {
                return (String) ((Map<?, ?>) competition).get("name");
            }
            return null;
        }
    }

    public String getClubName() {
        if (club != null) return (String) club.get("name");
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
