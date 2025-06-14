package com.dan.coindesk.repository;

import com.dan.coindesk.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ClassName: CurrencyRepository
 * Package: com.dan.coindesk.repository
 * Description:
 *
 * @Author 嘉哥
 * @Create 2025/6/11 下午 02:21
 * @Version 1.0
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

    Optional<Currency> findByCurrencyEn(String currencyEn);

    boolean existsByCurrencyEnOrCurrencyZh(String currencyEn, String currencyZh);
}
