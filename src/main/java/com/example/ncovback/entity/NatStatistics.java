package com.example.ncovback.entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Data
public class NatStatistics implements Comparable{
    private Date nat_time;
    private Integer nat_number;
    private String city_code;
    private String area_code;
    private String area_name;
    private Integer t_areanat;

    @Override
    public int compareTo(@NotNull Object o) {
        NatStatistics s = (NatStatistics) o;
        if (this.t_areanat > s.t_areanat) {
            return -1;
        }
        else if (this.t_areanat < s.t_areanat) {
            return 1;
        }else {
            return 0;
        }
    }
}
