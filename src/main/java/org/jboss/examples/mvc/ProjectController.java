package org.jboss.examples.mvc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.jboss.examples.model.Project;
import org.jboss.examples.repo.ProjectDao;

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
@RequestMapping("/projects")
public class ProjectController {

	// Inject the appropriate data-access object for the given entity.

	@Autowired
	private ProjectDao projectDao;

	// Inject data-access objects for any inter-entity relationships.

	@Autowired
	private InternDao internDao;

	@RequestMapping(method = RequestMethod.GET)
	public @ModelAttribute("entities")
	List<Project> viewProjects(@ModelAttribute("search") Project search) {
		List<Project> projects = projectDao.search(search);
		return projects;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewProject(@PathVariable("id") Long id, Model model,
			@RequestParam(required = false) String edit) {
		// Project project = projectDao.getById(id);
		List<Project> projects = projectDao.getAll();
		for (Project project2 : projects) {
			if (project2.getId().equals(id)) {
				model.addAttribute("project", project2);
			}
		}

		if (edit == null || !edit.equals("true")) {
			return "viewProject";
		}

		else {

			model.addAttribute("interns", internDao.getAll());

			return "updateProject";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updatePost(@PathVariable("id") Long id, Project project) {
		projectDao.update(project);
		return "viewProject";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String updateProject(@PathVariable("id") Long id, Project project) {
		projectDao.delete(id);
		return "redirect:/projects";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createProject(Model model) {

		model.addAttribute("interns", internDao.getAll());

		model.addAttribute("project", new Project());

		return "createProject";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createProject(Project project) {
		projectDao.create(project);
		return "redirect:/projects";
	}
}
