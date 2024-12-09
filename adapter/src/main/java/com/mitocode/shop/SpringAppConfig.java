package com.mitocode.shop;

import com.mitocode.shop.application.port.in.cart.AddToCartUseCase;
import com.mitocode.shop.application.port.in.cart.EmptyCartUseCase;
import com.mitocode.shop.application.port.in.cart.GetCartUseCase;
import com.mitocode.shop.application.port.in.product.FindProductsUseCase;
import com.mitocode.shop.application.port.out.persistence.CartRepository;
import com.mitocode.shop.application.port.out.persistence.ProductRepository;
import com.mitocode.shop.application.service.cart.AddToCartService;
import com.mitocode.shop.application.service.cart.EmptyCartService;
import com.mitocode.shop.application.service.cart.GetCartService;
import com.mitocode.shop.application.service.product.FindProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringAppConfig {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Bean
    FindProductsUseCase findProductsUseCase() {
        return new FindProductsService(productRepository);
    }

    @Bean
    AddToCartUseCase addToCartUseCase() {
        return new AddToCartService(cartRepository, productRepository);
    }

    @Bean
    EmptyCartUseCase emptyCartUseCase() {
        return new EmptyCartService(cartRepository);
    }

    @Bean
    GetCartUseCase getCartUseCase() {
        return new GetCartService(cartRepository);
    }

}
