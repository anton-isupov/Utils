package com.utils.graph.vertex.impl;

import com.utils.graph.vertex.VertexI;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SimpleVertex implements VertexI {
   private String name;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SimpleVertex simpleVertex = (SimpleVertex) o;
      return Objects.equals(name, simpleVertex.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name);
   }

}
