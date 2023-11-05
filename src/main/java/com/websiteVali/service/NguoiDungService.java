package com.websiteVali.service;


import java.util.List;

import com.websiteVali.dto.NguoiDungDTO;
import com.websiteVali.entity.NguoiDung;

public interface NguoiDungService {
	public NguoiDungDTO getByEmail(String email);
	public boolean registrationVerifyUserByEmail(NguoiDungDTO userDTO, String host);
	public NguoiDung getNguoiDungTheoEmail(String email);

	public NguoiDungDTO save(NguoiDungDTO userDTO);

	public String[] handleAddress(String diaChi);
	
	public boolean updateAddress(String userId);
	
	public List<NguoiDung> timKiemNguoiDung(String hoTen, String soDienThoai, String email, int page, int size);
	
	public boolean XoaNguoiDung(String id);
	
	public NguoiDung getNguoiDungById(String id);
	
	public void capNhatNguoiDung(NguoiDung nguoiDung);
	
}
