package com.utils.graph.vertex.impl;

import com.utils.graph.vertex.AbstractVertex;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class CoordinateVertex extends AbstractVertex {
    private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateVertex that = (CoordinateVertex) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
