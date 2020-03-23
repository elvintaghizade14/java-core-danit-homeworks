package Step_Project_1.io;

public interface Console {
  void print(String line);
  default void printLn(String line) {
    print(line);
    print("\n");
  }
  String readLn();
}
