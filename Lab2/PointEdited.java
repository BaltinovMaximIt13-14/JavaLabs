public class PointEdited {
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
  public PointEdited(int x, int y){
    this.x = x;
    this.y = y;
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
