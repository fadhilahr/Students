package com.bootcamp.siswa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootcamp.siswa.entity.Siswa;




@Repository
public interface SiswaRepo extends JpaRepository<Siswa, String> {
	

		
	@Query(value = "SELECT u FROM Siswa u", countQuery = "SELECT COUNT(u) FROM Siswa u")
	Page<Siswa> findPage(Pageable pageable);
}
