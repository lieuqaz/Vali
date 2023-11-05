package com.websiteVali.service.impl;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.websiteVali.converter.NguoiDungConverter;
import com.websiteVali.dto.NguoiDungDTO;
import com.websiteVali.entity.NguoiDung;
import com.websiteVali.entity.ROLE;
import com.websiteVali.repository.HoaDonRepository;
import com.websiteVali.repository.NguoiDungRepository;
import com.websiteVali.service.NguoiDungService;


@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Autowired
	private NguoiDungConverter nguoiDungConverter;




	@Override
	public NguoiDungDTO getByEmail(String email) {
		NguoiDung user = nguoiDungRepository.findByEmail(email);

		if (user != null) {
			NguoiDungDTO dto = nguoiDungConverter.toNguoiDungDTO(user);
			return dto;
		} else {
			return null;
		}

	}

	@Override
	public boolean registrationVerifyUserByEmail(NguoiDungDTO userDTO, String host) {
		boolean result = false;

		try {
			userDTO.setRole(ROLE.ROLE_USER);

			String id = save(userDTO).getUserId();

			NguoiDung user = nguoiDungRepository.findById(id).get();


			nguoiDungRepository.save(user);

			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}


	@Override
	public NguoiDungDTO save(NguoiDungDTO userDTO) {
		if (userDTO == null)
			return null;
//		NguoiDung userOld = nguoiDungRepository.findById(userDTO.getUserId()).get();
		NguoiDung userOld = new NguoiDung();

		NguoiDung user = nguoiDungRepository.save(nguoiDungConverter.toNguoiDung(userDTO, userOld));

		NguoiDungDTO userDTO2 = nguoiDungConverter.toNguoiDungDTO(user);
		return userDTO2;

	}



	@Override
	public String[] handleAddress(String diaChi) {
		String[] temp = diaChi.split(", ");
		return temp;
	}

	@Override
	public boolean updateAddress(String userId) {
		NguoiDung nguoiDung = nguoiDungRepository.findById(userId).get();
		return nguoiDung == null ? false : true;
	}

	@Override
	public NguoiDung getNguoiDungTheoEmail(String email) {
		
		return nguoiDungRepository.findByEmail(email);
	}

	@Override
	public List<NguoiDung> timKiemNguoiDung(String hoTen, String soDienThoai, String email, int page, int size) {
		return nguoiDungRepository.findByHoTenContainingAndSoDienThoaiContainingAndEmailContainingAndRole(hoTen, soDienThoai, email, ROLE.ROLE_USER, PageRequest.of(page, size));
	}

	@Override
	public boolean XoaNguoiDung(String id) {
		NguoiDung nguoiDung = nguoiDungRepository.findById(id).get();
		if(nguoiDung == null) {
			return false;
		}
		else if(hoaDonRepository.getHoaDonByNguoiDungId(nguoiDung.getId()) != null) {
			return false;
		}
		nguoiDungRepository.delete(nguoiDung);
		return true;
	}

	@Override
	public NguoiDung getNguoiDungById(String id) {
		return nguoiDungRepository.findById(id).get();
	}

	@Override
	public void capNhatNguoiDung(NguoiDung nguoiDung) {
		nguoiDungRepository.save(nguoiDung);
	}
	
}
