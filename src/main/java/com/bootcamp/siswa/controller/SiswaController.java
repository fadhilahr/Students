package com.bootcamp.siswa.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.siswa.dto.SiswaDto;
import com.bootcamp.siswa.entity.Siswa;
import com.bootcamp.siswa.service.SiswaDao;
import com.bootcamp.siswa.util.CommonResponse;
import com.bootcamp.siswa.util.CommonResponseGenerator;
import com.bootcamp.siswa.util.JsonUtil;


@RestController
@RequestMapping(path="",produces = "application/json; charset=UTF-8")
public class SiswaController {
	
	@Autowired
	private SiswaDao siswaDao;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private CommonResponseGenerator comGen;
	
	private static final String SISWA_ADDR ="/siswa";
	private static final String SISWA_PATH_VARIABLE_ID = "id";
	private static final String SISWA_PATH_VARIABLE_NAMA = "nama";
	private static final String SISWA_BY_ID_ADDR = SISWA_ADDR + "/{" + SISWA_PATH_VARIABLE_ID + "}";
	private static final String SISWA_BY_NAMA_ADDR = SISWA_ADDR + SISWA_PATH_VARIABLE_NAMA+ "/{"+ SISWA_PATH_VARIABLE_NAMA +"}" ;
	
	@GetMapping(SISWA_ADDR)
	@CrossOrigin(origins = "*")
	public String getAllSiswa() throws Exception {
		List<SiswaDto> listSiswaDto = siswaDao.getAllSiswa().stream().map(s -> modelMapper.map(s, SiswaDto.class))
				.collect(Collectors.toList());
		CommonResponse<List<SiswaDto>> response = comGen.generateCommonResponse(listSiswaDto);
		return JsonUtil.generateJson(response);
	}
	
	@PostMapping(SISWA_ADDR)
	@CrossOrigin(origins = "*")
	public String addSiswa(@RequestBody Siswa siswa) throws Exception {
		SiswaDto siswaDto = modelMapper.map(siswaDao.addSiswa(siswa), SiswaDto.class);
		CommonResponse<SiswaDto> response = comGen.generateCommonResponse(siswaDto);
		return JsonUtil.generateJson(response);
		
	}
	
	@PutMapping(SISWA_BY_ID_ADDR)
	@CrossOrigin(origins = "*")
	public String updateSiswa(@PathVariable(value = "id") String id, @RequestBody Siswa updateSiswa) throws Exception {
		SiswaDto siswaDto = modelMapper.map(siswaDao.updateSiswa(id, updateSiswa), SiswaDto.class);
		CommonResponse<SiswaDto> response = comGen.generateCommonResponse(siswaDto);
		return JsonUtil.generateJson(response);

	}
	
	@DeleteMapping(SISWA_BY_ID_ADDR)
	@CrossOrigin(origins = "*")
	public String deleteSiswaById(@PathVariable("id") String id) throws Exception {
		String resp = siswaDao.deleteSiswaById(id);
		CommonResponse<String> response = comGen.generateCommonResponse(resp);
		return JsonUtil.generateJson(response);

	}
	
	@GetMapping(SISWA_BY_ID_ADDR)
	@CrossOrigin(origins = "*")
	public String getSiswaById(@PathVariable("id") String id) throws Exception {
		SiswaDto siswaDto = modelMapper.map(siswaDao.getSiswaById(id), SiswaDto.class);
		CommonResponse<SiswaDto> response = comGen.generateCommonResponse(siswaDto);
		return JsonUtil.generateJson(response);
	}
	
	
	
	@ExceptionHandler
	public String exception(Exception e) throws Exception{
		CommonResponse<String> resp = comGen.generateCommonResponse("X01", e.getMessage(), String.class);
		return JsonUtil.generateJson(resp);
	}
	
	

}
