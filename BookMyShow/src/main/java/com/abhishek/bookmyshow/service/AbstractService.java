package com.abhishek.bookmyshow.service;


import com.abhishek.bookmyshow.model.UniquelyIdentifiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class AbstractService<M extends UniquelyIdentifiable, R extends JpaRepository<M, Long>> implements BaseService<M>{
  protected R repository;
  protected Class<M> mClass;

  public AbstractService(R repository, Class<M> mClass) {
    this.repository = repository;
    this.mClass = mClass;
  }

  @Override
  @Transactional(readOnly = true)
  public M getById(Long id) {
    if (id != null) {
      return repository.findById(id).orElse(null);
    } else {
      return null;
    }
  }

  @Override
  @Transactional(readOnly = true)
  public List<M> getAll() {
    List<M> entities = new ArrayList<>();
    for (M m : repository.findAll()) {
      entities.add(m);
    }
    return entities;
  }

  @Override
  @Transactional
  public M save(M instance) {
    try {
      M result;
      if (instance.getId() == null) {
        result = repository.save(instance);
      } else {
        result = repository.save(instance);
      }
      return result;
    }catch (Exception e){
      throw e;
    }
  }

  @Override
  @Transactional
  public void delete(M instance) {
    delete(instance.getId());
  }

  @Override
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public long getCount() {
    return repository.count();
  }

  @Override
  @Transactional(readOnly = true)
  public boolean exists(Long id) {
    return repository.existsById(id);
  }

}
