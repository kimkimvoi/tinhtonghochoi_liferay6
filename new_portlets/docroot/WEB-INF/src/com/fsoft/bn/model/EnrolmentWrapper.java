/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fsoft.bn.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Enrolment}.
 * </p>
 *
 * @author    FSOFT
 * @see       Enrolment
 * @generated
 */
public class EnrolmentWrapper implements Enrolment, ModelWrapper<Enrolment> {
	public EnrolmentWrapper(Enrolment enrolment) {
		_enrolment = enrolment;
	}

	public Class<?> getModelClass() {
		return Enrolment.class;
	}

	public String getModelClassName() {
		return Enrolment.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("enrolment_id", getEnrolment_id());
		attributes.put("hs_ten", getHs_ten());
		attributes.put("hs_ho", getHs_ho());
		attributes.put("hs_quoc_tich", getHs_quoc_tich());
		attributes.put("hs_ngay_sinh", getHs_ngay_sinh());
		attributes.put("hs_so_dien_thoai", getHs_so_dien_thoai());
		attributes.put("hs_nguoi_lien_he", getHs_nguoi_lien_he());
		attributes.put("hs_quan_he_voi_hoc_sinh", getHs_quan_he_voi_hoc_sinh());
		attributes.put("hk_dia_chi", getHk_dia_chi());
		attributes.put("hk_thanh_pho", getHk_thanh_pho());
		attributes.put("hk_tinh", getHk_tinh());
		attributes.put("hk_quoc_gia", getHk_quoc_gia());
		attributes.put("cm_ten", getCm_ten());
		attributes.put("cm_ho", getCm_ho());
		attributes.put("cm_quan_he_voi_hoc_sinh", getCm_quan_he_voi_hoc_sinh());
		attributes.put("cm_dia_chi_email", getCm_dia_chi_email());
		attributes.put("cm_so_dien_thoai_di_dong", getCm_so_dien_thoai_di_dong());
		attributes.put("cm_dien_thoai_noi_lam_viec",
			getCm_dien_thoai_noi_lam_viec());
		attributes.put("cm_ten_cong_ty", getCm_ten_cong_ty());
		attributes.put("cm_chuc_danh", getCm_chuc_danh());
		attributes.put("k_lop", getK_lop());
		attributes.put("k_nam_hoc", getK_nam_hoc());
		attributes.put("k_truong_hien_dang_hoc", getK_truong_hien_dang_hoc());
		attributes.put("k_sao_ma_biet_den", getK_sao_ma_biet_den());
		attributes.put("k_nguoi_gioi_thieu", getK_nguoi_gioi_thieu());
		attributes.put("k_thac_mac", getK_thac_mac());
		attributes.put("trang_thai", getTrang_thai());
		attributes.put("created_date", getCreated_date());
		attributes.put("modified_date", getModified_date());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String enrolment_id = (String)attributes.get("enrolment_id");

		if (enrolment_id != null) {
			setEnrolment_id(enrolment_id);
		}

		String hs_ten = (String)attributes.get("hs_ten");

		if (hs_ten != null) {
			setHs_ten(hs_ten);
		}

		String hs_ho = (String)attributes.get("hs_ho");

		if (hs_ho != null) {
			setHs_ho(hs_ho);
		}

		String hs_quoc_tich = (String)attributes.get("hs_quoc_tich");

		if (hs_quoc_tich != null) {
			setHs_quoc_tich(hs_quoc_tich);
		}

		Date hs_ngay_sinh = (Date)attributes.get("hs_ngay_sinh");

		if (hs_ngay_sinh != null) {
			setHs_ngay_sinh(hs_ngay_sinh);
		}

		String hs_so_dien_thoai = (String)attributes.get("hs_so_dien_thoai");

		if (hs_so_dien_thoai != null) {
			setHs_so_dien_thoai(hs_so_dien_thoai);
		}

		String hs_nguoi_lien_he = (String)attributes.get("hs_nguoi_lien_he");

		if (hs_nguoi_lien_he != null) {
			setHs_nguoi_lien_he(hs_nguoi_lien_he);
		}

		String hs_quan_he_voi_hoc_sinh = (String)attributes.get(
				"hs_quan_he_voi_hoc_sinh");

		if (hs_quan_he_voi_hoc_sinh != null) {
			setHs_quan_he_voi_hoc_sinh(hs_quan_he_voi_hoc_sinh);
		}

		String hk_dia_chi = (String)attributes.get("hk_dia_chi");

		if (hk_dia_chi != null) {
			setHk_dia_chi(hk_dia_chi);
		}

		String hk_thanh_pho = (String)attributes.get("hk_thanh_pho");

		if (hk_thanh_pho != null) {
			setHk_thanh_pho(hk_thanh_pho);
		}

		String hk_tinh = (String)attributes.get("hk_tinh");

		if (hk_tinh != null) {
			setHk_tinh(hk_tinh);
		}

		String hk_quoc_gia = (String)attributes.get("hk_quoc_gia");

		if (hk_quoc_gia != null) {
			setHk_quoc_gia(hk_quoc_gia);
		}

		String cm_ten = (String)attributes.get("cm_ten");

		if (cm_ten != null) {
			setCm_ten(cm_ten);
		}

		String cm_ho = (String)attributes.get("cm_ho");

		if (cm_ho != null) {
			setCm_ho(cm_ho);
		}

		String cm_quan_he_voi_hoc_sinh = (String)attributes.get(
				"cm_quan_he_voi_hoc_sinh");

		if (cm_quan_he_voi_hoc_sinh != null) {
			setCm_quan_he_voi_hoc_sinh(cm_quan_he_voi_hoc_sinh);
		}

		String cm_dia_chi_email = (String)attributes.get("cm_dia_chi_email");

		if (cm_dia_chi_email != null) {
			setCm_dia_chi_email(cm_dia_chi_email);
		}

		String cm_so_dien_thoai_di_dong = (String)attributes.get(
				"cm_so_dien_thoai_di_dong");

		if (cm_so_dien_thoai_di_dong != null) {
			setCm_so_dien_thoai_di_dong(cm_so_dien_thoai_di_dong);
		}

		String cm_dien_thoai_noi_lam_viec = (String)attributes.get(
				"cm_dien_thoai_noi_lam_viec");

		if (cm_dien_thoai_noi_lam_viec != null) {
			setCm_dien_thoai_noi_lam_viec(cm_dien_thoai_noi_lam_viec);
		}

		String cm_ten_cong_ty = (String)attributes.get("cm_ten_cong_ty");

		if (cm_ten_cong_ty != null) {
			setCm_ten_cong_ty(cm_ten_cong_ty);
		}

		String cm_chuc_danh = (String)attributes.get("cm_chuc_danh");

		if (cm_chuc_danh != null) {
			setCm_chuc_danh(cm_chuc_danh);
		}

		String k_lop = (String)attributes.get("k_lop");

		if (k_lop != null) {
			setK_lop(k_lop);
		}

		String k_nam_hoc = (String)attributes.get("k_nam_hoc");

		if (k_nam_hoc != null) {
			setK_nam_hoc(k_nam_hoc);
		}

		String k_truong_hien_dang_hoc = (String)attributes.get(
				"k_truong_hien_dang_hoc");

		if (k_truong_hien_dang_hoc != null) {
			setK_truong_hien_dang_hoc(k_truong_hien_dang_hoc);
		}

		String k_sao_ma_biet_den = (String)attributes.get("k_sao_ma_biet_den");

		if (k_sao_ma_biet_den != null) {
			setK_sao_ma_biet_den(k_sao_ma_biet_den);
		}

		String k_nguoi_gioi_thieu = (String)attributes.get("k_nguoi_gioi_thieu");

		if (k_nguoi_gioi_thieu != null) {
			setK_nguoi_gioi_thieu(k_nguoi_gioi_thieu);
		}

		String k_thac_mac = (String)attributes.get("k_thac_mac");

		if (k_thac_mac != null) {
			setK_thac_mac(k_thac_mac);
		}

		String trang_thai = (String)attributes.get("trang_thai");

		if (trang_thai != null) {
			setTrang_thai(trang_thai);
		}

		Date created_date = (Date)attributes.get("created_date");

		if (created_date != null) {
			setCreated_date(created_date);
		}

		Date modified_date = (Date)attributes.get("modified_date");

		if (modified_date != null) {
			setModified_date(modified_date);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	* Returns the primary key of this enrolment.
	*
	* @return the primary key of this enrolment
	*/
	public java.lang.String getPrimaryKey() {
		return _enrolment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this enrolment.
	*
	* @param primaryKey the primary key of this enrolment
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_enrolment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the enrolment_id of this enrolment.
	*
	* @return the enrolment_id of this enrolment
	*/
	public java.lang.String getEnrolment_id() {
		return _enrolment.getEnrolment_id();
	}

	/**
	* Sets the enrolment_id of this enrolment.
	*
	* @param enrolment_id the enrolment_id of this enrolment
	*/
	public void setEnrolment_id(java.lang.String enrolment_id) {
		_enrolment.setEnrolment_id(enrolment_id);
	}

	/**
	* Returns the hs_ten of this enrolment.
	*
	* @return the hs_ten of this enrolment
	*/
	public java.lang.String getHs_ten() {
		return _enrolment.getHs_ten();
	}

	/**
	* Sets the hs_ten of this enrolment.
	*
	* @param hs_ten the hs_ten of this enrolment
	*/
	public void setHs_ten(java.lang.String hs_ten) {
		_enrolment.setHs_ten(hs_ten);
	}

	/**
	* Returns the hs_ho of this enrolment.
	*
	* @return the hs_ho of this enrolment
	*/
	public java.lang.String getHs_ho() {
		return _enrolment.getHs_ho();
	}

	/**
	* Sets the hs_ho of this enrolment.
	*
	* @param hs_ho the hs_ho of this enrolment
	*/
	public void setHs_ho(java.lang.String hs_ho) {
		_enrolment.setHs_ho(hs_ho);
	}

	/**
	* Returns the hs_quoc_tich of this enrolment.
	*
	* @return the hs_quoc_tich of this enrolment
	*/
	public java.lang.String getHs_quoc_tich() {
		return _enrolment.getHs_quoc_tich();
	}

	/**
	* Sets the hs_quoc_tich of this enrolment.
	*
	* @param hs_quoc_tich the hs_quoc_tich of this enrolment
	*/
	public void setHs_quoc_tich(java.lang.String hs_quoc_tich) {
		_enrolment.setHs_quoc_tich(hs_quoc_tich);
	}

	/**
	* Returns the hs_ngay_sinh of this enrolment.
	*
	* @return the hs_ngay_sinh of this enrolment
	*/
	public java.util.Date getHs_ngay_sinh() {
		return _enrolment.getHs_ngay_sinh();
	}

	/**
	* Sets the hs_ngay_sinh of this enrolment.
	*
	* @param hs_ngay_sinh the hs_ngay_sinh of this enrolment
	*/
	public void setHs_ngay_sinh(java.util.Date hs_ngay_sinh) {
		_enrolment.setHs_ngay_sinh(hs_ngay_sinh);
	}

	/**
	* Returns the hs_so_dien_thoai of this enrolment.
	*
	* @return the hs_so_dien_thoai of this enrolment
	*/
	public java.lang.String getHs_so_dien_thoai() {
		return _enrolment.getHs_so_dien_thoai();
	}

	/**
	* Sets the hs_so_dien_thoai of this enrolment.
	*
	* @param hs_so_dien_thoai the hs_so_dien_thoai of this enrolment
	*/
	public void setHs_so_dien_thoai(java.lang.String hs_so_dien_thoai) {
		_enrolment.setHs_so_dien_thoai(hs_so_dien_thoai);
	}

	/**
	* Returns the hs_nguoi_lien_he of this enrolment.
	*
	* @return the hs_nguoi_lien_he of this enrolment
	*/
	public java.lang.String getHs_nguoi_lien_he() {
		return _enrolment.getHs_nguoi_lien_he();
	}

	/**
	* Sets the hs_nguoi_lien_he of this enrolment.
	*
	* @param hs_nguoi_lien_he the hs_nguoi_lien_he of this enrolment
	*/
	public void setHs_nguoi_lien_he(java.lang.String hs_nguoi_lien_he) {
		_enrolment.setHs_nguoi_lien_he(hs_nguoi_lien_he);
	}

	/**
	* Returns the hs_quan_he_voi_hoc_sinh of this enrolment.
	*
	* @return the hs_quan_he_voi_hoc_sinh of this enrolment
	*/
	public java.lang.String getHs_quan_he_voi_hoc_sinh() {
		return _enrolment.getHs_quan_he_voi_hoc_sinh();
	}

	/**
	* Sets the hs_quan_he_voi_hoc_sinh of this enrolment.
	*
	* @param hs_quan_he_voi_hoc_sinh the hs_quan_he_voi_hoc_sinh of this enrolment
	*/
	public void setHs_quan_he_voi_hoc_sinh(
		java.lang.String hs_quan_he_voi_hoc_sinh) {
		_enrolment.setHs_quan_he_voi_hoc_sinh(hs_quan_he_voi_hoc_sinh);
	}

	/**
	* Returns the hk_dia_chi of this enrolment.
	*
	* @return the hk_dia_chi of this enrolment
	*/
	public java.lang.String getHk_dia_chi() {
		return _enrolment.getHk_dia_chi();
	}

	/**
	* Sets the hk_dia_chi of this enrolment.
	*
	* @param hk_dia_chi the hk_dia_chi of this enrolment
	*/
	public void setHk_dia_chi(java.lang.String hk_dia_chi) {
		_enrolment.setHk_dia_chi(hk_dia_chi);
	}

	/**
	* Returns the hk_thanh_pho of this enrolment.
	*
	* @return the hk_thanh_pho of this enrolment
	*/
	public java.lang.String getHk_thanh_pho() {
		return _enrolment.getHk_thanh_pho();
	}

	/**
	* Sets the hk_thanh_pho of this enrolment.
	*
	* @param hk_thanh_pho the hk_thanh_pho of this enrolment
	*/
	public void setHk_thanh_pho(java.lang.String hk_thanh_pho) {
		_enrolment.setHk_thanh_pho(hk_thanh_pho);
	}

	/**
	* Returns the hk_tinh of this enrolment.
	*
	* @return the hk_tinh of this enrolment
	*/
	public java.lang.String getHk_tinh() {
		return _enrolment.getHk_tinh();
	}

	/**
	* Sets the hk_tinh of this enrolment.
	*
	* @param hk_tinh the hk_tinh of this enrolment
	*/
	public void setHk_tinh(java.lang.String hk_tinh) {
		_enrolment.setHk_tinh(hk_tinh);
	}

	/**
	* Returns the hk_quoc_gia of this enrolment.
	*
	* @return the hk_quoc_gia of this enrolment
	*/
	public java.lang.String getHk_quoc_gia() {
		return _enrolment.getHk_quoc_gia();
	}

	/**
	* Sets the hk_quoc_gia of this enrolment.
	*
	* @param hk_quoc_gia the hk_quoc_gia of this enrolment
	*/
	public void setHk_quoc_gia(java.lang.String hk_quoc_gia) {
		_enrolment.setHk_quoc_gia(hk_quoc_gia);
	}

	/**
	* Returns the cm_ten of this enrolment.
	*
	* @return the cm_ten of this enrolment
	*/
	public java.lang.String getCm_ten() {
		return _enrolment.getCm_ten();
	}

	/**
	* Sets the cm_ten of this enrolment.
	*
	* @param cm_ten the cm_ten of this enrolment
	*/
	public void setCm_ten(java.lang.String cm_ten) {
		_enrolment.setCm_ten(cm_ten);
	}

	/**
	* Returns the cm_ho of this enrolment.
	*
	* @return the cm_ho of this enrolment
	*/
	public java.lang.String getCm_ho() {
		return _enrolment.getCm_ho();
	}

	/**
	* Sets the cm_ho of this enrolment.
	*
	* @param cm_ho the cm_ho of this enrolment
	*/
	public void setCm_ho(java.lang.String cm_ho) {
		_enrolment.setCm_ho(cm_ho);
	}

	/**
	* Returns the cm_quan_he_voi_hoc_sinh of this enrolment.
	*
	* @return the cm_quan_he_voi_hoc_sinh of this enrolment
	*/
	public java.lang.String getCm_quan_he_voi_hoc_sinh() {
		return _enrolment.getCm_quan_he_voi_hoc_sinh();
	}

	/**
	* Sets the cm_quan_he_voi_hoc_sinh of this enrolment.
	*
	* @param cm_quan_he_voi_hoc_sinh the cm_quan_he_voi_hoc_sinh of this enrolment
	*/
	public void setCm_quan_he_voi_hoc_sinh(
		java.lang.String cm_quan_he_voi_hoc_sinh) {
		_enrolment.setCm_quan_he_voi_hoc_sinh(cm_quan_he_voi_hoc_sinh);
	}

	/**
	* Returns the cm_dia_chi_email of this enrolment.
	*
	* @return the cm_dia_chi_email of this enrolment
	*/
	public java.lang.String getCm_dia_chi_email() {
		return _enrolment.getCm_dia_chi_email();
	}

	/**
	* Sets the cm_dia_chi_email of this enrolment.
	*
	* @param cm_dia_chi_email the cm_dia_chi_email of this enrolment
	*/
	public void setCm_dia_chi_email(java.lang.String cm_dia_chi_email) {
		_enrolment.setCm_dia_chi_email(cm_dia_chi_email);
	}

	/**
	* Returns the cm_so_dien_thoai_di_dong of this enrolment.
	*
	* @return the cm_so_dien_thoai_di_dong of this enrolment
	*/
	public java.lang.String getCm_so_dien_thoai_di_dong() {
		return _enrolment.getCm_so_dien_thoai_di_dong();
	}

	/**
	* Sets the cm_so_dien_thoai_di_dong of this enrolment.
	*
	* @param cm_so_dien_thoai_di_dong the cm_so_dien_thoai_di_dong of this enrolment
	*/
	public void setCm_so_dien_thoai_di_dong(
		java.lang.String cm_so_dien_thoai_di_dong) {
		_enrolment.setCm_so_dien_thoai_di_dong(cm_so_dien_thoai_di_dong);
	}

	/**
	* Returns the cm_dien_thoai_noi_lam_viec of this enrolment.
	*
	* @return the cm_dien_thoai_noi_lam_viec of this enrolment
	*/
	public java.lang.String getCm_dien_thoai_noi_lam_viec() {
		return _enrolment.getCm_dien_thoai_noi_lam_viec();
	}

	/**
	* Sets the cm_dien_thoai_noi_lam_viec of this enrolment.
	*
	* @param cm_dien_thoai_noi_lam_viec the cm_dien_thoai_noi_lam_viec of this enrolment
	*/
	public void setCm_dien_thoai_noi_lam_viec(
		java.lang.String cm_dien_thoai_noi_lam_viec) {
		_enrolment.setCm_dien_thoai_noi_lam_viec(cm_dien_thoai_noi_lam_viec);
	}

	/**
	* Returns the cm_ten_cong_ty of this enrolment.
	*
	* @return the cm_ten_cong_ty of this enrolment
	*/
	public java.lang.String getCm_ten_cong_ty() {
		return _enrolment.getCm_ten_cong_ty();
	}

	/**
	* Sets the cm_ten_cong_ty of this enrolment.
	*
	* @param cm_ten_cong_ty the cm_ten_cong_ty of this enrolment
	*/
	public void setCm_ten_cong_ty(java.lang.String cm_ten_cong_ty) {
		_enrolment.setCm_ten_cong_ty(cm_ten_cong_ty);
	}

	/**
	* Returns the cm_chuc_danh of this enrolment.
	*
	* @return the cm_chuc_danh of this enrolment
	*/
	public java.lang.String getCm_chuc_danh() {
		return _enrolment.getCm_chuc_danh();
	}

	/**
	* Sets the cm_chuc_danh of this enrolment.
	*
	* @param cm_chuc_danh the cm_chuc_danh of this enrolment
	*/
	public void setCm_chuc_danh(java.lang.String cm_chuc_danh) {
		_enrolment.setCm_chuc_danh(cm_chuc_danh);
	}

	/**
	* Returns the k_lop of this enrolment.
	*
	* @return the k_lop of this enrolment
	*/
	public java.lang.String getK_lop() {
		return _enrolment.getK_lop();
	}

	/**
	* Sets the k_lop of this enrolment.
	*
	* @param k_lop the k_lop of this enrolment
	*/
	public void setK_lop(java.lang.String k_lop) {
		_enrolment.setK_lop(k_lop);
	}

	/**
	* Returns the k_nam_hoc of this enrolment.
	*
	* @return the k_nam_hoc of this enrolment
	*/
	public java.lang.String getK_nam_hoc() {
		return _enrolment.getK_nam_hoc();
	}

	/**
	* Sets the k_nam_hoc of this enrolment.
	*
	* @param k_nam_hoc the k_nam_hoc of this enrolment
	*/
	public void setK_nam_hoc(java.lang.String k_nam_hoc) {
		_enrolment.setK_nam_hoc(k_nam_hoc);
	}

	/**
	* Returns the k_truong_hien_dang_hoc of this enrolment.
	*
	* @return the k_truong_hien_dang_hoc of this enrolment
	*/
	public java.lang.String getK_truong_hien_dang_hoc() {
		return _enrolment.getK_truong_hien_dang_hoc();
	}

	/**
	* Sets the k_truong_hien_dang_hoc of this enrolment.
	*
	* @param k_truong_hien_dang_hoc the k_truong_hien_dang_hoc of this enrolment
	*/
	public void setK_truong_hien_dang_hoc(
		java.lang.String k_truong_hien_dang_hoc) {
		_enrolment.setK_truong_hien_dang_hoc(k_truong_hien_dang_hoc);
	}

	/**
	* Returns the k_sao_ma_biet_den of this enrolment.
	*
	* @return the k_sao_ma_biet_den of this enrolment
	*/
	public java.lang.String getK_sao_ma_biet_den() {
		return _enrolment.getK_sao_ma_biet_den();
	}

	/**
	* Sets the k_sao_ma_biet_den of this enrolment.
	*
	* @param k_sao_ma_biet_den the k_sao_ma_biet_den of this enrolment
	*/
	public void setK_sao_ma_biet_den(java.lang.String k_sao_ma_biet_den) {
		_enrolment.setK_sao_ma_biet_den(k_sao_ma_biet_den);
	}

	/**
	* Returns the k_nguoi_gioi_thieu of this enrolment.
	*
	* @return the k_nguoi_gioi_thieu of this enrolment
	*/
	public java.lang.String getK_nguoi_gioi_thieu() {
		return _enrolment.getK_nguoi_gioi_thieu();
	}

	/**
	* Sets the k_nguoi_gioi_thieu of this enrolment.
	*
	* @param k_nguoi_gioi_thieu the k_nguoi_gioi_thieu of this enrolment
	*/
	public void setK_nguoi_gioi_thieu(java.lang.String k_nguoi_gioi_thieu) {
		_enrolment.setK_nguoi_gioi_thieu(k_nguoi_gioi_thieu);
	}

	/**
	* Returns the k_thac_mac of this enrolment.
	*
	* @return the k_thac_mac of this enrolment
	*/
	public java.lang.String getK_thac_mac() {
		return _enrolment.getK_thac_mac();
	}

	/**
	* Sets the k_thac_mac of this enrolment.
	*
	* @param k_thac_mac the k_thac_mac of this enrolment
	*/
	public void setK_thac_mac(java.lang.String k_thac_mac) {
		_enrolment.setK_thac_mac(k_thac_mac);
	}

	/**
	* Returns the trang_thai of this enrolment.
	*
	* @return the trang_thai of this enrolment
	*/
	public java.lang.String getTrang_thai() {
		return _enrolment.getTrang_thai();
	}

	/**
	* Sets the trang_thai of this enrolment.
	*
	* @param trang_thai the trang_thai of this enrolment
	*/
	public void setTrang_thai(java.lang.String trang_thai) {
		_enrolment.setTrang_thai(trang_thai);
	}

	/**
	* Returns the created_date of this enrolment.
	*
	* @return the created_date of this enrolment
	*/
	public java.util.Date getCreated_date() {
		return _enrolment.getCreated_date();
	}

	/**
	* Sets the created_date of this enrolment.
	*
	* @param created_date the created_date of this enrolment
	*/
	public void setCreated_date(java.util.Date created_date) {
		_enrolment.setCreated_date(created_date);
	}

	/**
	* Returns the modified_date of this enrolment.
	*
	* @return the modified_date of this enrolment
	*/
	public java.util.Date getModified_date() {
		return _enrolment.getModified_date();
	}

	/**
	* Sets the modified_date of this enrolment.
	*
	* @param modified_date the modified_date of this enrolment
	*/
	public void setModified_date(java.util.Date modified_date) {
		_enrolment.setModified_date(modified_date);
	}

	/**
	* Returns the deleted of this enrolment.
	*
	* @return the deleted of this enrolment
	*/
	public boolean getDeleted() {
		return _enrolment.getDeleted();
	}

	/**
	* Returns <code>true</code> if this enrolment is deleted.
	*
	* @return <code>true</code> if this enrolment is deleted; <code>false</code> otherwise
	*/
	public boolean isDeleted() {
		return _enrolment.isDeleted();
	}

	/**
	* Sets whether this enrolment is deleted.
	*
	* @param deleted the deleted of this enrolment
	*/
	public void setDeleted(boolean deleted) {
		_enrolment.setDeleted(deleted);
	}

	public boolean isNew() {
		return _enrolment.isNew();
	}

	public void setNew(boolean n) {
		_enrolment.setNew(n);
	}

	public boolean isCachedModel() {
		return _enrolment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_enrolment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _enrolment.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _enrolment.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_enrolment.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _enrolment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_enrolment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EnrolmentWrapper((Enrolment)_enrolment.clone());
	}

	public int compareTo(com.fsoft.bn.model.Enrolment enrolment) {
		return _enrolment.compareTo(enrolment);
	}

	@Override
	public int hashCode() {
		return _enrolment.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.fsoft.bn.model.Enrolment> toCacheModel() {
		return _enrolment.toCacheModel();
	}

	public com.fsoft.bn.model.Enrolment toEscapedModel() {
		return new EnrolmentWrapper(_enrolment.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _enrolment.toString();
	}

	public java.lang.String toXmlString() {
		return _enrolment.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_enrolment.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Enrolment getWrappedEnrolment() {
		return _enrolment;
	}

	public Enrolment getWrappedModel() {
		return _enrolment;
	}

	public void resetOriginalValues() {
		_enrolment.resetOriginalValues();
	}

	private Enrolment _enrolment;
}