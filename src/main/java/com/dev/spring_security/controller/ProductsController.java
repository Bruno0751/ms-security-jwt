package com.dev.spring_security.controller;

import com.dev.spring_security.api.ProductsApi;
import com.dev.spring_security.dtos.ProductsRecordDto;
import com.dev.spring_security.model.ProductsModel;
import com.dev.spring_security.repositories.ProductsRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Component
@RestController
public class ProductsController implements ProductsApi {

    @Autowired
    ProductsRepository freguesRepository;

    @Override
    public ProductsModel insert(ProductsRecordDto freguesRecordDto) {
        var freguesModel = new ProductsModel();
        BeanUtils.copyProperties(freguesRecordDto, freguesModel);
        try {
            freguesModel = freguesRepository.save(freguesModel);
            return freguesModel;
        } catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(violation -> {
                System.out.println(violation.getMessage());
            });
        }
        return null;
    }

    @Override
    public List<ProductsModel> find() {
        return freguesRepository.findAll();
    }
}
