package com.aston.lesson6.phoneDirectory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PhoneDirectory {

  private Map<String, List<String>> directory;

  public PhoneDirectory() {
    directory = new HashMap<>();
  }

  public void add(String lastName, String phoneNumber) {
    directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
  }


  public List<String> get(String lastName) {

    return directory.getOrDefault(lastName, Collections.emptyList());
  }


  public void printAll() {
    if (directory.isEmpty()) {
      System.out.println("Телефонный справочник пуст.");
      return;
    }


    for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }


  public boolean removePhone(String lastName, String phoneNumber) {
    List<String> phones = directory.get(lastName);
    if (phones != null) {
      boolean removed = phones.remove(phoneNumber);
      if (phones.isEmpty()) {
        directory.remove(lastName);
      }
      return removed;
    }
    return false;
  }


  public boolean removeLastName(String lastName) {
    return directory.remove(lastName) != null;
  }


  public Set<String> getAllLastNames() {
    return directory.keySet();
  }


  public boolean containsLastName(String lastName) {
    return directory.containsKey(lastName);
  }


  public int size() {
    return directory.size();
  }


  public void clear() {
    directory.clear();
  }

}
