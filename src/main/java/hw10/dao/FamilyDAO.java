package hw10.dao;

import hw10.entity.Family;

import java.util.Collection;
import java.util.function.Predicate;

public interface FamilyDAO<T> {
  Collection<T> getAllFamilies();
  Family getFamilyByIndex(int index);
  Collection<T> getAllFamiliesBy(Predicate<T> p);
  boolean deleteFamily(int index);
  boolean deleteFamily(T data);
  void saveFamily(T data);
}