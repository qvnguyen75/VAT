package testpackage.VAT;

public interface Shape {
  String getName();
  String getType();
  void deleteFromDatabase();
  double calculateVolume();
  void saveToDatabase();
}
