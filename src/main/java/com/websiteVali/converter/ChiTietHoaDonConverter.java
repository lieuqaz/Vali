package com.websiteVali.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websiteVali.dto.ChiTietHoaDonDTO;
import com.websiteVali.dto.MauSanPhamDTO;
import com.websiteVali.entity.ChiTietHoaDon;
import com.websiteVali.entity.HoaDon;
import com.websiteVali.entity.MauSanPham;
import com.websiteVali.service.HoaDonService;
import com.websiteVali.service.MauSanPhamService;

@Component
public class ChiTietHoaDonConverter {

	@Autowired
	private MauSanPhamService mauSanPhamService;
	@Autowired
	private HoaDonService hoaDonService;
	@Autowired
	private MauSanPhamConverter mauSanPhamConverter;

	public ChiTietHoaDon toChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDonDTO) {

		if (chiTietHoaDonDTO == null) {
			return null;
		}
		try {
			String maSanPham = chiTietHoaDonDTO.getMauSanPhamDTO().getMaSanPham();
			System.out.println("maSanPham: " + maSanPham);
			int maMau = chiTietHoaDonDTO.getMauSanPhamDTO().getMaMau();
			System.out.println("maMau: " + maMau);
			String maHoaDon = chiTietHoaDonDTO.getMaHoaDon();
			System.out.println("maHoaDon: " + maHoaDon);
			int soLuong = chiTietHoaDonDTO.getSoLuong();
			System.out.println("soLuong: " + soLuong);
			HoaDon hoaDon = hoaDonService.getHoaDonTheoId(maHoaDon);
			System.out.println("hoaDon: " + hoaDon);
			MauSanPham mauSanPham = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(maSanPham, maMau);
			System.out.println("mauSanPham: " + mauSanPham);
		

			ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(mauSanPham, hoaDon, soLuong);

			return chiTietHoaDon;
		} catch (Exception e) {
			System.out.println("erorr: " + e);
			return null;
		}

	}

	public ChiTietHoaDonDTO toChiTietHoaDonDTO(ChiTietHoaDon chiTietHoaDon) {

		if (chiTietHoaDon == null)
			return null;

		String maHoaDon = chiTietHoaDon.getHoaDon().getId();

		MauSanPhamDTO mauSanPhamDTO = mauSanPhamConverter.toMauSanPhamDTO(chiTietHoaDon.getMauSanPham());

		int soLuong = chiTietHoaDon.getSoLuong();
		double giaBan = chiTietHoaDon.getMauSanPham().getSanPham().getGiaBan();
		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO(maHoaDon, mauSanPhamDTO, soLuong, giaBan);

		return chiTietHoaDonDTO;
	}

}
