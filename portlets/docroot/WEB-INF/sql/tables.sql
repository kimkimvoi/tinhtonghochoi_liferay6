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