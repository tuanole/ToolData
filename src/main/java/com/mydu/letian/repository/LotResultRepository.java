package com.mydu.letian.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mydu.letian.entity.LotResult;

@Repository
public interface LotResultRepository extends CrudRepository<LotResult, Long>{
	List<LotResult> findByLotRank(int rank);
	
	List<LotResult> findAll();
	
	List<LotResult> findByLotDateOrderByLotRankAsc(Date date);
	
	List<LotResult> findByLotDate(Date date);
	
	
	@Query("select l from LotResult l where l.lotDate =:date and l.lotPrize =:prize")
	LotResult getByLotDateAndLotPrize(@Param("date")Date date,@Param("prize") int prize);
}
