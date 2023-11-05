package com.websiteVali.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websiteVali.dto.NguoiDungDTO;
import com.websiteVali.dto.ThuongHieuDTO;
import com.websiteVali.entity.DongSanPham;
import com.websiteVali.entity.LoaiSanPham;
import com.websiteVali.service.DongSanPhamService;
import com.websiteVali.service.LoaiSanPhamService;
import com.websiteVali.service.NguoiDungService;
import com.websiteVali.validator.UserValidator;

@Controller
public class DangNhapController {

	@Autowired
	private NguoiDungService userService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@RequestMapping("/login")
	public String login(Model model) {
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();
		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("pageTitle", "Đăng Nhập");
		return "login/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		String userId = RandomStringUtils.randomNumeric(8);
		NguoiDungDTO userDTO = new NguoiDungDTO(userId);

		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();
		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);

		model.addAttribute("pageTitle", "Ä�Äƒng kÃ­ tÃ i khoáº£n");
		model.addAttribute("user", userDTO);
		return "login/register";
	}

	@PostMapping(value = "/register")
	public String register(Model model, HttpServletRequest request, @ModelAttribute("user") NguoiDungDTO userDTO,
			BindingResult bindingResult) {

		userValidator.validate(userDTO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("pageTitle", "Ä�Äƒng kÃ­ tÃ i khoáº£n");
			return "login/register";
		}

		String baseUrl = "http://" + request.getHeader("host");

		NguoiDungDTO dto = userService.getByEmail(userDTO.getEmail());

		if (dto != null) {
			model.addAttribute("pageTitle", "Ä�Äƒng kÃ­ tÃ i khoáº£n");
			return "login/register";
		}
		userService.registrationVerifyUserByEmail(userDTO, baseUrl);

		return "redirect:/login";
	}

	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/trang-chu";
	}
}
