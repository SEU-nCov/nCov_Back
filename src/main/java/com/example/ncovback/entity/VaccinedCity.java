package com.example.ncovback.entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class VaccinedCity implements Comparable{
    private String area_code;
    private String area_name;
    private Integer vaccined_value;

    @Override
    public int compareTo(@NotNull Object o) {
        VaccinedCity s = (VaccinedCity) o;
        if (this.vaccined_value > s.vaccined_value) {
            return -1;
        }
        else if (this.vaccined_value < s.vaccined_value) {
            return 1;
        }else {
            return 0;
    }
}
}
