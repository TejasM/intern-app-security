package org.jboss.examples.converters;

import org.jboss.examples.model.Intern;
import org.jboss.examples.repo.InternDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class InternConverter implements Converter<String, Intern> {
	
	@Autowired
	private InternDao internDao;

    public Intern convert(String username) {
        return internDao.getById(Long.parseLong(username));
    }

}
