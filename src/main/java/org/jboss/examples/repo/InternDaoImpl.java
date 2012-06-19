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

import org.jboss.examples.model.Intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InternDaoImpl implements InternDao
{

   @Autowired
   private EntityManager entityManager;

   @SuppressWarnings("unchecked")
   public List<Intern> getAll()
   {
      Query query = entityManager.createQuery("select e from " + "Intern" + " e");
      List<Intern> entities = query.getResultList();
      return entities;
   }

   public Intern getById(Long id)
   {
      return entityManager.find(Intern.class, id);
   }

   public void update(Intern entity)
   {
      entityManager.merge(entity);
      return;
   }

   public void create(Intern entity)
   {
      entityManager.persist(entity);
      return;
   }

   public void delete(Long id)
   {
      entityManager.remove(entityManager.find(Intern.class, id));
      return;
   }

   public List<Intern> search(Intern search)
   {
      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

      // Create and populate a query for the search

      CriteriaQuery<Intern> criteria = builder.createQuery(Intern.class);
      Root<Intern> root = criteria.from(Intern.class);
      TypedQuery<Intern> query = this.entityManager.createQuery(criteria.select(root).where(getSearchPredicates(root, search)));

      return query.getResultList();
   }

   private Predicate[] getSearchPredicates(Root<Intern> root, Intern search)
   {
      CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
      List<Predicate> predicatesList = new ArrayList<Predicate>();

      String fullName = search.getFullName();
      if (fullName != null && !"".equals(fullName))
      {
         predicatesList.add(builder.like(root.<String> get("fullName"), '%' + fullName + '%'));
      }
      String email = search.getEmail();
      if (email != null && !"".equals(email))
      {
         predicatesList.add(builder.like(root.<String> get("email"), '%' + email + '%'));
      }

      return predicatesList.toArray(new Predicate[predicatesList.size()]);
   }
}