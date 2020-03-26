package hw13.dao;

import hw13.entity.Family;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface FamilyDAO<T> {
  Collection<T> getAllFamilies();
  Family getFamilyByIndex(int index);
  Collection<T> getAllFamiliesBy(Predicate<T> p);
  boolean deleteFamily(int index);
  boolean deleteFamily(T data);
  void saveFamily(T data);
  void updateFamilies(List<T> families);
  void loadData(List<Family> families);
  Collection<T> downloadData();
}