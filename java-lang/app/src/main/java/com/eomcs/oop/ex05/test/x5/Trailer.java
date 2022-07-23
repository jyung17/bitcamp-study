package com.eomcs.oop.ex05.test.x5;

public class Trailer extends Option {
  public Trailer(Car car) {
    super(car);
  }

  CampingTrailer trailer;

  public void setTrailer(CampingTrailer trailer) {
    this.trailer = trailer;
  }

  @Override
  public void start() {
    car.start();
  }

  @Override
  public void stop() {
    car.stop();
  }

  @Override
  public void run() {
    car.run();
    System.out.println("덜덜덜 트레일러가 따라간다.");
  }
}
