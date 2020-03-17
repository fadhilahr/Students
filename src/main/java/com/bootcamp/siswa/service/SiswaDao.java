package com.bootcamp.siswa.service;

import java.util.List;


import com.bootcamp.siswa.entity.Siswa;

public interface SiswaDao {
	
	List<Siswa> getAllSiswa() throws Exception;
	Siswa addSiswa (Siswa siswa) throws Exception;
	Siswa updateSiswa (String id, Siswa updateSiswa) throws Exception;
	String deleteSiswaById (String id) throws Exception;
	Siswa getSiswaById(String id) throws Exception;
	

}
