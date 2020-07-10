package com.mydu.letian.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mydu.letian.entity.BetType;

@Repository
public interface BetTypeRepository extends CrudRepository<BetType, Long>{
	BetType findByTypeId(int id);
}
