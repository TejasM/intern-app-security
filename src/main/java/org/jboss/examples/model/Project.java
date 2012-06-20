package org.jboss.examples.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Project implements java.io.Serializable
{

   @Id
   private @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   Long id = null;
   @Version
   private @Column(name = "version")
   int version = 0;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Project) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   @Column
   private String projectName;

   public String getProjectName()
   {
      return this.projectName;
   }

   public void setProjectName(final String projectName)
   {
      this.projectName = projectName;
   }

   @Column
   private int maxPeople;

   public int getMaxPeople()
   {
      return this.maxPeople;
   }

   public void setMaxPeople(final int maxPeople)
   {
      this.maxPeople = maxPeople;
   }

   public String toString()
   {
      String result = "";
      if (projectName != null && !projectName.trim().isEmpty())
         result += projectName;
      result += " " + maxPeople;
      return result;
   }

   @ManyToMany(mappedBy = "projects", fetch=FetchType.EAGER)
   @LazyCollection(LazyCollectionOption.FALSE)
   private Set<Intern> interns = new HashSet<Intern>();
   
   public Set<Intern> getInterns()
   {
      return this.interns;
   }

   public void setInterns(final Set<Intern> interns)
   {
      this.interns = interns;
   }
}