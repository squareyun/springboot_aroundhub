package studio.square.testproject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.square.testproject.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    // ProductEntity : repository가 사용할 entity
    // String : primary key의 data type 값
}
