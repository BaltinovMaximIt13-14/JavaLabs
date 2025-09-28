public class Point {
  private int x;
  private int y;

  //Свойства
  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }
  public void setY(int y) {
    this.y = y;
  }

  //Конструкторы
  public Point() {
    this.x = 0;
    this.y = 0;
  }

  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  public Point(Point point){
    this.x = point.x;
    this.y = point.y;
  }

  public void deletePoint(){
    this.x = 0;
    this.y = 0;
  }

  @Override
  public String toString (){
    return "{" + this.x + ";" + this.y + "}";
  }
}
