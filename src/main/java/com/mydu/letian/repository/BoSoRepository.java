package com.mydu.letian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mydu.letian.entity.BoSo;

@Repository
public interface BoSoRepository extends CrudRepository<BoSo, Long>{

	List<BoSo> findAll();
	
	List<BoSo> findByBoName(String name);
	
	@Query("select distinct b.boName from BoSo b")
	List<String> findAllBoName();
	
	@Query("select b from BoSo b where b.id =:id")
	BoSo getById(@Param("id")Long id);
}
