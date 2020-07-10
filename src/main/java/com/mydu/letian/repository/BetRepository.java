package com.mydu.letian.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mydu.letian.entity.Base;
import com.mydu.letian.entity.Bet;
import com.mydu.letian.entity.BetType;
import com.mydu.letian.entity.User;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long>{
	
	List<Bet> findAll();
	
	@Query("select b from Bet b where b.baseIn =:baseIn")
	List<Bet> getByBaseIn(Base base);
	
	List<Bet> findByUser(User user);
	
	@Query("select b from Bet b where b.baseIn =:baseIn and b.betType =:betType")
	List<Bet> getByBaseInAndBetType(@Param("baseIn") Base baseIn, @Param("betType") BetType betType);
	
	@Query("select b from Bet b where b.baseIn =:baseIn and b.betDate =:betDate and b.betType =:betType")
	List<Bet> getByBaseInAndBetDateAndBetType(@Param("baseIn") Base baseIn, @Param("betDate") Date date, @Param("betType") BetType betType);
	
	List<Bet> findByUserAndBetType(User user, BetType betType);
	
	List<Bet> findByBaseOutAndBetDateAndBetType(Base baseOut, Date betDate, BetType betType);
	
	List<Bet> findByBetDateAndBetType(Date date, BetType betType);
}
