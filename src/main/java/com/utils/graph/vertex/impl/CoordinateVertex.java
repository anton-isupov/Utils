package com.utils.graph.vertex.impl;

import com.utils.graph.vertex.VertexI;
import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class CoordinateVertex implements VertexI {
    private int x;
    private int y;

}
