package com.dragomir.ecommerce;

import com.dragomir.ecommerce.models.*;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;


@Component
public class ExposeEntityIdRestMvcConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Category.class);
        config.exposeIdsFor(SubCategory.class);
        config.exposeIdsFor(Brand.class);
        config.exposeIdsFor(Product.class);
    }
}