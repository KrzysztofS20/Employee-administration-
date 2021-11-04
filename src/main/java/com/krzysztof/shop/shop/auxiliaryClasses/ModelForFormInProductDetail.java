package com.krzysztof.shop.shop.auxiliaryClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelForFormInProductDetail {

    int quantityOfProduct;

    public ModelForFormInProductDetail(int quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }
}
