create index IX_DDB7F716 on BN_Organizations (deleted);
create index IX_63084FB5 on BN_Organizations (organization_name, deleted);
create index IX_3D714098 on BN_Organizations (organizations_name, deleted);

create index IX_51D3A1C8 on BN_StaffInfo (deleted);
create index IX_A73D52DD on BN_StaffInfo (staff_email, deleted);
create index IX_EAC67FD7 on BN_StaffInfo (staff_firstname, staff_middlename, staff_lastname, deleted);
create index IX_640D69CB on BN_StaffInfo (staff_phone, deleted);
create index IX_DDAE5DBF on BN_StaffInfo (staff_role, deleted);