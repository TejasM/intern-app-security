package org.jboss.examples.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jboss.examples.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao
{

   @Autowired
   private EntityManager entityManager;

   @SuppressWarnings("unchecked")
   public List<Project> getAll()
   {
      Query query = entityManager.createQuery("select e from " + "Project" + " e");
      List<Project> entities = query.getResultList();
      return entities;
   }

   public Project getById(Long id)
   {
      return entityManager.find(Project.class, id);
   }

   public void update(Project entity)
   {
      entityManager.merge(entity);
      return;
   }

   public void create(Project entity)
   {
      entityManager.persist(entity);
      return;
   }

   public void delete(Long id)
   {
      entityManager.remove(entityManager.find(Project.class, id));
      return;
   }

   public List<Project> search(Project search)
   {
      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Create and populate a query for the search

      CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
      Root<Project> root = criteria.from(Project.class);
      TypedQuery<Project> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root, search)));

      return query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Project> root, Project search)
   {
      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String projectName = search.getProjectName();
      if (projectName != null && !"".equals(projectName))
      {
         predicatesList.add(builder.like(root.<String> get("projectName"), '%' + projectName + '%'));
      }
      int maxPeople = search.getMaxPeople();
      if (maxPeople != 0)
      {
         predicatesList.add(builder.equal(root.get("maxPeople"), maxPeople));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }
}