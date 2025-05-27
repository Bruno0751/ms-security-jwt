package com.dev.spring_security.api;

import com.dev.spring_security.dtos.ProductsRecordDto;
import com.dev.spring_security.model.ProductsModel;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Api(tags = {"Products"})
@RequestMapping("/v1/products")
public interface ProductsApi {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "")
    ProductsModel insert(@RequestBody @Valid ProductsRecordDto freguesRecordDto);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "")
    List<ProductsModel> find();
}
