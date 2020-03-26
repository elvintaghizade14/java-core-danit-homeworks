package hw11.dao;

import hw11.entity.Family;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDAO<Family> {

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

  public List<Family> getFamilies() {
    return families;
  }

  public void setFamilies(List<Family> families) {
    this.families = families;
  }
}
