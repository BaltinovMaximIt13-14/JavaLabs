public class LineEdited {
  private PointEdited PStart;
  private PointEdited PEnd;

  //Свойства
  public PointEdited getPEnd() {
    return this.PEnd;
  }
  public PointEdited getPStart() {
    return PStart;
  }

  public void setPEnd(PointEdited PEnd) {
    this.PEnd = PEnd;
  }
  public void setPStart(PointEdited PStart) {
    this.PStart = PStart;
  }

  //Конструкторы
    public LineEdited(PointEdited PStart, PointEdited PEnd){
    this.PStart = PStart;
    this.PEnd = PEnd;
  }

  public LineEdited(int xS, int yS, int xE, int yE){
    this.PStart = new PointEdited(xS, yS);
    this.PEnd = new PointEdited(xE, yE);
  }

  @Override
  public String toString(){
    return "Линия от " + this.PStart + " до " + this.PEnd;
  }
}
