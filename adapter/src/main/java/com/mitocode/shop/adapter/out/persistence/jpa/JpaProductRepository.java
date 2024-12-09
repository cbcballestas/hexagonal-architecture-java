package com.mitocode.shop.adapter.out.persistence.jpa;

import com.mitocode.shop.adapter.out.persistence.DemoProducts;
import com.mitocode.shop.application.port.out.persistence.ProductRepository;
import com.mitocode.shop.model.product.Product;
import com.mitocode.shop.model.product.ProductId;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@ConditionalOnProperty(name = "persistence", havingValue = "mysql")
@Repository
@RequiredArgsConstructor
public class JpaProductRepository implements ProductRepository {

    private final JpaProductClassSpringDataRepository productRepository;

    @PostConstruct
    private void createDemoProducts() {
        DemoProducts.DEMO_PRODUCTS.forEach(this::save);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(ProductMapper.toJpaEntity(product));
    }

    @Override
    @Transactional
    public Optional<Product> findById(ProductId productId) {
        return productRepository.findById(productId.value())
                .flatMap(ProductMapper::toModelEntityOptional);
    }

    @Override
    @Transactional
    public List<Product> findByNameOrDescription(String queryString) {
        return ProductMapper.toModelEntities(productRepository.findByNameOrDescriptionLike("%" + queryString + "%"));
    }

}
