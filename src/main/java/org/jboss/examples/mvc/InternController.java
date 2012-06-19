package org.jboss.examples.mvc;

import java.util.List;

import org.jboss.examples.model.Intern;
import org.jboss.examples.repo.InternDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/interns")
public class InternController
{

   // Inject the appropriate data-access object for the given entity.

   @Autowired
   private InternDao internDao;

   @RequestMapping(method = RequestMethod.GET)
   public @ModelAttribute("entities")
   List<Intern> viewInterns(@ModelAttribute("search")
   Intern search)
   {
      List<Intern> interns = internDao.search(search);
      return interns;
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public String viewIntern(@PathVariable("id")
   Long id, Model model, @RequestParam(required = false)
   String edit)
   {
      Intern intern = internDao.getById(id);
      model.addAttribute("intern", intern);

      if (edit == null || !edit.equals("true"))
      {
         return "viewIntern";
      }

      else
      {

         return "updateIntern";
      }
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.POST)
   public String updatePost(@PathVariable("id")
   Long id, Intern intern)
   {
      internDao.update(intern);
      return "viewIntern";
   }

   @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
   public String updateIntern(@PathVariable("id")
   Long id, Intern intern)
   {
      internDao.delete(id);
      return "redirect:/interns";
   }

   @RequestMapping(value = "/create", method = RequestMethod.GET)
   public String createIntern(Model model)
   {

      model.addAttribute("intern", new Intern());
      return "createIntern";
   }

   @RequestMapping(value = "/create", method = RequestMethod.POST)
   public String createIntern(Intern intern)
   {
      internDao.create(intern);
      return "redirect:/interns";
   }
}
