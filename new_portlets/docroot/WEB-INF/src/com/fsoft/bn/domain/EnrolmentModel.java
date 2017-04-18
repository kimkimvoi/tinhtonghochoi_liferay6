package com.fsoft.bn.domain;

import com.liferay.portal.kernel.util.StringPool;

public class EnrolmentModel {
	private String enrolmentId;
	private String hs_ten;
	private String hs_hoten;
	private String hs_ho;
	private String hs_quoc_tich;
	private String hs_ngay_sinh;
	private String hs_so_dien_thoai;
	private String hs_nguoi_lien_he;
	private String hs_quan_he_voi_hoc_sinh;
	private String hk_dia_chi;
	private String hk_thanh_pho;
	private String hk_tinh;
	private String hk_quoc_gia;
	private String cm_ten;
	private String cm_ho;
	private String cm_hoten;
	private String cm_quan_he_voi_hoc_sinh;
	private String cm_dia_chi_email;
	private String cm_so_dien_thoai_di_dong;
	private String cm_dien_thoai_noi_lam_viec;
	private String cm_ten_cong_ty;
	private String cm_chuc_danh;
	private String k_lop;
	private String k_nam_hoc;
	private String k_truong_hien_dang_hoc;
	private String k_sao_ma_biet_den;
	private String k_nguoi_gioi_thieu;
	private String k_thac_mac;
	private String trang_thai;
	private String ngay_tao;
	private String ngay_chinh_sua;
	private boolean khong_hop_le;
	private String trang_thai_hien_thi;
	
	public EnrolmentModel() {
		this.hs_ten = StringPool.BLANK;
		this.hs_ho = StringPool.BLANK;
		this.hs_quoc_tich = StringPool.BLANK;
		this.hs_ngay_sinh = StringPool.BLANK;
		this.hs_so_dien_thoai = StringPool.BLANK;
		this.hs_nguoi_lien_he = StringPool.BLANK;
		this.hs_quan_he_voi_hoc_sinh = StringPool.BLANK;
		this.hk_dia_chi = StringPool.BLANK;
		this.hk_thanh_pho = StringPool.BLANK;
		this.hk_tinh = StringPool.BLANK;
		this.hk_quoc_gia = StringPool.BLANK;
		this.cm_ten = StringPool.BLANK;
		this.cm_ho = StringPool.BLANK;
		this.cm_quan_he_voi_hoc_sinh = StringPool.BLANK;
		this.cm_dia_chi_email = StringPool.BLANK;
		this.cm_so_dien_thoai_di_dong = StringPool.BLANK;
		this.cm_dien_thoai_noi_lam_viec = StringPool.BLANK;
		this.cm_ten_cong_ty = StringPool.BLANK;
		this.cm_chuc_danh = StringPool.BLANK;
		this.k_lop = StringPool.BLANK;
		this.k_nam_hoc = StringPool.BLANK;
		this.k_truong_hien_dang_hoc = StringPool.BLANK;
		this.k_sao_ma_biet_den = StringPool.BLANK;
		this.k_nguoi_gioi_thieu = StringPool.BLANK;
		this.k_thac_mac = StringPool.BLANK;
		this.trang_thai = "1";
		this.ngay_tao = StringPool.BLANK;
		this.ngay_chinh_sua = StringPool.BLANK;
		this.khong_hop_le = false;
	}
	
	/**
	 * @return the hs_ten
	 */
	public String getHs_ten() {
		return hs_ten;
	}
	/**
	 * @param hs_ten the hs_ten to set
	 */
	public void setHs_ten(String hs_ten) {
		this.hs_ten = hs_ten;
	}
	/**
	 * @return the hs_ho
	 */
	public String getHs_ho() {
		return hs_ho;
	}
	/**
	 * @param hs_ho the hs_ho to set
	 */
	public void setHs_ho(String hs_ho) {
		this.hs_ho = hs_ho;
	}
	/**
	 * @return the hs_quoc_tich
	 */
	public String getHs_quoc_tich() {
		return hs_quoc_tich;
	}
	/**
	 * @param hs_quoc_tich the hs_quoc_tich to set
	 */
	public void setHs_quoc_tich(String hs_quoc_tich) {
		this.hs_quoc_tich = hs_quoc_tich;
	}
	/**
	 * @return the hs_ngay_sinh
	 */
	public String getHs_ngay_sinh() {
		return hs_ngay_sinh;
	}
	/**
	 * @param hs_ngay_sinh the hs_ngay_sinh to set
	 */
	public void setHs_ngay_sinh(String hs_ngay_sinh) {
		this.hs_ngay_sinh = hs_ngay_sinh;
	}
	/**
	 * @return the hs_so_dien_thoai
	 */
	public String getHs_so_dien_thoai() {
		return hs_so_dien_thoai;
	}
	/**
	 * @param hs_so_dien_thoai the hs_so_dien_thoai to set
	 */
	public void setHs_so_dien_thoai(String hs_so_dien_thoai) {
		this.hs_so_dien_thoai = hs_so_dien_thoai;
	}
	/**
	 * @return the hs_nguoi_lien_he
	 */
	public String getHs_nguoi_lien_he() {
		return hs_nguoi_lien_he;
	}
	/**
	 * @param hs_nguoi_lien_he the hs_nguoi_lien_he to set
	 */
	public void setHs_nguoi_lien_he(String hs_nguoi_lien_he) {
		this.hs_nguoi_lien_he = hs_nguoi_lien_he;
	}
	/**
	 * @return the hs_quan_he_voi_hoc_sinh
	 */
	public String getHs_quan_he_voi_hoc_sinh() {
		return hs_quan_he_voi_hoc_sinh;
	}
	/**
	 * @param hs_quan_he_voi_hoc_sinh the hs_quan_he_voi_hoc_sinh to set
	 */
	public void setHs_quan_he_voi_hoc_sinh(String hs_quan_he_voi_hoc_sinh) {
		this.hs_quan_he_voi_hoc_sinh = hs_quan_he_voi_hoc_sinh;
	}
	/**
	 * @return the hk_dia_chi
	 */
	public String getHk_dia_chi() {
		return hk_dia_chi;
	}
	/**
	 * @param hk_dia_chi the hk_dia_chi to set
	 */
	public void setHk_dia_chi(String hk_dia_chi) {
		this.hk_dia_chi = hk_dia_chi;
	}
	/**
	 * @return the hk_thanh_pho
	 */
	public String getHk_thanh_pho() {
		return hk_thanh_pho;
	}
	/**
	 * @param hk_thanh_pho the hk_thanh_pho to set
	 */
	public void setHk_thanh_pho(String hk_thanh_pho) {
		this.hk_thanh_pho = hk_thanh_pho;
	}
	/**
	 * @return the hk_tinh
	 */
	public String getHk_tinh() {
		return hk_tinh;
	}
	/**
	 * @param hk_tinh the hk_tinh to set
	 */
	public void setHk_tinh(String hk_tinh) {
		this.hk_tinh = hk_tinh;
	}
	/**
	 * @return the hk_quoc_gia
	 */
	public String getHk_quoc_gia() {
		return hk_quoc_gia;
	}
	/**
	 * @param hk_quoc_gia the hk_quoc_gia to set
	 */
	public void setHk_quoc_gia(String hk_quoc_gia) {
		this.hk_quoc_gia = hk_quoc_gia;
	}
	/**
	 * @return the cm_ten
	 */
	public String getCm_ten() {
		return cm_ten;
	}
	/**
	 * @param cm_ten the cm_ten to set
	 */
	public void setCm_ten(String cm_ten) {
		this.cm_ten = cm_ten;
	}
	/**
	 * @return the cm_ho
	 */
	public String getCm_ho() {
		return cm_ho;
	}
	/**
	 * @param cm_ho the cm_ho to set
	 */
	public void setCm_ho(String cm_ho) {
		this.cm_ho = cm_ho;
	}
	/**
	 * @return the cm_quan_he_voi_hoc_sinh
	 */
	public String getCm_quan_he_voi_hoc_sinh() {
		return cm_quan_he_voi_hoc_sinh;
	}
	/**
	 * @param cm_quan_he_voi_hoc_sinh the cm_quan_he_voi_hoc_sinh to set
	 */
	public void setCm_quan_he_voi_hoc_sinh(String cm_quan_he_voi_hoc_sinh) {
		this.cm_quan_he_voi_hoc_sinh = cm_quan_he_voi_hoc_sinh;
	}
	/**
	 * @return the cm_dia_chi_email
	 */
	public String getCm_dia_chi_email() {
		return cm_dia_chi_email;
	}
	/**
	 * @param cm_dia_chi_email the cm_dia_chi_email to set
	 */
	public void setCm_dia_chi_email(String cm_dia_chi_email) {
		this.cm_dia_chi_email = cm_dia_chi_email;
	}
	/**
	 * @return the cm_so_dien_thoai_di_dong
	 */
	public String getCm_so_dien_thoai_di_dong() {
		return cm_so_dien_thoai_di_dong;
	}
	/**
	 * @param cm_so_dien_thoai_di_dong the cm_so_dien_thoai_di_dong to set
	 */
	public void setCm_so_dien_thoai_di_dong(String cm_so_dien_thoai_di_dong) {
		this.cm_so_dien_thoai_di_dong = cm_so_dien_thoai_di_dong;
	}
	/**
	 * @return the cm_dien_thoai_noi_lam_viec
	 */
	public String getCm_dien_thoai_noi_lam_viec() {
		return cm_dien_thoai_noi_lam_viec;
	}
	/**
	 * @param cm_dien_thoai_noi_lam_viec the cm_dien_thoai_noi_lam_viec to set
	 */
	public void setCm_dien_thoai_noi_lam_viec(String cm_dien_thoai_noi_lam_viec) {
		this.cm_dien_thoai_noi_lam_viec = cm_dien_thoai_noi_lam_viec;
	}
	/**
	 * @return the cm_ten_cong_ty
	 */
	public String getCm_ten_cong_ty() {
		return cm_ten_cong_ty;
	}
	/**
	 * @param cm_ten_cong_ty the cm_ten_cong_ty to set
	 */
	public void setCm_ten_cong_ty(String cm_ten_cong_ty) {
		this.cm_ten_cong_ty = cm_ten_cong_ty;
	}
	/**
	 * @return the cm_chuc_danh
	 */
	public String getCm_chuc_danh() {
		return cm_chuc_danh;
	}
	/**
	 * @param cm_chuc_danh the cm_chuc_danh to set
	 */
	public void setCm_chuc_danh(String cm_chuc_danh) {
		this.cm_chuc_danh = cm_chuc_danh;
	}
	/**
	 * @return the k_lop
	 */
	public String getK_lop() {
		return k_lop;
	}
	/**
	 * @param k_lop the k_lop to set
	 */
	public void setK_lop(String k_lop) {
		this.k_lop = k_lop;
	}
	/**
	 * @return the k_nam_hoc
	 */
	public String getK_nam_hoc() {
		return k_nam_hoc;
	}
	/**
	 * @param k_nam_hoc the k_nam_hoc to set
	 */
	public void setK_nam_hoc(String k_nam_hoc) {
		this.k_nam_hoc = k_nam_hoc;
	}
	/**
	 * @return the k_truong_hien_dang_hoc
	 */
	public String getK_truong_hien_dang_hoc() {
		return k_truong_hien_dang_hoc;
	}
	/**
	 * @param k_truong_hien_dang_hoc the k_truong_hien_dang_hoc to set
	 */
	public void setK_truong_hien_dang_hoc(String k_truong_hien_dang_hoc) {
		this.k_truong_hien_dang_hoc = k_truong_hien_dang_hoc;
	}
	/**
	 * @return the k_sao_ma_biet_den
	 */
	public String getK_sao_ma_biet_den() {
		return k_sao_ma_biet_den;
	}
	/**
	 * @param k_sao_ma_biet_den the k_sao_ma_biet_den to set
	 */
	public void setK_sao_ma_biet_den(String k_sao_ma_biet_den) {
		this.k_sao_ma_biet_den = k_sao_ma_biet_den;
	}
	/**
	 * @return the k_nguoi_gioi_thieu
	 */
	public String getK_nguoi_gioi_thieu() {
		return k_nguoi_gioi_thieu;
	}
	/**
	 * @param k_nguoi_gioi_thieu the k_nguoi_gioi_thieu to set
	 */
	public void setK_nguoi_gioi_thieu(String k_nguoi_gioi_thieu) {
		this.k_nguoi_gioi_thieu = k_nguoi_gioi_thieu;
	}
	/**
	 * @return the k_thac_mac
	 */
	public String getK_thac_mac() {
		return k_thac_mac;
	}
	/**
	 * @param k_thac_mac the k_thac_mac to set
	 */
	public void setK_thac_mac(String k_thac_mac) {
		this.k_thac_mac = k_thac_mac;
	}
	/**
	 * @return the trang_thai
	 */
	public String getTrang_thai() {
		return trang_thai;
	}
	/**
	 * @param trang_thai the trang_thai to set
	 */
	public void setTrang_thai(String trang_thai) {
		this.trang_thai = trang_thai;
	}
	/**
	 * @return the ngay_tao
	 */
	public String getNgay_tao() {
		return ngay_tao;
	}
	/**
	 * @param ngay_tao the ngay_tao to set
	 */
	public void setNgay_tao(String ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	/**
	 * @return the ngay_chinh_sua
	 */
	public String getNgay_chinh_sua() {
		return ngay_chinh_sua;
	}
	/**
	 * @param ngay_chinh_sua the ngay_chinh_sua to set
	 */
	public void setNgay_chinh_sua(String ngay_chinh_sua) {
		this.ngay_chinh_sua = ngay_chinh_sua;
	}
	/**
	 * @return the khong_hop_le
	 */
	public boolean isKhong_hop_le() {
		return khong_hop_le;
	}
	/**
	 * @param khong_hop_le the khong_hop_le to set
	 */
	public void setKhong_hop_le(boolean khong_hop_le) {
		this.khong_hop_le = khong_hop_le;
	}

	/**
	 * @return the enrolmentId
	 */
	public String getEnrolmentId() {
		return enrolmentId;
	}

	/**
	 * @param enrolmentId the enrolmentId to set
	 */
	public void setEnrolmentId(String enrolmentId) {
		this.enrolmentId = enrolmentId;
	}

	/**
	 * @return the hs_hoten
	 */
	public String getHs_hoten() {
		return hs_hoten;
	}

	/**
	 * @param hs_hoten the hs_hoten to set
	 */
	public void setHs_hoten(String hs_hoten) {
		this.hs_hoten = hs_hoten;
	}

	/**
	 * @return the cm_hoten
	 */
	public String getCm_hoten() {
		return cm_hoten;
	}

	/**
	 * @param cm_hoten the cm_hoten to set
	 */
	public void setCm_hoten(String cm_hoten) {
		this.cm_hoten = cm_hoten;
	}

	/**
	 * @return the trang_thai_hien_thi
	 */
	public String getTrang_thai_hien_thi() {
		return trang_thai_hien_thi;
	}

	/**
	 * @param trang_thai_hien_thi the trang_thai_hien_thi to set
	 */
	public void setTrang_thai_hien_thi(String trang_thai_hien_thi) {
		this.trang_thai_hien_thi = trang_thai_hien_thi;
	}
	
}
