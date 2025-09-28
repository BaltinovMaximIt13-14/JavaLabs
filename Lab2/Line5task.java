import java.lang.Math;
public class Line5task {
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
  public Line5task(PointEdited PStart, PointEdited PEnd){
    this.PStart = PStart;
    this.PEnd = PEnd;
  }

  public Line5task(int xS, int yS, int xE, int yE){
    this.PStart = new PointEdited(xS, yS);
    this.PEnd = new PointEdited(xE, yE);
  }

  @Override
  public String toString(){
    return "Линия от " + this.PStart + " до " + this.PEnd;
  }

  //Функция вычисления длины
  public int length(){
    int x = (int) Math.pow(this.PEnd.getX()-this.PStart.getX(), 2);
    int y = (int )Math.pow(this.PEnd.getY()-this.PStart.getY(), 2);
    return (int) Math.sqrt(x+y);
  }
}
