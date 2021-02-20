package br.com.harisson.desafiocasadocodigo.util.document;

import br.com.harisson.desafiocasadocodigo.model.request.CustomerPostRequestBody;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class CustomerGroupSequenceProvider implements DefaultGroupSequenceProvider<CustomerPostRequestBody> {
    @Override
    public List<Class<?>> getValidationGroups(CustomerPostRequestBody customerPostRequestBody) {

        List<Class<?>> groups = new ArrayList<>();
        groups.add(CustomerPostRequestBody.class);

        if (customerPostRequestBody != null) {

            if (customerPostRequestBody.getDocument().length() == 14) {
                groups.add(CnpjGroup.class);
            } else {
                groups.add(CpfGroup.class);
            }

        }
        return groups;
    }
}
