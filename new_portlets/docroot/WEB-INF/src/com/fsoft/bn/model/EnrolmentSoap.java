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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    FSOFT
 * @generated
 */
public class EnrolmentSoap implements Serializable {
	public static EnrolmentSoap toSoapModel(Enrolment model) {
		EnrolmentSoap soapModel = new EnrolmentSoap();

		soapModel.setEnrolment_id(model.getEnrolment_id());
		soapModel.setHs_ten(model.getHs_ten());
		soapModel.setHs_ho(model.getHs_ho());
		soapModel.setHs_quoc_tich(model.getHs_quoc_tich());
		soapModel.setHs_ngay_sinh(model.getHs_ngay_sinh());
		soapModel.setHs_so_dien_thoai(model.getHs_so_dien_thoai());
		soapModel.setHs_nguoi_lien_he(model.getHs_nguoi_lien_he());
		soapModel.setHs_quan_he_voi_hoc_sinh(model.getHs_quan_he_voi_hoc_sinh());
		soapModel.setHk_dia_chi(model.getHk_dia_chi());
		soapModel.setHk_thanh_pho(model.getHk_thanh_pho());
		soapModel.setHk_tinh(model.getHk_tinh());
		soapModel.setHk_quoc_gia(model.getHk_quoc_gia());
		soapModel.setCm_ten(model.getCm_ten());
		soapModel.setCm_ho(model.getCm_ho());
		soapModel.setCm_quan_he_voi_hoc_sinh(model.getCm_quan_he_voi_hoc_sinh());
		soapModel.setCm_dia_chi_email(model.getCm_dia_chi_email());
		soapModel.setCm_so_dien_thoai_di_dong(model.getCm_so_dien_thoai_di_dong());
		soapModel.setCm_dien_thoai_noi_lam_viec(model.getCm_dien_thoai_noi_lam_viec());
		soapModel.setCm_ten_cong_ty(model.getCm_ten_cong_ty());
		soapModel.setCm_chuc_danh(model.getCm_chuc_danh());
		soapModel.setK_lop(model.getK_lop());
		soapModel.setK_nam_hoc(model.getK_nam_hoc());
		soapModel.setK_truong_hien_dang_hoc(model.getK_truong_hien_dang_hoc());
		soapModel.setK_sao_ma_biet_den(model.getK_sao_ma_biet_den());
		soapModel.setK_nguoi_gioi_thieu(model.getK_nguoi_gioi_thieu());
		soapModel.setK_thac_mac(model.getK_thac_mac());
		soapModel.setTrang_thai(model.getTrang_thai());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setModified_date(model.getModified_date());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static EnrolmentSoap[] toSoapModels(Enrolment[] models) {
		EnrolmentSoap[] soapModels = new EnrolmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnrolmentSoap[][] toSoapModels(Enrolment[][] models) {
		EnrolmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnrolmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnrolmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnrolmentSoap[] toSoapModels(List<Enrolment> models) {
		List<EnrolmentSoap> soapModels = new ArrayList<EnrolmentSoap>(models.size());

		for (Enrolment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnrolmentSoap[soapModels.size()]);
	}

	public EnrolmentSoap() {
	}

	public String getPrimaryKey() {
		return _enrolment_id;
	}

	public void setPrimaryKey(String pk) {
		setEnrolment_id(pk);
	}

	public String getEnrolment_id() {
		return _enrolment_id;
	}

	public void setEnrolment_id(String enrolment_id) {
		_enrolment_id = enrolment_id;
	}

	public String getHs_ten() {
		return _hs_ten;
	}

	public void setHs_ten(String hs_ten) {
		_hs_ten = hs_ten;
	}

	public String getHs_ho() {
		return _hs_ho;
	}

	public void setHs_ho(String hs_ho) {
		_hs_ho = hs_ho;
	}

	public String getHs_quoc_tich() {
		return _hs_quoc_tich;
	}

	public void setHs_quoc_tich(String hs_quoc_tich) {
		_hs_quoc_tich = hs_quoc_tich;
	}

	public Date getHs_ngay_sinh() {
		return _hs_ngay_sinh;
	}

	public void setHs_ngay_sinh(Date hs_ngay_sinh) {
		_hs_ngay_sinh = hs_ngay_sinh;
	}

	public String getHs_so_dien_thoai() {
		return _hs_so_dien_thoai;
	}

	public void setHs_so_dien_thoai(String hs_so_dien_thoai) {
		_hs_so_dien_thoai = hs_so_dien_thoai;
	}

	public String getHs_nguoi_lien_he() {
		return _hs_nguoi_lien_he;
	}

	public void setHs_nguoi_lien_he(String hs_nguoi_lien_he) {
		_hs_nguoi_lien_he = hs_nguoi_lien_he;
	}

	public String getHs_quan_he_voi_hoc_sinh() {
		return _hs_quan_he_voi_hoc_sinh;
	}

	public void setHs_quan_he_voi_hoc_sinh(String hs_quan_he_voi_hoc_sinh) {
		_hs_quan_he_voi_hoc_sinh = hs_quan_he_voi_hoc_sinh;
	}

	public String getHk_dia_chi() {
		return _hk_dia_chi;
	}

	public void setHk_dia_chi(String hk_dia_chi) {
		_hk_dia_chi = hk_dia_chi;
	}

	public String getHk_thanh_pho() {
		return _hk_thanh_pho;
	}

	public void setHk_thanh_pho(String hk_thanh_pho) {
		_hk_thanh_pho = hk_thanh_pho;
	}

	public String getHk_tinh() {
		return _hk_tinh;
	}

	public void setHk_tinh(String hk_tinh) {
		_hk_tinh = hk_tinh;
	}

	public String getHk_quoc_gia() {
		return _hk_quoc_gia;
	}

	public void setHk_quoc_gia(String hk_quoc_gia) {
		_hk_quoc_gia = hk_quoc_gia;
	}

	public String getCm_ten() {
		return _cm_ten;
	}

	public void setCm_ten(String cm_ten) {
		_cm_ten = cm_ten;
	}

	public String getCm_ho() {
		return _cm_ho;
	}

	public void setCm_ho(String cm_ho) {
		_cm_ho = cm_ho;
	}

	public String getCm_quan_he_voi_hoc_sinh() {
		return _cm_quan_he_voi_hoc_sinh;
	}

	public void setCm_quan_he_voi_hoc_sinh(String cm_quan_he_voi_hoc_sinh) {
		_cm_quan_he_voi_hoc_sinh = cm_quan_he_voi_hoc_sinh;
	}

	public String getCm_dia_chi_email() {
		return _cm_dia_chi_email;
	}

	public void setCm_dia_chi_email(String cm_dia_chi_email) {
		_cm_dia_chi_email = cm_dia_chi_email;
	}

	public String getCm_so_dien_thoai_di_dong() {
		return _cm_so_dien_thoai_di_dong;
	}

	public void setCm_so_dien_thoai_di_dong(String cm_so_dien_thoai_di_dong) {
		_cm_so_dien_thoai_di_dong = cm_so_dien_thoai_di_dong;
	}

	public String getCm_dien_thoai_noi_lam_viec() {
		return _cm_dien_thoai_noi_lam_viec;
	}

	public void setCm_dien_thoai_noi_lam_viec(String cm_dien_thoai_noi_lam_viec) {
		_cm_dien_thoai_noi_lam_viec = cm_dien_thoai_noi_lam_viec;
	}

	public String getCm_ten_cong_ty() {
		return _cm_ten_cong_ty;
	}

	public void setCm_ten_cong_ty(String cm_ten_cong_ty) {
		_cm_ten_cong_ty = cm_ten_cong_ty;
	}

	public String getCm_chuc_danh() {
		return _cm_chuc_danh;
	}

	public void setCm_chuc_danh(String cm_chuc_danh) {
		_cm_chuc_danh = cm_chuc_danh;
	}

	public String getK_lop() {
		return _k_lop;
	}

	public void setK_lop(String k_lop) {
		_k_lop = k_lop;
	}

	public String getK_nam_hoc() {
		return _k_nam_hoc;
	}

	public void setK_nam_hoc(String k_nam_hoc) {
		_k_nam_hoc = k_nam_hoc;
	}

	public String getK_truong_hien_dang_hoc() {
		return _k_truong_hien_dang_hoc;
	}

	public void setK_truong_hien_dang_hoc(String k_truong_hien_dang_hoc) {
		_k_truong_hien_dang_hoc = k_truong_hien_dang_hoc;
	}

	public String getK_sao_ma_biet_den() {
		return _k_sao_ma_biet_den;
	}

	public void setK_sao_ma_biet_den(String k_sao_ma_biet_den) {
		_k_sao_ma_biet_den = k_sao_ma_biet_den;
	}

	public String getK_nguoi_gioi_thieu() {
		return _k_nguoi_gioi_thieu;
	}

	public void setK_nguoi_gioi_thieu(String k_nguoi_gioi_thieu) {
		_k_nguoi_gioi_thieu = k_nguoi_gioi_thieu;
	}

	public String getK_thac_mac() {
		return _k_thac_mac;
	}

	public void setK_thac_mac(String k_thac_mac) {
		_k_thac_mac = k_thac_mac;
	}

	public String getTrang_thai() {
		return _trang_thai;
	}

	public void setTrang_thai(String trang_thai) {
		_trang_thai = trang_thai;
	}

	public Date getCreated_date() {
		return _created_date;
	}

	public void setCreated_date(Date created_date) {
		_created_date = created_date;
	}

	public Date getModified_date() {
		return _modified_date;
	}

	public void setModified_date(Date modified_date) {
		_modified_date = modified_date;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	private String _enrolment_id;
	private String _hs_ten;
	private String _hs_ho;
	private String _hs_quoc_tich;
	private Date _hs_ngay_sinh;
	private String _hs_so_dien_thoai;
	private String _hs_nguoi_lien_he;
	private String _hs_quan_he_voi_hoc_sinh;
	private String _hk_dia_chi;
	private String _hk_thanh_pho;
	private String _hk_tinh;
	private String _hk_quoc_gia;
	private String _cm_ten;
	private String _cm_ho;
	private String _cm_quan_he_voi_hoc_sinh;
	private String _cm_dia_chi_email;
	private String _cm_so_dien_thoai_di_dong;
	private String _cm_dien_thoai_noi_lam_viec;
	private String _cm_ten_cong_ty;
	private String _cm_chuc_danh;
	private String _k_lop;
	private String _k_nam_hoc;
	private String _k_truong_hien_dang_hoc;
	private String _k_sao_ma_biet_den;
	private String _k_nguoi_gioi_thieu;
	private String _k_thac_mac;
	private String _trang_thai;
	private Date _created_date;
	private Date _modified_date;
	private boolean _deleted;
}