package hw13.dao;

import hw13.entity.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDAO<Family> {

  private final static File file = new File("families.bin");
  private List<Family> families = new ArrayList<>();

  @Override
  public Collection<Family> getAllFamilies() {
    return families;
  }

  @Override
  public Collection<Family> getAllFamiliesBy(Predicate<Family> p) {
    return families.stream().filter(p).collect(Collectors.toList());
  }

  @Override
  public Family getFamilyByIndex(int index) {
    return (families == null || index < 0 || index >= families.size()) ? null : families.get(index);
  }

  @Override
  public boolean deleteFamily(int index) {
    if (families == null || index < 0 || index >= families.size()) return false;
    else {
      families.remove(index);
      return true;
    }
  }

  @Override
  public boolean deleteFamily(Family data) {
    if (families == null || !families.contains(data)) return false;
    else {
      families.remove(data);
      return true;
    }
  }

  @Override
  public void saveFamily(Family data) {
    int index = families.indexOf(data);
    if (index == -1) families.add(data);
    else families.set(index, data);
  }

  @Override
  public void updateFamilies(List<Family> families) {
    this.families = families;
  }

  @Override
  public void loadData(List<Family> families) {
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
        if (fos != null) {
          fos.close();
        }
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

  @Override
  public Collection<Family> downloadData() {
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
        if (ois != null) {
          ois.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (fin != null) {
          fin.close();
        }
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

  public List<Family> getFamilies() {
    return families;
  }

  public void setFamilies(List<Family> families) {
    this.families = families;
  }
}
