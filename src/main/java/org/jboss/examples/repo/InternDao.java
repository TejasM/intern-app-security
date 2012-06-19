package org.jboss.examples.repo;

import java.util.List;

import org.jboss.examples.model.Intern;

public interface InternDao
{
   public List<Intern> getAll();

   public Intern getById(Long id);

   public void update(Intern entity);

   public void create(Intern entity);

   public void delete(Long id);

   public List<Intern> search(Intern search);
}
