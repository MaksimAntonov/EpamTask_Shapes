package by.antonov.shapes.observer;

public interface CubeObservable {

  void attach(CubeObserver observer);

  void detach(CubeObserver observer);

  void notifyObservers();
}
