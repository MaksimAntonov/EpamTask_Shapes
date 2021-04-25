package by.antonov.shapes.observer;

import by.antonov.shapes.entity.Cube;
import java.util.EventObject;

public class CubeEvent extends EventObject {

  public CubeEvent(Cube source) {
    super(source);
  }

  @Override
  public Cube getSource() {
    return (Cube) super.getSource();
  }
}
