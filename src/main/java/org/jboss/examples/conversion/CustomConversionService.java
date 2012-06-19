package org.jboss.examples.conversion;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;
import org.jboss.examples.repo.InternDao;
import org.jboss.examples.converters.InternConverter;

public class CustomConversionService extends DefaultConversionService implements InitializingBean
{
   @Override
   public void afterPropertiesSet() throws Exception
   {
     
   }

   @Autowired
   private InternDao internDao;
}