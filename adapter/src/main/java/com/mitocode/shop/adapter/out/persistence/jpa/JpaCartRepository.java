package com.mitocode.shop.adapter.out.persistence.jpa;

import com.mitocode.shop.application.port.out.persistence.CartRepository;
import com.mitocode.shop.model.cart.Cart;
import com.mitocode.shop.model.customer.CustomerId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@ConditionalOnProperty(name = "persistence", havingValue = "mysql")
@Repository
@RequiredArgsConstructor
public class JpaCartRepository implements CartRepository {

    private final JpaCartClassSpringDataRepository cartRepository;

    @Override
    @Transactional
    public void save(Cart cart) {
        cartRepository.save(CartMapper.toJpaEntity(cart));
    }

    @Override
    public Optional<Cart> findByCustomerId(CustomerId customerId) {
        return cartRepository.findByCustomerId(customerId.value()).
                flatMap(CartMapper::toModelEntityOptional);
    }

    @Override
    public void deleteByCustomerId(CustomerId customerId) {
        cartRepository.findByCustomerId(customerId.value())
                .ifPresent(cartRepository::delete);
    }
}
