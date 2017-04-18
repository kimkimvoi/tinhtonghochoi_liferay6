create table BN_Answer (
	answer_id VARCHAR(75) not null primary key,
	answer_content STRING null,
	user_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_AnswerAttachedFile (
	answer_attached_id VARCHAR(75) not null primary key,
	answer_id VARCHAR(75) null,
	attached_file_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_BNContact (
	contactId LONG not null primary key,
	departmentKey VARCHAR(75) null,
	name VARCHAR(75) null,
	regency VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN
);

create table BN_BNNews (
	newsId LONG not null primary key,
	newsTitle VARCHAR(255) null,
	newsContent STRING null,
	createdDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN
);

create table BN_Enrolment (
	enrolment_id VARCHAR(75) not null primary key,
	hs_ten VARCHAR(75) null,
	hs_ho VARCHAR(75) null,
	hs_quoc_tich VARCHAR(75) null,
	hs_ngay_sinh DATE null,
	hs_so_dien_thoai VARCHAR(75) null,
	hs_nguoi_lien_he VARCHAR(75) null,
	hs_quan_he_voi_hoc_sinh VARCHAR(255) null,
	hk_dia_chi VARCHAR(255) null,
	hk_thanh_pho VARCHAR(75) null,
	hk_tinh VARCHAR(75) null,
	hk_quoc_gia VARCHAR(75) null,
	cm_ten VARCHAR(75) null,
	cm_ho VARCHAR(75) null,
	cm_quan_he_voi_hoc_sinh VARCHAR(255) null,
	cm_dia_chi_email VARCHAR(75) null,
	cm_so_dien_thoai_di_dong VARCHAR(75) null,
	cm_dien_thoai_noi_lam_viec VARCHAR(75) null,
	cm_ten_cong_ty VARCHAR(255) null,
	cm_chuc_danh VARCHAR(75) null,
	k_lop VARCHAR(75) null,
	k_nam_hoc VARCHAR(75) null,
	k_truong_hien_dang_hoc VARCHAR(255) null,
	k_sao_ma_biet_den STRING null,
	k_nguoi_gioi_thieu STRING null,
	k_thac_mac STRING null,
	trang_thai VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_EnrolmentAttachedFile (
	enrolment_attached_id VARCHAR(75) not null primary key,
	enrolment_id VARCHAR(75) null,
	attached_file_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_InvestmentProjects (
	project_id VARCHAR(75) not null primary key,
	project_name VARCHAR(255) null,
	total_investment_min VARCHAR(75) null,
	total_investment_max VARCHAR(75) null,
	implementation_location VARCHAR(255) null,
	start_time DATE null,
	end_time DATE null,
	project_purpose STRING null,
	charter_capital VARCHAR(75) null,
	project_category_id VARCHAR(75) null,
	project_status_id VARCHAR(75) null,
	investment_form_id VARCHAR(75) null,
	competent_organization_id VARCHAR(75) null,
	key_project BOOLEAN,
	technical_specifications STRING null,
	currency_type_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_Organizations (
	organizations_id LONG not null primary key,
	organizations_name VARCHAR(255) null,
	organizations_description STRING null,
	organizations_address VARCHAR(255) null,
	deleted BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table BN_PreschoolAttachedFile (
	preschool_attached_id VARCHAR(75) not null primary key,
	student_id VARCHAR(75) null,
	attached_file_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_PreschoolParent (
	preschoolParent_id VARCHAR(75) not null primary key,
	student_id VARCHAR(75) null,
	name VARCHAR(75) null,
	dob VARCHAR(75) null,
	placeOfBirth VARCHAR(75) null,
	nationality VARCHAR(75) null,
	idCardNumber VARCHAR(75) null,
	job VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	Email VARCHAR(75) null,
	isMother BOOLEAN,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_PreschoolStudent (
	student_id VARCHAR(75) not null primary key,
	student_name VARCHAR(75) null,
	student_sex VARCHAR(75) null,
	student_dob VARCHAR(75) null,
	student_placeOfBirth VARCHAR(75) null,
	student_nationality VARCHAR(75) null,
	student_phoneNumber VARCHAR(75) null,
	student_address VARCHAR(75) null,
	student_heatlhStatus VARCHAR(75) null,
	student_height VARCHAR(75) null,
	student_weight VARCHAR(75) null,
	student_contactName VARCHAR(75) null,
	student_contactRelationship VARCHAR(75) null,
	student_contactPhoneNumber VARCHAR(75) null,
	student_contactEmail VARCHAR(75) null,
	student_howToKnowBM VARCHAR(75) null,
	student_whoIntroduce VARCHAR(75) null,
	student_anyConfuse VARCHAR(75) null,
	status VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_PrimarySchoolAttachedFile (
	primarySchool_attached_id VARCHAR(75) not null primary key,
	primaryStudent_id VARCHAR(75) null,
	attached_file_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_PrimarySchoolParent (
	primarySchoolParent_id VARCHAR(75) not null primary key,
	primaryStudent_id VARCHAR(75) null,
	name VARCHAR(75) null,
	nationality VARCHAR(75) null,
	idCardNumber VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	Email VARCHAR(75) null,
	job VARCHAR(75) null,
	job_position VARCHAR(75) null,
	workplace VARCHAR(75) null,
	isMother BOOLEAN,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_PrimarySchoolStudent (
	primaryStudent_id VARCHAR(75) not null primary key,
	student_name VARCHAR(75) null,
	student_sex VARCHAR(75) null,
	student_dob VARCHAR(75) null,
	student_placeOfBirth VARCHAR(75) null,
	student_nationality VARCHAR(75) null,
	student_address VARCHAR(75) null,
	student_contactName VARCHAR(75) null,
	student_contactRelationship VARCHAR(75) null,
	student_contactPhoneNumber VARCHAR(75) null,
	student_contactEmail VARCHAR(75) null,
	student_schoolName VARCHAR(75) null,
	student_schoolYear VARCHAR(75) null,
	student_academicLevel VARCHAR(75) null,
	student_studiedLanguage VARCHAR(75) null,
	student_languageCenter VARCHAR(75) null,
	student_prizes VARCHAR(75) null,
	student_skippedGrade VARCHAR(75) null,
	student_penalty VARCHAR(75) null,
	student_interests VARCHAR(75) null,
	student_note VARCHAR(75) null,
	student_registrationClass VARCHAR(75) null,
	student_expectedEnrollTime VARCHAR(75) null,
	student_userCar VARCHAR(75) null,
	student_theLightClub VARCHAR(75) null,
	student_oversea VARCHAR(75) null,
	student_howToKnowBM VARCHAR(75) null,
	student_whoIntroduce VARCHAR(75) null,
	student_anyConfuse VARCHAR(75) null,
	status VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_Question (
	question_id VARCHAR(75) not null primary key,
	question_title VARCHAR(255) null,
	question_type_id VARCHAR(75) null,
	question_content STRING null,
	citizen_name VARCHAR(255) null,
	citizen_mail VARCHAR(255) null,
	citizen_phone VARCHAR(75) null,
	citizen_address VARCHAR(255) null,
	question_status_id VARCHAR(75) null,
	answer_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_QuestionAttachedFile (
	question_attached_id VARCHAR(75) not null primary key,
	question_id VARCHAR(75) null,
	attached_file_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_Recruitment (
	recruitment_id VARCHAR(75) not null primary key,
	candidate_name VARCHAR(75) null,
	candidate_sex VARCHAR(75) null,
	candidate_dob VARCHAR(75) null,
	candidate_placeOfBirth VARCHAR(75) null,
	candidate_nationality VARCHAR(75) null,
	candidate_race VARCHAR(75) null,
	candidate_religion VARCHAR(75) null,
	candidate_IdCardNumber VARCHAR(75) null,
	candidate_placeOfIssue VARCHAR(75) null,
	candidate_permanentPlace VARCHAR(75) null,
	candidate_temporaryPlace VARCHAR(75) null,
	candidate_phoneNumber VARCHAR(75) null,
	candidate_email VARCHAR(75) null,
	candidate_position VARCHAR(75) null,
	candidate_canStartDate VARCHAR(75) null,
	candidate_currentSalary VARCHAR(75) null,
	candidate_expectedSalary VARCHAR(75) null,
	candidate_howToKnowBM VARCHAR(75) null,
	candidate_whoIntroduce VARCHAR(75) null,
	candidate_anyConfuse VARCHAR(75) null,
	status VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_RecruitmentAttachedFile (
	recruitment_attached_id VARCHAR(75) not null primary key,
	recruitment_id VARCHAR(75) null,
	attached_file_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_RecruitmentEducationalHistory (
	recruitment_educational_history_id VARCHAR(75) not null primary key,
	recruitment_id VARCHAR(75) null,
	school VARCHAR(75) null,
	typeOfTraining VARCHAR(75) null,
	speciality VARCHAR(75) null,
	typeOfDegree VARCHAR(75) null,
	graduatedYear VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_RecruitmentLanguages (
	recruitment_languages_id VARCHAR(75) not null primary key,
	recruitment_id VARCHAR(75) null,
	language VARCHAR(75) null,
	level VARCHAR(75) null,
	certificate VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_RecruitmentProgrammings (
	recruitment_programmings_id VARCHAR(75) not null primary key,
	recruitment_id VARCHAR(75) null,
	course VARCHAR(75) null,
	level VARCHAR(75) null,
	certificate VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_RecruitmentTrainingCourses (
	recruitment_training_courses_id VARCHAR(75) not null primary key,
	recruitment_id VARCHAR(75) null,
	conductedBy VARCHAR(75) null,
	courseName VARCHAR(75) null,
	courseDesc VARCHAR(75) null,
	courseDate VARCHAR(75) null,
	certificate VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_Schedule (
	schedule_id VARCHAR(75) not null primary key,
	schedule_date DATE null,
	content STRING null,
	user_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_StaffInfo (
	staff_id LONG not null primary key,
	staff_firstname VARCHAR(255) null,
	staff_middlename VARCHAR(255) null,
	staff_lastname VARCHAR(255) null,
	staff_birthday DATE null,
	staff_phone VARCHAR(75) null,
	staff_email VARCHAR(255) null,
	staff_sex VARCHAR(75) null,
	staff_role VARCHAR(75) null,
	deleted BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null,
	organizations_id LONG
);

create table BN_UserSchedule (
	user_schedule_id VARCHAR(75) not null primary key,
	user_id VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);

create table BN_UserfulContactPhone (
	userful_contact_phone_id VARCHAR(75) not null primary key,
	userful_contact_name VARCHAR(75) null,
	userful_contact_phone VARCHAR(75) null,
	userful_contact_email VARCHAR(75) null,
	userful_contact_position VARCHAR(75) null,
	userful_contact_address VARCHAR(75) null,
	created_date DATE null,
	modified_date DATE null,
	deleted BOOLEAN
);