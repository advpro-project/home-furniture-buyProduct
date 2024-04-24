//package com.hoomgroom.buyproduct.repository;
//
//import com.hoomgroom.buyproduct.model.Furniture;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.util.UUID;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNull;
//@DataJpaTest
//public class FurnitureRepositoryTest {
//    @Autowired
//    private FurnitureRepository furnitureRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @BeforeEach
//    public void setUp() {
//        Furniture furniture = new Furniture();
//        furniture = new Furniture();
//        furniture.setId(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"));
//        furniture.setName("Furniture 1");
//        furniture.setType("Type A");
//        furniture.setDescription("lorem ipsum");
//        furniture.setImageUrl("example.url");
//        furniture.setOriginalPrice(1000);
//        furniture.setDiscountedPrice(500);
//        furniture.setHasDiscount(true);
//        entityManager.persist(furniture);
//    }
//
//    @Test
//    public void whenFindByType_thenReturnFurniture() {
//        // given
//        Long furnitureInternalId = 1L;
//        // when
//        Furniture found = furnitureRepository.findByInternalId(1L);
//
//        // then
//        assertThat(found.getInternalId()).isEqualTo(furnitureInternalId);
//    }
//}
