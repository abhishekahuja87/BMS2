package com.abhishek.bookmyshow.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<M extends Serializable> {
  M getById(Long id);
  List<M> getAll();
  long getCount();
  boolean exists(Long id);
  void delete(M instance);
  void delete(Long id);
  M save(M instance);
}