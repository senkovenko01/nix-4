package ua.com.alevel.entity;

import lombok.*;

@Setter
@Getter
@Generated
@AllArgsConstructor
@ToString
public class Route {
    private int id;
    private int idFrom;
    private int idTo;
    private int cost;
}
