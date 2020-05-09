package models;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LocationStats {
    private String country;
    private int latestTotalCases;
    private int newCases;
}
