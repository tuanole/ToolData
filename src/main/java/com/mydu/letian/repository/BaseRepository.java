package com.mydu.letian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mydu.letian.entity.Base;

@Repository
public interface BaseRepository extends CrudRepository<Base, Long>{

	List<Base> findAll();
	
	@Query("select b from Base b where b.baseName =:baseName")
	Base findByBaseNameSpec(@Param("baseName") String baseName);
	
	@Query("select b from Base b")
	List<Base> findAllBase();
	
	@Query("select b from Base b where b.baseId =:baseId")
	Base findBaseSpec(@Param("baseId") Long baseId);
	
//	@Transactional
//	@Modifying
//	@Query(value = "update Base b set b.baseName=:baseName, b.baseDes=:baseDes, b.rateLIn=:rateLIn, b.rateLOut=:rateLOut,"
//			+ " b.rateD=:rateD, b.rateX2=:rateX2, b.rateX3=:rateX3, b.rateX4=:rateX4, b.rate3c=:rate3c "
//			+ " where b.baseId=:baseId ")
//	void saveBase(@Param("baseId") Long baseId, @Param("baseName") String baseName,@Param("baseDes") String baseDes,@Param("rateLIn") double rateLIn, 
//			@Param("rateLOut") double rateLOut, @Param("rateD") double rateD, @Param("rateX2") double rateX2, 
//			@Param("rateX3") double rateX3, @Param("rateX4") double rateX4, @Param("rate3c") double rate3c);
	
	@Modifying
	@Query(value = "update dbo.bases set base_name=?, base_des=?, rate_l_in=?, rate_l_out=?, "
			+ "rate_d=?, rate_x2=?, rate_x3=?, rate_x4=?, rate_3c=? "
			+ " where base_id=? ", nativeQuery = true)
	void saveBase( String baseName, String baseDes, double rateLIn, 
			 double rateLOut, double rateD,  double rateX2, 
			 double rateX3, double rateX4, double rate3c, Long baseId);
	
}
