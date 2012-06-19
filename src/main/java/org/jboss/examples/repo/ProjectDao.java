package org.jboss.examples.repo;

import java.util.List;

import org.jboss.examples.model.Project;

public interface ProjectDao
{
   public List<Project> getAll();

   public Project getById(Long id);

   public void update(Project entity);

   public void create(Project entity);

   public void delete(Long id);

   public List<Project> search(Project search);
}
