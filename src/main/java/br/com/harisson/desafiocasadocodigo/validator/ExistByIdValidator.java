package br.com.harisson.desafiocasadocodigo.validator;

import br.com.harisson.desafiocasadocodigo.annotation.ExistById;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistByIdValidator implements ConstraintValidator<ExistById, Object> {

    private String fieldIdName;
    private Class<?> clazz;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void initialize(ExistById constraintAnnotation) {
        fieldIdName = constraintAnnotation.idFieldName();
        clazz = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select a from " + clazz.getName() + " a where a."+fieldIdName+" =:value");
        query.setParameter("value", o);
        List<?> list = query.getResultList();
        return !list.isEmpty();
    }
}
