package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    EntityManager em;

    // 신규 데이터 저장뿐만 아니라 변경된 데이터의 저장이라는 의미도 포함한다.
    // 이렇게 함으로써 이 메서드를 사용하는 클라이언트는 저장과 수정을 구분하지 않아도 되므로
    // 클라이언트의 로직이 단순해진다.
    public void save(Item item){
        // id가 신규면 새롭게 저장
        if (item.getId() == null) {
            em.persist(item);  // 새로운 엔티티로 판단해 영속화
        } else {
            // 있으면 저장된 엔티티를 수정한다고 보고 실행
            em.merge(item);  // 식별자가 있는 경우(준영속 상태인 경우) 병합
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
