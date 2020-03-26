package hw13;

import hw13.entity.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInOut {
  private final static File file = new File("families.bin");

  public static List<Family> downloadData() {
    List<Family> families = new ArrayList<>();
    FileInputStream fin = null;
    ObjectInputStream ois = null;
    try {
      fin = new FileInputStream(file);
      ois = new ObjectInputStream(fin);
      families = (List<Family>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        ois.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        fin.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (families.size() == 0) {
      System.out.println("\nFile is empty!\n");
    } else {
      for (Family p : families)
        System.out.printf("\n%s\n", p.toString());
    }
    return families;
  }

  public static void loadData(List<Family> families) {

    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      if (families.size() == 0) {
        System.out.println("\nFile is empty\n");
      }
      fos = new FileOutputStream(file);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(families);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        oos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
