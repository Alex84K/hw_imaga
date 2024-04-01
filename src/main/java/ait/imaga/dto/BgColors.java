package ait.imaga.dto;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class BgColors {
    private int b;
    private String closest_palette_color;
    private String closest_palette_color_html_code;
    private String closest_palette_color_parent;
    private double closest_palette_distance;
    private int g;
    private String html_code;
    private int r;
}

