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

import com.fsoft.bn.service.EnrolmentLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FSOFT
 */
public class EnrolmentClp extends BaseModelImpl<Enrolment> implements Enrolment {
	public EnrolmentClp() {
	}

	public Class<?> getModelClass() {
		return Enrolment.class;
	}

	public String getModelClassName() {
		return Enrolment.class.getName();
	}

	public String getPrimaryKey() {
		return _enrolment_id;
	}

	public void setPrimaryKey(String primaryKey) {
		setEnrolment_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _enrolment_id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
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

	@Override
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

	public BaseModel<?> getEnrolmentRemoteModel() {
		return _enrolmentRemoteModel;
	}

	public void setEnrolmentRemoteModel(BaseModel<?> enrolmentRemoteModel) {
		_enrolmentRemoteModel = enrolmentRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EnrolmentLocalServiceUtil.addEnrolment(this);
		}
		else {
			EnrolmentLocalServiceUtil.updateEnrolment(this);
		}
	}

	@Override
	public Enrolment toEscapedModel() {
		return (Enrolment)Proxy.newProxyInstance(Enrolment.class.getClassLoader(),
			new Class[] { Enrolment.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnrolmentClp clone = new EnrolmentClp();

		clone.setEnrolment_id(getEnrolment_id());
		clone.setHs_ten(getHs_ten());
		clone.setHs_ho(getHs_ho());
		clone.setHs_quoc_tich(getHs_quoc_tich());
		clone.setHs_ngay_sinh(getHs_ngay_sinh());
		clone.setHs_so_dien_thoai(getHs_so_dien_thoai());
		clone.setHs_nguoi_lien_he(getHs_nguoi_lien_he());
		clone.setHs_quan_he_voi_hoc_sinh(getHs_quan_he_voi_hoc_sinh());
		clone.setHk_dia_chi(getHk_dia_chi());
		clone.setHk_thanh_pho(getHk_thanh_pho());
		clone.setHk_tinh(getHk_tinh());
		clone.setHk_quoc_gia(getHk_quoc_gia());
		clone.setCm_ten(getCm_ten());
		clone.setCm_ho(getCm_ho());
		clone.setCm_quan_he_voi_hoc_sinh(getCm_quan_he_voi_hoc_sinh());
		clone.setCm_dia_chi_email(getCm_dia_chi_email());
		clone.setCm_so_dien_thoai_di_dong(getCm_so_dien_thoai_di_dong());
		clone.setCm_dien_thoai_noi_lam_viec(getCm_dien_thoai_noi_lam_viec());
		clone.setCm_ten_cong_ty(getCm_ten_cong_ty());
		clone.setCm_chuc_danh(getCm_chuc_danh());
		clone.setK_lop(getK_lop());
		clone.setK_nam_hoc(getK_nam_hoc());
		clone.setK_truong_hien_dang_hoc(getK_truong_hien_dang_hoc());
		clone.setK_sao_ma_biet_den(getK_sao_ma_biet_den());
		clone.setK_nguoi_gioi_thieu(getK_nguoi_gioi_thieu());
		clone.setK_thac_mac(getK_thac_mac());
		clone.setTrang_thai(getTrang_thai());
		clone.setCreated_date(getCreated_date());
		clone.setModified_date(getModified_date());
		clone.setDeleted(getDeleted());

		return clone;
	}

	public int compareTo(Enrolment enrolment) {
		String primaryKey = enrolment.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EnrolmentClp enrolment = null;

		try {
			enrolment = (EnrolmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = enrolment.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{enrolment_id=");
		sb.append(getEnrolment_id());
		sb.append(", hs_ten=");
		sb.append(getHs_ten());
		sb.append(", hs_ho=");
		sb.append(getHs_ho());
		sb.append(", hs_quoc_tich=");
		sb.append(getHs_quoc_tich());
		sb.append(", hs_ngay_sinh=");
		sb.append(getHs_ngay_sinh());
		sb.append(", hs_so_dien_thoai=");
		sb.append(getHs_so_dien_thoai());
		sb.append(", hs_nguoi_lien_he=");
		sb.append(getHs_nguoi_lien_he());
		sb.append(", hs_quan_he_voi_hoc_sinh=");
		sb.append(getHs_quan_he_voi_hoc_sinh());
		sb.append(", hk_dia_chi=");
		sb.append(getHk_dia_chi());
		sb.append(", hk_thanh_pho=");
		sb.append(getHk_thanh_pho());
		sb.append(", hk_tinh=");
		sb.append(getHk_tinh());
		sb.append(", hk_quoc_gia=");
		sb.append(getHk_quoc_gia());
		sb.append(", cm_ten=");
		sb.append(getCm_ten());
		sb.append(", cm_ho=");
		sb.append(getCm_ho());
		sb.append(", cm_quan_he_voi_hoc_sinh=");
		sb.append(getCm_quan_he_voi_hoc_sinh());
		sb.append(", cm_dia_chi_email=");
		sb.append(getCm_dia_chi_email());
		sb.append(", cm_so_dien_thoai_di_dong=");
		sb.append(getCm_so_dien_thoai_di_dong());
		sb.append(", cm_dien_thoai_noi_lam_viec=");
		sb.append(getCm_dien_thoai_noi_lam_viec());
		sb.append(", cm_ten_cong_ty=");
		sb.append(getCm_ten_cong_ty());
		sb.append(", cm_chuc_danh=");
		sb.append(getCm_chuc_danh());
		sb.append(", k_lop=");
		sb.append(getK_lop());
		sb.append(", k_nam_hoc=");
		sb.append(getK_nam_hoc());
		sb.append(", k_truong_hien_dang_hoc=");
		sb.append(getK_truong_hien_dang_hoc());
		sb.append(", k_sao_ma_biet_den=");
		sb.append(getK_sao_ma_biet_den());
		sb.append(", k_nguoi_gioi_thieu=");
		sb.append(getK_nguoi_gioi_thieu());
		sb.append(", k_thac_mac=");
		sb.append(getK_thac_mac());
		sb.append(", trang_thai=");
		sb.append(getTrang_thai());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", modified_date=");
		sb.append(getModified_date());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("com.fsoft.bn.model.Enrolment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>enrolment_id</column-name><column-value><![CDATA[");
		sb.append(getEnrolment_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hs_ten</column-name><column-value><![CDATA[");
		sb.append(getHs_ten());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hs_ho</column-name><column-value><![CDATA[");
		sb.append(getHs_ho());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hs_quoc_tich</column-name><column-value><![CDATA[");
		sb.append(getHs_quoc_tich());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hs_ngay_sinh</column-name><column-value><![CDATA[");
		sb.append(getHs_ngay_sinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hs_so_dien_thoai</column-name><column-value><![CDATA[");
		sb.append(getHs_so_dien_thoai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hs_nguoi_lien_he</column-name><column-value><![CDATA[");
		sb.append(getHs_nguoi_lien_he());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hs_quan_he_voi_hoc_sinh</column-name><column-value><![CDATA[");
		sb.append(getHs_quan_he_voi_hoc_sinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hk_dia_chi</column-name><column-value><![CDATA[");
		sb.append(getHk_dia_chi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hk_thanh_pho</column-name><column-value><![CDATA[");
		sb.append(getHk_thanh_pho());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hk_tinh</column-name><column-value><![CDATA[");
		sb.append(getHk_tinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hk_quoc_gia</column-name><column-value><![CDATA[");
		sb.append(getHk_quoc_gia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_ten</column-name><column-value><![CDATA[");
		sb.append(getCm_ten());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_ho</column-name><column-value><![CDATA[");
		sb.append(getCm_ho());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_quan_he_voi_hoc_sinh</column-name><column-value><![CDATA[");
		sb.append(getCm_quan_he_voi_hoc_sinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_dia_chi_email</column-name><column-value><![CDATA[");
		sb.append(getCm_dia_chi_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_so_dien_thoai_di_dong</column-name><column-value><![CDATA[");
		sb.append(getCm_so_dien_thoai_di_dong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_dien_thoai_noi_lam_viec</column-name><column-value><![CDATA[");
		sb.append(getCm_dien_thoai_noi_lam_viec());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_ten_cong_ty</column-name><column-value><![CDATA[");
		sb.append(getCm_ten_cong_ty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cm_chuc_danh</column-name><column-value><![CDATA[");
		sb.append(getCm_chuc_danh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>k_lop</column-name><column-value><![CDATA[");
		sb.append(getK_lop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>k_nam_hoc</column-name><column-value><![CDATA[");
		sb.append(getK_nam_hoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>k_truong_hien_dang_hoc</column-name><column-value><![CDATA[");
		sb.append(getK_truong_hien_dang_hoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>k_sao_ma_biet_den</column-name><column-value><![CDATA[");
		sb.append(getK_sao_ma_biet_den());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>k_nguoi_gioi_thieu</column-name><column-value><![CDATA[");
		sb.append(getK_nguoi_gioi_thieu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>k_thac_mac</column-name><column-value><![CDATA[");
		sb.append(getK_thac_mac());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trang_thai</column-name><column-value><![CDATA[");
		sb.append(getTrang_thai());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created_date</column-name><column-value><![CDATA[");
		sb.append(getCreated_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modified_date</column-name><column-value><![CDATA[");
		sb.append(getModified_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _enrolmentRemoteModel;
}