public class Line {
  private Point PStart;
  private Point PEnd;

  //Свойства

  public Point getPEnd() {
    return this.PEnd;
  }
  public Point getPStart() {
    return PStart;
  }

  public void setPEnd(Point PEnd) {
    this.PEnd = PEnd;
  }
  public void setPStart(Point PStart) {
    this.PStart = PStart;
  }

  //Конструкторы
  public Line(){
    this.PEnd = new Point();
    this.PStart = new Point();
  }

  public Line(Point PStart, Point PEnd){
    this.PStart = PStart;
    this.PEnd = PEnd;
  }

  public Line(int xS, int yS, int xE, int yE){
    this.PStart = new Point(xS, yS);
    this.PEnd = new Point(xE, yE);
  }

  public Line(Line line){
    this.PStart = line.getPStart();
    this.PEnd = line.getPEnd();
  }

  //Удаление
  public void deleteLine(){
    this.PEnd = new Point();
    this.PStart = new Point();
  }

  @Override
  public String toString(){
    return "Линия от " + this.PStart + " до " + this.PEnd;
  }
}
