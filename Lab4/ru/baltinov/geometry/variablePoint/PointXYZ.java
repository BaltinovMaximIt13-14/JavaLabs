package ru.baltinov.geometry.variablePoint;

public class PointXYZ extends PointXY {
  private int z;

  //Свойства
  public int getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }

  //Конструкторы
  public PointXYZ(int x, int y, int z){
    super(x, y);
    this.z = z;
  }

  public PointXYZ(){
    super(0, 0);
    this.z = 0;
  }

  public PointXYZ(PointXYZ p1){
    super(p1.getX(), p1.getY());
    this.z = p1.getZ();
  }

  @Override
  public String toString (){
    return "{" + super.getX() + ";" + super.getY() + ";" + z + "}";
  }
  @Override
  public PointXYZ copy() {
    return new PointXYZ(super.getX(), super.getY(), this.z);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    if (!super.equals(obj)) return false;

    PointXYZ other = (PointXYZ) obj;
    return this.z == other.z;
  }

  @Override
  public int hashCode() {
    return 31 * super.hashCode() + Integer.hashCode(z);
  }
}
