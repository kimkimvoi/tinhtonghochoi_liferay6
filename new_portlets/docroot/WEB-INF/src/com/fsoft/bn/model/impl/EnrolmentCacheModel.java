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

package com.fsoft.bn.model.impl;

import com.fsoft.bn.model.Enrolment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Enrolment in entity cache.
 *
 * @author FSOFT
 * @see Enrolment
 * @generated
 */
public class EnrolmentCacheModel implements CacheModel<Enrolment>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{enrolment_id=");
		sb.append(enrolment_id);
		sb.append(", hs_ten=");
		sb.append(hs_ten);
		sb.append(", hs_ho=");
		sb.append(hs_ho);
		sb.append(", hs_quoc_tich=");
		sb.append(hs_quoc_tich);
		sb.append(", hs_ngay_sinh=");
		sb.append(hs_ngay_sinh);
		sb.append(", hs_so_dien_thoai=");
		sb.append(hs_so_dien_thoai);
		sb.append(", hs_nguoi_lien_he=");
		sb.append(hs_nguoi_lien_he);
		sb.append(", hs_quan_he_voi_hoc_sinh=");
		sb.append(hs_quan_he_voi_hoc_sinh);
		sb.append(", hk_dia_chi=");
		sb.append(hk_dia_chi);
		sb.append(", hk_thanh_pho=");
		sb.append(hk_thanh_pho);
		sb.append(", hk_tinh=");
		sb.append(hk_tinh);
		sb.append(", hk_quoc_gia=");
		sb.append(hk_quoc_gia);
		sb.append(", cm_ten=");
		sb.append(cm_ten);
		sb.append(", cm_ho=");
		sb.append(cm_ho);
		sb.append(", cm_quan_he_voi_hoc_sinh=");
		sb.append(cm_quan_he_voi_hoc_sinh);
		sb.append(", cm_dia_chi_email=");
		sb.append(cm_dia_chi_email);
		sb.append(", cm_so_dien_thoai_di_dong=");
		sb.append(cm_so_dien_thoai_di_dong);
		sb.append(", cm_dien_thoai_noi_lam_viec=");
		sb.append(cm_dien_thoai_noi_lam_viec);
		sb.append(", cm_ten_cong_ty=");
		sb.append(cm_ten_cong_ty);
		sb.append(", cm_chuc_danh=");
		sb.append(cm_chuc_danh);
		sb.append(", k_lop=");
		sb.append(k_lop);
		sb.append(", k_nam_hoc=");
		sb.append(k_nam_hoc);
		sb.append(", k_truong_hien_dang_hoc=");
		sb.append(k_truong_hien_dang_hoc);
		sb.append(", k_sao_ma_biet_den=");
		sb.append(k_sao_ma_biet_den);
		sb.append(", k_nguoi_gioi_thieu=");
		sb.append(k_nguoi_gioi_thieu);
		sb.append(", k_thac_mac=");
		sb.append(k_thac_mac);
		sb.append(", trang_thai=");
		sb.append(trang_thai);
		sb.append(", created_date=");
		sb.append(created_date);
		sb.append(", modified_date=");
		sb.append(modified_date);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	public Enrolment toEntityModel() {
		EnrolmentImpl enrolmentImpl = new EnrolmentImpl();

		if (enrolment_id == null) {
			enrolmentImpl.setEnrolment_id(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setEnrolment_id(enrolment_id);
		}

		if (hs_ten == null) {
			enrolmentImpl.setHs_ten(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHs_ten(hs_ten);
		}

		if (hs_ho == null) {
			enrolmentImpl.setHs_ho(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHs_ho(hs_ho);
		}

		if (hs_quoc_tich == null) {
			enrolmentImpl.setHs_quoc_tich(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHs_quoc_tich(hs_quoc_tich);
		}

		if (hs_ngay_sinh == Long.MIN_VALUE) {
			enrolmentImpl.setHs_ngay_sinh(null);
		}
		else {
			enrolmentImpl.setHs_ngay_sinh(new Date(hs_ngay_sinh));
		}

		if (hs_so_dien_thoai == null) {
			enrolmentImpl.setHs_so_dien_thoai(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHs_so_dien_thoai(hs_so_dien_thoai);
		}

		if (hs_nguoi_lien_he == null) {
			enrolmentImpl.setHs_nguoi_lien_he(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHs_nguoi_lien_he(hs_nguoi_lien_he);
		}

		if (hs_quan_he_voi_hoc_sinh == null) {
			enrolmentImpl.setHs_quan_he_voi_hoc_sinh(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHs_quan_he_voi_hoc_sinh(hs_quan_he_voi_hoc_sinh);
		}

		if (hk_dia_chi == null) {
			enrolmentImpl.setHk_dia_chi(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHk_dia_chi(hk_dia_chi);
		}

		if (hk_thanh_pho == null) {
			enrolmentImpl.setHk_thanh_pho(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHk_thanh_pho(hk_thanh_pho);
		}

		if (hk_tinh == null) {
			enrolmentImpl.setHk_tinh(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHk_tinh(hk_tinh);
		}

		if (hk_quoc_gia == null) {
			enrolmentImpl.setHk_quoc_gia(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setHk_quoc_gia(hk_quoc_gia);
		}

		if (cm_ten == null) {
			enrolmentImpl.setCm_ten(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_ten(cm_ten);
		}

		if (cm_ho == null) {
			enrolmentImpl.setCm_ho(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_ho(cm_ho);
		}

		if (cm_quan_he_voi_hoc_sinh == null) {
			enrolmentImpl.setCm_quan_he_voi_hoc_sinh(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_quan_he_voi_hoc_sinh(cm_quan_he_voi_hoc_sinh);
		}

		if (cm_dia_chi_email == null) {
			enrolmentImpl.setCm_dia_chi_email(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_dia_chi_email(cm_dia_chi_email);
		}

		if (cm_so_dien_thoai_di_dong == null) {
			enrolmentImpl.setCm_so_dien_thoai_di_dong(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_so_dien_thoai_di_dong(cm_so_dien_thoai_di_dong);
		}

		if (cm_dien_thoai_noi_lam_viec == null) {
			enrolmentImpl.setCm_dien_thoai_noi_lam_viec(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_dien_thoai_noi_lam_viec(cm_dien_thoai_noi_lam_viec);
		}

		if (cm_ten_cong_ty == null) {
			enrolmentImpl.setCm_ten_cong_ty(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_ten_cong_ty(cm_ten_cong_ty);
		}

		if (cm_chuc_danh == null) {
			enrolmentImpl.setCm_chuc_danh(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setCm_chuc_danh(cm_chuc_danh);
		}

		if (k_lop == null) {
			enrolmentImpl.setK_lop(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setK_lop(k_lop);
		}

		if (k_nam_hoc == null) {
			enrolmentImpl.setK_nam_hoc(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setK_nam_hoc(k_nam_hoc);
		}

		if (k_truong_hien_dang_hoc == null) {
			enrolmentImpl.setK_truong_hien_dang_hoc(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setK_truong_hien_dang_hoc(k_truong_hien_dang_hoc);
		}

		if (k_sao_ma_biet_den == null) {
			enrolmentImpl.setK_sao_ma_biet_den(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setK_sao_ma_biet_den(k_sao_ma_biet_den);
		}

		if (k_nguoi_gioi_thieu == null) {
			enrolmentImpl.setK_nguoi_gioi_thieu(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setK_nguoi_gioi_thieu(k_nguoi_gioi_thieu);
		}

		if (k_thac_mac == null) {
			enrolmentImpl.setK_thac_mac(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setK_thac_mac(k_thac_mac);
		}

		if (trang_thai == null) {
			enrolmentImpl.setTrang_thai(StringPool.BLANK);
		}
		else {
			enrolmentImpl.setTrang_thai(trang_thai);
		}

		if (created_date == Long.MIN_VALUE) {
			enrolmentImpl.setCreated_date(null);
		}
		else {
			enrolmentImpl.setCreated_date(new Date(created_date));
		}

		if (modified_date == Long.MIN_VALUE) {
			enrolmentImpl.setModified_date(null);
		}
		else {
			enrolmentImpl.setModified_date(new Date(modified_date));
		}

		enrolmentImpl.setDeleted(deleted);

		enrolmentImpl.resetOriginalValues();

		return enrolmentImpl;
	}

	public String enrolment_id;
	public String hs_ten;
	public String hs_ho;
	public String hs_quoc_tich;
	public long hs_ngay_sinh;
	public String hs_so_dien_thoai;
	public String hs_nguoi_lien_he;
	public String hs_quan_he_voi_hoc_sinh;
	public String hk_dia_chi;
	public String hk_thanh_pho;
	public String hk_tinh;
	public String hk_quoc_gia;
	public String cm_ten;
	public String cm_ho;
	public String cm_quan_he_voi_hoc_sinh;
	public String cm_dia_chi_email;
	public String cm_so_dien_thoai_di_dong;
	public String cm_dien_thoai_noi_lam_viec;
	public String cm_ten_cong_ty;
	public String cm_chuc_danh;
	public String k_lop;
	public String k_nam_hoc;
	public String k_truong_hien_dang_hoc;
	public String k_sao_ma_biet_den;
	public String k_nguoi_gioi_thieu;
	public String k_thac_mac;
	public String trang_thai;
	public long created_date;
	public long modified_date;
	public boolean deleted;
}