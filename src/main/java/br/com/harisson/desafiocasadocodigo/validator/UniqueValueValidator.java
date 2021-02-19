package br.com.harisson.desafiocasadocodigo.validator;

import br.com.harisson.desafiocasadocodigo.annotation.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue,Object> {

    private String domainAttribute;
    private Class<?> clazz;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        clazz = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from " + clazz.getName() + " where " + domainAttribute + "=:value");
        query.setParameter("value", o);
        List<?> list = query.getResultList();
        Assert.state(list.size() <=1, "Foi encontrado mais de um " + clazz+" com o atributo " + domainAttribute+ " = " + o);
        return list.isEmpty();
    }
}
