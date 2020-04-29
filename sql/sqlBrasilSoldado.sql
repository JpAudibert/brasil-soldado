CREATE TABLE "warning" (
	idWarning SERIAL,
	message TEXT NOT NULL,
	
	CONSTRAINT pk_warning PRIMARY KEY(idWarning)
);

CREATE TABLE "interview" (
	idInterview SERIAL,
	report TEXT NOT NULL,
	
	CONSTRAINT pk_interview PRIMARY KEY(idInterview)
);

CREATE TABLE "qualification" (
	idQualification SERIAL,
	type VARCHAR(45) NOT NULL,
	
	CONSTRAINT pk_qualification PRIMARY KEY(idQualification)
);

CREATE TABLE "state" (
	idState SERIAL,
	name VARCHAR(45) NOT NULL,
	initials VARCHAR(2) NOT NULL,
	
	CONSTRAINT pk_state PRIMARY KEY(idState)
);

CREATE TABLE "city" (
	idCity SERIAL,
	name VARCHAR(60) NOT NULL,
	initials VARCHAR(3),
	fkStateId INT NOT NULL,
	
	CONSTRAINT pk_city PRIMARY KEY(idCity),
	CONSTRAINT fk_fkStateId_city FOREIGN KEY(fkStateId) REFERENCES "state"
);

CREATE TABLE "person" (
	idPerson SERIAL,
	name VARCHAR(60) NOT NULL,
	surname VARCHAR(60) NOT NULL,
	birthday DATE NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	type INT NOT NULL,
	enabled BOOLEAN NOT NULL,
	momsName VARCHAR(120),
	dadsName VARCHAR(120),
	fkCityId INT NOT NULL,
	
	CONSTRAINT pk_person PRIMARY KEY(idPerson),
	CONSTRAINT fk_fkCityId_person FOREIGN KEY(fkCityId) REFERENCES city
);

CREATE TABLE "battalion"(
	idBattalion SERIAL,
	qttMembers INT NOT NULL,
	idPersonResponsible INT NOT NULL,
	fkCityId INT NOT NULL,
	
	CONSTRAINT pk_battalion PRIMARY KEY(idBattalion),
	CONSTRAINT fk_idPersonResponsible_battalion FOREIGN KEY(idPersonResponsible) REFERENCES person,
	CONSTRAINT fk_fkCityId_battalion FOREIGN KEY(fkCityId) REFERENCES city
);

CREATE TABLE "militaryJunta"(
	idMilitaryJunta SERIAL,
	fkBattalionId INT NOT NULL,
	
	CONSTRAINT pk_militaryJunta PRIMARY KEY(idMilitaryJunta),
	CONSTRAINT fk_fkBattalionId_miliaryJunta FOREIGN KEY(idMilitaryJunta) REFERENCES battalion
);

CREATE TABLE "personWarning"(
	idPersonWarning SERIAL,
	fkPersonId INT NOT NULL,
	fkWarningId INT NOT NULL,
	
	CONSTRAINT pk_personWarning PRIMARY KEY(idPersonWarning),
	CONSTRAINT fk_fkPersonId_personWarning FOREIGN KEY(fkPersonId) REFERENCES person,
	CONSTRAINT fk_fkWarningId_personWarning FOREIGN KEY(fkWarningId) REFERENCES warning
);

CREATE TABLE "personInterview"(
	idPersonInterview SERIAL,
	fkPersonId INT NOT NULL,
	fkInterviewId INT NOT NULL,
	
	CONSTRAINT pk_personInterview PRIMARY KEY(idPersonInterview),
	CONSTRAINT fk_fkPersonId_personInterview FOREIGN KEY(fkPersonId) REFERENCES person,
	CONSTRAINT fk_fkInterviewId_personInterview FOREIGN KEY(fkInterviewId) REFERENCES interview
);

CREATE TABLE "personQualification"(
	idPersonQualification SERIAL,
	fkPersonId INT NOT NULL,
	fkQualificationId INT NOT NULL,
	
	CONSTRAINT pk_personQualification PRIMARY KEY(idPersonQualification),
	CONSTRAINT fk_fkPersonId_personQualification FOREIGN KEY(fkPersonId) REFERENCES person,
	CONSTRAINT fk_fkQualificationId_personQualification FOREIGN KEY(fkQualificationId) REFERENCES qualification
);




