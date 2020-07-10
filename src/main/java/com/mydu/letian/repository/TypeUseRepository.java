package com.mydu.letian.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mydu.letian.entity.BetType;
import com.mydu.letian.entity.TypeUse;

@Repository
public interface TypeUseRepository extends CrudRepository<TypeUse, Long>{

	List<TypeUse> findAll();
	
	List<TypeUse> findByBetType(BetType betType);
}
